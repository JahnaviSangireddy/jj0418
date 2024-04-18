package com.mylearnings.ToolStore.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RentalAgreement {

//	●	Tool code - Speciﬁed at checkout
//	●	Tool type - From tool info
//	●	Tool brand - From tool info
//	●	Rental days - Speciﬁed at checkout
//	●	Check out date - Speciﬁed at checkout
//	●	Due date - Calculated from checkout date and rental days.
//	●	Daily rental charge - Amount per day, speciﬁed by the tool type.
//	●	Charge days - Count of chargeable days, from day after checkout through and including due date, excluding “no charge” days as speciﬁed by the tool type.
//	●	Pre-discount charge - Calculated as charge days X daily charge. Resulting total rounded half up to cents.
//	●	Discount percent - Speciﬁed at checkout.
//	●	Discount amount - calculated from discount % and pre-discount charge. Resulting amount rounded half up to cents.
//	●	Final charge - Calculated as pre-discount charge - discount amount.

	private String toolCode;
	private ToolType toolType;
	private String toolBrand;
	private int rentalDays;
	private LocalDate checkoutDate;
	private LocalDate dueDate;
	private double dailyRentalCharge;
	private int chargeDays;
	private double preDiscountCharge;
	private double discountPercent;
	private double discountAmount;
	private double finalCharge;
	
	public String getToolCode() {
		return toolCode;
	}
	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}
	public ToolType getToolType() {
		return toolType;
	}
	public void setToolType(ToolType toolType) {
		this.toolType = toolType;
	}
	public String getToolBrand() {
		return toolBrand;
	}
	public void setToolBrand(String toolBrand) {
		this.toolBrand = toolBrand;
	}
	public int getRentalDays() {
		return rentalDays;
	}
	public void setRentalDays(int rentalDays) {
		this.rentalDays = rentalDays;
	}
	public LocalDate getCheckoutDate() {
		return checkoutDate;
	}
	public void setCheckoutDate(LocalDate checkoutDate) {
		this.checkoutDate = checkoutDate;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	public double getDailyRentalCharge() {
		return dailyRentalCharge;
	}
	public void setDailyRentalCharge(double dailyRentalCharge) {
		this.dailyRentalCharge = dailyRentalCharge;
	}
	public int getChargeDays() {
		return chargeDays;
	}
	public void setChargeDays(int chargeDays) {
		this.chargeDays = chargeDays;
	}
	public double getPreDiscountCharge() {
		return preDiscountCharge;
	}
	public void setPreDiscountCharge(double preDiscountCharge) {
		this.preDiscountCharge = preDiscountCharge;
	}
	public double getDiscountPercent() {
		return discountPercent;
	}
	public void setDiscountPercent(double discountPercent) {
		this.discountPercent = discountPercent;
	}
	public double getDiscountAmount() {
		return discountAmount;
	}
	public void setDiscountAmount(double discountAmount) {
		this.discountAmount = discountAmount;
	}
	public double getFinalCharge() {
		return finalCharge;
	}
	public void setFinalCharge(double finalCharge) {
		this.finalCharge = finalCharge;
	}
	
	public void printRentalAgreement(RentalAgreement rentalAgreement) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yy");

			System.out.println("*************** RENTAL AGREEMENT *****************");
			System.out.println("Tool code -"+rentalAgreement.getToolCode());
			System.out.println("Tool type - "+rentalAgreement.getToolType().getToolTypeName());
			System.out.println("Tool brand - "+rentalAgreement.getToolBrand());
			System.out.println("Rental days - "+rentalAgreement.getRentalDays());
			System.out.println("Check out date - "+rentalAgreement.getCheckoutDate().format(formatter));		
			System.out.println("Due date - "+rentalAgreement.getDueDate().format(formatter));
			System.out.println("Daily rental charge - $"+rentalAgreement.getDailyRentalCharge());
			System.out.println("Charge days - "+rentalAgreement.getChargeDays());
			System.out.println("Pre-discount charge- $"+rentalAgreement.getPreDiscountCharge());
			System.out.println("Discount percent-"+rentalAgreement.getDiscountPercent()+"%");
			System.out.println("Discount amount- $"+rentalAgreement.getDiscountAmount());
			System.out.println("Final charge - $"+rentalAgreement.getFinalCharge());
			System.out.println("****************************************************");				
	}
	
	
}
