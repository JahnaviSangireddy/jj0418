package com.mylearnings.ToolStore;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.text.DateFormatter;

import com.mylearnings.ToolStore.entity.RentalAgreement;
import com.mylearnings.ToolStore.entity.ToolType;
import com.mylearnings.ToolStore.entity.Tools;
import com.mylearnings.ToolStore.service.Checkout;
import com.mylearnings.ToolStore.service.ToolsService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {    
    	
    	ToolsService toolservice = new ToolsService();
		
		List<Tools> toolsList = toolservice.getToolsList();
					
		Scanner scan = new Scanner(System.in);
		System.out.println("Provide the tool code from below table");

		for (Tools tool : toolsList) {
			System.out.println(tool.getToolCode() + " " + tool.getToolType().getToolTypeName());
		}
		String toolcode = scan.next();

		System.out.println("Enter the number of days for which the customer wants to rent the tool");
		int rentalDays = scan.nextInt();

		System.out.println("Enter the discount percent");
		double discountPercent = scan.nextDouble();

		System.out.println("Enter the checkout date");
		String checkoutDateString = scan.next();
				
		LocalDate checkoutDate = formatDate(checkoutDateString);
		
		System.out.println("toolcode :"+toolcode+" rentalDays :"+rentalDays+" discountPercent:"+discountPercent+" checkoutDate:"+checkoutDate);
		Checkout ch = new Checkout();
        ch.checkout(toolcode,rentalDays,discountPercent,checkoutDate);
		//LocalDate dueDate = checkoutDate.plusDays(rentalDays);
        //ch.calculateHolidayCount(checkoutDate,dueDate);
    }
    
    public static LocalDate formatDate(String checkoutDateString) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yy");
		LocalDate checkoutDate = LocalDate.parse(checkoutDateString, formatter);
		return checkoutDate;
	}
}
