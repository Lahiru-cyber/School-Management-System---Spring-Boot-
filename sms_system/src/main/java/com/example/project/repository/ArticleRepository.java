package com.example.project.repository;

import com.example.project.entity.Article;
import com.example.project.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
    Article getArticleById(int Id);
    Article getArticleByName(String name);

}