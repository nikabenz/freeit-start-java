package edu.freeit.lesson7;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class DayPlannerRunner {
    public static void main(String[] args) throws ParseException {
        String delimiter = "-".repeat(50);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        int dayCount = 365;
        DayPlanner dayPlanner = new DayPlanner(dayCount);
        //fill dayPlanner
        Note note1 = new Note(new GregorianCalendar().getTime(), Activity.COOKING,
                "read 999999 book in English");
        dayPlanner.addNote(note1);
        Note note2 = new Note(simpleDateFormat.parse("25.03.2020"), Activity.FITNESS,
                "read a magazine");
        dayPlanner.addNote(note2);
        Note note3 = new Note(simpleDateFormat.parse("25.05.2020"), Activity.FITNESS,
                "write and read articles, analyze articles");
        dayPlanner.addNote(note3);
        for (int i = 3; i < dayPlanner.getArrayOfNotes().length - 354; i++) {
            if (i % 2 == 0) {
                dayPlanner.addNote(new Note(simpleDateFormat.parse("25.07.2020"), Activity.FITNESS,
                        "to-do list " + i + " and read a lot of letters"));
            } else {
                dayPlanner.addNote(new Note(simpleDateFormat.parse("25.09.2020"), Activity.RELAX,
                        "to-do list " + i));
            }
        }
        Note noteNext = new Note("read a magazine, analyze 999999 articles");
        dayPlanner.addNote(noteNext);
        Note noteNext1 = new Note("read a magazine, analyze 999999 articles, write a letter");
        dayPlanner.addNote(noteNext1);
        Note noteNext2 = new Note("read a magazine, analyze 999999 articles, write an article");
        dayPlanner.addNote(noteNext2);
        Note noteNext3 = new Note("read a magazine, analyze 999999 articles, jogging");
        dayPlanner.addNote(noteNext3);
        Note noteNext4 = new Note("read a magazine, analyze 999999 articles, fitness and relax");
        dayPlanner.addNote(noteNext4);
        //daily planner is filling up
        System.out.println(delimiter + "output before to sort");
        dayPlanner.print();

        System.out.println(delimiter + "output after to sort");
        dayPlanner.sort();
        dayPlanner.print();
        System.out.println(delimiter + "output frequency dictionary");
        System.out.println("read:\n" + dayPlanner.defineFrequencyOfIndividualCase("read"));
        System.out.println("to-do:\n" + dayPlanner.defineFrequencyOfIndividualCase("to-do"));
        System.out.println("write:\n" + dayPlanner.defineFrequencyOfIndividualCase("write"));
        System.out.println("analyze:\n" + dayPlanner.defineFrequencyOfIndividualCase("analyze"));
        System.out.println("jogging:\n" + dayPlanner.defineFrequencyOfIndividualCase("jogging"));
        System.out.println("digits:\n" + dayPlanner.defineFrequencyOfIndividualCase("\\d"));

        System.out.println("number of diary entries -> " + dayPlanner.getSizeOfArrayOfNotes());

        System.out.println(delimiter + "output after to update of notes from date");
        System.out.println(dayPlanner.updateNote(simpleDateFormat.parse("25.09.2020"),
                "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"));

        System.out.println(delimiter + "output of notes with selected activity");
        dayPlanner.print(dayPlanner.getNotesOf(Activity.FITNESS));

        System.out.println(delimiter + "output of notes from startDate to endDate");
        dayPlanner.print(dayPlanner.getNotesFromTo(simpleDateFormat.parse("25.07.2020"),
                simpleDateFormat.parse("25.10.2020")));

        System.out.println(delimiter + "output of note from date");
        System.out.println(dayPlanner.getNote(simpleDateFormat.parse("25.05.2020")));

        System.out.println(delimiter + "output of deleted note from date");
        System.out.println(dayPlanner.deleteNote(simpleDateFormat.parse("25.03.2020")));

        System.out.println(delimiter + "output all notes after deletion");
        dayPlanner.print();

        System.out.println(delimiter + "output of deleted note from date");
        System.out.println(dayPlanner.deleteNote(simpleDateFormat.parse("25.07.2020")));

        System.out.println(delimiter + "output all notes after deletion");
        dayPlanner.print();

        System.out.println(delimiter + "output of deleted note from date");
        System.out.println(dayPlanner.deleteNote(simpleDateFormat.parse("25.09.2020")));

        System.out.println(delimiter + "output all notes after deletion");
        dayPlanner.print();
    }
}
