package cn.cslg.NetCourse.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.cslg.NetCourse.hibernateSessionFactory.HibernateSessionFactory;
import cn.cslg.NetCourse.pojo.Institute;
import cn.cslg.NetCourse.pojo.Teacher;

public class TeacherDao {
	private static Session session = HibernateSessionFactory.getSession();
	private static Transaction tx = null;

	public void add(Teacher teacher) {

		try {
			tx = session.beginTransaction();
			session.save(teacher);
			tx.commit();
//			System.out.println(teacher);
//			System.out.println("添加教师成功！");
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		}

	}

	public void delete(Teacher teacher) {
		try {
			tx = session.beginTransaction();
			session.delete(teacher);
			tx.commit();
//			System.out.println(teacher);
//			System.out.println("删除教师成功！");
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		}

	}

	public void update(Teacher teacher) {
		try {
			tx = session.beginTransaction();
			session.update(teacher);
			tx.commit();
//			System.out.println(teacher);
//			System.out.println("修改教师成功！");
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		}

	}

	public Teacher search(String username) {
		Teacher teacher = (Teacher) session.get(Teacher.class, username);
//		System.out.println(teacher);
		return teacher;

	}
	
	public List<Teacher> search(Institute institute){
		String hql="from Teacher t where t.institute=:institute";
		List<Teacher> list=session.createQuery(hql).setParameter("institute", institute).list();
//		for(Teacher teacher:list){
//			System.out.println(teacher);
//		}
		return list;
	}

}
