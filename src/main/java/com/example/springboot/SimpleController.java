package com.example.springboot;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SimpleController {
	@Value("${spring.application.name}")
	String appName;
	@Value("${spring.application.dateTitle}")
	String dateTitle;
	@GetMapping("/")
	public String homePage(Model model) {
		model.addAttribute("appName", appName);
	return "home";
	}
	@GetMapping("/datepage")
	public String datePage(Model model) {
		model.addAttribute("dateTitle", dateTitle);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String dateStr = simpleDateFormat.format(new Date()); 

		model.addAttribute("localDateTime", dateStr);
	return "datepage";
	}
}