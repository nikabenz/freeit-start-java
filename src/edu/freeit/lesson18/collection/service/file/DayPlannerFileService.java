package edu.freeit.lesson18.collection.service.file;

import edu.freeit.lesson18.collection.Activity;
import edu.freeit.lesson18.collection.DayPlanner;
import edu.freeit.lesson18.collection.Note;
import edu.freeit.lesson18.collection.service.DayPlannerService;
import edu.freeit.lesson18.collection.service.util.FileUtility;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DayPlannerFileService implements DayPlannerService {
    public DayPlannerFileService() {

    }

    public static void main(String[] args) throws IOException {
        FileUtility.createDir();
        File file = FileUtility.createFile();
        System.out.println("AbsolutePath " + file.getAbsolutePath());
        FileUtility.getDirList(file);
        FileUtility.isDirList(file);
    }

    @Override
    public void downloadNotes(String fromFile, DayPlanner dayPlanner) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fromFile))) {
            bufferedReader.markSupported();
            bufferedReader.mark(1000);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
            int countLinesInFile = 0;
            while (bufferedReader.readLine() != null) {
                countLinesInFile++;
            }
            bufferedReader.reset();
            int countNotesInFile;
            for (countNotesInFile = 0; countNotesInFile < (countLinesInFile / 3); countNotesInFile++) {
                Note note = new Note();
                note.setDate(simpleDateFormat.parse(bufferedReader.readLine()));
                note.setType(Activity.valueOf(bufferedReader.readLine()));
                note.setText(bufferedReader.readLine());
                dayPlanner.getNotes().add(note);
            }
            System.out.println("Add " + countNotesInFile + " notes to day-planner");
        } catch (ParseException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void unloadNotes(DayPlanner dayPlanner) {
        FileUtility.createDir();
        File file = FileUtility.createFile();
        System.out.println("AbsolutePath " + file.getAbsolutePath());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        try (PrintWriter printWriter = new PrintWriter(file)) {
            for (int i = 0; i < dayPlanner.getNotes().size(); i++) {
                Note note = dayPlanner.getNotes().get(i);
                printWriter.println(simpleDateFormat.format(note.getDate()));
                printWriter.println(note.getType());
                printWriter.println(note.getText());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        dayPlanner.getNotes().clear();
    }
}
