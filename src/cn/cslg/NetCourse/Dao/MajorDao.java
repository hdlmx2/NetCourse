package cn.cslg.NetCourse.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.cslg.NetCourse.hibernateSessionFactory.HibernateSessionFactory;
import cn.cslg.NetCourse.pojo.Institute;
import cn.cslg.NetCourse.pojo.Major;

public class MajorDao {
	private static Session session = HibernateSessionFactory.getSession();
	private static Transaction tx = null;

	public void add(Major major) {
		try {
			tx = session.beginTransaction();
			session.save(major);
			tx.commit();
//			System.out.println(major);
//			System.out.println("���רҵ��Ϣ�ɹ���");

		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		}
	}

	public void delete(Major major) {
		try {
			tx = session.beginTransaction();
			session.delete(major);
			tx.commit();
//			System.out.println(major);
//			System.out.println("ɾ��רҵ�ɹ���");

		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();

		}
	}

	public void update(Major major) {
		try {
			tx = session.beginTransaction();
			session.update(major);
			tx.commit();
//			System.out.println(major);
//			System.out.println("�޸�רҵ��Ϣ�ɹ���");

		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();

		}

	}

	public Major search(Integer majorid) {
		Major major = (Major) session.get(Major.class, majorid);
//		System.out.println(major);
		return major;
	}

	public List<Major> search(Institute institute) {
		String hql = "from Major m where m.institute=:institute";

		List<Major> list = session.createQuery(hql).setParameter("institue", institute).list();
//		for (Major major : list) {
//			System.out.println(major);
//		}

		return list;

	}

	public List<Major> search(String majorname) {
		String hql = "from Major m where m.majorName=:majorName";

		List<Major> list = session.createQuery(hql).setParameter("majorName", majorname).list();
//		for (Major major : list) {
//			System.out.println(major);
//		}

		return list;

	}

	public List<Major> getMajor(Institute institute) {
		String hql = "from Major c where c.institute=:institute";

		List<Major> list = session.createQuery(hql).setParameter("institute", institute).list();
//		for (Major major : list) {
//			System.out.println(major);
//		}

		return list;

	}

}
