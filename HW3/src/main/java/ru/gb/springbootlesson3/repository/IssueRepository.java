package ru.gb.springbootlesson3.repository;

import org.springframework.stereotype.Repository;
import ru.gb.springbootlesson3.entity.Issue;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class IssueRepository {
    private List<Issue> list = new ArrayList<>();

    public void createIssue(Issue issue){
        list.add(issue);
    }

    public Issue findById(long id){
        return list.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Issue> findByReaderId(long readerId) {
        return list.stream()
                .filter(e -> e.getIdReader() == readerId)
                .collect(Collectors.toList());
    }

    public void updateIssue(Issue issue) {
        // Предполагается, что в реальном приложении здесь будет обновление в базе данных
    }

    public boolean isBookIssued(long bookId) {
        return list.stream()
                .anyMatch(issue -> issue.getIdBook() == bookId && issue.getReturnedAt() == null);
    }
}
