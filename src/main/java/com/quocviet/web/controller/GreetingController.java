package com.quocviet.web.controller;

import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/home")
public class GreetingController {

  protected static Logger logger = Logger.getLogger("GreetingController");

  //define the same url with GET so users can skip to the greetings page
  //note there is no actual greetings.html file!! 
  @RequestMapping(value = "/greetings.html", method = RequestMethod.POST)
  public String showAllGreetings(@RequestParam(value="greetingText", required=true) String greetingText,
                                 Map<String, Object> model) {    

    logger.info("entering showAllGreetings"); 

    model.put("greetingText", greetingText);

    // This will resolve to /WEB-INF/jsp/greetings.jsp
    return "greetings";
  } 

  @RequestMapping(value = "/addgreeting.html", method = RequestMethod.GET)
  public String showAddGreetingPage() {   

    logger.info("entering showAddGreetingPage");

    // This will resolve to /WEB-INF/jsp/addgreeting.jsp
    return "addgreeting";
  } 

}