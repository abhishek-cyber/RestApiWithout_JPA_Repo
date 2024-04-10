package com.abhi.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.abhi.entity.Book;

@Service
public class BookService {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private RowMapper<Book> bookRowMapper = (rs, rowNum) -> {
        Book book = new Book();
        book.setId(rs.getInt("id"));
        book.setTitle(rs.getString("title"));
        book.setAuthor(rs.getString("author"));
        return book;
    };
    
    public List<Book> findAll()
    {
    	return jdbcTemplate.query("select * from books", bookRowMapper);
    }
    
    public Book findBookById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM books WHERE id = ?", new Object[]{id}, bookRowMapper);
    }

    public int save(Book book) {
        return jdbcTemplate.update("INSERT INTO books (id,title, author) VALUES (?,?, ?)", book.getId(),book.getTitle(), book.getAuthor());
    }

    public int update(Book book) {
        return jdbcTemplate.update("UPDATE books SET title = ?, author = ? WHERE id = ?", book.getTitle(), book.getAuthor(), book.getId());
    }

    public int delete(int id) {
        return jdbcTemplate.update("DELETE FROM books WHERE id = ?", id);
    }
}
