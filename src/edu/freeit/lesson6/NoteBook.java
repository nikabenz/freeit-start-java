package edu.freeit.lesson6;

import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NoteBook {
    private final int length = 10;
    private long id;
    private String category;
    Note[] arrayOfNotes;
    private Person owner;

    public NoteBook(long id, String category) {
        this.id = id;
        this.category = category;
        arrayOfNotes = new Note[length];
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

    public int getSizeArrayOfNotes() {
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

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public void print() {
        for (Note note : arrayOfNotes) {
            System.out.println(note + "\n");
        }
    }

    public void addNote(Note note, int index) {
        this.arrayOfNotes[index] = note;
    }

    public Note[] sort() {
        Note temp;
        for (int i = 0; i < arrayOfNotes.length; i++) {
            for (int j = 0; j < arrayOfNotes.length - 1; j++) {
                if (arrayOfNotes[j].getDate().before(arrayOfNotes[j + 1].getDate())) {
                    temp = arrayOfNotes[j];
                    arrayOfNotes[j] = arrayOfNotes[j + 1];
                    arrayOfNotes[j + 1] = temp;
                }
            }
        }
        return arrayOfNotes;
    }

    public String defineFrequency(int index) {
        Note note = arrayOfNotes[index];
        Note[] temp = arrayOfNotes;
        String frequency = "";
        int n = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i].getText().equals(note.getText()) && !note.getText().equals("")) {
                n++;
            }
        }
        frequency = note.getText() + " -> " + n + "\n";
        return frequency;
    }

    public String defineFrequencyIndividualCase(String individualCase) {
        Pattern pattern = Pattern.compile(".*" + individualCase + ".*");
        Matcher matcher;
        Note[] temp = arrayOfNotes;
        StringBuilder frequency = new StringBuilder();
        StringBuilder cases;
        int totalNumberOfCase = 0;
        int n;
        for (int i = 0; i < temp.length; i++) {
            n = 0;
            cases = new StringBuilder(temp[i] != null ? temp[i].getText() : "");
            matcher = pattern.matcher(cases);
            while (matcher.find()) {
                n++;
                //System.out.println(matcher.group() + " -> " + n);
            }
            if ( n != 0) {
                totalNumberOfCase += n;
                frequency.append(cases).append(";\n");
            }
        }
        String delimeter;
        if (totalNumberOfCase == 1) {
            delimeter = " case -> \n";
        } else {
            delimeter = " cases -> \n";
        }
        return totalNumberOfCase + delimeter + frequency.toString();
    }
    @Override
    public String toString() {
        return new StringJoiner(", ", NoteBook.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("category='" + category + "'")
                .toString();
    }
}
