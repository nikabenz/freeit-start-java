package edu.freeit.lesson16.example.service.stax;

import edu.freeit.lesson16.example.model.Book;
import edu.freeit.lesson16.example.model.Library;
import edu.freeit.lesson16.example.model.Price;
import edu.freeit.lesson16.example.model.utilconst.XMLTag;

import javax.xml.namespace.QName;
import javax.xml.stream.*;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LibraryStAXParser {
    private Book book;
    private Price price;
    List<Book> listBooks;

    public void downloadBooksWithStAXReader(Library library, String pathFrom) {
        try {
            XMLEventReader xmlEventReader = getStAXReader(pathFrom);
            while (xmlEventReader.hasNext()) {
                XMLEvent xmlEvent = xmlEventReader.nextEvent();
                startElement(xmlEvent, xmlEventReader);
                endElement(xmlEvent);
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            System.out.println(e.getMessage() + " | " + e.getCause().getMessage());
            throw new RuntimeException(e);
        }
        library.setBooksList(listBooks);
    }

    private void startElement(XMLEvent xmlEvent, XMLEventReader xmlEventReader) throws XMLStreamException {
        if (xmlEvent.isStartElement()) {
            StartElement startElement = xmlEvent.asStartElement();
            if (getTagNameEqual(startElement, XMLTag.BOOK)) {
                book = new Book();
            } else if (getTagNameEqual(startElement, XMLTag.TITLE)) {
                book.setTitle(xmlEventReader.nextEvent().asCharacters().getData());
            } else if (getTagNameEqual(startElement, XMLTag.AUTHOR)) {
                book.setAuthor(xmlEventReader.nextEvent().asCharacters().getData());
            } else if (getTagNameEqual(startElement, XMLTag.VALUE)) {
                price = new Price();
                price.setPrice(Double.parseDouble(xmlEventReader.nextEvent().asCharacters().getData()));
            } else if (getTagNameEqual(startElement, XMLTag.CURRENCY)) {
                price.setCurrency(xmlEventReader.nextEvent().asCharacters().getData());
                Attribute attribute = startElement.getAttributeByName(new QName(XMLTag.CODE));
                if (attribute != null) {
                    price.setCode(Integer.parseInt(attribute.getValue()));
                }
            }
        }
    }

    private void endElement(XMLEvent xmlEvent) {
        if (xmlEvent.isEndElement()) {
            EndElement endElement = xmlEvent.asEndElement();
            if (endElement.getName().getLocalPart().equals(XMLTag.BOOK)) {
                book.setPrice(price);
                if (listBooks == null) {
                    listBooks = new ArrayList<>();
                }
                listBooks.add(book);
            }
        }
    }

    private boolean getTagNameEqual(StartElement startElement, String tagName) {
        return startElement.getName().getLocalPart().equals(tagName);
    }

    private XMLEventReader getStAXReader(String pathFrom) throws FileNotFoundException, XMLStreamException {
        return XMLInputFactory.newInstance().createXMLEventReader(new FileInputStream(pathFrom));
    }

    public void unloadBooksWithStAXEvent(Library library, String pathTo) {
        XMLEventWriter writer;
        try {
            writer = getXMLEventWriter(pathTo);
            XMLEventFactory xmlEventFactory = XMLEventFactory.newInstance();
            XMLEvent xmlEvent = xmlEventFactory.createStartDocument();
            writer.add(xmlEvent);
            writer.add(xmlEventFactory.createStartElement("", "", XMLTag.CATALOGUE));
            for (int i = 0; i < library.getBooksList().size(); i++) {
                writer.add(xmlEventFactory.createStartElement("", "", XMLTag.BOOK));
                Book book = library.getBooksList().get(i);
                setTagNameEqual(writer, xmlEventFactory, book.getTitle(), XMLTag.TITLE);
                setTagNameEqual(writer, xmlEventFactory, book.getAuthor(), XMLTag.AUTHOR);
                writer.add(xmlEventFactory.createStartElement("", "", XMLTag.PRICE));
                setTagNameEqual(writer, xmlEventFactory, String.valueOf(book.getPrice().getPrice()), XMLTag.VALUE);
                writer.add(xmlEventFactory.createStartElement("", "", XMLTag.CURRENCY));
                writer.add(xmlEventFactory.createAttribute(XMLTag.CODE, String.valueOf(book.getPrice().getCode())));
                writer.add(xmlEventFactory.createCharacters(book.getPrice().getCurrency()));
                writer.add(xmlEventFactory.createEndElement("", "", XMLTag.CURRENCY));
                writer.add(xmlEventFactory.createEndElement("", "", XMLTag.PRICE));
                writer.add(xmlEventFactory.createEndElement("", "", XMLTag.BOOK));
            }
            writer.add(xmlEventFactory.createEndElement("", "", XMLTag.CATALOGUE));
            library.getBooksList().clear();
            writer.add(xmlEventFactory.createEndDocument());
            writer.flush();
            writer.close();
        } catch (IOException | XMLStreamException e) {
            System.out.println(e.getMessage() + " | " + e.getCause().getMessage());
            throw new RuntimeException(e);
        }
    }

    private void setTagNameEqual(XMLEventWriter writer, XMLEventFactory xmlEventFactory, String textContent, String tagName) throws XMLStreamException {
        writer.add(xmlEventFactory.createStartElement("", "", tagName));
        writer.add(xmlEventFactory.createCharacters(textContent));
        writer.add(xmlEventFactory.createEndElement("", "", tagName));
    }

    private XMLEventWriter getXMLEventWriter(String pathTo) throws IOException, XMLStreamException {
        return XMLOutputFactory.newInstance().createXMLEventWriter(new FileOutputStream(pathTo));
    }

    public void unloadBooksWithStAX(Library library, String pathTo) {
        XMLStreamWriter writer = null;
        try {
            writer = getXMLStreamWriter(pathTo);
            writer.writeStartDocument("1.0");
            writer.writeStartElement(XMLTag.CATALOGUE);
            for (int i = 0; i < library.getBooksList().size(); i++) {
                writer.writeStartElement(XMLTag.BOOK);
                writer.writeStartElement(XMLTag.TITLE);
                writer.writeCharacters(library.getBooksList().get(i).getTitle());
                writer.writeEndElement();
                writer.writeStartElement(XMLTag.AUTHOR);
                writer.writeCharacters(library.getBooksList().get(i).getAuthor());
                writer.writeEndElement();
                writer.writeStartElement(XMLTag.PRICE);
                writer.writeStartElement(XMLTag.VALUE);
                writer.writeCharacters(String.valueOf(library.getBooksList().get(i).getPrice().getPrice()));
                writer.writeEndElement();
                writer.writeStartElement(XMLTag.CURRENCY);
                writer.writeAttribute(XMLTag.CODE, String.valueOf(library.getBooksList().get(i).getPrice().getCode()));
                writer.writeCharacters(library.getBooksList().get(i).getPrice().getCurrency());
                writer.writeEndElement();
                writer.writeEndElement();
                writer.writeEndElement();
            }
            writer.writeEndDocument();
            writer.flush();
            library.getBooksList().clear();
        } catch (XMLStreamException | IOException e) {
            System.out.println(e.getMessage() + " | " + e.getCause().getMessage());
            throw new RuntimeException(e);
        } finally {
            if (Objects.nonNull(writer)) {
                try {
                    writer.close();
                } catch (XMLStreamException e) {
                    System.out.println(e.getMessage() + " | " + e.getCause().getMessage());
                }
            }
        }
    }

    private XMLStreamWriter getXMLStreamWriter(String pathTo) throws IOException, XMLStreamException {
        return XMLOutputFactory.newInstance().createXMLStreamWriter(new FileWriter(pathTo));
    }
}

