package com.estudio_juridico_barreiro_y_asoc.ms_questions.service;

import com.estudio_juridico_barreiro_y_asoc.ms_questions.model.Question;
import com.estudio_juridico_barreiro_y_asoc.ms_questions.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService{

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Question saveQuestion(Question question) {
        return questionRepository.save(question);
    }
}
