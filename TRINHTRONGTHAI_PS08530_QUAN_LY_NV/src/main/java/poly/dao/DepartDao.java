package poly.dao;

import java.util.List;

import poly.model.Depart;

public interface DepartDao {
	//lấy tất cả.
	List<Depart> findAll();
	
	//Tìm kiếm theo tên và lấytheo vị trí bắt đầu firstResult kết thúc  maxResult 
	List<Depart> findAllIndex(int firstResult, int maxResult,String name);
	
	//Tìm kiếm theo tên
	List<Depart> findLikeName(String name);
	
	Depart findById(String id);
	
	Boolean deleteDepart(Depart depart);
	
	Boolean insertDepart(Depart depart);
	
	Boolean updateDepart(Depart depart);
	
	
}
