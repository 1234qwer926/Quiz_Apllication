package com.pavan.QuizApp.Controller;

import com.pavan.QuizApp.Model.Question;
import com.pavan.QuizApp.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {




    @Autowired
    QuestionService service;
    @GetMapping("/allquestions")
    public ResponseEntity<List<Question>> allQuestions(){
        return service.getAllQuestions();
    }
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> getAllBYCategory(@PathVariable String category){
        return service.getByCategory(category);
    }
    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody Question qes){
        return service.addOne(qes);
    }
}
