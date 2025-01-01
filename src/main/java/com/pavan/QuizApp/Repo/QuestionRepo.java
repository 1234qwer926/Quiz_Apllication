package com.pavan.QuizApp.Repo;

import com.pavan.QuizApp.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Integer> {

    List<Question> findByCategories(String category);

    @Query(value = "SELECT * FROM question q WHERE q.categories = :category ORDER BY RAND() LIMIT :noQe", nativeQuery = true)
    List<Question> findByCategoryQuiz(String category, int noQe); // Changed noQe type to int
}
