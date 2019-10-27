package poly.controller.admin;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javassist.expr.NewArray;
import poly.model.Record;
import poly.model.Staff;
import poly.service.Mailer;
import poly.service.RecordService;
import poly.service.StaffService;

@Controller
@RequestMapping("/admin/records")
public class RecordController {
@Autowired
RecordService recordService;

@Autowired
StaffService staffService;

@Autowired 
Mailer mailer;

	@RequestMapping("/index")
	public String cleanSession(HttpSession session) {
		session.setAttribute("idNV", "");	
		session.setAttribute("NhanVien", new Staff());
		return "redirect:/admin/records/home.htm";
	}
	
	
	@RequestMapping("/home") 
	 public String home(HttpSession session,ModelMap model
 							   ,@RequestParam(value = "page", defaultValue = "1") int page
 							  ,@RequestParam(value = "message", defaultValue = "") String mess) {
			
		String idStaff= (String) session.getAttribute("idNV"); 
		int totalPage = (int) Math.ceil(recordService.findByStaffId(idStaff).size()/9.0);
		model.addAttribute("Records", recordService.findAllIndex(page, idStaff));
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("startPage", page);
		model.addAttribute("Record",new Record());
		model.addAttribute("message", mess);
		return "admin/qlthanhtich";
	}
	
	@RequestMapping("/search")
	public String search(HttpSession session,ModelMap model
				,@RequestParam("idStaff") String idNV) {
			
		if (idNV.equals("")) {	
			session.setAttribute("NhanVien", new Staff());		
		}
		else {
			 try {
				 int id = Integer.parseInt(idNV);	       
				 Staff staff =staffService.findById(id);		
				 session.setAttribute("NhanVien", staff );
			} catch (Exception e) {
				model.addAttribute("Records", null);
				model.addAttribute("totalPage", 0);
				model.addAttribute("startPage", 0);
				model.addAttribute("Record",new Record());
				return "admin/qlthanhtich";
			}
		}
			
		session.setAttribute("idNV", idNV);	
		return "redirect:/admin/records/home.htm";
	}
	
	@RequestMapping("/delete")
	public String delete(ModelMap model,@RequestParam("id") int id) {
		Record record = recordService.findById(id);
		if (!recordService.deleteRecord(record)) {
			model.addAttribute("message", "deleteFalse");	
		}
		else {
			Staff staff = staffService.findById(record.getStaff().getId());
			String body = "";
			if (record.getType()) {
				body="Bạn đã bị xóa 1 điểm cộng thành tích ";
			}
			else {
				body="Bạn đã được xóa 1 điểm phạt";
			}
			model.addAttribute("message", "deleteTrue");	
			mailer.sendEmail("ABCGROUP", staff.getEmail(), "Đánh giá nhân viên", body);
			
		}
		return "redirect:/admin/records/home.htm";
	}
	
	@RequestMapping(params = "update")
	public String update(ModelMap model,@ModelAttribute("Record") Record record) {
		if (!recordService.updateRecord(record)) {
			model.addAttribute("message", "updateFalse");
		}
		else {
			Staff staff = staffService.findById(record.getStaff().getId());
			String body = "";
			if (record.getType()) {
				body="Thành tích của bạn đã được cập nhật lại +1 điểm . Lý do: " +record.getReason();
			}
			else {
				body="Thành tích của bạn đã được cập nhật lại -1 điểm. Lý do: " +record.getReason();
			}
			model.addAttribute("message", "updateTrue");
			mailer.sendEmail("ABCGROUP", staff.getEmail(), "Đánh giá nhân viên", body);
			
		}
		return "redirect:/admin/records/home.htm";
	}
	
	
	@RequestMapping(params = "insert")
	public String insert(ModelMap model,@ModelAttribute("Record") Record record) {
		if (!recordService.insertRecord(record)) {
			model.addAttribute("message", "insertFalse");
		}
		else {
			Staff staff = staffService.findById(record.getStaff().getId());
			String body = "";
			if (record.getType()) {
				body="Bạn đã được 1 điểm cộng vào thành tích cá nhân. Lý do: " +record.getReason();
			}
			else {
				body="Bạn đã bị trừ 1 điểm trong thành tích cá nhân. Lý do: " +record.getReason();
			}
			
			model.addAttribute("message", "insertTrue");
			mailer.sendEmail("ABCGROUP", staff.getEmail(), "Đánh giá nhân viên", body);
		}
		return "redirect:/admin/records/home.htm";
	}
}
