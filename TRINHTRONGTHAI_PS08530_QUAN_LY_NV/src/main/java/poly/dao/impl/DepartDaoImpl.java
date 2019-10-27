package poly.dao.impl;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import poly.dao.DepartDao;
import poly.model.Depart;

@Repository
public class DepartDaoImpl extends HibernateHelper implements DepartDao {
	
	@Override
	@Transactional
	public List<Depart> findAll() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM Depart";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Depart> list = query.list();
		return list;
	}

	@Override
	@Transactional
	public List<Depart> findAllIndex(int firstResult, int maxResult, String name) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM Depart Where name like :tenPB";
		Query query = session.createQuery(hql);
			query.setParameter("tenPB", "%" + name +"%");			
			query.setFirstResult(firstResult);
			query.setMaxResults(maxResult);
		@SuppressWarnings("unchecked")
		List<Depart> list = query.list();
		return list;
		
	}
	
	@Override
	@Transactional
	public List<Depart> findLikeName(String name) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM Depart Where name like :tenPB";
		Query query = session.createQuery(hql);
		query.setParameter("tenPB", "%" + name +"%");
		@SuppressWarnings("unchecked")
		List<Depart> list = query.list();
		return list;
	}
	
	@Override
	@Transactional
	public Depart findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteDepart(Depart depart) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.delete(depart);
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
	public Boolean insertDepart(Depart depart) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(depart);
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
	public Boolean updateDepart(Depart depart) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(depart);
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

//	@Override
//	public List<Depart> findAll(int firstResult, int maxResult) {
//		Session session = sessionFactory.getCurrentSession();
//		String hql = "FROM Depart";
//		Query query = session.createQuery(hql);
//		query.setFirstResult(firstResult);
//		query.setMaxResults(maxResult);
//		@SuppressWarnings("unchecked")
//		List<Depart> list = query.list();
//		return list;
//		
//	}




	
}
