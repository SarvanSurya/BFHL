package com.bfhc.jfsd.springboot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bfhl")
public class RestControllerClass 
{
	@GetMapping("demo")
	public String demo() {
		return "The Project is Working";
	}
	
	
	  @GetMapping
	    public Map<String, Integer> getOperationCode() {
	        Map<String, Integer> response = new HashMap<>();
	        response.put("operation_code", 1);
	        return response;
	    }

	    @PostMapping
	    public Map<String, Object> processData(@RequestBody Map<String, List<String>> requestData) {
	        Map<String, Object> response = new HashMap<>();
	        String userId = "john_doe_17091999";  // Replace with logic for dynamic user_id if needed
	        String email = "john@xyz.com";  // Replace with actual email
	        String rollNumber = "ABCD123";  // Replace with actual roll number

	        List<String> data = requestData.get("data");
	        List<String> numbers = new ArrayList<>();
	        List<String> alphabets = new ArrayList<>();
	        List<String> highestLowercaseAlphabet = new ArrayList<>();

	        for (String item : data) {
	            if (item.matches("[0-9]+")) {
	                numbers.add(item);
	            } else if (item.matches("[a-zA-Z]")) {
	                alphabets.add(item);
	                if (item.matches("[a-z]")) {
	                    highestLowercaseAlphabet.add(item);
	                }
	            }
	        }

	        if (!highestLowercaseAlphabet.isEmpty()) {
	            String maxLowercase = Collections.max(highestLowercaseAlphabet);
	            highestLowercaseAlphabet.clear();
	            highestLowercaseAlphabet.add(maxLowercase);
	        }

	        response.put("is_success", true);
	        response.put("user_id", userId);
	        response.put("email", email);
	        response.put("roll_number", rollNumber);
	        response.put("numbers", numbers);
	        response.put("alphabets", alphabets);
	        response.put("highest_lowercase_alphabet", highestLowercaseAlphabet);

	        return response;
	    }
}
