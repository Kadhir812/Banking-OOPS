package com.example.oes.dao;

import java.util.List;

import com.example.oes.dto.Question;


public interface questionDAO {
    void addQuestion(Question q);
    List<Question> getAllQuestions();
    void updateQuestion(int id, String text);
}
