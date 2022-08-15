package edu.freeit.lesson7;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@IsSecretContent(reason = "just an example")
public class DayPlanner implements NoteBook {
    private Note[] arrayOfNotes;
    private int size;

    public DayPlanner(int length) {
        this.arrayOfNotes = new Note[length];
    }

    public DayPlanner() {
        this(30);
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

    public int getSize() {
        return size;
    }

    public void print() {
        for (Note note : defineArrayOfNotNullNotes()) {
            System.out.println(note + "\n");
        }
    }

    public void print(Note[] notes) {
        for (Note note : notes) {
            System.out.println(note + "\n");
        }
    }

    @Override
    public boolean addNote(Note note) {
        boolean addedNote = false;
        if (getSize() != arrayOfNotes.length) {
            this.arrayOfNotes[getSize()] = note;
            addedNote = true;
            size++;
        }
        return addedNote;
    }

    @Override
    public Note updateNote(Date date, String text) {
        Note updatedNote = getNote(date);
        if (updatedNote != null) {
            updatedNote.setText(updatedNote.getText() + ", " + text);
            return updatedNote;
        } else {
            return null;
        }
    }

    @Override
    public Note deleteNote(Date date) {
        Note[] temp = defineArrayOfNotNullNotes();
        Note deletedNote = null;
        int index = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i].getDate().compareTo(date) == 0) {
                deletedNote = temp[i];
                size--;
                index = i;
                break;
            }
        }
        if (deletedNote != null) {
            for (int i = index; i < temp.length - 1; i++) {
                temp[i] = temp[i + 1];
            }
            temp[temp.length - 1] = null;
            return deletedNote;
        }
        return null;
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
        if (notesOfType.length != 0) {
            return notesOfType;
        }
        return null;
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

    public void sort() {
        Arrays.sort(defineArrayOfNotNullNotes());
    }

    public String defineFrequencyOfIndividualCase(String individualCase) {
        Pattern pattern = Pattern.compile(".*" + individualCase + ".*");
        Matcher matcher;
        Note[] temp = defineArrayOfNotNullNotes();
        StringBuilder frequency = new StringBuilder();
        int totalNumberOfCase = 0;
        int n;
        DateFormat dateFormat = new SimpleDateFormat("   dd.MM.yyyy ");
        for (Note note : temp) {
            n = 0;
            StringBuilder cases = new StringBuilder(note.getText());
            matcher = pattern.matcher(cases);
            while (matcher.find()) {
                n++;
            }
            if (n != 0) {
                totalNumberOfCase += n;
                frequency.append(cases).append(dateFormat.format(note.getDate())).append(";\n");
            }
        }
        String delimiter = totalNumberOfCase == 1 ? " case -> \n" : " cases -> \n";
        return totalNumberOfCase + delimiter + frequency;
    }

    public Note[] defineArrayOfNotNullNotes() {
        this.arrayOfNotes = Arrays.copyOfRange(arrayOfNotes, 0, getSize());
        return this.arrayOfNotes;
    }
}
