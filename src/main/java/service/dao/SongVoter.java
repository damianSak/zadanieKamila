package service.dao;

import model.Song;
import utils.StringHandler;

import java.util.ArrayList;

public class SongVoter {

    public static ArrayList<Song> giveVoteToSong(ArrayList<Song> songs) {
        ListViewer.showSongsListOnConsole(songs);
        System.out.println();
        String votes = StringHandler.printMessageWithChooseOption("Podaj numer pisenki z listy.");
        if (votes.length() > 0) {
            int id = Integer.parseInt(votes) - 1;
            songs.get(id)
                    .setVotes(songs.get(id).getVotes() + 1);
        } else {
            System.out.println("Nie podano wartości.");
        }
        return songs;

    }
}
