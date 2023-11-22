package com.management.employeeManagement.DAO;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.management.employeeManagement.model.User;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

public class UserDAO extends HibernateDaoSupport {

		@Transactional(value="hibernate.em.transactionManager.user")
		public User getUserUsingUsername(String userName) {
			
			List<User> entries = getHibernateTemplate().execute(new HibernateCallback<List<User>>() {
				
				@SuppressWarnings("unchecked")
				public List<User> doInHibernate(Session hSession) throws HibernateException {
					Criteria criteria= hSession.createCriteria(User.class);
					criteria.add(Restrictions.eq("userName", userName));
					return criteria.list();
				}
			});
			
			return entries.get(0);
		}
}
