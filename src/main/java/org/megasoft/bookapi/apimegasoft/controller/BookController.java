package org.megasoft.bookapi.apimegasoft.controller;

import org.megasoft.bookapi.apimegasoft.model.Book;
import org.megasoft.bookapi.apimegasoft.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book createdBook = bookService.createBook(book);
        return ResponseEntity.ok(createdBook);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Book book = bookService.getBookById(id);
        return ResponseEntity.ok(book);
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooksSortedByPublicationDate();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Book>> findBooksByTitle(@RequestParam String title) {
        List<Book> books = bookService.findBooksByTitle(title);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/author")
    public ResponseEntity<List<Book>> findBooksByAuthor(@RequestParam String author) {
        List<Book> books = bookService.findBooksByAuthor(author);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/price-range")
    public ResponseEntity<List<Book>> findBooksByPriceRange(
            @RequestParam BigDecimal minPrice, @RequestParam BigDecimal maxPrice) {
        List<Book> books = bookService.findBooksByPriceRange(minPrice.doubleValue(), maxPrice.doubleValue());
        return ResponseEntity.ok(books);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}