package edu.freeit.lesson7;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class DayPlannerRunner {
    public static void main(String[] args) throws ParseException {
        String delimiter = "-".repeat(50);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        DayPlanner dayPlanner = new DayPlanner(111, " diary");
        //fill dayPlanner
        Note note1 = new Note(new GregorianCalendar().getTime(), Activity.COOKING, "I like cooking", "read 999999 book in English");
        dayPlanner.addNote(note1);
        Note note2 = new Note(simpleDateFormat.parse("25.03.2020"), Activity.FITNESS, "I like fitness", "read a magazine");
        dayPlanner.addNote(note2);
        Note note3 = new Note(simpleDateFormat.parse("25.05.2020"), Activity.FITNESS, "I like fitness", "write and read articles, analyze articles");
        dayPlanner.addNote(note3);
        for (int i = 5; i < dayPlanner.getLength() - 100; i++) {
            if (i % 2 == 0) {
                dayPlanner.addNote(new Note(simpleDateFormat.parse("25.07.2020"), Activity.FITNESS, "I like fitness", "to-do list " + i + " and read a lot of letters"));
            } else {
                dayPlanner.addNote(new Note(simpleDateFormat.parse("25.09.2020"), Activity.RELAX, "I like relax", "to-do list " + i));
            }
        }
        Note note101 = new Note("read a magazine, analyze 999999 articles");
        dayPlanner.addNote(note101);
        //daily planner is filling up
        System.out.println(delimiter + "output before to sort");
        dayPlanner.print();

        System.out.println(delimiter + "output after to sort");
        dayPlanner.print(dayPlanner.sort(dayPlanner.defineArrayOfNotNullNotes()));

        System.out.println(delimiter + "output frequency dictionary");
        System.out.println(dayPlanner.defineFrequencyOfIndividualCase("read"));
        System.out.println(dayPlanner.defineFrequencyOfIndividualCase("to-do"));
        System.out.println(dayPlanner.defineFrequencyOfIndividualCase("write"));
        System.out.println(dayPlanner.defineFrequencyOfIndividualCase("analyze"));
        System.out.println(dayPlanner.defineFrequencyOfIndividualCase("\\d"));

        System.out.println("number of diary entries -> " + dayPlanner.getSizeOfArrayOfNotes());

        System.out.println(delimiter + "output of notes with selected activity");
        dayPlanner.print(dayPlanner.getNotesOf(Activity.FITNESS));

        System.out.println(delimiter + "output of notes from startDate to endDate");
        dayPlanner.print(dayPlanner.getNotesFromTo(simpleDateFormat.parse("25.07.2020"), simpleDateFormat.parse("25.10.2020")));

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
