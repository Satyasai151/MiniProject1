package com.info.service;

import java.util.List;
import java.util.Map;

import com.info.entity.Plan;

public interface PlanService {
	public Map<Integer, String> getPlanCategorys();

	public boolean savePlan(Plan plan);

	public List<Plan> getAllPlans();

	public Plan getPlanById(Integer planId);

	public boolean updatePlan(Plan plan);

	public boolean deletePlanId(Integer planId);

	public boolean planStatusChange(Integer planId, String status);

}
