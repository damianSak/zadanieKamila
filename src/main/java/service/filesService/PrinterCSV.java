package service.filesService;

import model.Song;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import static service.dao.SongsSorter.sortSongsByVotes;

public class PrinterCSV {
    public static void printAllSongsToCsv(ArrayList<Song> songs, String stringPath) {
        Path path = Paths.get(stringPath);
        ArrayList<String> topListToPrint = new ArrayList<>();
        for (Song song : sortSongsByVotes(songs)) {
            topListToPrint.add(song.split(","));
        }
        topListToPrint.add(0, "Title,Author,Album,Category,Votes");
        try {
            Files.write(path, topListToPrint);
            System.out.println("Zapisano plik pomyślnie.");
        } catch (IOException exception) {
            System.out.println("Nie utworzono pliku.");
        }
    }
}
