package edu.freeit.lesson16.example.service.dom;

import edu.freeit.lesson16.example.model.Book;
import edu.freeit.lesson16.example.model.Library;
import edu.freeit.lesson16.example.model.Price;
import edu.freeit.lesson16.example.model.utilconst.XMLTag;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class LibraryDOMParser {
    public void downloadBooksWithDOMParser(Library library, String pathFrom) {
        Document doc;
        try {
            doc = getDOMDocument(pathFrom);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            System.out.println(e.getMessage() + " | " + e.getCause().getMessage());
            throw new RuntimeException(e);
        }
        Node rootNode = doc.getFirstChild();
        NodeList listChild = rootNode.getChildNodes();
        for (int i = 0; i < listChild.getLength(); i++) {
            if (listChild.item(i).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            Book book = new Book();
            NodeList listChildDeep = listChild.item(i).getChildNodes();
            for (int j = 0; j < listChildDeep.getLength(); j++) {
                if (listChildDeep.item(j).getNodeType() != Node.ELEMENT_NODE) {
                    continue;
                }
                switch (listChildDeep.item(j).getNodeName().toLowerCase()) {
                    case XMLTag.TITLE -> book.setTitle(listChildDeep.item(j).getTextContent());

                    case XMLTag.AUTHOR -> book.setAuthor(listChildDeep.item(j).getTextContent());

                    case XMLTag.PRICE -> {
                        Price price = new Price();
                        NodeList priceList = listChildDeep.item(j).getChildNodes();
                        for (int k = 0; k < priceList.getLength(); k++) {
                            if (priceList.item(k).getNodeType() != Node.ELEMENT_NODE) {
                                continue;
                            }
                            switch (priceList.item(k).getNodeName().toLowerCase()) {
                                case XMLTag.VALUE ->
                                        price.setPrice(Double.parseDouble(priceList.item(k).getTextContent()));

                                case XMLTag.CURRENCY -> {
                                    price.setCurrency(priceList.item(k).getTextContent());
                                    price.setCode(Integer.parseInt(priceList.item(k).getAttributes().getNamedItem(XMLTag.CODE).getTextContent()));
                                }
                                default ->
                                        throw new IllegalStateException("Unexpected value: " + priceList.item(k).getNodeName().toLowerCase());
                            }
                            book.setPrice(price);
                        }
                    }
                    default ->
                            throw new IllegalStateException("Unexpected value: " + listChildDeep.item(j).getNodeName());
                }
            }
            library.getBooksList().add(book);
        }
    }

    private Document getDOMDocument(String pathToXML) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        return factory.newDocumentBuilder().parse(pathToXML);
    }

    public Document unloadBooksWithDOM(Library library) {
        Document document;
        try {
            document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        } catch (ParserConfigurationException e) {
            System.out.println(e.getMessage() + " | " + e.getCause().getMessage());
            throw new RuntimeException(e);
        }
        Element root = document.createElement(XMLTag.CATALOGUE);
        for (int i = 0; i < library.getBooksList().size(); i++) {
            Book book = library.getBooksList().get(i);
            Element bookToCatalogue = document.createElement(XMLTag.BOOK);
            Element title = document.createElement(XMLTag.TITLE);
            title.setTextContent(book.getTitle());
            Element author = document.createElement(XMLTag.AUTHOR);
            author.setTextContent(book.getAuthor());
            Element priceToBook = document.createElement(XMLTag.PRICE);
            Element value = document.createElement(XMLTag.VALUE);
            value.setTextContent(String.valueOf(book.getPrice().getPrice()));
            Element currency = document.createElement(XMLTag.CURRENCY);
            currency.setTextContent(book.getPrice().getCurrency());
            currency.setAttribute(XMLTag.CODE, String.valueOf(book.getPrice().getCode()));
            bookToCatalogue.appendChild(title);
            bookToCatalogue.appendChild(author);
            bookToCatalogue.appendChild(priceToBook);
            priceToBook.appendChild(value);
            priceToBook.appendChild(currency);
            root.appendChild(bookToCatalogue);

        }
        document.appendChild(root);
        library.getBooksList().clear();
        return document;
    }
}
