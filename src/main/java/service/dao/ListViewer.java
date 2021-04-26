package service.dao;

import model.Song;

import java.util.ArrayList;

public class ListViewer {
    public static void showSongsListOnConsole(ArrayList<Song> songs) {
        int i = 1;
        for (Song song : songs) {
            System.out.println("Nr " + i + " " + song.toString());
            i++;
        }
    }
}
