package com.info.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.info.constants.AppConstants;
import com.info.entity.Plan;
import com.info.props.AppProperties;
import com.info.service.PlanServiceImpl;

@RestController
public class PlanController {

	private PlanServiceImpl service;

	private Map<String, String> messages;

	public PlanController(PlanServiceImpl service, AppProperties appProps) {
		super();
		this.service = service;
		this.messages = appProps.getMessages();
		System.out.println(messages);
	}

	@GetMapping("/categories")
	public ResponseEntity<Map<Integer, String>> planCategories() {
		Map<Integer, String> planCategorys = service.getPlanCategorys();
		return new ResponseEntity<>(planCategorys, HttpStatus.OK);

	}

	@PostMapping("/savePlan")
	public ResponseEntity<String> savePlan(@RequestBody Plan plan) {
		String responseMessage = AppConstants.EMPTY_STR;
		boolean savePlan = service.savePlan(plan);
		
		if (savePlan) {
			responseMessage = messages.get(AppConstants.PLAN_SAVE_SUCCESS);
		} else {
			responseMessage = messages.get(AppConstants.PLAN_SAVE_FAIL);
		}
		return new ResponseEntity<>(responseMessage, HttpStatus.CREATED);
	}

	@GetMapping("/appPlans")
	public ResponseEntity<List<Plan>> getAllPlans() {
		List<Plan> allPlans = service.getAllPlans();
		return new ResponseEntity<>(allPlans, HttpStatus.OK);

	}

	@GetMapping("/plan/{planId}")
	public ResponseEntity<Plan> editPlan(@PathVariable Integer planId) {
		Plan plan = service.getPlanById(planId);

		return new ResponseEntity<>(plan, HttpStatus.OK);
	}

	@PutMapping("/planUpdate")
	public ResponseEntity<String> updatePlan(@RequestBody Plan plan) {
		boolean updatePlan = service.updatePlan(plan);
		
		String msg = AppConstants.EMPTY_STR;
		if (updatePlan) {
			msg = messages.get(AppConstants.PLAN_UPDATE_SUCCESS);
		} else {
			msg = messages.get(AppConstants.PLAN_UPDATE_FAIL);

		}
		return new ResponseEntity<>(msg, HttpStatus.OK);

	}

	@DeleteMapping("/plan/{planId}")
	public ResponseEntity<String> deletePlan(@PathVariable Integer PlanId) {
		boolean deletePlanId = service.deletePlanId(PlanId);
		String respMsg = AppConstants.EMPTY_STR;
	
		if (deletePlanId) {
			respMsg = messages.get(AppConstants.PLAN_DELETE_SUCCESS);
		} else {
			respMsg = messages.get(AppConstants.PLAN_DELETE_FAIL);
		}
		return new ResponseEntity<>(respMsg, HttpStatus.OK);

	}

	@PutMapping("/status-change/{planId}/{status}")
	public ResponseEntity<String> statusChange(@PathVariable Integer planId, @PathVariable String status) {
		boolean planStatusChange = service.planStatusChange(planId, status);
		
		String respMsg = AppConstants.EMPTY_STR;
		if (planStatusChange) {
			respMsg = messages.get(AppConstants.PLAN_STATUS_CHANGE_SUCCESS);

		} else {
			respMsg = messages.get(AppConstants.PLAN_DELETE_FAIL);
		}
		return new ResponseEntity<>(respMsg, HttpStatus.OK);

	}

}
