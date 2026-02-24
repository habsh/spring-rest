package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calci")
public class CalculatorController {
	
	//GET  -> http://localhost:7878/calci/add?num1=30&num2=40
	@GetMapping("/add")	
	public int addition(@RequestParam int num1,@RequestParam int num2) {
		return(num1+num2);
	}
	//GET  -> http://localhost:7878/calci/sub/20/10
	@GetMapping("/sub/{num1}/{num2}")	
	public int sub(@PathVariable int num1,@PathVariable int num2) {
		return(num1-num2);
	}
	
	
}
