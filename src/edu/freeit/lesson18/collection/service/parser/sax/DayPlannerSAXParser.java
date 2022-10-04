package edu.freeit.lesson18.collection.service.parser.sax;

import edu.freeit.lesson18.collection.Note;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;

public class DayPlannerSAXParser {

    public List<Note> parse(String fromXML) {
        DayPlannerHandler dayPlannerHandler = new DayPlannerHandler();
        try {
            SAXParserFactory.newInstance().newSAXParser().parse(fromXML, dayPlannerHandler);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new RuntimeException(e);
        }
        return dayPlannerHandler.getNotes();
    }
}
