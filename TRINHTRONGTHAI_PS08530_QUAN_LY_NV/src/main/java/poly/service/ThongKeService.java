package poly.service;

import java.util.List;



public interface ThongKeService {
	List<Object[]> tKPhongBan();
	
	List<Object[]> tKNhanvien(String name);
	
	List<Object[]> tKNhanvien(int page,String name);
	
}
