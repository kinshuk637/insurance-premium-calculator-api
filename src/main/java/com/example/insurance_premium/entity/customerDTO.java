package com.example.insurance_premium.entity;


import java.util.Date;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//@Table(name="")
@Entity

public class customerDTO {
	private String name;
	private int age;
	private String maritalStatus;
	Date carBuyDate;
	double carPrice;
	double premium;
}
