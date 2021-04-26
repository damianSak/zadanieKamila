package model;

import java.util.Objects;

public class Song {

    private String title;
    private String author;
    private String album;
    private ECategory category;
    private Integer votes;

    public Song() {
    }

    public Song(String title, String author, String album, ECategory category) {
        this.title = title;
        this.author = author;
        this.album = album;
        this.category = category;
    }

    public Song(String title, String author, String album, ECategory category, int votes) {

        this.title = title;
        this.author = author;
        this.album = album;
        this.category = category;
        this.votes = votes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public ECategory getCategory() {
        return category;
    }

    public void setCategory(ECategory category) {
        this.category = category;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Song)) return false;
        Song song = (Song) o;
        return votes == song.votes &&
                Objects.equals(title, song.title) &&
                Objects.equals(author, song.author) &&
                Objects.equals(album, song.album) &&
                Objects.equals(category, song.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, album, category, votes);
    }

    @Override
    public String toString() {
        return title + " " + author + " " + album + " " + category + " " + votes;
    }

    public String split(String separator) {
        return getTitle() + separator + getAuthor()
                + separator + getAlbum() + separator
                + getCategory() + separator
                + getVotes();
    }
}

