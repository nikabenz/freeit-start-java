package edu.freeit.lesson18.collection;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;
import java.util.StringJoiner;

public class Note implements Comparable<Note> {
    private int id;
    private Date date;
    private Activity type;
    private String text;

    public Note() {
        this.date = new GregorianCalendar().getTime();
    }

    public Note(String text) {
        this.date = new GregorianCalendar().getTime();
        this.type = Activity.PLANNING;
        this.text = text;
    }

    public Note(Date date, Activity type, String text) {
        this.date = date;
        this.type = type;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public Activity getType() {
        return type;
    }

    public String getText() {
        return text;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setType(Activity type) {
        this.type = type;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return new StringJoiner(", ", "[", "]")
                .add("date=" + simpleDateFormat.format(date))
                .add("topic='" + type + "'")
                .add("text='" + text + "'")
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return id == note.id && date.equals(note.date) && type == note.type && Objects.equals(text, note.text);
    }

    @Override
    public int compareTo(Note other) {
        return this.getDate().before(other.getDate()) ? -1 : this.getDate().after(other.getDate()) ? 1 : 0;
    }
}
