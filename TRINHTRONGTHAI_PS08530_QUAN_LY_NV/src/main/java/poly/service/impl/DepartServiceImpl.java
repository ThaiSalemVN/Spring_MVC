package poly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.dao.DepartDao;
import poly.model.Depart;
import poly.service.DepartService;

@Service
public class DepartServiceImpl implements DepartService {
	@Autowired
	DepartDao departDao;
	
	@Override
	public List<Depart> findAll() {
		
		return departDao.findAll();
	}
	
	@Override
	public List<Depart> findAllPage(int page,String name) {
		///maxResult là số item trên 1 page
		int maxResult = 5;
		int firstResult = (page -1) * maxResult;	
		return departDao.findAllIndex(firstResult,maxResult,name);
	}
	
	@Override
	public List<Depart> findLikeName(String name) {
		
		return departDao.findLikeName(name);
	}


	@Override
	public Depart findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteDepart(Depart depart) {
		
		return departDao.deleteDepart(depart);
	}

	@Override
	public Boolean insertDepart(Depart depart) {
		
		return departDao.insertDepart(depart);
	}

	@Override
	public Boolean updateDepart(Depart depart) {
		
		return departDao.updateDepart(depart);
	}




}
