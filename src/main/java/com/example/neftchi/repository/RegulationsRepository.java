package com.example.neftchi.repository;

import com.example.neftchi.model.Regulations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface RegulationsRepository extends JpaRepository<Regulations, Long> {
}
