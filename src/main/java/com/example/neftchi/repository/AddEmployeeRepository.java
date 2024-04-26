package com.example.neftchi.repository;

import com.example.neftchi.model.AddEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface AddEmployeeRepository extends JpaRepository<AddEmployee, Long> {
}
