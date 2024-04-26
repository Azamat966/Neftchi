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
    // Метод для получения списка сотрудников, отсортированных по дате (ASC)
    @Query("SELECT e FROM AddEmployee e ORDER BY e.name_lastname ASC")
    List<AddEmployee> findAllByOrderByNameAsc();

    // Метод для получения списка сотрудников, отсортированных по дате (DESC)
    @Query("SELECT e FROM AddEmployee e ORDER BY e.name_lastname DESC")
    List<AddEmployee> findAllByOrderByNameDesc();

    @Query("SELECT e FROM AddEmployee e ORDER BY e.localDateTime ASC")
    List<AddEmployee> findDateAsc();

    // Метод для получения списка сотрудников, отсортированных по дате (DESC)
    @Query("SELECT e FROM AddEmployee e ORDER BY e.localDateTime DESC")
    List<AddEmployee> findDataDesc();
}