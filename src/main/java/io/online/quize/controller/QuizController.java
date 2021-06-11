package io.online.quize.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.online.quize.model.Question;
import io.online.quize.service.QuizService;

@RestController
public class QuizController {

    @Autowired
    private QuizService service;

    @GetMapping("/question")
    public ResponseEntity<List<Question>> getQuestion() {
        return service.getAllQuestion();
    }

    @PostMapping("/question")
    public ResponseEntity<Question> createQuestion(@RequestBody Question question) {
        return service.createQuestion(question);
    }

    @DeleteMapping("/question/{id}")
    public ResponseEntity<Question> deletQuestion(@PathVariable Long id) {
        return service.deleteQuestion(id);
    }

    @PutMapping("/question/{id}")
    public ResponseEntity<Question> updateQuestion(@RequestBody Question question, @PathVariable Long id) {
        return service.updateQuestion(id, question);
    }

    @PostMapping("/questions")
    public ResponseEntity<Question> createAll(@RequestBody List<Question> questions) {
        return service.createAll(questions);
    }

    @GetMapping("/question/{id}")
    public ResponseEntity<Question> getOneQuestion(@PathVariable Long id) {
        return service.getOneQuestion(id);
    }

}
