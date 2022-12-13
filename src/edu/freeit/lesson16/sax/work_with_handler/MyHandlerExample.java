package edu.freeit.lesson16.sax.work_with_handler;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyHandlerExample extends DefaultHandler {
    private boolean author = false;
    private boolean cost = false;

    @Override
    public void startDocument() {
        System.out.println("Parsing started...");
    }

    @Override
    public void endDocument() {
        System.out.println("Parsing ended...");
    }

    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) {

        if (qName.equalsIgnoreCase("author")) {
            author = true;
        }

        if (qName.equalsIgnoreCase("cost")) {
            System.out.println("Currency: " + attributes.getValue(0));
            cost = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {

        if (qName.equalsIgnoreCase("author")) {
            System.out.println("//parsing of author is ended!");
            author = false;
        }

        if (qName.equalsIgnoreCase("cost")) {
            System.out.println("//parsing of cost is ended!");
            cost = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {

        if (author) {
            System.out.println("Name: " + new String(ch, start, length));
        }

        if (cost) {
            System.out.println("Cost: " + new String(ch, start, length));
        }
    }
}
