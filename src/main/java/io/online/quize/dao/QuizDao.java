package io.online.quize.dao;

import java.util.List;

import io.online.quize.model.Question;

public interface QuizDao {

    public List<Question> getAllQuestion();

    public Question getOneQuestion(Long id);

    public Question createOrUpdateQuestion(Question question);

    public void deletQuestion(Long id);

    public void createMultipleQuestion(List<Question> question);

}
