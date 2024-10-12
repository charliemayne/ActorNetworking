package com.actornetwork.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import ch.qos.logback.core.model.Model;

/**
 * Controller for Index Page
 * 
 * @author Wolfgang Zoppelt
 */

@Controller
public class IndexController {

	/**
	 * Get Mapping for index location
	 * 
	 * @author Wolfgang Zoppelt
	 * @return index.html
	 */
	@GetMapping("/")
	public String getIndex() {
		return "index.html";
	}
}
