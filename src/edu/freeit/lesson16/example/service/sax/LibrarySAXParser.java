package edu.freeit.lesson16.example.service.sax;

import edu.freeit.lesson16.example.model.Library;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class LibrarySAXParser {
    public void downloadBooksWithSAXParser(Library library, String pathFrom) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        BooksHandler booksHandler = new BooksHandler();
        try {
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse(pathFrom, booksHandler);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println(e.getMessage() + " | " + e.getCause().getMessage());
            throw new RuntimeException(e);
        }
        library.setBooksList(booksHandler.getListBooks());
    }
}
