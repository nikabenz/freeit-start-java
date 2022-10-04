package edu.freeit.lesson18.collection.service.parser.stax;

import edu.freeit.lesson18.collection.Activity;
import edu.freeit.lesson18.collection.Note;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DayPlannerStAXParser {
    private static final String NOTE = "note";
    private static final String ID = "id";
    private static final String DATE = "date";
    private static final String TOPIC = "topic";
    private static final String ACTIVITY = "activity";
    private static final String TIME = "time";
    List<Note> notes = new ArrayList<>();
    private Note note;
    private StringBuilder textOfNote;

    public List<Note> parse(String fromXML) {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try {
            XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(fromXML));
            while (xmlEventReader.hasNext()) {
                XMLEvent xmlEvent = xmlEventReader.nextEvent();
                startElement(xmlEvent, xmlEventReader);
                endElement(xmlEvent);
            }
        } catch (XMLStreamException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return notes;
    }

    private void startElement(XMLEvent xmlEvent, XMLEventReader xmlEventReader) {
        try {
            if (xmlEvent.isStartElement()) {
                StartElement startElement = xmlEvent.asStartElement();
                if (isTagNameEqual(startElement, NOTE)) {
                    note = new Note();
                    Attribute attribute = startElement.getAttributeByName(new QName(ID));
                    if (attribute != null) {
                        note.setId(Integer.parseInt(attribute.getValue()));
                    }
                } else if (isTagNameEqual(startElement, DATE)) {


                    note.setDate(new SimpleDateFormat("dd.MM.yyyy").parse(xmlEventReader.nextEvent().asCharacters().getData()));


                } else if (isTagNameEqual(startElement, TOPIC)) {

                    note.setType(Activity.valueOf(xmlEventReader.nextEvent().asCharacters().getData().toUpperCase()));

                } else if (isTagNameEqual(startElement, ACTIVITY)) {
                    if (textOfNote == null) {
                        textOfNote = new StringBuilder("\n");
                    }
                    Attribute attribute = startElement.getAttributeByName(new QName(TIME));
                    if (attribute != null) {
                        textOfNote.append(attribute.getValue() + " -> ");
                    }

                    textOfNote.append(xmlEventReader.nextEvent().asCharacters().getData() + "\n");

                }
            }
        } catch (Exception e) {

        }
    }

    private void endElement(XMLEvent xmlEvent) {
        if (xmlEvent.isEndElement()) {
            EndElement endElement = xmlEvent.asEndElement();
            if (endElement.getName().getLocalPart().equals(NOTE)) {
                note.setText(textOfNote.toString());
                notes.add(note);
                textOfNote = null;
            }
        }
    }

    private boolean isTagNameEqual(StartElement startElement, String tagName) {
        return startElement.getName().getLocalPart().equals(tagName);
    }

}
