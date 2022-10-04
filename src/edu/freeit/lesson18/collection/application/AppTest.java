package edu.freeit.lesson18.collection.application;

import edu.freeit.lesson18.collection.DayPlanner;
import edu.freeit.lesson18.collection.Note;
import edu.freeit.lesson18.collection.service.DayPlannerService;
import edu.freeit.lesson18.collection.service.file.DayPlannerFileService;
import edu.freeit.lesson18.collection.service.parser.DayPlannerXMLService;

import java.text.ParseException;

public class AppTest {
    public static void main(String[] args) {
        DayPlanner dayPlanner = new DayPlanner();
//        DayPlannerService dayPlannerService = new DayPlannerXMLService();
//        dayPlannerService.downloadNotes("notes.xml", dayPlanner);
//        for (Note note : dayPlanner.getNotes()) {
//            System.out.println(note);
//        }
        DayPlannerService dayPlannerService = new DayPlannerFileService();
        dayPlannerService.downloadNotes("notes.txt", dayPlanner);
        for (Note note : dayPlanner.getNotes()) {
            System.out.println(note);
        }
        dayPlannerService = new DayPlannerXMLService();
        try {
            dayPlannerService.unloadNotes(dayPlanner);
        } catch (ParseException e) {

        }
        for (Note note : dayPlanner.getNotes()) {
            System.out.println(note);
        }
    }
}
