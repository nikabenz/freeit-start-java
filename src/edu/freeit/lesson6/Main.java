package edu.freeit.lesson6;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Person mars = new Person(1, "mars");
        NoteBook noteBook = new NoteBook(11, " diary");
        noteBook.setOwner(mars);
        //Note note1 = new Note(110, "read a book in English");
        //noteBook.addNote(note1, 0);
        Note note2 = new Note(111, "read a magazine");
        noteBook.addNote(note2, 1);
        Note note3 = new Note(112, "write and read articles, analyze articles");
        noteBook.addNote(note3, 2);
        for (int i = 3; i < noteBook.getLength(); i++) {
            if (i % 2 == 0) {
                noteBook.addNote(new Note(110 + i, "to-do list " + i + " and read a lot of letters"), i);
            } else {
                noteBook.addNote(new Note(110 + i, "to-do list " + i), i);
            }
            Thread.sleep(4000);
        }
//        System.out.println("----------------------------------------------------------------------------------------output before to sort");
//
//        noteBook.print();
//        System.out.println("----------------------------------------------------------------------------------------output after to sort");
//        noteBook.sort();
//        noteBook.print();
        System.out.println("----------------------------------------------------------------------------------------output frequency dictionary");

        System.out.println(noteBook.defineFrequencyIndividualCase("read"));
        System.out.println(noteBook.defineFrequencyIndividualCase("to-do"));
        System.out.println(noteBook.defineFrequencyIndividualCase("write"));
        System.out.println(noteBook.defineFrequencyIndividualCase("analyze"));
        System.out.println(noteBook.defineFrequencyIndividualCase("\\d"));
        System.out.println("number of notes -> " + noteBook.getSizeArrayOfNotes());
    }
}
