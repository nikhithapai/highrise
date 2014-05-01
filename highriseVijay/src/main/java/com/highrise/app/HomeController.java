package com.highrise.app;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.highrise.model.User;
import com.highrise.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller

public class HomeController {
	
	@Autowired
	private UserService userService;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		/*ApplicationContext appContext = 
		    	  new ClassPathXmlApplicationContext("spring/appServlet/servlet-context.xml");*/
	 
	//	UserService userBo = (UserService)appContext.getBean("userBO");
		User user = new User();
		user.setUserName("ruben");
		user.setUserType("Engineer");
		//userService.save(user);
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "login";
	}
	
}
