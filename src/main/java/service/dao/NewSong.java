package service.dao;

import model.ECategory;
import model.Song;

import java.util.ArrayList;
import java.util.Scanner;

public class NewSong {
    public static void addSong(ArrayList<Song> songs) {
        Scanner scanner = new Scanner(System.in);
        Song newSong = new Song();
        System.out.println("Podaj tytuł piosenki");
        System.out.print(">: ");
        newSong.setTitle(scanner.nextLine());
        System.out.println("Podaj autora piosenki");
        System.out.print(">: ");
        newSong.setAuthor(scanner.nextLine());
        System.out.print(">: ");
        System.out.println("Podaj album");
        System.out.print(">: ");
        newSong.setAlbum(scanner.nextLine());
        System.out.println("Podaj jedną z dostępnych kategorii: ALTERNATIVE, METAL, ROCK, POP, RNB ");
        System.out.print(">: ");
        String err;
        do {
            try {
                newSong.setCategory(ECategory.valueOf(scanner.nextLine().toUpperCase()));
                err = "ok";
            } catch (IllegalArgumentException exception) {
                System.out.println("Nie prawidłowa katergoria, uzupełnij pole ponownie.");
                System.out.print(">: ");
                err = "error";
            }
        } while (err.contains("error"));
        System.out.println("Podaj ile głosów ma otrzymać piosenka");
        System.out.print(">: ");
        String votes = scanner.nextLine();
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
