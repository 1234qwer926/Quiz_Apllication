package com.pavan.QuizApp.Controller;

import com.pavan.QuizApp.Model.QuestionMapper;
import com.pavan.QuizApp.Model.Response;
import com.pavan.QuizApp.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuizController {

    @Autowired
    QuizService quizService;
    @PostMapping("/quiz/create")
    public ResponseEntity<String> create(@RequestParam String category,@RequestParam int noQe,@RequestParam String title){
        return quizService.createQuiz(category,noQe,title);
    }

    @GetMapping("/getquiz/{id}")
    public ResponseEntity<List<QuestionMapper>> getQue(@PathVariable Integer id){
        return quizService.getQuestions(id);
    }
    @PostMapping("/submit/{id}")
    public ResponseEntity<Integer> getRes(@PathVariable int id, @RequestBody List<Response> response){
        return quizService.getResult(id,response);
    }
}
