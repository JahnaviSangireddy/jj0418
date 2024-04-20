package com.mylearnings.ToolStore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import com.mylearnings.ToolStore.service.Checkout;

public class ToolRentalAppTest {

	Checkout ck;
	
	@Before
	public void createCheckoutObj() {
	
		 ck = new Checkout();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test1() {

		LocalDate checkoutDate = LocalDate.of(2015, 9, 3);
		double finalcharge = ck.checkout("JAKR", 5, 101, checkoutDate);
	}
	 
	 @Test
	 public void test2() {
		 LocalDate checkoutDate = LocalDate.of(2020, 7, 2);			
		 double finalcharge = ck.checkout("LADW", 3, 10, checkoutDate);
		
		 assertNotNull(finalcharge);
		 assertEquals(3.582,finalcharge,0);
	 }
	 
	 @Test
	 public void test3() {
		 LocalDate checkoutDate = LocalDate.of(2015, 7, 2);			
		 double finalcharge = ck.checkout("CHNS", 5, 25, checkoutDate);
		 
		 assertNotNull(finalcharge);
		 assertEquals(3.3525, finalcharge,0);
	 }
	 
	 @Test
	 public void test4() {
		 LocalDate checkoutDate = LocalDate.of(2015, 9, 3);			
		 double finalcharge = ck.checkout("JAKD", 6, 0, checkoutDate);
		 assertNotNull(finalcharge);
		 assertEquals(8.97,finalcharge,0);
	 }
	 
	 @Test
	 public void test5() {
		 LocalDate checkoutDate = LocalDate.of(2015, 7, 2);			
		 double finalcharge = ck.checkout("JAKR", 9, 0, checkoutDate);
		 
		 assertNotNull(finalcharge);
		 assertEquals(14.950000000000001,finalcharge,0 );
	 }
	 
	 @Test
	 public void test6() {
		 LocalDate checkoutDate = LocalDate.of(2020, 7, 2);			
		 double finalcharge = ck.checkout("JAKR", 4, 50, checkoutDate);
		 
		 assertNotNull(finalcharge);
		 assertEquals(1.495, finalcharge,0);
	 }
}
