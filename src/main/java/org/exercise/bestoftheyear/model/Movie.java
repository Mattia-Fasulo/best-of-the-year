package org.exercise.bestoftheyear.model;

public class Movie  extends Content{
    private String director;

    public Movie(int id, String title, String director) {
        super(id, title);
        this.director = director;
    }


    public int getId() {
        return super.getId();
    }

    public String getTitle() {
        return super.getTitle();
    }

    public String getDirector() {
        return director;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + super.getId() +
                ", title='" + super.getTitle() + '\'' +
                "director='" + director + '\'' +
                '}';
    }
}
