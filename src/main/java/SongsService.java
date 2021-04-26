import model.Song;
import org.xml.sax.SAXException;
import service.MenuList;
import utils.StringHandler;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;

import static service.dao.ListViewer.showSongsListOnConsole;
import static service.dao.MenuService.*;
import static service.dao.SongAdder.addSongToCollection;
import static service.dao.SongVoter.giveVoteToSong;
import static service.dao.VotesRemover.deleteVotesFromAllSongs;
import static service.dao.VotesRemover.deleteVotesFromOneSong;
import static service.filesService.ReaderCSV.readSongsFromCSV;
import static service.filesService.ReaderXML.readSongsFromXML;

public class SongsService {

    ArrayList<Song> firstList;
    String formatFile;
    String error;

    public void initializeServis() {
        System.out.println("Witaj w serwisie piosenek");
        do {
            System.out.println("Podaj ścieżkę do pliku ze swoją listą:");
            System.out.print(">: ");
            formatFile = StringHandler.readStringFromUser();
            try {
                if (formatFile.contains(".csv")) {
                    firstList = readSongsFromCSV(formatFile);
                    System.out.println();
                    displayMenu(firstList);
                    error = "ok";
                } else if (formatFile.contains(".xml")) {
                    firstList = readSongsFromXML(formatFile);
                    System.out.println();
                    displayMenu(firstList);
                    error = "ok";
                } else {
                    System.out.println("Prosze podać plik w formacie .csv lub .xml");
                    error = "error";
                }
            } catch (NoSuchFileException | FileNotFoundException exception) {
                System.out.println("Nie znaleziono takiego pliku");
                error = "error";
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            }
        } while (error.contains("error"));
    }

    private static void displayMenu(ArrayList<Song> firstList) throws IOException, ParserConfigurationException, SAXException {
        String option = " ";
        while (!(option.equals("0"))) {
            MenuList.showMenu();
            System.out.print(">: ");
            option = StringHandler.readStringFromUser();
            System.out.println();

            switch (option) {
                case "0":
                    System.out.println("Bye!!");
                    StringHandler.closeScanner();
                    break;
                case "1":
                    readSongsListFromFile(firstList);
                    break;
                case "2":
                    showSongsListOnConsole(firstList);
                    break;
                case "3":
                    addSongToCollection(firstList);
                    break;
                case "4":
                    giveVoteToSong(firstList);
                    break;
                case "5":
                    deleteVotesFromOneSong(firstList);
                    break;
                case "6":
                    deleteVotesFromAllSongs(firstList);
                    break;
                case "7":
                    generateSongsListByVotes(firstList);
                    break;
                case "8":
                    generateSongsListByCategory(firstList);
                    break;
                default:
                    System.out.println("Wybierz ponownie");
                    break;
            }
        }
    }
}
