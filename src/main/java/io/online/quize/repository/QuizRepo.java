package io.online.quize.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.online.quize.model.Question;

@Repository
public interface QuizRepo extends JpaRepository<Question, Long> {

}
