package service.filesService;

import model.Song;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import static service.dao.Sorter.sortByVotes;

public class PrinterCSV {
    public static void printAllToCsv(ArrayList<Song> songs, String stringPath) {
        Path path = Paths.get(stringPath);
        ArrayList<String> listToprint = new ArrayList<>();
        for (Song song : sortByVotes(songs)) {
            listToprint.add(song.split(","));
        }
        listToprint.add(0, "Title,Author,Album,Category,Votes");
        try {
            Files.write(path, listToprint);
            System.out.println("Zapisano plik pomyślnie.");
        } catch (IOException exception) {
            System.out.println("Nie utworzono pliku.");
        }
    }
}
