package com.mylearnings.ToolStore.entity;

public class Tools {

	private String toolCode;
	private ToolType toolType;
	private String brand;
	
	public Tools(String toolCode, ToolType toolType, String brand) {
		super();
		this.toolCode = toolCode;
		this.toolType = toolType;
		this.brand = brand;
	}
	
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
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Tools [toolCode=" + toolCode + ", toolType=" + toolType + ", brand=" + brand + "]";
	}
	
	
}
