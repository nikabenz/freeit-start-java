package edu.freeit.lesson6;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.StringJoiner;

public class Note {
    private long id;
    private Date date;
    private String topic;
    private String header;
    private String text;

    public Note() {
    }

    public Note(long id, String text) {
        this.id = id;
        this.date = new GregorianCalendar().getTime();
        this.topic = "";
        this.header = "to-do list";
        this.text = text;
    }

    public Note(long id, Date date, String topic, String header, String text) {
        this.id = id;
        this.date = date;
        this.topic = topic;
        this.header = header;
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public String getText() {
        return text;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Note.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("date=" + date)
                .add("topic='" + topic + "'")
                .add("header='" + header + "'")
                .add("text='" + text + "'")
                .toString();
    }
}
