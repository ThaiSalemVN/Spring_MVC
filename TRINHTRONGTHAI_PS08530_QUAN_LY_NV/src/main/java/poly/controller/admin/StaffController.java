package poly.controller.admin;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javassist.expr.NewArray;
import poly.model.Depart;
import poly.model.Record;
import poly.model.Staff;
import poly.service.DepartService;
import poly.service.Mailer;
import poly.service.RecordService;
import poly.service.StaffService;

@Controller
@RequestMapping("/admin/staffs")
public class StaffController {
	@Autowired
	StaffService staffService;
	
	@Autowired
	Mailer mailer;
	
	@RequestMapping("/index")
	public String removeSession(HttpSession session) {
			
		session.setAttribute("nameStaff", "");
		
		return "redirect:/admin/staffs/home.htm";
		
	}

	@RequestMapping("/home")
	public String home(ModelMap model, HttpSession session,
			@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "idStaff", defaultValue = "0") int idStaff
			 ,@RequestParam(value = "message", defaultValue = "") String mess) {
		
		String nameTK = (String) session.getAttribute("nameStaff");
		List<Staff> list = staffService.findAllPage(page, nameTK);
		int totalPage = (int) Math.ceil(staffService.findLikeName(nameTK).size() / 7.0);
	
		
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("startPage", page);
		model.addAttribute("Staffs", list);
		model.addAttribute("Staff", new Staff()); 
		if (idStaff==0) {
			model.addAttribute("Staff", new Staff()); 
		}
		else {
			model.addAttribute("Staff", staffService.findById(idStaff)); 
		}
		model.addAttribute("message", mess);
		return "admin/qlnhanvien";
	}

	@RequestMapping("/search")
	public String search(HttpSession session, @RequestParam("tenNV") String name) {
		session.setAttribute("nameStaff", name);
		return "redirect:/admin/staffs/home.htm";
	}

	@RequestMapping("/delete")
	public String delete(ModelMap model, @RequestParam("id") int id) {
		Staff staff = new Staff();
			staff.setId(id);
		if (!staffService.deleteStaff(staff)) {
			model.addAttribute("message", "deleteFalse");	
		}else {
			model.addAttribute("message", "deleteTrue");	
		}
		
		return "redirect:/admin/staffs/home.htm";
	}

	@RequestMapping(params = "insert")
	public String insert(ModelMap model, @ModelAttribute("Staff") Staff staff,
			@RequestParam("imageNew") MultipartFile photo) {
		
		if (!photo.isEmpty()) {
			if (!saveImage(photo)) {
				model.addAttribute("message", "Lưu hình không thành công");
				return "admin/error";
			}else {
				String nameImage = photo.getOriginalFilename();
				staff.setPhoto(nameImage);
			}	
		} 
	
		if (!staffService.insertStaff(staff)) {
			model.addAttribute("message", "insertFalse");
		}else {
			model.addAttribute("message", "insertTrue");
			model.addAttribute("idStaff", staffService.maxId());
		}
		return "redirect:/admin/staffs/home.htm";
	}

	@RequestMapping(params = "update")
	public String update(ModelMap model, @ModelAttribute("Staff") Staff staff,
			@RequestParam("imageNew") MultipartFile photo) {

		if (!photo.isEmpty()) {
			if (saveImage(photo)) {
				staff.setPhoto(photo.getOriginalFilename());
			} else {
				model.addAttribute("message", "Upload hình thất bại!!!.");
				return "admin/error";
			}
		}

		if (!staffService.updateStaff(staff)) {
			model.addAttribute("message", "updateFalse");
		}
		else {
			model.addAttribute("message", "updateTrue");
			model.addAttribute("idStaff", staff.getId());
		}
		
		return "redirect:/admin/staffs/home.htm";
	}

	

	@RequestMapping("/record/like")
	public String recordLike(ModelMap model,@RequestParam(value= "idStaffR", defaultValue = "0") int id,
							@RequestParam("reason") String reason) {
		
		  if (!insertRecord(id, reason, true)) {
			  model.addAttribute("message", "recordFalse");
		  }
		 else {
		   mailer.sendEmail("ABCGROUP", staffService.findById(id).getEmail()
						, "ĐÁNH GIÁ NHÂN VIÊN "
						, "Bạn đã được 1 điểm cộng vào thành tích cá nhân. Lý do: "+reason);
		}
	
		return "redirect:/admin/staffs/home.htm";
	}
	
	
	
	@RequestMapping("/record/dislike")
	public String recordDislike(ModelMap model,@RequestParam(value= "idStaffR", defaultValue = "0") int id,
							@RequestParam("reason") String reason) {
	
		  if (!insertRecord(id, reason, false)) {
			  model.addAttribute("message", "recordFalse");
		  }
		  else {
			  mailer.sendEmail("ABCGROUP", staffService.findById(id).getEmail()
						, "ĐÁNH GIÁ NHÂN VIÊN "
						, "Bạn đã bị trừ 1 điểm trong thành tích cá nhân. Lý do: "+reason);
		  }	  
		return "redirect:/admin/staffs/home.htm";
	}

	
	@Autowired
	DepartService departService;
	@ModelAttribute("Departs")
	public List<Depart> phongban() {
		return departService.findAll();
	}


	@Autowired
	ServletContext context;
	public boolean saveImage(MultipartFile photo) {
		try {
			String photoPath = context.getRealPath("/resources/images/" + photo.getOriginalFilename());
			photo.transferTo(new File(photoPath));
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	
	@Autowired
	RecordService recordService;
	public boolean insertRecord(int id, String reason, boolean type) {
		Staff staff = new Staff();
			staff.setId(id);
	    Record record = new Record();
			record.setReason(reason);
			record.setType(type);
			record.setDate(new Date());
			record.setStaff(staff);
		return recordService.insertRecord(record);
	}
}
