package com.mylearnings.ToolStore;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BrowserStackJunit {
	
	String message = "BrowserStack is the intended message";
	@Test 
	public void testMessage() {
	System.out. println("Inside testMessage()");
	assertEquals(message, "BrowserStack is the intended message");
	}
}
