package service.dao;

import model.Song;
import java.util.ArrayList;
import java.util.Scanner;

public class Vote {
    private static Scanner scanner = new Scanner(System.in);

    public static ArrayList<Song> giveVoteToSong(ArrayList<Song> songs) {
        ViewerList.showSongsList(songs);
        System.out.println();
        System.out.println("Podaj numer pisenki z listy.");
        System.out.print(">: ");
        String votes = scanner.nextLine();
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
