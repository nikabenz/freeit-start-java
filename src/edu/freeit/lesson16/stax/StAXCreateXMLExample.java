package edu.freeit.lesson16.stax;

import edu.freeit.lesson16.dom.Book;
import edu.freeit.lesson16.dom.Cost;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class StAXCreateXMLExample {
    public static void main(String[] args) {

        XMLStreamWriter writer = null;

        try {
            XMLOutputFactory output = XMLOutputFactory.newInstance();
            writer = output.createXMLStreamWriter(new FileWriter("result.xml"));

            // Открываем XML-документ и Пишем корневой элемент BookCatalogue
            writer.writeStartDocument("1.0");
            writer.writeStartElement("books");
            // Делаем цикл для книг
            for (int i = 1; i <= 5; i++) {
                Book book = new Book();
                book.setTitle("new book Title" + i);
                book.setAuthor("new book Author" + i);
                book.setDate("2018-01-025" + i);
                book.setIsbn("0-00-000000-0" + i);
                Cost cost = new Cost();
                cost.setCost(21.1 + (i + i / 10));
                cost.setCurrency("EUR");
                book.setCost(cost);
                book.setPublisher("new book Publisher" + i);

                writer.writeStartElement("Book");

                // Title
                writer.writeStartElement("Title");
                writer.writeCharacters(book.getTitle());
                writer.writeEndElement();
                // Author
                writer.writeStartElement("Author");
                writer.writeCharacters(book.getAuthor());
                writer.writeEndElement();
                // Date
                writer.writeStartElement("Date");
                writer.writeCharacters(book.getDate());
                writer.writeEndElement();
                // ISBN
                writer.writeStartElement("ISBN");
                writer.writeCharacters(book.getIsbn());
                writer.writeEndElement();
                // Publisher
                writer.writeStartElement("Publisher");
                writer.writeCharacters(book.getPublisher());
                writer.writeEndElement();
                // Cost
                writer.writeStartElement("Cost");
                writer.writeAttribute("currency", book.getCost().getCurrency());
                writer.writeCharacters(String.valueOf(book.getCost().getCost()));
                writer.writeEndElement();

                writer.writeEndElement();
            }

            writer.writeEndElement();

            writer.writeEndDocument();
            writer.flush();
        } catch (XMLStreamException | IOException ex) {
            ex.printStackTrace();
        } finally {
            if (Objects.nonNull(writer)) {
                try {
                    writer.close();
                } catch (XMLStreamException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
