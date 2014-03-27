package be.plantenshop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import be.plantenshop.services.SoortService;

@Controller
@RequestMapping("/")
public class HomeController {
	private final SoortService soortService;
	
	private static final String HOME_VIEW = "home";
	
	@Autowired
	HomeController(SoortService soortService) {
		this.soortService = soortService;
	}
	
	@RequestMapping(method= RequestMethod.GET)
	ModelAndView home() {
		return new ModelAndView(HOME_VIEW, "soorten", soortService.findAll());
	}
}
