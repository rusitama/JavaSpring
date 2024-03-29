package ru.gb.springbootlesson3.repository;

import org.springframework.stereotype.Repository;
import ru.gb.springbootlesson3.entity.Book;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {

    private List<Book> list = new ArrayList<>();

    public Book save(Book book) {
        list.add(book);
        return book;
    }

    public Book findById(long id) {
        return list.stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void deleteById(long id) {
        list.removeIf(book -> book.getId() == id);
    }

    public List<Book> findAll() {
        return new ArrayList<>(list);
    }

    // Другие методы для поиска книг по различным критериям, если необходимо
}
