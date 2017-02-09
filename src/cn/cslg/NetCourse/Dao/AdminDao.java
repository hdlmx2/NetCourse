package cn.cslg.NetCourse.Dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.cslg.NetCourse.hibernateSessionFactory.HibernateSessionFactory;

public class AdminDao {
	private static Session session = HibernateSessionFactory.getSession();
	private static Transaction tx = null;
	
	

}
