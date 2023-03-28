package org.exercise.bestoftheyear.model;

public class Song extends Content{
    private String author;

    public Song(int id, String title, String author) {
        super(id, title);
        this.author = author;
    }


    public int getId() {
        return super.getId();
    }

    public String getTitle() {
        return super.getTitle();
    }



    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + super.getId() +
                ", title='" + super.getTitle() + '\'' +
                "author='" + author + '\'' +
                '}';
    }
}
