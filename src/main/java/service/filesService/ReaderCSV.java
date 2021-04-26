package service.filesService;

import model.ECategory;
import model.Song;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ReaderCSV {
    public static ArrayList<Song> readSongsCSV(String stringPath) throws IOException {
        Path path = Paths.get(stringPath);
        ArrayList<String> reading = (ArrayList) Files.readAllLines(path);
        ArrayList<Song> songsList = convertToObject(reading);
        return songsList;
    }

    private static ArrayList<Song> convertToObject(ArrayList<String> reading) {
        ArrayList<Song> songsList = new ArrayList<>();
        for (String string : reading) {
            String[] field = string.trim().split(",");
            try {
                songsList.add(new Song(field[0], field[1]
                        , field[2], ECategory.valueOf(field[3].toUpperCase()),
                        Integer.parseInt(field[4])));
            } catch (IllegalArgumentException exception) {
                System.out.println("Zły format piosenki " + field[0]);
            }
        }
        return songsList;
    }
}
