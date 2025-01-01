package com.pavan.QuizApp.Repo;


import com.pavan.QuizApp.Model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface QuizRepo extends JpaRepository<Quiz,Integer> {


}
