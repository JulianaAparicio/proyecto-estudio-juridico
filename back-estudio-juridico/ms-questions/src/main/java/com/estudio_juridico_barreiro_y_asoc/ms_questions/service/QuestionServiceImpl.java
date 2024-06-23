package com.estudio_juridico_barreiro_y_asoc.ms_questions.service;

import com.estudio_juridico_barreiro_y_asoc.ms_questions.mails.QuestionMail;
import com.estudio_juridico_barreiro_y_asoc.ms_questions.model.Question;
import com.estudio_juridico_barreiro_y_asoc.ms_questions.repository.QuestionRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.logging.Logger;

@Service
public class QuestionServiceImpl implements QuestionService{

    private final Logger logger = Logger.getLogger("QuestionService");

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public void saveQuestion(Question question) throws BadRequestException {
        if (question.getFullName()==null || question.getEmail()==null || question.getPhoneNumber()==null || question.getMessage()==null){
            logger.warning("The data entered has null values.");
            throw new BadRequestException("The question has null values.");
        } else {
            logger.info("Creating new question...");
            logger.info("Sending email with the new question...");
            QuestionMail.sendQuestionEmail(question);
            logger.info("The question was created successfully.");
            questionRepository.save(question);
        }
    }

    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

}
