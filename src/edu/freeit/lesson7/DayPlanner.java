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
        for (int i = 0; i < size; i++) {
            if (arrayOfNotes[i].getDate().equals(date)) {
                return arrayOfNotes[i];
            }
        }
        return null;
    }

    public int getSize() {
        return size;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(arrayOfNotes[i] + "\n");
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
        Note deletedNote = null;
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (arrayOfNotes[i].getDate().compareTo(date) == 0) {
                deletedNote = arrayOfNotes[i];
                size--;
                index = i;
                break;
            }
        }
        if (deletedNote != null) {
            for (int i = index; i < size - 1; i++) {
                arrayOfNotes[i] = arrayOfNotes[i + 1];
            }
            arrayOfNotes[size - 1] = null;
            return deletedNote;
        }
        return null;
    }

    public Note[] getNotesOf(Activity type) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (arrayOfNotes[i].getType().equals(type)) {
                count++;
            }
        }
        Note[] notesOfType = new Note[count];
        for (int i = 0, j = 0; i < size; i++) {
            if (arrayOfNotes[i].getType().equals(type)) {
                notesOfType[j] = arrayOfNotes[i];
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
        for (int i = 0; i < size; i++) {
            if (arrayOfNotes[i].getDate().after(from) && arrayOfNotes[i].getDate().before(to)) {
                count++;
            }
        }
        Note[] notesFromTo = new Note[count];
        for (int i = 0, j = 0; i < size; i++) {
            if (arrayOfNotes[i].getDate().after(from) && arrayOfNotes[i].getDate().before(to)) {
                notesFromTo[j] = arrayOfNotes[i];
                j++;
            }
        }
        return notesFromTo;
    }

    public void sort() {
        Arrays.sort(Arrays.copyOfRange(arrayOfNotes, 0, size));
    }

    public String defineFrequencyOfIndividualCase(String individualCase) {
        Pattern pattern = Pattern.compile(".*" + individualCase + ".*");
        Matcher matcher;
        StringBuilder frequency = new StringBuilder();
        int totalNumberOfCase = 0;
        int n;
        DateFormat dateFormat = new SimpleDateFormat("   dd.MM.yyyy ");
        for (int i = 0; i < size; i++) {
            n = 0;
            StringBuilder cases = new StringBuilder(arrayOfNotes[i].getText());
            matcher = pattern.matcher(cases);
            while (matcher.find()) {
                n++;
            }
            if (n != 0) {
                totalNumberOfCase += n;
                frequency.append(cases).append(dateFormat.format(arrayOfNotes[i].getDate())).append(";\n");
            }
        }
        String delimiter = totalNumberOfCase == 1 ? " case -> \n" : " cases -> \n";
        return totalNumberOfCase + delimiter + frequency;
    }
}
