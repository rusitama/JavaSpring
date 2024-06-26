package ru.gb.springbootlesson3.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Issue {
    private static long genId;

    private final long id;
    private final long idReader;
    private final long idBook;
    private final LocalDateTime issuedAt;
    private LocalDateTime returnedAt;

    public Issue(long idReader, long idBook) {
        id = genId++;
        this.idReader = idReader;
        this.idBook = idBook;
        this.issuedAt = LocalDateTime.now();
    }
}