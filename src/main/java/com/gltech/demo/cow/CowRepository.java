package com.gltech.demo.cow;

import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CowRepository extends JpaRepository<Cow, Long> {
    @Transactional(readOnly = true)
    @Query("select c from Cow c where c.id = :id")
    Optional<Cow> getCowById(@Param("id") long id);
}
