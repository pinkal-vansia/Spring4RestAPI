package com.invokedynamic.spring;

 
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.invokedynamic.spring.User;
 
/**
 * Handles requests for the application home page.
 */
@Controller
public class RestController {
   
  private static final Logger logger = LoggerFactory.getLogger(RestController.class);
  private Map<String, User> users = new HashMap<String, User>();
   
  public RestController() {
    // pre-initialize the list of issuers available ...
     
	  users.put("pinkal", new User("pinkal", "pinkal123", "pinkal@gmail.com", "USA"));
	  users.put("mahesh", new User("mahesh", "mahesh123", "mahesh@gmail.com", "USA"));
  }
   
  /**
   * Simply selects the home view to render by returning its name.
   */
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String home(Locale locale, Model model) {
    logger.info("Welcome home! The client locale is {}.", locale);
     
    Date date = new Date();
    DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
     
    String formattedDate = dateFormat.format(date);
     
    model.addAttribute("serverTime", formattedDate );
     
    return "status";
  }
   
  @RequestMapping(value="/users", method=RequestMethod.GET)
  @ResponseBody
  public Map<String, User> getAllUsers() {
    logger.info("Inside getAllUsers() method...");
     
    return users;
  }
   
  @RequestMapping(value="/user/{username}", method=RequestMethod.GET)
  @ResponseBody
  public User getUserByUsername(@PathVariable("username") String username) {
	  User user = users.get(username);
     
    if (user != null) {
      logger.info("Inside sgetUserByUsername, returned: " + user.toString());
    } else {
      logger.info("Inside getUserByUsername, ticker: " + username + ", NOT FOUND!");
    }
    return user;
  }
 
  @RequestMapping(value="/user/delete/{username}", method=RequestMethod.GET)
  @ResponseBody
  public User deleteIssuerByTicker(@PathVariable("username") String username) {
	  User user = users.remove(username);
     
    if (user != null) {
      logger.info("Inside deleteIssuerByTicker, deleted: " + user.toString());
    } else {
      logger.info("Inside deleteIssuerByTicker, ticker: " + username + ", NOT FOUND!");
    }
    return user;
  }
 
  @RequestMapping(value="/user/create", method=RequestMethod.GET)
  public ModelAndView addUser() {
     
    return new ModelAndView("addUser", "command", new User());
  }
   
  @RequestMapping(value="/user/addUser", method=RequestMethod.POST)
  @ResponseBody
  public String addUser(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
	  if (result.hasErrors()) {
		  
		  return "addUser";
      }
    if (user != null) {
      logger.info("Inside addIssuer, adding: " + user.toString());
    } else {
      logger.info("Inside addIssuer...");
    }
    users.put(user.getUsername(), user);
    return "{\"success\":1}";
  }
}