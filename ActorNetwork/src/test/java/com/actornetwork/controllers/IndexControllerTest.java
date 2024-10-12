package com.actornetwork.controllers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class IndexControllerTest {
	
	IndexController ic = new IndexController();
	
	@Test
	void testGetIndex() {
		assertTrue(ic.getIndex() == "index.html");
	}
}
