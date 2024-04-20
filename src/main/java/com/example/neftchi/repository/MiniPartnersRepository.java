package com.example.neftchi.repository;

import com.example.neftchi.model.MiniPartners;
import com.example.neftchi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface MiniPartnersRepository extends JpaRepository<MiniPartners, Long> {
}
