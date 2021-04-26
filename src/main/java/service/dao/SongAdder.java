package service.dao;

import model.MusicCategory;
import model.Song;
import utils.StringHandler;

import java.util.ArrayList;

public class SongAdder {
    public static void addSongToCollection(ArrayList<Song> songs) {

        Song newSong = new Song();

        newSong.setTitle(StringHandler.printMessageWithChooseOption("Podaj tytuł piosenki"));

        newSong.setAuthor(StringHandler.printMessageWithChooseOption("Podaj autora piosenki"));

        newSong.setAlbum(StringHandler.printMessageWithChooseOption("Podaj album"));

        System.out.println("Podaj jedną z dostępnych kategorii: ALTERNATIVE, METAL, ROCK, POP, RNB ");
        System.out.print(">: ");
        String errorStatus;
        do {
            try {
                newSong.setCategory(MusicCategory.valueOf(StringHandler.readStringFromUser().toUpperCase()));
                errorStatus = "ok";
            } catch (IllegalArgumentException exception) {
                System.out.println("Nie prawidłowa katergoria, uzupełnij pole ponownie.");
                System.out.print(">: ");
                errorStatus = "error";
            }
        } while (errorStatus.contains("error"));

        String votes = StringHandler.printMessageWithChooseOption("Podaj ile głosów ma otrzymać piosenka");
        if (votes.length() > 0) {
            newSong.setVotes(Integer.parseInt(votes));
        } else {
            newSong.setVotes(0);
        }

        if (newSong.getTitle().length() == 0 || newSong.getAlbum().length() == 0 || newSong.getAuthor().length() == 0) {
            System.out.println("Nie udało sie dodać użytkownika z pustymi polami. Spróbuj ponownie.");
        } else {
            songs.add(newSong);
        }
    }
}
