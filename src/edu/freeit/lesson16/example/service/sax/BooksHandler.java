package edu.freeit.lesson16.example.service.sax;

import edu.freeit.lesson16.example.model.Book;
import edu.freeit.lesson16.example.model.Price;
import edu.freeit.lesson16.example.model.utilconst.XMLTag;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class BooksHandler extends DefaultHandler {
    private Book book;
    private Price price;
    List<Book> listBooks;
    private boolean title = false;
    private boolean author = false;
    private boolean value = false;
    private boolean currency = false;

    public BooksHandler() {
        super();
    }

    public List<Book> getListBooks() {
        return listBooks;
    }

    @Override
    public void startDocument() {
        System.out.println("Data-processing started ");
    }

    @Override
    public void endDocument() {
        System.out.println("Data-processing ended ");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equalsIgnoreCase(XMLTag.TITLE)) {
            book = new Book();
            title = true;
        }
        if (qName.equalsIgnoreCase(XMLTag.AUTHOR)) {
            author = true;
        }
        if (qName.equalsIgnoreCase(XMLTag.VALUE)) {
            price = new Price();
            value = true;
        }
        if (qName.equalsIgnoreCase(XMLTag.CURRENCY)) {
            price.setCode(Integer.parseInt(attributes.getValue(XMLTag.CODE)));
            currency = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equalsIgnoreCase(XMLTag.BOOK)) {
            book.setPrice(price);
            if (listBooks == null) {
                listBooks = new ArrayList<>();
            }
            listBooks.add(book);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (title) {
            book.setTitle(new String(ch, start, length));
            title = false;
        }
        if (author) {
            book.setAuthor(new String(ch, start, length));
            author = false;
        }
        if (value) {
            price.setPrice(Double.parseDouble(new String(ch, start, length)));
            value = false;
        }
        if (currency) {
            price.setCurrency(new String(ch, start, length));
            currency = false;
        }
    }
}
