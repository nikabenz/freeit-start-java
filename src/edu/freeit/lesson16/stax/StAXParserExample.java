package edu.freeit.lesson16.stax;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Objects;

public class StAXParserExample {
    public static void main(String[] args) {
        XMLStreamReader xmlr = null;
        try {
            XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
            xmlr = xmlInputFactory.createXMLStreamReader(new FileInputStream("books.xml"));

            while (xmlr.hasNext()) {
                xmlr.next();
                if (xmlr.isStartElement()) {
                    System.out.print("<" + xmlr.getLocalName() + ">");
                } else if (xmlr.isEndElement()) {
                    System.out.println("</" + xmlr.getLocalName() + ">\n");
                } else if (xmlr.hasText() && xmlr.getText().trim().length() > 0) {
                    System.out.print(xmlr.getText());
                }
            }

        } catch (FileNotFoundException | XMLStreamException ex) {
            ex.printStackTrace();
        } finally {
            if (Objects.nonNull(xmlr)) {
                try {
                    xmlr.close();
                } catch (XMLStreamException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}