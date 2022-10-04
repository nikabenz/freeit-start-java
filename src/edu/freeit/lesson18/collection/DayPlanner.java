package edu.freeit.lesson18.collection;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DayPlanner implements NoteBook {

    private List<Note> notes;

    public DayPlanner() {
        this.notes = new ArrayList<>();
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    @Override
    public boolean addNote(Note note) {
        notes.add(note);
        return false;
    }

    @Override
    public Note getNote(Date date) {
        return null;
    }

    @Override
    public Note updateNote(Date date, String text) {
        return null;
    }

    @Override
    public Note deleteNote(Date date) {
        Note note = null;
        for (int i = 0; i < notes.size(); i++) {
            if (notes.get(i).getDate().equals(date)) {
                note = notes.get(i);
                break;
            }
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        if (notes.remove(note)) {
            //System.out.println(note + " is deleted");
            return note;
        }
        //System.out.println("Sorry, note from " + simpleDateFormat.format(date) + "is not found");
        return null;
    }
}
