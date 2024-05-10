package com.example.neftchi.repository;

import com.example.neftchi.model.Appeal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface AppealRepository extends JpaRepository<Appeal, Long> {
    @Query("select a from Appeal a order by a.name_lastname")
    List<Appeal> findAllSordDate();
    @Query("select a from Appeal a order by a.numberTel ")
    List<Appeal> findAllSordNumberTel();
    @Query("select a from Appeal  a order by a.email")
    List<Appeal> FindAllSordEmail();
    @Query("select a from Appeal a order by a.name_lastname desc")
    List<Appeal> findAllSordDatedesc();
    @Query("select a from Appeal a order by a.numberTel desc")
    List<Appeal> findAllSordNumberTeldesc();
    @Query("select a from Appeal  a order by a.email desc")
    List<Appeal> FindAllSordEmaildesc();
}
