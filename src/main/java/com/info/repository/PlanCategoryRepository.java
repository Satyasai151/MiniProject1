package com.info.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.info.entity.PlanCateogry;

public interface PlanCategoryRepository extends JpaRepository<PlanCateogry, Integer> {

}
