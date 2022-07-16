package edu.freeit.lesson6;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NoteBook {
    private int length;
    private String category;
    private Note[] arrayOfNotes;

    public NoteBook() {
        this.length = 10;
        this.category = "to-do-list";
        this.arrayOfNotes = new Note[length];
    }

    public NoteBook(int length, String category) {
        this.length = length;
        this.category = category;
        this.arrayOfNotes = new Note[length];
    }

    public Note[] getArrayOfNotes() {
        return arrayOfNotes;
    }

    public Note getNote(int index) {
        return arrayOfNotes[index];
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

    public void setArrayOfNotes(Note[] arrayOfNotes) {
        this.arrayOfNotes = arrayOfNotes;
    }

    public void print() {
        for (Note note : arrayOfNotes) {
            if (note != null) {
                System.out.println(note + "\n");
            }
        }
    }

    public void print(Note[] notes) {
        for (Note note : notes) {
            System.out.println(note + "\n");
        }
    }

    public void addNote(Note note, int index) {
        this.arrayOfNotes[index] = note;
    }

    public Note[] sort() {
        Note temp;
        Note[] notes = defineArrayOfNotNullNotes();
        for (int i = 0; i < notes.length; i++) {
            for (int j = 0; j < notes.length - 1; j++) {
                if (notes[j].getDate().before(notes[j + 1].getDate())) {
                    temp = notes[j];
                    notes[j] = notes[j + 1];
                    notes[j + 1] = temp;
                }
            }
        }
        return notes;
    }

    public String defineFrequency(int index) {
        Note note = arrayOfNotes[index];
        Note[] temp = arrayOfNotes;
        String frequency = "";
        int n = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] != null) {
                if (temp[i].getText().equals(note.getText()) && !note.getText().equals("")) {
                    n++;
                }
            }
        }
        frequency = note.getText() + " -> " + n + "\n";
        return frequency;
    }

    public String defineFrequencyOfIndividualCase(String individualCase) {
        Pattern pattern = Pattern.compile(".*" + individualCase + ".*");
        Matcher matcher;
        Note[] temp = arrayOfNotes;
        StringBuilder frequency = new StringBuilder();
        StringBuilder cases;
        int totalNumberOfCase = 0;
        int n;
        DateFormat dateFormat = new SimpleDateFormat("   dd.MM.yyyy ");
        for (int i = 0; i < temp.length; i++) {
            n = 0;
            cases = new StringBuilder(temp[i] != null ? temp[i].getText() : "");
            matcher = pattern.matcher(cases);
            while (matcher.find()) {
                n++;
            }
            if (n != 0) {
                totalNumberOfCase += n;
                frequency.append(cases).append(dateFormat.format(temp[i].getDate())).append(";\n");
            }
        }
        String delimeter = totalNumberOfCase == 1 ? " case -> \n" : " cases -> \n";
        return totalNumberOfCase + delimeter + frequency.toString();
    }

    private Note[] defineArrayOfNotNullNotes() {
        int notNullElements = 0;
        for (int i = 0; i < arrayOfNotes.length; i++) {
            if (arrayOfNotes[i] != null) {
                notNullElements++;
            }
        }
        int j = 0;
        Note[] notNullNotes = new Note[notNullElements];
        for (int i = 0; i < arrayOfNotes.length; i++) {
            if (arrayOfNotes[i] != null) {
                notNullNotes[j] = arrayOfNotes[i];
                j++;
            }
        }
        return notNullNotes;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", NoteBook.class.getSimpleName() + "[", "]")
                .add("category='" + category + "'")
                .toString();
    }
}