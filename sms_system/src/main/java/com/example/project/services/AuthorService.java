package com.example.project.services;

import com.example.project.entity.Article;
import com.example.project.entity.Author;
import com.example.project.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> findAllAuthors() {
        return authorRepository.findAll();}
    public Author addAuthor(Author author1) {

        Author author=new Author();
        author.setName(author1.getName());
        authorRepository.save(author);
        return author1;
    }
    public Author findAuthorByName(String name) {
        return authorRepository.getAuthorByName(name);
    }
    public ResponseEntity<Author> updateAuthorDetails(int id, Author author) {
        Author updateAuthor = authorRepository.findById(id).orElse(null);
        updateAuthor.setName(author.getName());
        Author setupdate = authorRepository.save(updateAuthor);
        return ResponseEntity.ok().body(setupdate);
    }
    public ResponseEntity<?> deleteAuthorDetail(Integer id) {
        Author obj = authorRepository.findById(id).orElse(null);
        authorRepository.delete(obj);
        return new ResponseEntity<String>("Deleted", HttpStatus.OK);
    }
}
