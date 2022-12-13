package edu.freeit.lesson16.sax.work_with_handler;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SAXParserHandlerExample {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser;
        try {
            saxParser = factory.newSAXParser();
            saxParser.parse(new File("books.xml"), new MyHandlerExample());
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
