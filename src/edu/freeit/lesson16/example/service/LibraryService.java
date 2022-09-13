package edu.freeit.lesson16.example.service;

import edu.freeit.lesson16.example.model.utilconst.BookParserType;
import edu.freeit.lesson16.example.model.utilconst.BookWriterType;
import edu.freeit.lesson16.example.model.Library;
import edu.freeit.lesson16.example.service.dom.LibraryDOMParser;
import edu.freeit.lesson16.example.service.sax.LibrarySAXParser;
import edu.freeit.lesson16.example.service.stax.LibraryStAXParser;
import org.w3c.dom.Document;

import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class LibraryService {
    public void downloadBooks(Library library, String pathFrom, BookParserType type) {
        switch (type) {
            case DOM -> {
                LibraryDOMParser libraryDOMParser = new LibraryDOMParser();
                libraryDOMParser.downloadBooksWithDOMParser(library, pathFrom);
            }
            case SAX -> {
                LibrarySAXParser librarySAXParser = new LibrarySAXParser();
                librarySAXParser.downloadBooksWithSAXParser(library, pathFrom);
            }
            case STAX -> {
                LibraryStAXParser libraryStAXParser = new LibraryStAXParser();
                libraryStAXParser.downloadBooksWithStAXReader(library, pathFrom);
            }
        }

    }

    public void unloadBooks(Library library, String pathTo, BookWriterType type) {
        switch (type) {
            case DOM -> {
                LibraryDOMParser libraryDOMParser = new LibraryDOMParser();
                writeCatalogueToXML(libraryDOMParser.unloadBooksWithDOM(library), pathTo);
            }
            case STAX -> {
                LibraryStAXParser libraryStAXParser = new LibraryStAXParser();
                libraryStAXParser.unloadBooksWithStAX(library, pathTo);
            }
            case STAX_EVENT -> {
                LibraryStAXParser libraryStAXParser = new LibraryStAXParser();
                libraryStAXParser.unloadBooksWithStAXEvent(library, pathTo);
            }
        }
    }

    private void writeCatalogueToXML(Document document, String pathTo) {
        File file = new File(pathTo);
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(new DOMSource(document), new StreamResult(file));
        } catch (TransformerException e) {
            System.out.println(e.getMessage() + " " + e.getCause().toString());
        }
    }

    public void checkCatalogue(Library library) throws InterruptedException {
        if (library.getBooksList().isEmpty()) {
            System.out.println("Каталог пуст");
        } else {
            System.out.println("Каталог заполнен");
            library.print();
        }
        Thread.sleep(2000);
    }
}

