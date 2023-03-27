package org.exercise.bestoftheyear.controller;

import org.exercise.bestoftheyear.model.Movie;
import org.exercise.bestoftheyear.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Controller
@RequestMapping
public class HomeController {
    @GetMapping
    public String home(Model model) {
        model.addAttribute("user", "Mattia");
        return "home";
    }

    @GetMapping("/not_found")
    public String notFound(){
        return "not_found";
    }

    @GetMapping("/movies")
    public String movies(Model model){
        List<Movie> bestMovies = getBestMovies();
        StringBuilder names = new StringBuilder();
        for(Movie m : bestMovies){
            names.append(m.getTitle()).append(", ");
        }
        names = new StringBuilder(names.substring(0, names.length() - 2));
        model.addAttribute("movies", names);
        return "movies";
    }

    @GetMapping("/movies/{id}")
    public String movie(Model model, @PathVariable(required = false ) int id, RedirectAttributes redirectAttributes){
        List<Movie> bestMovies = getBestMovies();

        Optional<Movie> foundOrNot = bestMovies.stream().filter((m) -> m.getId() == id).findFirst();

        if(foundOrNot.isEmpty()){
            redirectAttributes.addFlashAttribute("object", "movies");
            return "redirect:/not_found";
        } else {
            model.addAttribute("movie",foundOrNot.get());
            return "single_movie";
        }

    }

    @GetMapping("/songs")
    public String songs(Model model){
        List<Song> bestSongs = getBestSongs();
        StringBuilder names = new StringBuilder();
        for(Song m : bestSongs){
            names.append(m.getTitle()).append(", ");
        }
        names = new StringBuilder(names.substring(0, names.length() - 2));
        model.addAttribute("songs", names);
        return "songs";
    }

    @GetMapping("/songs/{id}")
    public String song(Model model, @PathVariable(required = false ) int id,  RedirectAttributes redirectAttributes){
        List<Song> bestSongs = getBestSongs();

        Optional<Song> foundOrNot = bestSongs.stream().filter((s) -> s.getId() == id).findFirst();

        if(foundOrNot.isEmpty()){
            redirectAttributes.addFlashAttribute("object", "songs");
            return "redirect:/not_found";
        } else {
            model.addAttribute("song",foundOrNot.get());
            return "single_song";
        }

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
