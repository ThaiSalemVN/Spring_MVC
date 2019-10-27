package poly.dao.impl;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import poly.dao.StaffDao;
import poly.model.Staff;

@Repository
public class StaffDaoImpl extends HibernateHelper implements StaffDao {

	@Override
	@Transactional
	public List<Staff> findAll() {
		 Session session = sessionFactory.getCurrentSession();
		 String hql = "FROM Staff";
		 Query query = session.createQuery(hql);		
		@SuppressWarnings("unchecked")
		List<Staff> list = query.list();	 		 
		return list;
	}

	@Override
	@Transactional
	public List<Staff> findTop10() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "exec sp_top10";
		Query query = session.createSQLQuery(hql).addEntity(Staff.class);
		@SuppressWarnings("unchecked")
		List<Staff> list = query.list(); 
		return list ;
	}
	
	
	@Override
	@Transactional
	public List<Staff> findAllIndex(int firstResult, int maxResult, String name) {
		Session session = sessionFactory.getCurrentSession();
		String hql= "FROM Staff WHERE name like :name";
		Query query = session.createQuery(hql);
		query.setParameter("name", "%" + name+ "%");
		query.setFirstResult(firstResult);
		query.setMaxResults(maxResult);
		@SuppressWarnings("unchecked")
		List<Staff> list = query.list();
		return list;
	}

	
	@Override
	@Transactional
	public List<Staff> findLikeName(String name) {
		Session session = sessionFactory.getCurrentSession();
		String hql= "FROM Staff WHERE name like :name";
		Query query = session.createQuery(hql);
		query.setParameter("name", "%" + name+ "%");
		@SuppressWarnings("unchecked")
		List<Staff> list = query.list();
		return list;
	}

	
	@Override
	@Transactional
	public Staff findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Staff staff = session.get(Staff.class,id);
		return staff;
	}

	
	@Override
	public boolean insertStaff(Staff staff) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(staff);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return false;
		}
		finally {
			session.close();
		}
		return true;
	}

	@Override
	public boolean updateStaff(Staff staff) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(staff);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return false;
		}
		finally {
			session.close();
		}
		return true;
	}

	@Override
	public boolean deleteStaff(Staff staff) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.delete(staff);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return false;
		}
		finally {
			session.close();
		}
		return true;
	}

	@Override
	@Transactional
	public Integer maxId() {
		Session session = sessionFactory.getCurrentSession();
		String hql ="Select Max(id) From Staff";
		Query query = session.createQuery(hql);
		Integer kq =  Integer.valueOf(query.uniqueResult()+"") ;	
		return kq;

	}






	
}
