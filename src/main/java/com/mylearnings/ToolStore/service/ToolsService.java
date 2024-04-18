package com.mylearnings.ToolStore.service;

import java.util.ArrayList;
import java.util.List;

import com.mylearnings.ToolStore.entity.ToolType;
import com.mylearnings.ToolStore.entity.Tools;

public class ToolsService {

	public static List<Tools> toolsList = new ArrayList<>();
	
	static {
		//toolTypeName, dailyCharge, weekdayCharge, weekendCharge, holidayCharge
		ToolType Ladder = new ToolType("Ladder", 1.99, true, true, false);
		ToolType chainsaw = new ToolType("Chainsaw", 1.49, true, false, true);
		ToolType jackhammer = new ToolType("Jackhammer", 2.99, true, false, false);
		
		Tools tool1 = new Tools("CHNS", chainsaw, "Stihl");
		Tools tool2 = new Tools("LADW", Ladder, "Werner");
		Tools tool3 = new Tools("JAKD", jackhammer, "DeWalt");
		Tools tool4 = new Tools("JAKR", jackhammer, "Ridgid");

		toolsList.add(tool1);
		toolsList.add(tool2);
		toolsList.add(tool3);
		toolsList.add(tool4);
		}
	
	public  List<Tools> getToolsList(){
		
		return toolsList;
	}
	
	public Tools getToolToolCode(String toolCode) {
		
		for(Tools tool : toolsList) {
			if(toolCode.equals(tool.getToolCode())) {
			
				return tool;
			}
		}
		return null;		
	}
}
