package com.equiz.com.eQuiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.equiz.com.eQuiz.model.Result;

@Repository
public interface ResultRepo extends JpaRepository<Result, Integer> {

}