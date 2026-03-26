package com.example.oes.service;

import com.example.oes.dao.MemberDAOImpl;
import com.example.oes.dao.questionDAOImpl;
import com.example.oes.dto.Member;
import com.example.oes.dto.Question;
import java.util.List;

public class UserService {
    private final questionDAOImpl questionDao = new questionDAOImpl();
    private final MemberDAOImpl memberDao = new MemberDAOImpl();

    public List<Question> getAllQuestions() {
        return questionDao.getAllQuestions();
    }

    public void registerMember(Member m) {
        memberDao.addMember(m);
    }
}
