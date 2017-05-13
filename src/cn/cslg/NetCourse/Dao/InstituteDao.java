package cn.cslg.NetCourse.Dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.cslg.NetCourse.hibernateSessionFactory.HibernateSessionFactory;
import cn.cslg.NetCourse.pojo.Institute;
import cn.cslg.NetCourse.pojo.Major;

public class InstituteDao {
	private static Session session = HibernateSessionFactory.getSession();
	private static Transaction tx = null;

	public void add(Institute institute) {
		try {
			tx = session.beginTransaction();
			session.save(institute);
			tx.commit();
//			System.out.println(institute);
//			System.out.println("学院添加成功！");
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		}

	}

	public void delete(Institute institute) {
		try {
			tx = session.beginTransaction();
			session.delete(institute);
			tx.commit();
//			System.out.println(institute);
//			System.out.println("学院删除成功！");
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		}

	}

	public List<Institute> allInstitute() {
		String hql = "from Institute";
		List<Institute> list = session.createQuery(hql).list();
//		for (Institute institute : list) {
//			System.out.println(institute);
//		}
		return list;

	}

	public void update(Institute institute) {
		try {
			tx = session.beginTransaction();
			session.update(institute);
			tx.commit();
//			System.out.println(institute);
//			System.out.println("学院修改成功！");
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		}

	}

	public Institute search(Integer id) {
		Institute institute = (Institute) session.get(Institute.class, id);
//		System.out.println(institute);
		return institute;
	}

	public Set<Major> search(Institute institute) {
		Integer id = institute.getInstituteId();
		Institute institute2 = (Institute) session.get(Institute.class, id);
		Set<Major> majors = institute2.getMajors();
//		for (Major major : majors) {
//			System.out.println(major);
//		}
		return majors;

	}
}