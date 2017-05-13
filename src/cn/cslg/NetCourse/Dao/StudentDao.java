package cn.cslg.NetCourse.Dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.cslg.NetCourse.hibernateSessionFactory.HibernateSessionFactory;
import cn.cslg.NetCourse.pojo.Student;

public class StudentDao {
	private static Session session = HibernateSessionFactory.getSession();
	private static Transaction tx = null;

	public void add(Student student) {
		try {
			tx = session.beginTransaction();
			session.save(student);
			tx.commit();
//			System.out.println(student);
//			System.out.println("添加学生信息成功！");

		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		}
	}

	public void delete(Student student) {
		try {
			tx = session.beginTransaction();
			session.delete(student);
			tx.commit();
//			System.out.println(student);
//			System.out.println("删除学生信息成功！");

		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		}
	}

	public void update(Student student) {
		try {
			tx = session.beginTransaction();
			session.update(student);
			tx.commit();
//			System.out.println(student);
//			System.out.println("修改学生信息成功！");

		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		}

	}

	public Student search(String username) {
		Student student = (Student) session.get(Student.class, username);
//		System.out.println(student);
		return student;
	}

}