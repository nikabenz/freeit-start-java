package edu.freeit.lesson7;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class NoteBookRunner {
    public static void main(String[] args) throws ParseException {
        String delimiter = "-".repeat(50);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        NoteBook noteBook = new NoteBook(111, " diary");
        Note note1 = new Note(new GregorianCalendar().getTime(), Activity.COOKING, "I like cooking", "read a book in English");
        noteBook.addNote(note1, 0);
        Note note2 = new Note(simpleDateFormat.parse("25.03.2020"), Activity.FITNESS, "I like fitness", "read a magazine");
        noteBook.addNote(note2, 1);
        Note note3 = new Note(simpleDateFormat.parse("25.05.2020"), Activity.FITNESS, "I like fitness","write and read articles, analyze articles");
        noteBook.addNote(note3, 2);
        for (int i = 5; i < noteBook.getLength() - 100; i++) {
            if (i % 2 == 0) {
                noteBook.addNote(new Note(simpleDateFormat.parse("25.07.2020"), Activity.FITNESS, "I like fitness","to-do list " + i + " and read a lot of letters"), i);
            } else {
                noteBook.addNote(new Note(simpleDateFormat.parse("25.09.2020"), Activity.RELAX, "I like relax","to-do list " + i), i);
            }
        }
        Note note101 = new Note("read a magazine, analyze articles");
        noteBook.addNote(note101, 100);
        System.out.println(delimiter + "output before to sort");

        noteBook.print();
        System.out.println(delimiter + "output after to sort");

        noteBook.print(noteBook.sort());
        System.out.println(delimiter + "output frequency dictionary");

        System.out.println(noteBook.defineFrequencyOfIndividualCase("read"));
        System.out.println(noteBook.defineFrequencyOfIndividualCase("to-do"));
        System.out.println(noteBook.defineFrequencyOfIndividualCase("write"));
        System.out.println(noteBook.defineFrequencyOfIndividualCase("analyze"));
        System.out.println(noteBook.defineFrequencyOfIndividualCase("\\d"));
        System.out.println("number of diary entries -> " + noteBook.getSizeOfArrayOfNotes());
        System.out.println(delimiter + "output of notes with selected activity");
        noteBook.print(noteBook.getNotesOf(Activity.FITNESS));
        System.out.println(delimiter + "output of notes from startDate to endDate");
        noteBook.print(noteBook.getNotesFromTo(simpleDateFormat.parse("25.07.2020"), simpleDateFormat.parse("25.10.2020")));
    }
}
