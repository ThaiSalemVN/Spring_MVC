package poly.controller.admin;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import poly.model.Depart;
import poly.service.DepartService;

@Controller
@RequestMapping("/admin/departs")
public class DepartController {
	@Autowired
	DepartService departService;
	
	
	@RequestMapping("/index")
	public String removeSession(HttpSession session) {
		session.setAttribute("nameDepart", "");		
		return "redirect:/admin/departs/home.htm";
	}
	
	
	@RequestMapping("/home")
	public String home(ModelMap model,HttpServletRequest request
						,HttpSession session
			            ,@RequestParam(value = "page",defaultValue = "1") int page								 		 
			            ,@RequestParam(value = "message", defaultValue = "") String mess
			   ) {
					
//// Vừa phân trang list tìm kiếm và All.
				String nameTK = (String) session.getAttribute("nameDepart");
			
			List<Depart> list = departService.findAllPage(page,nameTK);	
			int totalPage = (int) Math.ceil( departService.findLikeName(nameTK).size()/5.0);// 5 số item trên 1 trang.
			
			model.addAttribute("Depart", new Depart());
			model.addAttribute("Departs",list );
			model.addAttribute("totalPage",totalPage);
			model.addAttribute("startPage", page);	
			model.addAttribute("message", mess);
		return "admin/qlphongban";
	}
	
	@RequestMapping("/search")
	public String search(ModelMap model
						,HttpSession session, @RequestParam("tenPB") String name) {
			
		session.setAttribute("nameDepart", name);
		return "redirect:/admin/departs/home.htm";
	}
	
		
	@RequestMapping("/delete")
	public String delete(ModelMap model, @RequestParam("id") String maPB) {
		Depart depart = new Depart();
		depart.setId(maPB);
		if (!departService.deleteDepart(depart)) {
			model.addAttribute("message","deleteFalse");
		
		}else {
			model.addAttribute("message","deleteTrue");
		}
		return "redirect:/admin/departs/home.htm";
	}
	
	@RequestMapping(params = "insert", method = RequestMethod.POST)
	public String insert(ModelMap model, @ModelAttribute("Depart") Depart d) {				
	
		if (departService.insertDepart(d)) {
			model.addAttribute("message", "insertTrue");
		}
		else {
			model.addAttribute("message", "insertFalse");
		}	
		return "redirect:/admin/departs/home.htm";		
	}
	
	@RequestMapping(params = "update", method = RequestMethod.POST)
	public String update(ModelMap model, @ModelAttribute("Depart") Depart d) {
     
		if (departService.updateDepart(d)) {
			model.addAttribute("message", "updateTrue");
		}
		else {
			model.addAttribute("message", "updateFalse");
		}
		return "redirect:/admin/departs/home.htm";
	}
	
}
