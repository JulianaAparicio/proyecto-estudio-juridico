package com.estudio_juridico_barreiro_y_asoc.ms_questions.controller;

import com.estudio_juridico_barreiro_y_asoc.ms_questions.model.Question;
import com.estudio_juridico_barreiro_y_asoc.ms_questions.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/questions")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @PostMapping
    public ResponseEntity<String> createQuestion(@RequestBody Question question){
        questionService.saveQuestion(question);
        return ResponseEntity.status(HttpStatus.CREATED).body("Question created successfully.");
    }
}
