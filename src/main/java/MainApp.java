import model.Song;
import org.xml.sax.SAXException;
import service.*;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.Scanner;
import static service.dao.MenuService.*;
import static service.dao.NewSong.addSong;
import static service.filesService.ReaderCSV.readSongsCSV;
import static service.dao.Remover.deletVoteFromAllSongs;
import static service.dao.Remover.deleteVoteOneSong;
import static service.dao.ViewerList.showSongsList;
import static service.dao.Vote.giveVoteToSong;
import static service.filesService.ReaderXML.readXML;

public class MainApp {
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Song> firstList;
        String formatFile;
        String err;
        System.out.println("Witaj w serwisie piosenek");
        do {
            System.out.println("Podaj ścieżkę do pliku ze swoją listą:");
            System.out.print(">: ");
            formatFile = scanner.nextLine();
            try {
                if (formatFile.contains(".csv")) {
                    firstList = readSongsCSV(formatFile);
                    System.out.println();
                    displayMenu(firstList);
                    err = "ok";
                } else if (formatFile.contains(".xml")) {
                    firstList = readXML(formatFile);
                    System.out.println();
                    displayMenu(firstList);
                    err = "ok";
                } else {
                    System.out.println("Prosze podać plik w formacie .csv lub .xml");
                    err = "error";
                }
            } catch (NoSuchFileException | FileNotFoundException exception) {
                System.out.println("Nie znaleziono takiego pliku");
                err = "error";
            }
        } while (err.contains("error"));
    }

    private static void displayMenu(ArrayList<Song> firstList) throws IOException, ParserConfigurationException, SAXException {
        Scanner scanner = new Scanner(System.in);
        String option = " ";
        while (!(option.equals("0"))) {
            MenuList.showMenu();
            System.out.print(">: ");
            option = scanner.nextLine();
            System.out.println();

            switch (option) {
                case "0":
                    System.out.println("Bye!!");
                    break;
                case "1":
                    getOption1(firstList);
                    break;
                case "2":
                    showSongsList(firstList);
                    break;
                case "3":
                    addSong(firstList);
                    break;
                case "4":
                    giveVoteToSong(firstList);
                    break;
                case "5":
                    deleteVoteOneSong(firstList);
                    break;
                case "6":
                    deletVoteFromAllSongs(firstList);
                    break;
                case "7":
                    getOption7(firstList);
                    break;
                case "8":
                    getOption8(firstList);
                    break;
                default:
                    System.out.println("Wybierz ponownie");
                    break;

            }
        }
    }
}