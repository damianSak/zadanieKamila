package service.dao;

import model.Song;

import java.util.ArrayList;

public class ViewerList {
    public static void showSongsList(ArrayList<Song> songs) {
        int i = 1;
        for (Song song : songs) {
            System.out.println("Nr " + i + " " + song.toString());
            i++;
        }
    }
}
