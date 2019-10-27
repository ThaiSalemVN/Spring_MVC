package poly.dao;

import java.util.List;



public interface ThongKeDao {
	List<Object[]> tKPhongBan();
      
    List<Object[]> tKNhanVien(String name);
    
    List<Object[]> tKNhanVien(int firstResult, int maxResult, String name);
}
