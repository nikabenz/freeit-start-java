package edu.freeit.lesson7;

import java.util.Comparator;

public class NotesComparator implements Comparator<Note> {
    @Override
    public int compare(Note thisNote, Note otherNote) {
        if (thisNote.getDate().before(otherNote.getDate())) {
            return -1;
        } else if (thisNote.getDate().after(otherNote.getDate())) {
            return 1;
        }
        return 0;
    }
}
