package org.exercise.bestoftheyear.controller;

import org.exercise.bestoftheyear.model.Movie;
import org.exercise.bestoftheyear.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping
public class HomeController {
    @GetMapping
    public String home(Model model) {
        model.addAttribute("user", "Mattia");
        return "home";
    }

    @GetMapping("/movies")
    public String movies(Model model){
        List<Movie> bestMovies = getBestMovies();
        StringBuilder names = new StringBuilder();
        for(Movie m : bestMovies){
            names.append(m.getTitle()).append(", ");
        }
        names = new StringBuilder(names.substring(0, names.length() - 2));
        model.addAttribute("movies", names.toString());
        return "movies";
    }

    @GetMapping("/songs")
    public String songs(Model model){
        List<Song> bestSongs = getBestSongs();
        StringBuilder names = new StringBuilder();
        for(Song m : bestSongs){
            names.append(m.getTitle()).append(", ");
        }
        names = new StringBuilder(names.substring(0, names.length() - 2));
        model.addAttribute("songs", names.toString());
        return "songs";
    }

    private List<Movie> getBestMovies(){
        List<Movie> bestMovies = new ArrayList<>();
        bestMovies.add(new Movie("Blade Runner"));
        bestMovies.add(new Movie("Matrix"));
        bestMovies.add(new Movie("Il Padrino"));
        return bestMovies;
    }

    private List<Song> getBestSongs(){
        List<Song> bestSongs = new ArrayList<>();
        bestSongs.add(new Song("Hog"));
        bestSongs.add(new Song("Ouverture"));
        bestSongs.add(new Song("Non crollo"));
        return bestSongs;
    }
}
