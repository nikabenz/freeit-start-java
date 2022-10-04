package edu.freeit.lesson18.collection.service;

import edu.freeit.lesson18.collection.DayPlanner;
import edu.freeit.lesson18.collection.Note;

import java.text.ParseException;
import java.util.List;

public interface DayPlannerService {
    void downloadNotes(String fromSource, DayPlanner dayPlanner);

    void unloadNotes(DayPlanner dayPlanner) throws ParseException;

    //void fill(DayPlanner dayPlanner);

    //void sort(DayPlanner dayPlanner);

    //void print(DayPlanner dayPlanner);
}
