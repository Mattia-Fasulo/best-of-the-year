package org.exercise.bestoftheyear.controller;

import org.exercise.bestoftheyear.model.Movie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/movies")
public class MovieController {


    @GetMapping()
    public String movies(Model model){
        List<Movie> bestMovies = getBestMovies();
        model.addAttribute("movies", bestMovies);
        return "movies";
    }

    private List<Movie> getBestMovies(){
        List<Movie> bestMovies = new ArrayList<>();
        bestMovies.add(new Movie(1,"Film 1", "Director 1"));
        bestMovies.add(new Movie(2,"Film 2", "Director 2"));
        bestMovies.add(new Movie(3,"Film 3", "Director 3"));
        bestMovies.add(new Movie(4,"Film 4", "Director 4"));
        bestMovies.add(new Movie(5,"Film 5", "Director 5"));

        return bestMovies;
    }

    @GetMapping("/{id}")
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
}
