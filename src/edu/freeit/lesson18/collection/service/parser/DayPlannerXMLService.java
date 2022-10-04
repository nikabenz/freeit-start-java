package edu.freeit.lesson18.collection.service.parser;

import edu.freeit.lesson18.collection.DayPlanner;
import edu.freeit.lesson18.collection.Note;
import edu.freeit.lesson18.collection.service.DayPlannerService;
import edu.freeit.lesson18.collection.service.parser.sax.DayPlannerSAXParser;
import edu.freeit.lesson18.collection.service.parser.stax.DayPlannerStAXParser;
import edu.freeit.lesson18.collection.service.util.FileUtility;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DayPlannerXMLService implements DayPlannerService {
    @Override
    public void downloadNotes(String fromXML, DayPlanner dayPlanner) {
        //DayPlannerSAXParser dayPlannerSAXParser = new DayPlannerSAXParser();
        //dayPlanner.setNotes(dayPlannerSAXParser.parse(fromXML));
        DayPlannerStAXParser dayPlannerStAXParser = new DayPlannerStAXParser();
        dayPlanner.setNotes(dayPlannerStAXParser.parse(fromXML));
    }

    @Override
    public void unloadNotes(DayPlanner dayPlanner) {
        FileUtility.createDir();
        File file = FileUtility.createFile();
        System.out.println("AbsolutePath " + file.getAbsolutePath());
        Document document;
        try {
            document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        } catch (ParserConfigurationException e) {
            System.out.println(e.getMessage() + " | " + e.getCause().getMessage());
            throw new RuntimeException(e);
        }
        Element root = document.createElement("notes");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        for (int i = 0; i < dayPlanner.getNotes().size(); i++) {
            Note note = dayPlanner.getNotes().get(i);
            Element noteElement = document.createElement("note");
            Element date = document.createElement("date");
            date.setTextContent(simpleDateFormat.format(note.getDate()));
            Element type = document.createElement("topic");
            type.setTextContent(String.valueOf(note.getType()));
            Element text = document.createElement("text");
            String[] partsOfText = note.getText().trim().toLowerCase().split("\\d{2}:\\d{2}");
            List<String> timeAttributes = new ArrayList<>();
            Pattern pattern = Pattern.compile("\\d{2}:\\d{2}");
            Matcher matcher = pattern.matcher(note.getText());
            while (matcher.find()) {
                timeAttributes.add(matcher.group());
            }
            System.out.println("size is " + timeAttributes.size());
            System.out.println("length is " + partsOfText.length);
            for (int j = 0; j < partsOfText.length; j++) {
                if (partsOfText[j].trim() != "") {
                    Element activity = document.createElement("activity");
                    activity.setTextContent(partsOfText[j].trim());
                    activity.setAttribute("time", timeAttributes.get(j - 1));
                    text.appendChild(activity);
                }
            }
            noteElement.appendChild(date);
            noteElement.appendChild(type);
            noteElement.appendChild(text);
            root.appendChild(noteElement);

        }
        document.appendChild(root);
        dayPlanner.getNotes().clear();
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(new DOMSource(document), new StreamResult(file));
        } catch (TransformerException e) {
            System.out.println(e.getMessage() + " " + e.getCause().toString());
        }
        dayPlanner.getNotes().clear();
    }
}
