package com.example.neftchi.repository;

import com.example.neftchi.model.Appeal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface AppealRepository extends JpaRepository<Appeal, Long> {
//    Optional<Appeal> findById();
}
