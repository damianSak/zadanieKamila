package service.dao;

import model.Song;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sorter {

    public static ArrayList<Song> sortByCategory(List<Song> songs) {
        ArrayList<Song> sortedsongs = new ArrayList<>();
        songs.stream()
                .sorted(Comparator.comparing(Song::getCategory))
                .forEach(sortedsongs::add);
        return sortedsongs;
    }
    public static ArrayList<Song> getTop10(ArrayList<Song> songs) {
        ArrayList<Song> rankingSongs = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            rankingSongs.add(sortByVotes(songs).get(i));
        }
        return rankingSongs;
    }
    public static ArrayList<Song> getTop3(ArrayList<Song> songs) {
        ArrayList<Song> rankingSongs = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            rankingSongs.add(sortByVotes(songs).get(i));
        }
        return rankingSongs;
    }
    public static ArrayList<Song> sortByVotes(List<Song> songs) {
        ArrayList<Song> revsongs = new ArrayList<>();
        songs.stream()
                .sorted(Comparator.comparingInt(Song::getVotes))
                .forEach(revsongs::add);
        Collections.reverse(revsongs);
        return revsongs;
    }
}

