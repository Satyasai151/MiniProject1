package com.info.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.entity.Plan;
import com.info.entity.PlanCateogry;
import com.info.repository.PlanCategoryRepository;
import com.info.repository.PlanRepository;

@Service
public class PlanServiceImpl implements PlanService {
	@Autowired
	private PlanRepository planRepo;
	@Autowired
	private PlanCategoryRepository planCategoryRepository;

	@Override
	public Map<Integer, String> getPlanCategorys() {
		List<PlanCateogry> catagories = planCategoryRepository.findAll();
		Map<Integer, String> categoryMap = new HashMap<>();
		catagories.forEach(category -> {
			categoryMap.put(category.getCategoryId(), category.getCategoryName());
		});

		return categoryMap;
	}

	@Override
	public boolean savePlan(Plan plan) {
		Plan save = planRepo.save(plan);
		if (save.getPlanId() != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Plan> getAllPlans() {
		List<Plan> findAll = planRepo.findAll();
		return findAll;
	}

	@Override
	public Plan getPlanById(Integer planId) {
		Optional<Plan> findById = planRepo.findById(planId);
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public boolean updatePlan(Plan plan) {
		planRepo.save(plan);
		return plan.getPlanId()!=null;
	}

	@Override
	public boolean deletePlanId(Integer planId) {
		boolean status=false;
		try {
			planRepo.deleteById(planId);
			status=true;
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return false;
	}

	@Override
	public boolean planStatusChange(Integer planId, String status) {
		Optional<Plan> findById = planRepo.findById(planId);
		if(findById.isPresent()) {
			Plan plan = findById.get();
			plan.setActiveSw(status);
			planRepo.save(plan);
			return true;
		}
		return false;
	}

}
