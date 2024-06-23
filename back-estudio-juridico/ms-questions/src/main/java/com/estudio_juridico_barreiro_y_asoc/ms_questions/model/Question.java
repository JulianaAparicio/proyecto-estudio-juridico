package com.estudio_juridico_barreiro_y_asoc.ms_questions.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    @NonNull
    private Date date;

    @Column
    @NonNull
    private String fullName;

    @Column
    @NonNull
    private String email;

    @Column
    @NonNull
    private String phoneNumber;

    @Column
    @NonNull
    private String message;
}
