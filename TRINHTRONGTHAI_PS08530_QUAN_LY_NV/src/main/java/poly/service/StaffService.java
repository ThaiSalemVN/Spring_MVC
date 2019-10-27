package poly.service;

import java.util.List;

import poly.model.Staff;

public interface StaffService {
	
	
	List<Staff> findAll();
	
	List<Staff> findTop10();
	
	List<Staff> findAllPage(int page,String name);
	
	List<Staff> findLikeName(String name);
	
	Staff findById(int id);
	
	Integer maxId();
	
	boolean insertStaff(Staff staff);
	
	boolean updateStaff(Staff staff);
	
	boolean deleteStaff(Staff staff);
	
	
	
}
