package edu.freeit.lesson18.collection.service.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileUtility {
    public static File createFile() {
        File file = null;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String delimiter = System.getProperty("file.separator");
            System.out.println("Specify the name of the folder in which you create the file");
            String folderName = reader.readLine();
            System.out.println("To create a file, specify the file name with the extension");
            String fileName = reader.readLine();
            String filePath = "d:" + delimiter + folderName + delimiter + fileName;
            file = new File(filePath);
            if (file.isFile()) {
                System.out.println(filePath);
            } else {
                System.out.println("File is created: " + file.getName());
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    public static File createDir() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String delimiter = System.getProperty("file.separator");
        System.out.println("Specify the name of the directory");
        String nameDir = null;
        try {
            nameDir = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String filePath = "d:" + delimiter + nameDir;

        File file = new File(filePath);

        if (file.isDirectory()) {
            System.out.println("Created successfully: " + filePath);

        } else {
            System.out.println("Catalogue is created: " + filePath);
            file.mkdir();
        }
        return file;
    }

    public static void getDirList(File dir) {
        String dirName = dir.getName();
        File fDir = new File(dirName);
        if (fDir.isDirectory()) {
            System.out.println("Directory " + dirName);
            String[] list = fDir.list();
            for (int i = 0; i < list.length; i++) {
                File file = new File(dirName + "/" + list[i]);
                if (file.isDirectory()) {
                    System.out.println(list[i] + " is directory");
                } else {
                    System.out.println(list[i] + " is file");
                }
            }
        } else {
            System.out.println(dirName + " is not directory");
        }
    }

    public static void isDirList(File dir) {

        if (dir.isDirectory()) {
            for (File file : dir.listFiles()) {
                if (file.isDirectory()) {
                    System.out.println(file.getName() + " \tdirectory");
                } else {
                    System.out.println(file.getName() + " \tfile");
                }
            }
        } else {
            System.out.println(dir.getName() + " is not directory");
        }
    }
}
