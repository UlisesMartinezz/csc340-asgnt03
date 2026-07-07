package com.example.demo.posts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Character, Long> {
    List<Character> findByNameContainingIgnoreCase(String name);
    List<Character> findByUniverseContainingIgnoreCase(String universe);
}

