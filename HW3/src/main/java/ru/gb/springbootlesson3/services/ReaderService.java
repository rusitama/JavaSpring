package ru.gb.springbootlesson3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.springbootlesson3.entity.Reader;
import ru.gb.springbootlesson3.repository.ReaderRepository;

import java.util.List;

@Service
public class ReaderService {

    private final ReaderRepository readerRepository;

    @Autowired
    public ReaderService(ReaderRepository readerRepository) {
        this.readerRepository = readerRepository;
    }

    public Reader createReader(Reader reader) {
        return readerRepository.save(reader);
    }

    public Reader findReaderById(long id) {
        return readerRepository.findById(id);
    }

    public void deleteReaderById(long id) {
        readerRepository.deleteById(id);
    }

    public List<Reader> getAllReaders() {
        return readerRepository.findAll();
    }

    // Методы для получения выдач книг читателя и других операций, связанных с читателями,
    // могут быть добавлены по мере необходимости
}
