
package edu.freeit.lesson6;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.StringJoiner;

public class Note {
    private Date date;
    private String topic;
    private String header;
    private String text;

    public Note() {
    }

    public Note(String text) {
        this.date = new GregorianCalendar().getTime();
        this.topic = "";
        this.header = "to-do list";
        this.text = text;
    }

    public Note(Date date, String topic, String header, String text) {
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
                .add("date=" + date)
                .add("topic='" + topic + "'")
                .add("header='" + header + "'")
                .add("text='" + text + "'")
                .toString();
    }
}