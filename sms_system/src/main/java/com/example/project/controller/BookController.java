package com.example.project.controller;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.entity.Book;
import com.example.project.services.BookServices;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping
public class BookController {
	@Autowired
	private BookServices libraryServices;
	// Displaying details of Books
	@GetMapping("/book")
	public List<Book> getAllBooks() {

		return libraryServices.displayBooks();
	}
	// Inserting book details
	@PostMapping("/book")
	public Book insertBook(@RequestBody Book library) {
		return libraryServices.addBook(library);
	}
	// Searching a specific book by id
	@GetMapping("/book/{id}")
	public Book findBookById(@PathVariable int id) {
		return libraryServices.findBookById(id);
	}

	// Searching a specific book
	@GetMapping("/search/{name}")
	public Book findBookByName(@PathVariable String name) {
		return libraryServices.findBookByName(name);
	}

	// Updating book details
	@PutMapping("/update/{id}")
	public ResponseEntity<Book> updateBookDetails(@PathVariable int id, @RequestBody Book library) {
		return libraryServices.updateBookDetails(id, library);
	}
	// Deleting book details
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteBookDetail(@PathVariable Integer id) {
		return libraryServices.deleteBookDetail(id);
	}


	
	

}
