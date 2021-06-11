package io.online.quize.boa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.online.quize.dao.QuizDao;
import io.online.quize.model.Question;
import io.online.quize.repository.QuizRepo;

@Component
public class QuizDaoImpl implements QuizDao {

    @Autowired
    private QuizRepo repo;

    @Override
    public List<Question> getAllQuestion() {
        return repo.findAll();
    }

    @Override
    public Question getOneQuestion(Long id) {
        return repo.getOne(id);
    }

    @Override
    public void deletQuestion(Long id) {
        repo.deleteById(id);
    }

    @Override
    public void createMultipleQuestion(List<Question> question) {
        repo.saveAll(question);
    }

    @Override
    public Question createOrUpdateQuestion(Question question) {
        return repo.save(question);
    }

    public Question getOne(Long id) {
        Optional<Question> findById = repo.findById(id);
        return findById.isPresent() ? findById.get() : null;
    }
}
