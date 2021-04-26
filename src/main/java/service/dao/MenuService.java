package service.dao;

import model.Song;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import static service.dao.Connector.connectList;
import static service.filesService.PrinterCSV.printAllToCsv;
import static service.filesService.PrinterXML.printToXML;
import static service.filesService.ReaderCSV.readSongsCSV;
import static service.dao.Sorter.*;
import static service.dao.ViewerList.showSongsList;
import static service.filesService.ReaderXML.readXML;

public class MenuService {

    private static Scanner scanner = new Scanner(System.in);
    private static String option = "";

    public static void getOption1(ArrayList<Song> songs) throws IOException, ParserConfigurationException, SAXException {
        String answer;
        String formatFile;
        ArrayList<Song> nextList = new ArrayList<>();
        do {
            System.out.println("Proszę podać ścieżkę do pliku");
            System.out.print(">: ");
            formatFile = scanner.nextLine();
            if (formatFile.contains(".csv")) {
                nextList = readSongsCSV(formatFile);
                System.out.println();
            } else if (formatFile.contains(".xml")) {
                nextList = readXML(formatFile);
            } else {
                System.out.println("Nie rozpoznano!!");
            }
            if (!nextList.isEmpty()) {
                connectList(songs, nextList);
            }
            System.out.println("Chcesz wczytać kolejną listę? Y/N");
            System.out.print(">: ");
            answer = scanner.nextLine().toUpperCase();
        } while (answer.contains("Y"));
    }

    public static void getOption7(ArrayList<Song> songs) {
        final int songsSize = songs.size();
        System.out.println("Wygeneruj raport z rankingu:");
        System.out.println("1 - Dla wszystkich piosenek");
        System.out.println("2 - Top 3");
        System.out.println("3 - Top 10");
        System.out.print(">: ");
        option = scanner.nextLine();
        System.out.println();
        switch (option) {
            case "1":
                getQestion(sortByVotes(songs));
                break;
            case "2":
                final int top3 = 3;
                if (songsSize >= top3) {
                    getQestion(getTop3(songs));
                } else {
                    System.out.println("Lista jest za krótka.");
                }
                break;
            case "3":
                final int top10 = 10;
                if (songsSize >= top10) {
                    getQestion(getTop10(songs));
                } else {
                    System.out.println("Lista jest za krótka.");
                }
                break;
            default:
        }
    }

    public static void getOption8(ArrayList<Song> songs) {
        getQestion(sortByCategory(songs));
    }

    private static void getQestion(ArrayList<Song> songs) {
        System.out.println("Czy wyświetlić raport? Y/N");
        System.out.print(">: ");
        option = scanner.nextLine().toUpperCase();
        if (option.equals("Y")) {
            showSongsList(songs);
            getPrintQuestion(songs);
        } else {
            getPrintQuestion(songs);
        }
    }

    private static void getPrintQuestion(ArrayList<Song> songs) {
        System.out.println("Czy zapisać raport do pliku? Y/N");
        System.out.print(">: ");
        option = scanner.nextLine().toUpperCase();
        if (option.equals("Y")) {
            System.out.println("Wprowadź ścieżkę pliku oraz nazwę pliku.");
            System.out.print(">: ");
            option = scanner.nextLine();
            if (option.contains(".csv")) {
                printAllToCsv(songs, option);
            } else if (option.contains(".xml")) {
                printToXML(songs, option);
            } else {
                System.out.println("Prosze podać plik w formacie .csv lub .xml");
                getPrintQuestion(songs);
            }
        }
    }

}
