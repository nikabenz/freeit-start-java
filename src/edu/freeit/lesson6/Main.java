package edu.freeit.lesson6;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Person mars = new Person(1, "mars");
        NoteBook noteBook = new NoteBook(11, " diary");
        noteBook.setOwner(mars);
        Note note1 = new Note(110, "read");
        noteBook.addNote(note1, 0);
        Note note2 = new Note(111, "read");
        noteBook.addNote(note2, 1);
        Note note3 = new Note(112, "read");
        noteBook.addNote(note3, 2);
        for (int i = 3; i < noteBook.getLength(); i++) {
            noteBook.addNote(new Note(110 + i, "to-do list " + i), i);
            Thread.sleep(4000);
        }
        System.out.println("----------------------------------------------------------------------------------------output before to sort");

        noteBook.print();
        System.out.println("----------------------------------------------------------------------------------------output after to sort");
        noteBook.sort();
        noteBook.print();
        System.out.println("----------------------------------------------------------------------------------------output frequency dictionary");
        System.out.println(noteBook.getNote(0).getText());
        System.out.println(noteBook.defineFrequency(0));
        System.out.println(noteBook.getNote(noteBook.getLength() - 1).getText());
        System.out.println(noteBook.defineFrequency(noteBook.getLength() - 1));
    }
}
