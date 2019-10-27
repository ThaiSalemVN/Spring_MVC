package poly.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import poly.service.Mailer;

@Controller
@RequestMapping("/admin/")
public class EmailController {
@Autowired
Mailer mailer;

	@RequestMapping("email")
	public String showForm() {
		
		return "admin/email";
	}
	
	@RequestMapping(value =  "email",method = RequestMethod.POST)
	public String sendEmail(ModelMap model,@RequestParam("from") String from
							,@RequestParam("to") String to,@RequestParam("subject") String subject
							,@RequestParam("message") String message) {
		
		try {
			mailer.sendEmail(from, to, subject, message);
			model.addAttribute("mss", "true");
		} catch (Exception e) {
			model.addAttribute("mss", "false");
		}
		return "admin/email";
	}
}
