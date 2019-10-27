package poly.dao;

import java.util.List;

import poly.model.Staff;


public interface StaffDao{
	
	List<Staff> findAll();
	
	List<Staff> findAllIndex(int firstResult, int maxResult, String name);
	
	List<Staff> findLikeName(String name);
	
	List<Staff> findTop10();
	
	
	Staff findById(int id);
	
	Integer maxId();
	
	boolean insertStaff(Staff staff);
	
	boolean updateStaff(Staff staff);
	
	boolean deleteStaff(Staff staff);
	
		
	
}
