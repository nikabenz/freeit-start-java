package edu.freeit.lesson18.collection.service.parser.sax;

import edu.freeit.lesson18.collection.Activity;
import edu.freeit.lesson18.collection.Note;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DayPlannerHandler extends DefaultHandler {
    private boolean date = false;
    private boolean topic = false;
    private boolean activity = false;
    private List<Note> notes;
    private Note note;
    private StringBuilder textOfNote;

    public List<Note> getNotes() {
        return notes;
    }

    @Override
    public void startDocument() {
        System.out.println("Process is started");
    }

    @Override
    public void endDocument() {
        System.out.println("Process is completed successfully");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equalsIgnoreCase("note")) {
            note = new Note();
            note.setId(Integer.parseInt(attributes.getValue("id")));
        }
        if (qName.equalsIgnoreCase("date")) {
            date = true;
        }
        if (qName.equalsIgnoreCase("topic")) {
            topic = true;
        }
        if (qName.equalsIgnoreCase("activity")) {
            if (textOfNote == null) {
                textOfNote = new StringBuilder("\n");
            }
            textOfNote.append(attributes.getValue("time")).append(" -> ");
            activity = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equalsIgnoreCase("note")) {
            if (notes == null) {
                notes = new ArrayList<>();
            }
            note.setText(textOfNote.toString());
            notes.add(note);
            textOfNote = null;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (date) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
            try {
                note.setDate(simpleDateFormat.parse(new String(ch, start, length)));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            date = false;
        }
        if (topic) {
            note.setType(Activity.valueOf(new String(ch, start, length).toUpperCase()));
            topic = false;
        }
        if (activity) {
            textOfNote.append(new String(ch, start, length)).append("\n");
            activity = false;
        }
    }
}
