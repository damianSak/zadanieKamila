package service.dao;

import model.Song;

import java.util.ArrayList;

public class ListConnector {
    public static ArrayList<Song> connectList(ArrayList<Song> mainList, ArrayList<Song> bonusList) {
        ArrayList<Song> temp = new ArrayList<>();
        ArrayList<Song> temp2 = new ArrayList<>();
        for (Song song : mainList) {
            temp.add(new Song(song.getTitle(), song.getAuthor(), song.getAlbum(), song.getCategory()));
        }
        for (Song song : bonusList) {
            temp2.add(new Song(song.getTitle(), song.getAuthor(), song.getAlbum(), song.getCategory()));
        }
        int i = 0;
        for (Song elem : temp2) {
            if (temp.contains(elem)) {
                for (Song song : temp) {
                    if (song.equals(elem)) {
                        mainList.get(i).setVotes(mainList.get(i).getVotes() + bonusList.get(i).getVotes());
                        System.out.println(song.getTitle() + " występuje na twojej liście.");
                    }
                }
            } else {
                mainList.add(bonusList.get(i));
            }
            i++;
        }
        System.out.println();
        System.out.println("Udało się dodać piosenki z listy. \n");
        return mainList;
    }
}
