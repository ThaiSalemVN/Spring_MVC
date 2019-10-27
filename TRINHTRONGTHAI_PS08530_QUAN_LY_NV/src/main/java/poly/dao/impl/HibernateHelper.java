package poly.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

//@Transactional
public class HibernateHelper {
	@Autowired
	SessionFactory sessionFactory;
	
//	public List<Object[]> getCurent(String hql){
//		Session session = sessionFactory.getCurrentSession();
//		Query query = session.createQuery(hql);
//		@SuppressWarnings("unchecked")
//		List<Object[]> list = query.list();
//		return list;
//		
//	}
	
}
