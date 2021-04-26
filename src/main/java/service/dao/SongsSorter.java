package service.dao;

import model.Song;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SongsSorter {

    public static ArrayList<Song> sortSongsByCategory(List<Song> songs) {
        ArrayList<Song> sortedSongsList = new ArrayList<>();
        songs.stream()
                .sorted(Comparator.comparing(Song::getCategory))
                .forEach(sortedSongsList::add);
        return sortedSongsList;
    }

    public static ArrayList<Song> getTop10Songs(ArrayList<Song> songs) {
        return giveTopList(songs,10);
    }

    public static ArrayList<Song> getTop3Songs(ArrayList<Song> songs) {
       return giveTopList(songs,3);
    }

    public static ArrayList<Song> sortSongsByVotes(List<Song> songs) {
        ArrayList<Song> sortedSongsList = new ArrayList<>();
        songs.stream()
                .sorted(Comparator.comparingInt(Song::getVotes))
                .forEach(sortedSongsList::add);
        Collections.reverse(sortedSongsList);
        return sortedSongsList;
    }

    public static ArrayList<Song> giveTopList(ArrayList<Song> songs,int numberOfPosition ){
        ArrayList<Song> rankingSongsList = new ArrayList<>();
        for (int i = 0; i < numberOfPosition; i++) {
            rankingSongsList.add(sortSongsByVotes(songs).get(i));
        }
        return rankingSongsList;
    }
}

