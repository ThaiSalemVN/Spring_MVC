package poly.controller.admin;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import poly.service.ThongKeService;

@Controller
@RequestMapping("admin/statistic")
public class ThongKeController {
	@Autowired
	ThongKeService thongKeService;
	
	@RequestMapping("/depart")
	public String tKDepart(ModelMap model) {
	  List<Object[]> list = thongKeService.tKPhongBan();
		model.addAttribute("tkDeparts", list);	
		return "admin/tkdepart";
	}
	
	/* Phần thống kê thành tích nhân viên */

	@RequestMapping("/staff")
	public String Staff(HttpSession session) {
		session.setAttribute("nameStaff", "");
		return "redirect:/admin/statistic/staff/home.htm";
	}
	
	@RequestMapping("/staff/home")
	public String tkStaff(HttpSession session,ModelMap model
							, @RequestParam(value = "page", defaultValue = "1") int page) {
			
			String name = (String) session.getAttribute("nameStaff");
		
		List<Object[]> list = thongKeService.tKNhanvien(page, name);
		model.addAttribute("totalPage",Math.ceil(thongKeService.tKNhanvien(name).size()/7.0));
		model.addAttribute("startPage", page);
		model.addAttribute("tkStaff",list);
		return "admin/tkstaff";
	}
	
	@RequestMapping("/staff/search")
	public String searchtkStaff(HttpSession session, @RequestParam("nameStaff") String name) {
		
		session.setAttribute("nameStaff", name);
		return "redirect:/admin/statistic/staff/home.htm";
	}
	
	@RequestMapping("/staff/ct")
	public String xemCTNV(HttpSession session,@RequestParam("idStaff") String id) {	
		
		session.setAttribute("idNV", id);
		return "redirect:/admin/records/home.htm";
	}
}
