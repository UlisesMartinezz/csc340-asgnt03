package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.posts.Character;
import com.example.demo.posts.PostService;

@Controller 
public class UiController {
    
    private final PostService postService;

    public UiController(PostService postService){
        this.postService = postService; 
    }

    /*when server is running, the 'return' is the UI that I want to see. The return UI should be a template in the template folder*/ 
    @GetMapping("/about")
    public String about(){
        return "about";
    }

    // Let's write the code so we can see a character's details

    /*
    - remember that all the returns are strings, the string will be the name of the template you want to go to
    - @GetMapping("/chars/{id}"): Says that when I send a Get requestion to /chars/character ID, then ___ will happen
    */
   @GetMapping("/chars/{id}")
    public String getCharById(@PathVariable long id, Model model){
        Character character = postService.getCharacterById(id);
        model.addAttribute("character", character);
        return "details";
    }


}
