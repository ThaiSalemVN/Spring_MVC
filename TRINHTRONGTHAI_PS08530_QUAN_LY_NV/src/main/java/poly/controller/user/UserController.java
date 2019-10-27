package poly.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.service.StaffService;

@Controller
@RequestMapping("/user/")
public class UserController {
	@Autowired
	StaffService staffService;
	
	@RequestMapping("home")
	public String sayhello(ModelMap model) {
		model.addAttribute("top10", staffService.findTop10());		
		return "user/home";
	}
	
	
}
