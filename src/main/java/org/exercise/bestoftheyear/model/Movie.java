package org.exercise.bestoftheyear.model;

public class Movie {
    static int count = 1;
    private int id;
    private String title;

    public Movie( String title) {
        this.id = count;
        this.title = title;
        count++;
        if(count >= 4){
            count = 1;
        }
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
