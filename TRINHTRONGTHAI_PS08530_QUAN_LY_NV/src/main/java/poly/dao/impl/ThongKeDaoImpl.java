package poly.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import poly.dao.StaffDao;
import poly.dao.ThongKeDao;

@Repository
@Transactional
public class ThongKeDaoImpl extends HibernateHelper implements ThongKeDao {
@Autowired
StaffDao staffDao;

	@Override
	public List<Object[]> tKPhongBan() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "Exec sp_ttphongban";
		Query query = session.createSQLQuery(hql);

		@SuppressWarnings("unchecked")
		List<Object[]> list = query.list();
		return list;
	}

	
	
	
	
	@Override
	public List<Object[]> tKNhanVien(String name) {
		Session session = sessionFactory.getCurrentSession();
		int maxResult = staffDao.findAll().size();
		String hql = "EXEC sp_ttnhanvien @Name=N'"+ name+ "' ,@Ofset = 0, @Fetch ="+maxResult;			 
		  Query query = session.createSQLQuery(hql);	  
		  @SuppressWarnings("unchecked") 
		  List<Object[]> list = query.list();	 
		 return list;
	}

	@Override
	public List<Object[]> tKNhanVien(int firstResult, int maxResult, String name) {
		  Session session = sessionFactory.getCurrentSession(); 	
		  String hql = "EXEC sp_ttnhanvien @Name=N'"+ name+ "' ,@Ofset ="
		  +firstResult+", @Fetch ="+maxResult;	
		  Query query = session.createSQLQuery(hql);	  
		  @SuppressWarnings("unchecked") 
		  List<Object[]> list = query.list(); 
		return list;
	}

}
