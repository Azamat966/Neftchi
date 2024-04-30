package com.example.neftchi.repository;

import com.example.neftchi.model.Adminstration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface AdminstrationRepository extends JpaRepository<Adminstration, Long> {
}
