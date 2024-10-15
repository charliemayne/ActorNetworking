package com.actornetwork.domain;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserTest {
	
	User user; 
	
	@BeforeEach
	void setUp() {
		user = new User("First", "Last", "test@test.com", "Password");
	}
		
	@Test
	void testFirstName() {
		assertTrue(user.getFirstName() == "First");
		user.setFirstName("Test");
		assertTrue(user.getFirstName() == "Test");
	}
	
	@Test
	void testLastName() {
		assertTrue(user.getLastName() == "Last");
		user.setLastName("Test");
		assertTrue(user.getLastName() == "Test");
	}
	
	@Test
	void testEmail() {
		assertTrue(user.getEmail() == "test@test.com");
		user.setLastName("Test");
		assertTrue(user.getLastName() == "Test");
	}
}
