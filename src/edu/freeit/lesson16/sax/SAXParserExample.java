package edu.freeit.lesson16.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SAXParserExample {
    public static void main(String[] args) {


        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser;


        try {
            saxParser = factory.newSAXParser();
            saxParser.parse(new File("books.xml"), new DefaultHandler() {
                private boolean title = false;
                private boolean date = false;

                @Override
                public void startDocument() {

                    System.out.println("Document parsing is started! ");
                }

                @Override
                public void endDocument() {

                    System.out.println("Document parsing is ended!! ");
                }

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) {

                    if (qName.equalsIgnoreCase("title")) {
                        title = true;
                    }

                    if (qName.equalsIgnoreCase("date")) {
                        date = true;
                    }
                }

                @Override
                public void endElement(String uri, String localName, String qName) {

                    if (qName.equalsIgnoreCase("title")) {
                        System.out.println("Title parsing is ended!! ");
                        title = false;
                    }

                    if (qName.equalsIgnoreCase("date")) {
                        System.out.println("Date parsing is ended!! ");
                        date = false;
                    }
                }

                @Override
                public void characters(char[] ch, int start, int length) {

                    if (title) {
                        System.out.println("Title text content is  " + new String(ch, start, length));
                    }

                    if (date) {
                        System.out.println("Date text content is " + new String(ch, start, length));
                    }
                }
            });
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }

    }

}