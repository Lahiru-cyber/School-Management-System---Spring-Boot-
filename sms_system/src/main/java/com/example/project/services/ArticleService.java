package com.example.project.services;

import com.example.project.entity.Article;
import com.example.project.entity.Author;
import com.example.project.entity.Book;
import com.example.project.repository.ArticleRepository;
import com.example.project.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    AuthorRepository authorRepository;
    public List<Article> findAllArticles() { return articleRepository.findAll(); }
    public Article findBookById(int id) {
        return articleRepository.getArticleById(id);
    }
    public Article addArticle(Article articleData) {
        Article article=new Article();
        article.setYear(articleData.getYear());
        article.setName(articleData.getName());
        if(articleData.getAuthor()!=null) {
            Author author=authorRepository.findById(articleData.getAuthor().getId()).orElse(null);
            article.setAuthor(author);}
        articleRepository.save(article);
        return articleData;
    }
    public Article findArticleByName(String name) {
        return articleRepository.getArticleByName(name);
    }
    public ResponseEntity<Article> updateArticleDetails(int id, Article articleData) {
        Article updateArticle = articleRepository.findById(id).orElse(null);

        updateArticle.setName(articleData.getName());
       updateArticle.setYear(articleData.getYear());
        if(articleData.getAuthor()!=null)
        {
            Author author=authorRepository.findById(articleData.getAuthor().getId()).orElse(null);
            articleData.setAuthor(author);
        }
        Article setupdate = articleRepository.save(updateArticle);

        return ResponseEntity.ok().body(setupdate);
    }


    public ResponseEntity<?> deleteBookDetail(Integer id) {
        Article obj = articleRepository.findById(id).orElse(null);
        articleRepository.delete(obj);
        return new ResponseEntity<String>("Deleted", HttpStatus.OK);
    }
}
