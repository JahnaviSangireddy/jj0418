package com.mylearnings.ToolStore.entity;

public class ToolType {

	private String toolTypeName;
	private double dailyCharge;
	private boolean weekdayCharge;
	private boolean weekendCharge;
	private boolean holidayCharge;
	
	
	public ToolType(String toolTypeName, double dailyCharge, boolean weekdayCharge, boolean weekendCharge,
			boolean holidayCharge) {
		super();
		this.toolTypeName = toolTypeName;
		this.dailyCharge = dailyCharge;
		this.weekdayCharge = weekdayCharge;
		this.weekendCharge = weekendCharge;
		this.holidayCharge = holidayCharge;
	}
	
	public String getToolTypeName() {
		return toolTypeName;
	}
	public void setToolTypeName(String toolTypeName) {
		this.toolTypeName = toolTypeName;
	}
	public double getDailyCharge() {
		return dailyCharge;
	}
	public void setDailyCharge(double dailyCharge) {
		this.dailyCharge = dailyCharge;
	}
	public boolean isWeekdayCharge() {
		return weekdayCharge;
	}
	public void setWeekdayCharge(boolean weekdayCharge) {
		this.weekdayCharge = weekdayCharge;
	}
	public boolean isWeekendCharge() {
		return weekendCharge;
	}
	public void setWeekendCharge(boolean weekendCharge) {
		this.weekendCharge = weekendCharge;
	}
	public boolean isHolidayCharge() {
		return holidayCharge;
	}
	public void setHolidayCharge(boolean holidayCharge) {
		this.holidayCharge = holidayCharge;
	}

	@Override
	public String toString() {
		return "ToolType [toolTypeName=" + toolTypeName + ", dailyCharge=" + dailyCharge + ", weekdayCharge="
				+ weekdayCharge + ", weekendCharge=" + weekendCharge + ", holidayCharge=" + holidayCharge + "]";
	}
	
	
	
}
