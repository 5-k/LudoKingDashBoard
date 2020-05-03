package com.prateek.springservice.repo;

import com.prateek.springservice.entity.MatchResult;
import com.prateek.springservice.entity.SemiAndFinals;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author prateek.mishra
 * Repository Interface for CRUD operations on User Table
 */
public interface SemifinalsAndFinalsRepo extends JpaRepository<SemiAndFinals, Integer>{

}