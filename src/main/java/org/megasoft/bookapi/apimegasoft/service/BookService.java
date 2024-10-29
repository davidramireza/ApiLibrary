package org.megasoft.bookapi.apimegasoft.service;

import org.megasoft.bookapi.apimegasoft.exception.BookNotFoundException;
import org.megasoft.bookapi.apimegasoft.model.Book;

import java.util.List;

public interface BookService {
    Book createBook(Book book);
    Book getBookById(Long id) throws BookNotFoundException;
    List<Book> findBooksByTitle(String titlePart);
    List<Book> findBooksByPriceRange(double min, double max);
    List<Book> findBooksByAuthor(String author);
    List<Book> getAllBooksSortedByPublicationDate();
    void deleteBook(Long id);
}