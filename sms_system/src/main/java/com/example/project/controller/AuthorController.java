package com.example.project.controller;
import com.example.project.entity.Author;
import com.example.project.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    //Display all authors
    @GetMapping(value = "/author")
    public List<Author> getArticles()
    {
        return authorService.findAllAuthors();
    }

    //Insert New Authors
    @PostMapping(value="/author")
    public Author insertAuthor(@RequestBody Author author){
        return authorService.addAuthor(author);
    }

    //Search author by name
    @GetMapping("/findAutho/{name}")
    public Author findAuthorByName(@PathVariable String name) {
        return authorService.findAuthorByName(name);
    }

    //Update authors
    @PutMapping("/updateAuthor/{id}")
    public ResponseEntity<Author> updateAuthorDetails(@PathVariable int id, @RequestBody Author author) {
        return authorService.updateAuthorDetails(id, author);

    }
    //Delete authors
    @DeleteMapping("/deleteAuthor/{id}")
    public ResponseEntity<?> deleteAuthorDetail(@PathVariable Integer id) {

        return authorService.deleteAuthorDetail(id);

    }
}
