package io.online.quize.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.online.quize.boa.QuizDaoImpl;
import io.online.quize.model.Question;

@Service
public class QuizService {

    @Autowired
    private QuizDaoImpl serviceImpl;

    public ResponseEntity<Question> createQuestion(Question question) {
        serviceImpl.createOrUpdateQuestion(question);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    public ResponseEntity<List<Question>> getAllQuestion() {
        List<Question> questions = serviceImpl.getAllQuestion();
        return new ResponseEntity<List<Question>>(questions, HttpStatus.OK);
    }

    public ResponseEntity<Question> deleteQuestion(Long id) {
        serviceImpl.deletQuestion(id);
        return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);

    }

    public ResponseEntity<Question> updateQuestion(Long id, Question question) {
        Question updatedQuestion = serviceImpl.getOne(id);
        if (null != updatedQuestion) {
            updatedQuestion.setAnswers(question.getAnswers());
            updatedQuestion.setMarks(question.getMarks());
            updatedQuestion.setQuestion(question.getQuestion());
            serviceImpl.createOrUpdateQuestion(updatedQuestion);
            return new ResponseEntity<Question>(updatedQuestion, HttpStatus.MOVED_PERMANENTLY);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Question> getOneQuestion(Long id) {
        Question one = serviceImpl.getOne(id);
        return (null != one) ? ResponseEntity.status(HttpStatus.OK).body(one)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    public ResponseEntity<Question> createAll(List<Question> questions) {
        serviceImpl.createMultipleQuestion(questions);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
