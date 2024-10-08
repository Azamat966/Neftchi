package com.example.neftchi.repository;

import com.example.neftchi.model.Services;
import jdk.jfr.TransitionTo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ServiceRepository extends JpaRepository<Services, Long> {
}