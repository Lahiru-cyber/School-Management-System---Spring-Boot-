package com.example.project.repository;

import com.example.project.entity.Article;
import com.example.project.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
    Author getAuthorByName(String name);
}