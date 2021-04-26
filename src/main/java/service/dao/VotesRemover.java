package service.dao;

import model.Song;
import utils.StringHandler;

import java.util.ArrayList;

public class VotesRemover {

    public static ArrayList<Song> deleteVotesFromOneSong(ArrayList<Song> songs) {
        ListViewer.showSongsListOnConsole(songs);
        String votes = StringHandler.printMessageWithChooseOption("Podaj numer piosenki z listy której głosy chcesz usunąć: ");
        if (votes.length() > 0 && Integer.parseInt(votes) - 1 == songs.size()) {
            int id = Integer.parseInt(votes) - 1;
            songs.get(id).setVotes(0);
            System.out.println("Wyzerowano głosy.");
        } else {
            System.out.println("Nie udało się wyzerować głosów.");
        }
        return songs;
    }

    public static ArrayList<Song> deleteVotesFromAllSongs(ArrayList<Song> songs) {
        for (Song song : songs) {
            song.setVotes(0);
        }
        System.out.println("Wyzerowano wszystkie głosy.");
        return songs;
    }
}
