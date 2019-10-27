package poly.service;

import java.util.List;

import poly.model.Depart;

public interface DepartService {
	List<Depart> findAll();
	//page vị trí page chọn trong phân trang.
	List<Depart> findAllPage(int page,String name);
	List<Depart> findLikeName(String name);
	Depart findById(String id);
	Boolean deleteDepart(Depart depart);
	Boolean insertDepart(Depart depart);
	Boolean updateDepart(Depart depart);
	
	
}
