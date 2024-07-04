package com.example.insurance_premium.service;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.example.insurance_premium.entity.customerDTO;

@Service
public class PremiumService {
	public double getPremium(customerDTO customer){
		double baseRate = 10000.00;
		double adjustedRate=0.00;
		
		LocalDate localCarBuyDate = convertToLocalDateViaInstant(customer.getCarBuyDate());
        
        // Get today's date
        LocalDate today = LocalDate.now();
        
        // Calculate the difference in years
        int carAge = Period.between(localCarBuyDate, today).getYears();
        
        String m_status = customer.getMaritalStatus();
        
        int age = customer.getAge();
        double carPrice = customer.getCarPrice();
        
        //Age condition
        
        if(age<20) {
        	adjustedRate=1.30*baseRate;
        }else if(age>=20 && age<25) {
        	adjustedRate = 1.20*baseRate;
        }else if(age>=25 && age<30) {
        	adjustedRate=1.15*baseRate;
        }else if(age>=30 && age<60) {
        	adjustedRate=1.10*baseRate;
        }else if(age>=60 && age<70) {
        	adjustedRate=1.05*baseRate;
        }else if(age>=70 && age<80) {
        	adjustedRate=1.12*baseRate;
        }else if(age>=80) {
        	adjustedRate=1.16*baseRate;
        }
        
        //Marital Status Condition
        
        if(m_status.equals("unmarried") && age<22) {
        	adjustedRate=1.40*adjustedRate;
        }else if(m_status.equals("unmarried") && age>=22 && age<26) {
        	adjustedRate=1.30*adjustedRate;
        }else if(m_status.equals("unmarried") && age>=26 && age<35) {
        	adjustedRate=1.20*adjustedRate;
        }else if(m_status.equals("unmarried") && age>=35 && age<45) {
        	adjustedRate=1.15*adjustedRate;
        }else if(m_status.equals("unmarried") && age>=45) {
        	adjustedRate=1.20*adjustedRate;
        }else if(m_status.equals("married") && age<22) {
        	adjustedRate=1.22*adjustedRate;
        }else if(m_status.equals("married") && age>=22 && age<26) {
        	adjustedRate=1.18*adjustedRate;
        }else if(m_status.equals("married") && age>=26 && age<35) {
        	adjustedRate=1.10*adjustedRate;
        }else if(m_status.equals("married") && age>=35 && age<45) {
        	adjustedRate=1.05*adjustedRate;
        }else if(m_status.equals("married") && age>=45) {
        	adjustedRate=1.00*adjustedRate;
        }
        
        // Car Price condition
        
        if(carPrice<200000) {
        	adjustedRate=1.00*adjustedRate;
        }else if(carPrice>=200000 && carPrice<300000) {
        	adjustedRate=1.10*adjustedRate;
        }else if(carPrice>=300000 && carPrice<600000) {
        	adjustedRate=1.20*adjustedRate;
        }else if(carPrice>=600000 && carPrice<1000000) {
        	adjustedRate=1.35*adjustedRate;
        }else if(carPrice>=1000000 && carPrice<1500000) {
        	adjustedRate=1.50*adjustedRate;
        }else if(carPrice>=1500000 && carPrice<2000000) {
        	adjustedRate=1.60*adjustedRate;
        }else if(carPrice>=2000000 && carPrice<2500000) {
        	adjustedRate=1.70*adjustedRate;
        }else if(carPrice>=2500000 && carPrice<3000000) {
        	adjustedRate=1.75*adjustedRate;
        }else if(carPrice>=3000000 && carPrice<3500000) {
        	adjustedRate=1.80*adjustedRate;
        }else if(carPrice>=3500000 && carPrice<4000000) {
        	adjustedRate=1.85*adjustedRate;
        }else if(carPrice>=4000000) {
        	adjustedRate=1.90*adjustedRate;
        }
        
        //Car Age Condition
        
        if(carAge<1) {
        	adjustedRate=1.05*adjustedRate;
        }else if(carAge>=1 && carAge<2) {
        	adjustedRate=1.03*adjustedRate;
        }else if(carAge>=2 && carAge<3) {
        	adjustedRate=1.05*adjustedRate;
        }else if(carAge>=3 && carAge<5) {
        	adjustedRate=1.08*adjustedRate;
        }else if(carAge>=5 && carAge<8) {
        	adjustedRate=1.10*adjustedRate;
        }else if(carAge>=8 && carAge<10) {
        	adjustedRate=1.15*adjustedRate;
        }else if(carAge>=10 && carAge<14) {
        	adjustedRate=1.18*adjustedRate;
        }else if(carAge>=14) {
        	adjustedRate=1.20*adjustedRate;
        }
        
        return adjustedRate;
        
	}
	
	
	public static LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
          .atZone(ZoneId.systemDefault())
          .toLocalDate();
    }
}
