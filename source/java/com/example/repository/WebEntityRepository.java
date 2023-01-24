package com.example.repository;

import com.example.domain.entity.WebEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Web entity JPA repository
 */
public interface WebEntityRepository extends JpaRepository<WebEntity, Long> {

    List<WebEntity> findAllByLastName(String lastName);

    @Query("SELECT WebEntity FROM WebEntity we WHERE we.firstName = ?1")
    List<WebEntity> findAllByFirstName(String firstName);
}
