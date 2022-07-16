package edu.freeit.lesson6;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        NoteBook noteBook = new NoteBook(111, " diary");
        Note note1 = new Note("read a book in English");
        noteBook.addNote(note1, 0);
        Note note2 = new Note("read a magazine");
        noteBook.addNote(note2, 1);
        Note note3 = new Note("write and read articles, analyze articles");
        noteBook.addNote(note3, 2);
        for (int i = 5; i < noteBook.getLength() - 100; i++) {
            if (i % 2 == 0) {
                noteBook.addNote(new Note("to-do list " + i + " and read a lot of letters"), i);
            } else {
                noteBook.addNote(new Note("to-do list " + i), i);
            }
            Thread.sleep(4000);
        }
        Note note101 = new Note("read a magazine, analyze articles");
        noteBook.addNote(note101, 100);
        System.out.println("----------------------------------------------------------------------------------------output before to sort");

        noteBook.print();
        System.out.println("----------------------------------------------------------------------------------------output after to sort");

        noteBook.print(noteBook.sort());
        System.out.println("----------------------------------------------------------------------------------------output frequency dictionary");

        System.out.println(noteBook.defineFrequencyOfIndividualCase("read"));
        System.out.println(noteBook.defineFrequencyOfIndividualCase("to-do"));
        System.out.println(noteBook.defineFrequencyOfIndividualCase("write"));
        System.out.println(noteBook.defineFrequencyOfIndividualCase("analyze"));
        System.out.println(noteBook.defineFrequencyOfIndividualCase("\\d"));
        System.out.println("number of diary entries -> " + noteBook.getSizeOfArrayOfNotes());
    }
}
