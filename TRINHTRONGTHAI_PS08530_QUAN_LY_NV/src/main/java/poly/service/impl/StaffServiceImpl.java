package poly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.dao.StaffDao;
import poly.model.Staff;
import poly.service.StaffService;

@Service
public class StaffServiceImpl implements StaffService{
	
	@Autowired
	StaffDao staffDao;
	
	@Override
	public List<Staff> findAll() {
		return staffDao.findAll();
	}

	@Override
	public List<Staff> findTop10() {
		return staffDao.findTop10();
	}

	@Override
	public List<Staff> findAllPage(int page, String name) {		
		int maxResult = 7;
		int firstResult = (page - 1)*maxResult;
		return  staffDao.findAllIndex(firstResult, maxResult, name);
	}
	
	@Override
	public List<Staff> findLikeName(String name) {
		return staffDao.findLikeName(name);
	}

	
	
	@Override
	public Staff findById(int id) {
		
		return staffDao.findById(id);
	}

	@Override
	public boolean insertStaff(Staff staff) {
		
		return staffDao.insertStaff(staff);
	}

	@Override
	public boolean updateStaff(Staff staff) {
		
		return staffDao.updateStaff(staff);
	}

	@Override
	public boolean deleteStaff(Staff staff) {
		
		return staffDao.deleteStaff(staff);
	}

	@Override
	public Integer maxId() {
		
		return staffDao.maxId();
	}




}
