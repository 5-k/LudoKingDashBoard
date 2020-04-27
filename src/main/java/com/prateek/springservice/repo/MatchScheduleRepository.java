package com.prateek.springservice.repo;

import java.sql.Date;
import java.util.List;

import com.prateek.springservice.entity.MatchSchedule;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author prateek.mishra
 * Repository Interface for CRUD operations on User Table
 */
public interface MatchScheduleRepository extends JpaRepository<MatchSchedule, Integer>{



}