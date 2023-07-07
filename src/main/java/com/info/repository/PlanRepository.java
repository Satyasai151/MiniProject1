package com.info.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.info.entity.Plan;

public interface PlanRepository extends JpaRepository<Plan, Integer>{

}
