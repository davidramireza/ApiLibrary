package org.megasoft.bookapi.apimegasoft.dao;

import org.megasoft.bookapi.apimegasoft.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class BookDAOImpl implements BookDAO{

    private List<Book> books = new ArrayList<>();

    @Override
    public Book createBook(Book book) {
        books.add(book);
        return book;
    }

    @Override
    public Book save(Book book) {
        books.add(book);
        return book;
    }

    @Override
    public Optional<Book> findById(Long id) {
        return books.stream().filter(book -> book.getId().equals(id)).findFirst();
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(books);
    }

    @Override
    public void delete(Long id) {
        books.removeIf(book -> book.getId().equals(id));
    }

    @Override
    public List<Book> findByTitle(String titlePart) {
        return books.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(titlePart.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> findByPriceRange(double min, double max) {
        return books.stream()
                .filter(book -> book.getPrice().doubleValue() >= min && book.getPrice().doubleValue() <= max)
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> findByAuthor(String author) {
        return books.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> getAllBooksSortedByPublicationDate() {
        return books.stream()
                .sorted((b1, b2) -> b1.getPublicationDate().compareTo(b2.getPublicationDate()))
                .collect(Collectors.toList());
    }
}
