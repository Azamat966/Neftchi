package com.example.neftchi.repository;

import com.example.neftchi.model.AddEmployee;
import com.example.neftchi.model.Category;
import com.example.neftchi.model.CreateNews;
import com.example.neftchi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface CreateNewsRepository extends JpaRepository<CreateNews, Long> {

    @Query("SELECT e FROM CreateNews e ORDER BY e.dataCreated ASC")
    List<CreateNews> findAllByOrderByNameAsc();

    @Query("SELECT e FROM CreateNews e ORDER BY e.dataCreated DESC")
    List<CreateNews> findAllByOrderByNameDesc();


    @Query("SELECT e FROM CreateNews e where e.category.category = :category")
    List<CreateNews> findAllByCategory(@Param(value = "category") String category);



}

//  @Query("select c from Category c order by c.importance_number")
//    List<Category>findAllOrderNumber();