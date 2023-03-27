package org.exercise.bestoftheyear.model;

public class Song {
    static int count = 1;
    private int id;
    private String title;

    public Song( String title) {
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
}
