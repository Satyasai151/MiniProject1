package com.info.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "Plan_category")
public class PlanCateogry {
	@Id
	@GeneratedValue
	@Column(name = "CATEGORY_ID")
	private Integer categoryId;
	@Column(name = "CATEGORY_NAME")
	private String categoryName;
	@Column(name = "ACTIVE_SW")
	private String activeSw;
	@Column(name = "CREATE_BY")
	private String createBy;
	@Column(name = "UPDATE_BY")
	private String updateBy;
	@Column(name = "CREATE_DATE", updatable = false)
	@CreationTimestamp
	private LocalDate createDate;
	@Column(name = "UPDATE_DATE", insertable = false)
	@UpdateTimestamp
	private LocalDate updateDate;

}
