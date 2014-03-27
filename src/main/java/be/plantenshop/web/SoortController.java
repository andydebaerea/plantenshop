package be.plantenshop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import be.plantenshop.services.SoortService;

@Controller
@RequestMapping("/soort")
public class SoortController {
	private final SoortService soortService;
	
	private static final String SOORT_VIEW = "winkel/soortdetails";
	
	@Autowired
	SoortController(SoortService soortService) {
		this.soortService = soortService;
	}
	
	@RequestMapping(value="{id}", method= RequestMethod.GET)
	ModelAndView SoortWeergeven(@PathVariable long id) {
		return new ModelAndView(SOORT_VIEW, "soort", soortService.read(id));
	}
}
