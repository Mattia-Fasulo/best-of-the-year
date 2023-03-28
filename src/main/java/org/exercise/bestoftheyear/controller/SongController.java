package org.exercise.bestoftheyear.controller;

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

@Controller
@RequestMapping("/songs")
public class SongController {
    @GetMapping()
    public String songs(Model model){
        List<Song> bestSongs = getBestSongs();
        model.addAttribute("songs", bestSongs);
        return "songs";
    }

    @GetMapping("/{id}")
    public String song(Model model, @PathVariable(required = false ) int id, RedirectAttributes redirectAttributes){
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



    private List<Song> getBestSongs(){
        List<Song> bestSongs = new ArrayList<>();
        bestSongs.add(new Song(1,"Song 1","Author 1"));
        bestSongs.add(new Song(2,"Song 2","Author 2"));
        bestSongs.add(new Song(3,"Song 3","Author 3"));
        bestSongs.add(new Song(4,"Song 4","Author 4"));
        bestSongs.add(new Song(5,"Song 5","Author 5"));

        return bestSongs;
    }
}
