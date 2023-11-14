package com.exam.controller;

import com.exam.model.exam.Question;
import com.exam.model.exam.Quiz;
import com.exam.sevice.QuestionService;
import com.exam.sevice.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin("*")
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuizService quizService;

    // add question service
    @PostMapping("/")
    public ResponseEntity<Question> add(@RequestBody Question question) {
        return  ResponseEntity.ok(this.questionService.addQuestion(question));
    }

    //update the question
    @PutMapping("/")
    public ResponseEntity<Question> update(@RequestBody Question question) {
        return ResponseEntity.ok(this.questionService.updateQuestion(question));
    }

    // get all questions of any quiz
    @GetMapping("/quiz/{qid}")
    public ResponseEntity<?> getQuestionsOfQuiz(@PathVariable("qid") Long qid) {
        Quiz quiz = this.quizService.getQuiz(qid);
        Set<Question> questions = quiz.getQuestions();
        List<Question> list  = new ArrayList<>(questions);
        if(list.size() > Integer.parseInt(quiz.getNumberOfQuestion())) {
            list = list.subList(0, Integer.parseInt(quiz.getNumberOfQuestion() + 1));
        }
        return ResponseEntity.ok(list);
    }

    // get single question
    @GetMapping("/{quesId}")
    public Question get(@PathVariable("quesId") Long quesId) {
        return this.questionService.getQuestion(quesId);
    }

    // delete question
    @DeleteMapping("/{quesId}")
    public void delete(@PathVariable("quesId") Long quesId) {
        this.questionService.deleteQuestion(quesId);
    }

}
