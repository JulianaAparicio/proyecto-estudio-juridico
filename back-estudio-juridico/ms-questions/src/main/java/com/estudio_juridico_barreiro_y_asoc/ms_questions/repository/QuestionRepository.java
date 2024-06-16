package com.estudio_juridico_barreiro_y_asoc.ms_questions.repository;

import com.estudio_juridico_barreiro_y_asoc.ms_questions.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
}
