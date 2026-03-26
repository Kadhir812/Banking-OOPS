package com.example.oes.service;

import com.example.oes.dao.questionDAOImpl;
import com.example.oes.dto.Question;
import java.util.List;

public class AdminService {
    private final questionDAOImpl dao = new questionDAOImpl();

    public void addQuestion(Question q) {
        dao.addQuestion(q);
    }

    public void updateQuestion(int id, String text) {
        dao.updateQuestion(id, text);
    }

    public List<Question> getAllQuestions() {
        return dao.getAllQuestions();
    }
}
