package edu.freeit.lesson7;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.StringJoiner;

public class Note implements Comparable<Note> {
    private Date date;
    private Activity type;
    private String header;
    private String text;

    public Note() {
    }

    public Note(String text) {
        this.date = new GregorianCalendar().getTime();
        this.type = Activity.PLANNING;
        this.header = "to-do list";
        this.text = text;
    }

    public Note(Date date, Activity type, String header, String text) {
        this.date = date;
        this.type = type;
        this.header = header;
        this.text = text;
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
    public int compareTo(Note other) {
        return this.getDate().before(other.getDate()) ? -1 : this.getDate().after(other.getDate()) ? 1 : 0;
    }
}