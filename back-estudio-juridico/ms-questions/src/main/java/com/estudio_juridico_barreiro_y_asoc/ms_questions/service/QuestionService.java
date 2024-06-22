package com.estudio_juridico_barreiro_y_asoc.ms_questions.service;

import com.estudio_juridico_barreiro_y_asoc.ms_questions.model.Question;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface QuestionService {
    public Question saveQuestion(Question question) throws BadRequestException;

    public List<Question> getAllQuestions();

}
