package com.example.springboot;


import java.time.LocalDateTime;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	 private static final Logger LOGGER = LoggerFactory.getLogger(SimpleController.class);	
	
	@GetMapping("/")
	public String homePage(Model model) {
		model.addAttribute("appName", appName);
	return "home";
	}

	@GetMapping("/datepage")
	public String datePage(Model model) {
		int 	intMonth = LocalDateTime.now().getMonthValue(),
				intDay = LocalDateTime.now().getDayOfMonth();
		String	season = "hiver";
		int currentAnnualTimeStamp = intDay * intMonth,
			springTimeline = 21 * 3,
			summerTimeline = 21 * 6,
			fallTimeline = 21 * 9,
			winterTimeline = 21 * 12;
		ArrayList<Saison> saisons = new ArrayList<Saison>();

		if (currentAnnualTimeStamp >= winterTimeline) season = "hiver";
		else if (currentAnnualTimeStamp >= fallTimeline) season = "automne";
		else if (currentAnnualTimeStamp >= summerTimeline) season = "été";
		else if (currentAnnualTimeStamp >= springTimeline) season = "printemps";
		
		saisons.add(new Saison("printemps", season == "printemps"));
		saisons.add(new Saison("été", season == "été"));
		saisons.add(new Saison("automne", season == "automne"));
		saisons.add(new Saison("hiver", season == "hiver"));

		LOGGER.info(saisons.toString());
		
		model.addAttribute("saisons", saisons);
		model.addAttribute("dateTitle", dateTitle);
		model.addAttribute("localDateTime", LocalDateTime.now());
		model.addAttribute("season", season);
	return "datepage";
	}
}