package com.feederTool.webFeederTool.DataPreparations;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// type id repository interface

@Repository
public interface TypesRepository extends JpaRepository<TypeHistory, Long> {}
