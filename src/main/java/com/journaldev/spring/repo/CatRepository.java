package com.journaldev.spring.repo;


import java.util.List;
import java.util.Optional;

import com.journaldev.spring.model.Cat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

@Repository
public interface CatRepository extends CrudRepository<Cat, Long> {
    List<Cat> findByName(String name);
    Optional<Cat> findById(Long id);
}