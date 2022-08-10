package edu.freeit.lesson7;

import java.util.Date;

public interface NoteBook {
    boolean addNote(Note note);

    Note getNote(Date date);

    Note updateNote(Date date, String text);

    Note deleteNote(Date date);
}
