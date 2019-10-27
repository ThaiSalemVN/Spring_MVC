package poly.dao.impl;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import poly.dao.RecordDao;
import poly.model.Record;
import poly.model.Staff;


@Repository
public class RecordDaoImpl extends HibernateHelper implements RecordDao {

	@Override
	@Transactional
	public List<Record> findAll() {
	    Session session = sessionFactory.getCurrentSession();
	    String hql = "FROM Record";
	    Query query = session.createQuery(hql);
	    @SuppressWarnings("unchecked")
		List<Record> list = query.list();
		return list;
	}

	@Override
	@Transactional
	public List<Record> findAllIndex(int firstResult, int maxResult, String idStaff) {
		if (idStaff.equals("")) {
		  Session session = sessionFactory.getCurrentSession();
		    String hql = "FROM Record";
		    Query query = session.createQuery(hql);
		    query.setFirstResult(firstResult);
		    query.setMaxResults(maxResult);
		    @SuppressWarnings("unchecked")
			List<Record> list = query.list();
			return list;
		}
		else {
			Session session = sessionFactory.getCurrentSession();
			String hql = "FROM Record where staffid=:idNV ";
			Query query = session.createQuery(hql);
			 query.setParameter("idNV", idStaff); 
			 query.setFirstResult(firstResult);
			 query.setMaxResults(maxResult);
			@SuppressWarnings("unchecked")
			List<Record> list = query.list();
			return list;
		}
	}
	
	@Override
	@Transactional
	public List<Record> findByStaffId(String staffid) {
		if (staffid.equals("")) {
			return findAll();
		}
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM Record where staffid=:idNV ";
		Query query = session.createQuery(hql);
		 query.setParameter("idNV", staffid); 
		@SuppressWarnings("unchecked")
		List<Record> list = query.list();
		return list;
	}

	@Override
	@Transactional
	public Record findById(int id) {
		Session session = sessionFactory.getCurrentSession();
	    Record record = session.get(Record.class,id);
		return record;
		
	}
	
	@Override
	public boolean deleteRecord(Record record) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.delete(record);
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
	public boolean insertRecord(Record record) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(record);
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
	public boolean updateRecord(Record record) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(record);
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

	

}
