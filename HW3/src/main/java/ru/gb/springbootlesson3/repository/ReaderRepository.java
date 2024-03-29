package ru.gb.springbootlesson3.repository;

import org.springframework.stereotype.Repository;
import ru.gb.springbootlesson3.entity.Reader;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ReaderRepository {

    private List<Reader> list = new ArrayList<>();

    public Reader save(Reader reader) {
        list.add(reader);
        return reader;
    }

    public Reader findById(long id) {
        return list.stream()
                .filter(reader -> reader.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void deleteById(long id) {
        list.removeIf(reader -> reader.getId() == id);
    }

    public List<Reader> findAll() {
        return new ArrayList<>(list);
    }

    // Другие методы для поиска читателей по различным критериям, если необходимо
}
