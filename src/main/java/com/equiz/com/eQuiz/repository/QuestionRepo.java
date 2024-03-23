package com.equiz.com.eQuiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.equiz.com.eQuiz.model.Question;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Integer> {

}
