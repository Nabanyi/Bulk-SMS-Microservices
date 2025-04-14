package com.example.demo.utils;

import org.springframework.context.annotation.Configuration;

@Configuration
public class Helper {

	public Helper() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getUserId() {
		//CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return 1;// userDetails.getId().intValue();
	}
}
