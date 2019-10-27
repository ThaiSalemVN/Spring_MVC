package poly.controller.admin;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.context.annotation.SessionScope;

import poly.model.User;
import poly.service.UserService;

@Controller
@RequestMapping("/admin/")
public class LoginController {
@Autowired
UserService userService;

	@RequestMapping("login")
	public String showform(HttpSession session,ModelMap model) {	
		User sessionUser = (User) session.getAttribute("User");
		if (sessionUser!=null) {
			return "redirect:/admin/home.htm";
		}
		else {
			    User user = new User();		
				model.addAttribute("user", user);
				
			return "blank/login-form";
		}
		
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String checkUser(HttpSession session,HttpServletResponse response
								,ModelMap model,@ModelAttribute("user") User user
								,@RequestParam(value ="remember-me",defaultValue = "false") boolean remember ){
		
		User user2 = userService.findByName(user.getUsername());
	  if (user2!=null && user.getPassword().equals(user2.getPassword())) {
		  
		  	Cookie cookie1 = new Cookie("ckId",user2.getUsername());
			Cookie cookie2 = new Cookie("ckPw",user2.getPassword());
		
		  if (remember) {
			cookie1.setMaxAge(30*24*60*60);
			cookie2.setMaxAge(30*24*60*60);				
		}
		  else {
			 cookie1.setMaxAge(0);
			 cookie2.setMaxAge(0);			
		  }
		// Gửi cookie về client để lưu lại
		  response.addCookie(cookie1);
		  response.addCookie(cookie2);

		session.setAttribute("User", user2);
		return "redirect:/admin/home.htm";
	}
		model.addAttribute("message", "Username or password incorrect");
		return "blank/login-form";
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.removeAttribute("User");
		return "redirect:/admin/login.htm";
	}
	
	@RequestMapping("change")
	public String showFormChange() {
		return "admin/changepassword";
	}
	
	@RequestMapping(value = "change", method = RequestMethod.POST)
	public String change(ModelMap model,HttpSession session
									 ,@RequestParam("pw") String password
									,@RequestParam("newpw") String newPw
									,@RequestParam("confirmpw") String confirm
						,@SessionAttribute("User") User user){
		if (!password.equals(user.getPassword())) {
			model.addAttribute("message", "Sai mật khẩu!!!");
		}
		else {
			if (newPw.equals(confirm)) {
				user.setPassword(newPw);		
				if (userService.updateUser(user)) {
					session.setAttribute("User", user);
					return "admin/home";
				}else {
					model.addAttribute("message", "Thay đổi mật khẩu thất bại!!!");
				}		
			}
			model.addAttribute("message", "Xác nhận mật khẩu không khớp!!!");
		}	
		return "admin/changepassword";
	}
	
	
}
