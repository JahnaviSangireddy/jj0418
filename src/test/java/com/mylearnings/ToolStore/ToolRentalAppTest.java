package com.mylearnings.ToolStore;

import java.time.LocalDate;

import org.junit.Test;

import com.mylearnings.ToolStore.service.Checkout;

public class ToolRentalAppTest {

	Checkout ck = new Checkout();
	
	 @Test
	public void test1() {	
		
		 try {
			 LocalDate checkoutDate = LocalDate.of(2015, 9, 3);			
			 ck.checkout("JAKR", 5, 101, checkoutDate);
		 }catch(IllegalArgumentException e) {
			 System.out.println(e.getMessage());
		 }		 
	    }
	 
	 @Test
	 public void test2() {
		 LocalDate checkoutDate = LocalDate.of(2020, 7, 2);			
		 ck.checkout("LADW", 3, 10, checkoutDate);
	 }
	 
	 @Test
	 public void test3() {
		 LocalDate checkoutDate = LocalDate.of(2015, 7, 2);			
		 ck.checkout("CHNS", 5, 25, checkoutDate);
	 }
	 
	 @Test
	 public void test4() {
		 LocalDate checkoutDate = LocalDate.of(2015, 9, 3);			
		 ck.checkout("JAKD", 6, 0, checkoutDate);
	 }
	 
	 @Test
	 public void test5() {
		 LocalDate checkoutDate = LocalDate.of(2015, 7, 2);			
		 ck.checkout("JAKR", 9, 0, checkoutDate);
	 }
	 
	 @Test
	 public void test6() {
		 LocalDate checkoutDate = LocalDate.of(2020, 7, 2);			
		 ck.checkout("JAKR", 4, 50, checkoutDate);
	 }
}
