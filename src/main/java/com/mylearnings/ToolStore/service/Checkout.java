package com.mylearnings.ToolStore.service;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

import com.mylearnings.ToolStore.entity.RentalAgreement;
import com.mylearnings.ToolStore.entity.ToolType;
import com.mylearnings.ToolStore.entity.Tools;

public class Checkout {
	
	public double checkout(String toolcode,int rentalDays,double discountPercent,LocalDate checkoutDate) {
		
		ToolsService toolservice = new ToolsService();
		if (rentalDays < 1) {
			throw new IllegalArgumentException("rental days must be greater than 1");
		}
		if (discountPercent < 0 || discountPercent > 100) {
			throw new IllegalArgumentException("Invalid discount percent");
		}

		RentalAgreement rentalAgreement = new RentalAgreement();
	
		rentalAgreement.setToolCode(toolcode);		
		Tools tool = toolservice.getToolToolCode(toolcode);
		rentalAgreement.setToolType(tool.getToolType());
		rentalAgreement.setToolBrand(tool.getBrand());
		rentalAgreement.setRentalDays(rentalDays);
		rentalAgreement.setCheckoutDate(checkoutDate);
		
		
		LocalDate dueDate = checkoutDate.plusDays(rentalDays);
		rentalAgreement.setDueDate(dueDate);
		rentalAgreement.setDailyRentalCharge(tool.getToolType().getDailyCharge());
		
		int chargeDays = calculateChargeDays(checkoutDate,dueDate,tool.getToolType());
		rentalAgreement.setChargeDays(chargeDays);
		rentalAgreement.setDiscountPercent(discountPercent);
		
		double preDiscountCharge = chargeDays * tool.getToolType().getDailyCharge();
		rentalAgreement.setPreDiscountCharge(preDiscountCharge);
		
		double discountAmount = (discountPercent * preDiscountCharge)/100;
		rentalAgreement.setDiscountAmount(discountAmount);
		
		double finalCharge = preDiscountCharge - discountAmount;
		rentalAgreement.setFinalCharge(finalCharge);
		
		rentalAgreement.printRentalAgreement(rentalAgreement);
		
		return finalCharge;
	
	}
	
	public int calculateChargeDays(LocalDate checkoutDate, LocalDate dueDate, ToolType toolType) {

		int chargeDays =0;
		int weekdaycount = calculateWeekDaysCount(checkoutDate,dueDate);
		int weekendcount = calculateWeekendCount(checkoutDate,dueDate);
		int holidaycount = calculateHolidayCount(checkoutDate,dueDate);
		
		if(toolType.isWeekdayCharge()) {
			chargeDays += weekdaycount;
		}
		if(toolType.isWeekendCharge()) {
			chargeDays += weekendcount;
		}
		if(!toolType.isHolidayCharge() && holidaycount >0) {
			chargeDays -= holidaycount;
		}
		return chargeDays;
	}

	public int calculateHolidayCount(LocalDate checkoutDate, LocalDate dueDate) {
		
		LocalDate date = checkoutDate.plusDays(1);
		
		int holidaycount=0;
	
		while(!date.isAfter(dueDate)) {
			if((date.getDayOfMonth() == 4) && (date.getMonth().compareTo(Month.JULY) == 0)) {
				holidaycount++;
			}else if((date.getMonth().compareTo(Month.SEPTEMBER) == 0)  && (date.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY)).equals(date))) {
				holidaycount++;
			}
			
			date = date.plusDays(1);
		}
			
		//int holidaycount = (int) rentaldates.stream().filter((ld)->ld.equals(independenceDay)).count();

		System.out.println("holiday count "+holidaycount);
		return holidaycount;
	}

	public int calculateWeekendCount(LocalDate checkoutDate, LocalDate dueDate) {
		
		int weekend=0;
		LocalDate date = checkoutDate.plusDays(1);
		
		while(!date.isAfter(dueDate)) {
			
				if(date.getDayOfWeek()==DayOfWeek.SATURDAY || date.getDayOfWeek()==DayOfWeek.SUNDAY) {
					weekend++;
				}
		
				date = date.plusDays(1);
		}
		
		System.out.println("weekend count "+weekend);
		return weekend;
	}

	public int calculateWeekDaysCount(LocalDate checkoutDate, LocalDate dueDate) {
		
		int weekdaycount=0;
		LocalDate date = checkoutDate.plusDays(1);
		
		while(!date.isAfter(dueDate)) {
			
				if(date.getDayOfWeek()!=DayOfWeek.SATURDAY && date.getDayOfWeek()!=DayOfWeek.SUNDAY) {
					
					weekdaycount++;
				}
		
				date = date.plusDays(1);
		}
		
		System.out.println("weekdays "+weekdaycount);
		return weekdaycount;
	}

	
}
