package com.example.project.controller;
import com.example.project.entity.Article;
import com.example.project.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ArticleController {
    @Autowired
    ArticleService articleService;

    //Display all articles
    @GetMapping(value = "/article")
    public List<Article> getArticles()
    {
        return articleService.findAllArticles();
    }

    //Display aritcle by ID
    @GetMapping("/articleid")
    public Article findArticleById(@RequestParam(value = "id") int id) {

        return articleService.findBookById(id);
    }
    //Insert Articles
    @PostMapping(value="/article")
    public Article insertArticle(@RequestBody Article article){
        return articleService.addArticle(article);
    }

    //Display aritcle by Name
    @GetMapping("/findArticle/{name}")
    public Article findArticleByName(@PathVariable String name) {
        return articleService.findArticleByName(name);
    }

    // Updating article details
    @PutMapping("/updateArticle/{id}")
    public ResponseEntity<Article> updateArticleDetails(@PathVariable int id, @RequestBody Article article) {
        return articleService.updateArticleDetails(id, article);
    }
    // Deleting article details
    @DeleteMapping("/deleteArticle/{id}")
    public ResponseEntity<?> deleteArticleDetail(@PathVariable Integer id) {

        return articleService.deleteBookDetail(id);

    }
}
