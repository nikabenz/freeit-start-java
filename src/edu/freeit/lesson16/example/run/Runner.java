package edu.freeit.lesson16.example.run;

import edu.freeit.lesson16.example.model.utilconst.BookParserType;
import edu.freeit.lesson16.example.model.utilconst.BookWriterType;
import edu.freeit.lesson16.example.model.Library;
import edu.freeit.lesson16.example.service.LibraryService;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.Scanner;

public class Runner {
    public static final String XML_FROM = "library.xml";
    public static final String XML_TO = "newLibrary.xml";
    public static final String FIRST = "1";
    public static final String SECOND = "2";
    public static final String THIRD = "3";

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, TransformerException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        String user;
        System.out.println("Хотите посмотреть каталог? выход - q");
        user = scanner.nextLine().trim().toLowerCase();
        if (user.equals("q")) {
            System.out.println("Вы вышли");
            scanner.close();
            return;
        }
        Library library = new Library();
        LibraryService service = new LibraryService();
        do {
            service.checkCatalogue(library);
            System.out.println("С помощью какого инструмента заполняем каталог? 1 - DOM, 2 - SAX, 3 - StAX");
            do {
                user = scanner.nextLine().trim();
                if (user.equals(FIRST) || user.equals(SECOND) || user.equals(THIRD)) {
                    break;
                }
                System.out.println("Сделайте выбор: 1 - DOM, 2 - SAX, 3 - StAX");
            } while (true);
            switch (user) {
                case FIRST -> service.downloadBooks(library, XML_FROM, BookParserType.DOM);
                case SECOND -> service.downloadBooks(library, XML_FROM, BookParserType.SAX);
                case THIRD -> service.downloadBooks(library, XML_FROM, BookParserType.STAX);
            }
            service.checkCatalogue(library);
            System.out.println("С помощью какого инструмента выгружаем каталог? 1 - DOM, 2 - StAX, 3 - StAX-Event");
            do {
                user = scanner.nextLine().trim();
                if (user.equals(FIRST) || user.equals(SECOND) || user.equals(THIRD)) {
                    break;
                }
                System.out.println("Сделайте выбор: 1 - DOM, 2 - StAX-Stream, 3 - StAX-Event");
            } while (true);
            switch (user) {
                case FIRST -> service.unloadBooks(library, XML_TO, BookWriterType.DOM);
                case SECOND -> service.unloadBooks(library, XML_TO, BookWriterType.STAX);
                case THIRD -> service.unloadBooks(library, XML_TO, BookWriterType.STAX_EVENT);
            }
            service.checkCatalogue(library);
            System.out.println("Ещё? y/n");
            user = scanner.nextLine().trim().toLowerCase();
        } while (!user.equals("n"));
        System.out.println("Завершили");
        scanner.close();
    }
}
