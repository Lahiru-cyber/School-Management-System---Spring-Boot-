package com.example.project.services;

import com.example.project.entity.Author;
import com.example.project.entity.Book;
import com.example.project.entity.Category;
import com.example.project.repository.ArticleRepository;
import com.example.project.repository.AuthorRepository;
import com.example.project.repository.BookRepository;
import com.example.project.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookServices {
	@Autowired
	private BookRepository libraryRepository;

	@Autowired
	private ArticleRepository articleRepository;
	@Autowired
	private AuthorRepository authorRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	public List<Book> displayBooks() {

		return libraryRepository.findAll(Sort.by("id"));
	}
	public Book addBook(Book library) {
		Book book = new Book();
		book.setName(library.getName());
		book.setPrice(library.getPrice());
		if(library.getAuthor()!=null)
		{
			Author author=authorRepository.findById(library.getAuthor().getId()).orElse(null);
			book.setAuthor(author);
		}
		if(library.getCategory()!=null)
		{
			Category category=categoryRepository.findById(library.getCategory().getId()).orElse(null);
			book.setCategory(category);
		}
		libraryRepository.save(library);
		return library;
	}
	public Book findBookByName(String name) {

		return libraryRepository.getBookByName(name);
	}

	public ResponseEntity<Book> updateBookDetails(int id, Book library) {
		Book book=new Book();
		Book updateBook = libraryRepository.findById(id).orElse(null);
		updateBook.setName(library.getName());
		updateBook.setPrice(library.getPrice());

		if(library.getAuthor()!=null)
		{
			Author author=authorRepository.findById(library.getAuthor().getId()).orElse(null);
			book.setAuthor(author);
		}

		if(library.getCategory()!=null)
		{
			Category category=categoryRepository.findById(library.getCategory().getId()).orElse(null);
			book.setCategory(category);

		}
		Book setupdate = libraryRepository.save(updateBook);
		return ResponseEntity.ok().body(setupdate);
	}

	public ResponseEntity<?> deleteBookDetail(Integer id) {
		Book obj = libraryRepository.findById(id).orElse(null);
		libraryRepository.delete(obj);
		return new ResponseEntity<String>("Deleted", HttpStatus.OK);

	}

	public Book findBookById(int id) {
		return libraryRepository.getBookById(id);

	}


	
	

}


