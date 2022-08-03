package edu.freeit.lesson7;

import java.util.Date;

public interface NoteBook {
    void addNote(Note note);

    Note getNote(Date date);

    Note updateNote(Date date, Note newNote);

    Note deleteNote(Date date);

    void print(Note[] notes);

    Note[] sort(Note[] notes);
}
