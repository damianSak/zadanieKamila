package service.dao;

import model.Song;
import java.util.ArrayList;
import java.util.Scanner;

public class Remover {
    private static Scanner scanner = new Scanner(System.in);

    public static ArrayList<Song> deleteVoteOneSong(ArrayList<Song> songs) {
        ViewerList.showSongsList(songs);
        System.out.println("Podaj numer piosenki z listy której głosy chcesz usunąć: ");
        System.out.print(">: ");
        String votes = scanner.nextLine();
        if (votes.length() > 0 && Integer.parseInt(votes) - 1 == songs.size()) {
            int id = Integer.parseInt(votes) - 1;
            songs.get(id).setVotes(0);
            System.out.println("Wyzerowano głosy.");
        } else {
            System.out.println("Nie udało się wyzerować głosów.");
        }
        return songs;
    }

    public static ArrayList<Song> deletVoteFromAllSongs(ArrayList<Song> songs) {
        for (Song song : songs) {
            song.setVotes(0);
        }
        System.out.println("Wyzerowano wszystkie głosy.");
        return songs;
    }
}
