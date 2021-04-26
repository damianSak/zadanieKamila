package service.dao;

import model.Song;
import org.xml.sax.SAXException;
import utils.StringHandler;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

import static service.dao.ListConnector.connectList;
import static service.filesService.PrinterCSV.printAllSongsToCsv;
import static service.filesService.PrinterXML.printSongsToXML;
import static service.filesService.ReaderCSV.readSongsFromCSV;
import static service.dao.SongsSorter.*;
import static service.dao.ListViewer.showSongsListOnConsole;
import static service.filesService.ReaderXML.readSongsFromXML;

public class MenuService {

    private static String option = "";

    public static void readSongsListFromFile(ArrayList<Song> songs) throws IOException, ParserConfigurationException, SAXException {
        String answer;
        String formatFile;
        ArrayList<Song> nextList = new ArrayList<>();
        do {
            formatFile = StringHandler.printMessageWithChooseOption("Proszę podać ścieżkę do pliku");
            if (formatFile.contains(".csv")) {
                nextList = readSongsFromCSV(formatFile);
                System.out.println();
            } else if (formatFile.contains(".xml")) {
                nextList = readSongsFromXML(formatFile);
            } else {
                System.out.println("Nie rozpoznano!!");
            }
            if (!nextList.isEmpty()) {
                connectList(songs, nextList);
            }
            answer = StringHandler.printMessageWithChooseOption("Chcesz wczytać kolejną listę? Y/N")
                    .toUpperCase();
        } while (answer.contains("Y"));
    }

    public static void generateSongsListByVotes(ArrayList<Song> songs) {
        final int songsSize = songs.size();
        System.out.println("Wygeneruj raport z rankingu:");
        System.out.println("1 - Dla wszystkich piosenek");
        System.out.println("2 - Top 3");
        System.out.println("3 - Top 10");
        System.out.print(">: ");
        option = StringHandler.readStringFromUser();
        System.out.println();
        switch (option) {
            case "1":
                printSongsOnConsole(sortSongsByVotes(songs));
                break;
            case "2":
                final int top3 = 3;
                if (songsSize >= top3) {
                    printSongsOnConsole(getTop3Songs(songs));
                } else {
                    System.out.println("Lista jest za krótka.");
                }
                break;
            case "3":
                final int top10 = 10;
                if (songsSize >= top10) {
                    printSongsOnConsole(getTop10Songs(songs));
                } else {
                    System.out.println("Lista jest za krótka.");
                }
                break;
            default:
        }
    }

    public static void generateSongsListByCategory(ArrayList<Song> songs) {
        printSongsOnConsole(sortSongsByCategory(songs));
    }

    private static void printSongsOnConsole(ArrayList<Song> songs) {
        option = StringHandler.printMessageWithChooseOption("Czy wyświetlić raport? Y/N")
                .toUpperCase();
        if (option.equals("Y")) {
            showSongsListOnConsole(songs);
            saveListToFile(songs);
        } else {
            saveListToFile(songs);
        }
    }

    private static void saveListToFile(ArrayList<Song> songs) {
        option = StringHandler.printMessageWithChooseOption("Czy zapisać raport do pliku? Y/N")
                .toUpperCase();
        if (option.equals("Y")) {
            option = StringHandler.printMessageWithChooseOption("Wprowadź ścieżkę pliku oraz nazwę pliku.");
            if (option.contains(".csv")) {
                printAllSongsToCsv(songs, option);
            } else if (option.contains(".xml")) {
                printSongsToXML(songs, option);
            } else {
                System.out.println("Prosze podać plik w formacie .csv lub .xml");
                saveListToFile(songs);
            }
        }
    }
}
