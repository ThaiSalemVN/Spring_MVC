package poly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.dao.ThongKeDao;
import poly.service.ThongKeService;

@Service
public class ThongKeServiceImpl implements ThongKeService {
@Autowired
ThongKeDao thongKeDao;
	
	@Override
	public List<Object[]> tKPhongBan() {
		
		return thongKeDao.tKPhongBan();
	}

	@Override
	public List<Object[]> tKNhanvien(String name) {
		
		return thongKeDao.tKNhanVien(name);
	}

	@Override
	public List<Object[]> tKNhanvien(int page, String name) {		
		  int maxResult = 7; 
		  int firstResult = (page - 1)*maxResult;		 
		  return thongKeDao.tKNhanVien(firstResult, maxResult, name);		 
	
	}

}
