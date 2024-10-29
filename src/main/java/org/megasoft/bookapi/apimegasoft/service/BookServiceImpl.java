package org.megasoft.bookapi.apimegasoft.service;

import org.megasoft.bookapi.apimegasoft.dao.BookDAO;
import org.megasoft.bookapi.apimegasoft.exception.BookNotFoundException;
import org.megasoft.bookapi.apimegasoft.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookServiceImpl implements BookService {
    private final BookDAO bookDAO;

    public BookServiceImpl(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }


    @Override
    public Book createBook(Book book) {
        return bookDAO.createBook(book);
    }

    @Override
    public Book getBookById(Long id) throws BookNotFoundException {
        return bookDAO.findById(id).orElseThrow(() -> new BookNotFoundException("Book not found"));
    }

    @Override
    public List<Book> findBooksByTitle(String titlePart) {
        return bookDAO.findByTitle(titlePart);
    }

    @Override
    public List<Book> findBooksByPriceRange(double min, double max) {
        return bookDAO.findByPriceRange(min, max);
    }

    @Override
    public List<Book> findBooksByAuthor(String author) {
        return bookDAO.findByAuthor(author);
    }

    @Override
    public List<Book> getAllBooksSortedByPublicationDate() {
        return bookDAO.getAllBooksSortedByPublicationDate();
    }

    @Override
    public void deleteBook(Long id) {
        bookDAO.delete(id);
    }
}