package com.example.neftchi.repository;

import com.example.neftchi.model.AppealAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface AppealAnswerRepository extends JpaRepository<AppealAnswer, Long> {
}