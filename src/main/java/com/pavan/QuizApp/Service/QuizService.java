package com.pavan.QuizApp.Service;

import com.pavan.QuizApp.Model.Question;
import com.pavan.QuizApp.Model.QuestionMapper;
import com.pavan.QuizApp.Model.Quiz;
import com.pavan.QuizApp.Model.Response;
import com.pavan.QuizApp.Repo.QuestionRepo;
import com.pavan.QuizApp.Repo.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizRepo quizRepo;
    @Autowired
    QuestionRepo questionRepo;

    public ResponseEntity<String> createQuiz(String category, int noQe, String title) {
        Quiz quiz=new Quiz();
        List<Question> dbQuestions=questionRepo.findByCategoryQuiz(category,noQe);
        quiz.setQuestions(dbQuestions);
        quiz.setTittle(title);
        quizRepo.save(quiz);

        return new ResponseEntity<>("Created", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionMapper>> getQuestions(Integer id) {
        List<QuestionMapper> usersQues=new ArrayList<>();
        Optional<Quiz> dbData=quizRepo.findById(id);
        List<Question> dbQuestions=dbData.get().getQuestions();
        for(Question q:dbQuestions){
            QuestionMapper temp=new QuestionMapper(q.getId(),q.getQuestionName(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            usersQues.add(temp);
        }
        return new ResponseEntity<>(usersQues,HttpStatus.OK);

    }


    public ResponseEntity<Integer> getResult(int id, List<Response> response) {
        Optional<Quiz> quiz=quizRepo.findById(id);
        List<Question> answers=quiz.get().getQuestions();
        HashMap<Integer,String> hm=new HashMap<>();
        for(Response res:response){
            hm.put(res.getId(),res.getResponse());
        }
        int res = 0;
        for(Question q:answers){
            if(hm.containsKey(q.getId()) && q.getAnswer().equals(hm.get(q.getId()))){
                res++;
            }
        }
        return new ResponseEntity<>(res,HttpStatus.OK);
    }
}
