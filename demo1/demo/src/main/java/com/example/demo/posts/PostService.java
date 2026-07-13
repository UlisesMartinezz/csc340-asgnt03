package com.example.demo.posts;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Character> getAllCharacters() {
        return postRepository.findAll();
    }

    public Character getCharacterById(long id) {
        return postRepository.findById(id).orElse(null);
    }

    public Character createCharacter(Character character) {
        return postRepository.save(character);
    }

    public Character updateCharacter(long id, Character updatedCharacter) {
        Character existingCharacter = postRepository.findById(id).orElse(null);
        if (existingCharacter != null) {
            existingCharacter.setName(updatedCharacter.getName());
            existingCharacter.setDescription(updatedCharacter.getDescription());
            existingCharacter.setRole(updatedCharacter.getRole());
            existingCharacter.setUniverse(updatedCharacter.getUniverse());
            return postRepository.save(existingCharacter);
        }
        return null;
    }

    public boolean deleteCharacter(long id) {
        if (postRepository.existsById(id)) {
            postRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Character> searchCharacters(String keyword) {
        return postRepository.findByNameContainingIgnoreCase(keyword);
    }

    public List<Character> getCharactersByUniverse(String universe) {
        return postRepository.findByUniverseContainingIgnoreCase(universe);
    }
}
