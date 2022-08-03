package edu.freeit.lesson7;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DayPlanner implements NoteBook {
    private int length;
    private String category;
    private Note[] arrayOfNotes;

    public DayPlanner() {
        this.length = 10;
        this.category = "to-do-list";
        this.arrayOfNotes = new Note[length];
    }

    public DayPlanner(int length, String category) {
        this.length = length;
        this.category = category;
        this.arrayOfNotes = new Note[length];
    }

    public Note[] getArrayOfNotes() {
        return arrayOfNotes;
    }

    @Override
    public Note getNote(Date date) {
        for (Note note : defineArrayOfNotNullNotes())
            if (note.getDate().equals(date)) {
                return note;
            }
        return null;
    }

    public int getLength() {
        return length;
    }

    public int getSizeOfArrayOfNotes() {
        int size = 0;
        for (Note note : arrayOfNotes) {
            if (note != null) {
                size++;
            }
        }
        return size;
    }

    public void print() {
        for (Note note : defineArrayOfNotNullNotes()) {
            System.out.println(note + "\n");
        }
    }

    @Override
    public void print(Note[] notes) {
        for (Note note : notes) {
            System.out.println(note + "\n");
        }
    }

    @Override
    public void addNote(Note note) {
        this.arrayOfNotes[getSizeOfArrayOfNotes()] = note;
    }

    @Override
    public Note updateNote(Date date, Note newNote) {
        return null;
    }

    @Override
    public Note deleteNote(Date date) {
        Note[] temp = defineArrayOfNotNullNotes();
        Note deletedNote = null;
        int index = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i].getDate().compareTo(date) == 0) {
                deletedNote = temp[i];
                index = i;
                break;
            }
        }
        for (int i = index; i < temp.length - 1; i++) {
            temp[i] = temp[i + 1];
        }
        temp[temp.length - 1] = null;
        return deletedNote;
    }

    public Note[] getNotesOf(Activity type) {
        int count = 0;
        for (Note note : defineArrayOfNotNullNotes()) {
            if (note.getType().equals(type)) {
                count++;
            }
        }
        Note[] notesOfType = new Note[count];
        for (int i = 0, j = 0; i < defineArrayOfNotNullNotes().length; i++) {
            if (getArrayOfNotes()[i].getType().equals(type)) {
                notesOfType[j] = getArrayOfNotes()[i];
                j++;
            }
        }
        return notesOfType;
    }

    public Note[] getNotesFromTo(Date from, Date to) {
        int count = 0;
        for (Note note : defineArrayOfNotNullNotes()) {
            if (note.getDate().after(from) && note.getDate().before(to)) {
                count++;
            }
        }
        Note[] notesFromTo = new Note[count];
        for (int i = 0, j = 0; i < defineArrayOfNotNullNotes().length; i++) {
            if (getArrayOfNotes()[i].getDate().after(from) && getArrayOfNotes()[i].getDate().before(to)) {
                notesFromTo[j] = getArrayOfNotes()[i];
                j++;
            }
        }
        return notesFromTo;
    }

    public Note[] sort(Note[] notes) {
        notes = defineArrayOfNotNullNotes();
        Arrays.sort(notes);
        return notes;
    }

    public String defineFrequencyOfIndividualCase(String individualCase) {
        Pattern pattern = Pattern.compile(".*" + individualCase + ".*");
        Matcher matcher;
        Note[] temp = defineArrayOfNotNullNotes();
        StringBuilder frequency = new StringBuilder();
        int totalNumberOfCase = 0;
        int n;
        DateFormat dateFormat = new SimpleDateFormat("   dd.MM.yyyy ");
        for (int i = 0; i < temp.length; i++) {
            n = 0;
            StringBuilder cases = new StringBuilder(temp[i].getText());
            matcher = pattern.matcher(cases);
            while (matcher.find()) {
                n++;
            }
            if (n != 0) {
                totalNumberOfCase += n;
                frequency.append(cases).append(dateFormat.format(temp[i].getDate())).append(";\n");
            }
        }
        String delimiter = totalNumberOfCase == 1 ? " case -> \n" : " cases -> \n";
        return totalNumberOfCase + delimiter + frequency;
    }

    public Note[] defineArrayOfNotNullNotes() {
        this.arrayOfNotes = Arrays.copyOfRange(arrayOfNotes, 0, getSizeOfArrayOfNotes());
        return this.arrayOfNotes;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", "[", "]")
                .add("category='" + category + "'")
                .toString();
    }
}
