package com.prateek.springservice.repo;

import com.prateek.springservice.entity.MatchResult;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author prateek.mishra
 * Repository Interface for CRUD operations on User Table
 */
public interface MatchResultRepository extends JpaRepository<MatchResult, Integer>{

	public MatchResult findBymatchid(int matchid);
}