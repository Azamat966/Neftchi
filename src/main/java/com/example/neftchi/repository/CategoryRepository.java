package com.example.neftchi.repository;

import com.example.neftchi.model.Category;
import com.example.neftchi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("select c from Category c order by c.importance_number")
    List<Category>findAllOrderNumber();
}
