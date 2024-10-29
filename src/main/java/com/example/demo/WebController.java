package com.example.demo;



import java.lang.System.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@Controller
public class WebController {
	
	
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(WebController.class);
	
	@GetMapping(value = { "/","/EB" })
    public String EB() {
		logger.debug("Accessing Hospital-1 endpoint");
        return "EB";
    }
}
