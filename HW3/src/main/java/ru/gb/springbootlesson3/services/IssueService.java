package ru.gb.springbootlesson3.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.gb.springbootlesson3.controllers.IssueRequest;
import ru.gb.springbootlesson3.entity.Issue;
import ru.gb.springbootlesson3.repository.IssueRepository;
import ru.gb.springbootlesson3.repository.ReaderRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class IssueService {

    private final IssueRepository issueRepository;
    private final ReaderRepository readerRepository;

    @Value("${application.issue.max-allowed-books:1}")
    private int maxAllowedBooks;

    public IssueService(IssueRepository issueRepository, ReaderRepository readerRepository) {
        this.issueRepository = issueRepository;
        this.readerRepository = readerRepository;
    }

    public Issue createIssue(IssueRequest issueRequest) {
        long readerId = issueRequest.getReaderId();
        long bookId = issueRequest.getBookId();

        // Проверка, что у пользователя на руках нет книг
        List<Issue> issues = issueRepository.findByReaderId(readerId);
        if (issues.size() >= maxAllowedBooks) {
            throw new IllegalStateException("Читателю уже выдано максимальное количество книг");
        }

        // Проверка наличия книги
        if (issueRepository.isBookIssued(bookId)) {
            throw new IllegalStateException("Книга уже находится на руках у другого читателя");
        }

        // Создание выдачи
        Issue issue = new Issue(readerId, bookId);
        issueRepository.createIssue(issue);
        return issue;
    }

    public Issue findIssueById(long id) {
        return issueRepository.findById(id);
    }

    public void returnBook(long issueId) {
        Issue issue = issueRepository.findById(issueId);
        if (issue != null && issue.getReturnedAt() == null) {
            issue.setReturnedAt(LocalDateTime.now());
            issueRepository.updateIssue(issue);
        }
    }
}
