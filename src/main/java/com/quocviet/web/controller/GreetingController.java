package com.quocviet.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.quocviet.domain.Color;
import com.quocviet.domain.Greeting;
import com.quocviet.service.GreetingService;
import com.quocviet.web.form.GreetingForm;
@Controller
@RequestMapping("/home")
public class GreetingController {

	protected static Logger logger = Logger.getLogger("GreetingController");

	private GreetingService greetingService;

	@Autowired
	public GreetingController(GreetingService greetingService) {
		this.greetingService = greetingService;
	}
	@RequestMapping(value = "/addgreeting.html", method = RequestMethod.GET)
	public String showAddGreetingPage(@ModelAttribute("greetingform") GreetingForm greetingForm, Map<String, Object> model) {		

		logger.info("entering showAddGreetingPage()");

		//resolves to /WEB-INF/jsp/addgreeting.jsp
		return "addgreeting";
	}	

	@RequestMapping(value = "/greetings.html", method = RequestMethod.POST)
	public String addGreetingAndShowAll(@ModelAttribute("greetingform") GreetingForm greetingForm,
			Map<String, Object> model) {		

		logger.info("entering addGreetingAndShowAll()");

		UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Greeting greeting = greetingForm.getGreeting();
		greeting.setUsername(userDetails.getUsername());
		greeting.setGreetingDate(new Date());
		greetingService.addGreeting(greeting);

		List<Greeting> greetings = greetingService.getAllGreetings();
		model.put("greetingList", greetings);

		String selectedColorCode=greetingForm.getColor().getColorCode(); 
		if(selectedColorCode.equals("")) //if no color selected, then make default white
			selectedColorCode="9E7BFF";
		model.put("colorcode", selectedColorCode);

		// This will resolve to /WEB-INF/jsp/greetings.jsp
		return "greetings";
	} 

	@ModelAttribute("colorlist")
	public List<Color> populateColorList() {
		//color list is hardcoded for now
		List<Color> colorList = new ArrayList<Color>();
		colorList.add(new Color("Indian Red", "F75D59"));
		colorList.add(new Color("Red", "FF0000"));
		colorList.add(new Color("Salmon", "F9966B"));
		colorList.add(new Color("Lemon Chiffon", "FFF8C6"));
		colorList.add(new Color("Olive Green", "BCE954"));
		colorList.add(new Color("Steel Blue", "C6DEFF"));
		colorList.add(new Color("Medium Purple", "9E7BFF"));
		return colorList;
	}

	@RequestMapping(value="/greetings.html", method=RequestMethod.GET)
	public String showAllGreetings(Map<String,Object> model) {
		List<Greeting> greetings = greetingService.getAllGreetings();
		model.put("greetingList", greetings);
		model.put("colorcode", "BCE954");
		return "greetings";
	}
	
	@RequestMapping(value="/restrictedarea.html", method=RequestMethod.GET)
	public String showRestrictedArea() {
		return "restrictedarea";
	}
}