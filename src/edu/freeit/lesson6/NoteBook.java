package edu.freeit.lesson6;

import java.util.StringJoiner;

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

    public void setArrayOfNotes(Note[] arrayOfNotes) {
        this.arrayOfNotes = arrayOfNotes;
    }

    public void addNote(Note note, int index) {
        this.arrayOfNotes[index] = note;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public void print() {
        for (Note note : arrayOfNotes) {
            System.out.println(note + "\n");
        }
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

    @Override
    public String toString() {
        return new StringJoiner(", ", NoteBook.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("category='" + category + "'")
                .toString();
    }
}
