package org.megasoft.bookapi.apimegasoft.dao;

import org.megasoft.bookapi.apimegasoft.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookDAO {
    Book createBook(Book book);
    Book save(Book book);
    Optional<Book> findById(Long id);
    List<Book> findAll();
    void delete(Long id);
    List<Book> findByTitle(String titlePart);
    List<Book> findByPriceRange(double min, double max);
    List<Book> findByAuthor(String author);
    List<Book> getAllBooksSortedByPublicationDate();
}