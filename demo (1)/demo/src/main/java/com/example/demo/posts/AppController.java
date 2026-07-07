package com.example.demo.posts;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/characters")
public class AppController {

    private final PostService postService;

    public AppController(PostService postService) {
        this.postService = postService;
    }

    // Get all characters
    @GetMapping
    public List<Character> getAllCharacters() {
        return postService.getAllCharacters();
    }

    // Get a character by ID
    @GetMapping("/{id}")
    public Character getCharacterById(@PathVariable long id) {
        return postService.getCharacterById(id);
    }

    // Add a new character
    @PostMapping
    public Character createCharacter(@RequestBody Character character) {
        return postService.createCharacter(character);
    }

    // Update an existing character
    @PutMapping("/{id}")
    public Character updateCharacter(@PathVariable long id, @RequestBody Character updatedCharacter) {
        return postService.updateCharacter(id, updatedCharacter);
    }

    // Delete an existing character
    @DeleteMapping("/{id}")
    public boolean deleteCharacter(@PathVariable long id) {
        return postService.deleteCharacter(id);
    }

    // Get characters of one given category (example: universe)
    @GetMapping("/universe/{universe}")
    public List<Character> getCharactersByUniverse(@PathVariable String universe) {
        return postService.getCharactersByUniverse(universe);
    }

    // Get characters whose name contains a string
    @GetMapping("/search")
    public List<Character> searchCharacters(@RequestParam String keyword) {
        return postService.searchCharacters(keyword);
    }
}
