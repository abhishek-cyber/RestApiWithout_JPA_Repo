package com.abhi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.entity.Book;
import com.abhi.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {

	
	@Autowired
	BookService bookService;
	
	@GetMapping
	public List<Book> getAllBooks()
	{
		System.out.println("Hitting Get All Books");
		return bookService.findAll();
		
	}
	
	@GetMapping("/{id}")
	public Book getBookById(@PathVariable int id)
	{
		System.out.println("Hitting Save Method");
		return bookService.findBookById(id);
	}
	
	@PostMapping
	public String addBook(@RequestBody Book book)
	{
		String str="SuccessFully Saved";
		bookService.save(book);
		return str;
	}
	
	@PutMapping
	public void updateBook(@RequestBody Book book)
	{
		bookService.update(book);
	}
	
	@DeleteMapping("/{id}")
	public void deleteBook(@RequestBody int id)
	{
		bookService.delete(id);
	}
}
