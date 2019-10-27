package poly.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.service.DepartService;

@Controller
@RequestMapping("/admin/")
public class AdminController {
	@Autowired
	DepartService departService;
	
	@RequestMapping("home")
	public String about() {
		return "admin/home";
	}
		
	@RequestMapping("error")
	public String loi() {
		return "admin/error";
	}
}

