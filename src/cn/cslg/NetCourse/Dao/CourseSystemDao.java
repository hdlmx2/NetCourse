package cn.cslg.NetCourse.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.cslg.NetCourse.hibernateSessionFactory.HibernateSessionFactory;
import cn.cslg.NetCourse.pojo.Course;
import cn.cslg.NetCourse.pojo.CourseSystem;
import cn.cslg.NetCourse.pojo.Major;

public class CourseSystemDao {
	private static Session session = HibernateSessionFactory.getSession();
	private static Transaction tx = null;

	/*
	 * ��ӿγ���ϵ��Ϣ�� 1�����ȼ���꼶�������Ƿ����Ҫ�� 2�����ÿγ��Ƿ����ƶ���רҵ���꼶��ӹ� �� 3�����ÿγ��Ƿ��������꼶��ӹ���
	 */ public void add(CourseSystem courseSystem) {
		// ����꼶��Ϣ��
		if (courseSystem.getGrade() > 4 || courseSystem.getGrade() < 1) {
			System.out.println("�꼶������Ҫ��");
			return;
		}
		// ���ÿγ��Ƿ���ӹ�
		List<Course> list = search(courseSystem.getMajor(), courseSystem.getGrade());
		boolean isExist = false;
		for (Course course : list) {

			if (course.getCourseId().equals(courseSystem.getCourse().getCourseId())) {
				isExist = true;
				System.out.println("�ÿγ��Ѿ��ڸ�רҵ�Ŀγ���ϵ�д��ڣ�");
				return;
			}

		}
		// ���ÿγ��Ƿ��������꼶��ӹ�
		Integer grade = search(courseSystem.getMajor(), courseSystem.getCourse()).getGrade();
		System.out.println(grade);

		if (grade != null) {
			System.out.println("�ÿγ��Ѿ��������꼶��ӹ��ˣ�");
			return;
		}

		try {
			tx = session.beginTransaction();
			session.save(courseSystem);
			tx.commit();
//			System.out.println(courseSystem);
//			System.out.println("�γ̳ɹ���ӵ���רҵ��");

		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		}
	}

	public void delete(CourseSystem courseSystem) {
		try {
			tx = session.beginTransaction();
			session.delete(courseSystem);
			tx.commit();
//			System.out.println(courseSystem);
//			System.out.println("�ÿγ̳ɹ��Ӹ�רҵ��ɾ����");

		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();

		}
	}

	// �޸Ŀγ�ϵͳ��Ϣ
	public void update(CourseSystem courseSystem) {
		try {
			tx = session.beginTransaction();
			session.update(courseSystem);
			tx.commit();
//			System.out.println(courseSystem);
//			System.out.println("�γ���ϵ�޸ĳɹ���");

		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();

		}

	}

	// ���꼶��רҵ������רҵ���ƶ��꼶�γ�
	public List<Course> search(Major major, Integer grade) {

		String hql = "from CourseSystem cs where cs.major=:major and cs.grade=:grade";
		Query query = session.createQuery(hql);
		query.setParameter("major", major);
		query.setParameter("grade", grade);
		List<CourseSystem> list = query.list();
		// ǿlist�еĿγ̷��뵽courseLlist��
		List<Course> courseList = new ArrayList<Course>();
		for (int i = 0; i < list.size(); i++) {
			courseList.add(list.get(i).getCourse());
//			System.out.println(list.get(i));
		}
		return courseList;
	}

	/*
	 * ����רҵ�Ϳγ̲��Ҹ���Ϣ���ڵ��꼶
	 * 
	 */
	// public Integer search(Major major, Course course) {
	//
	// String hql = "from CourseSystem cs where cs.major=:major and
	// cs.course=:course";
	// Query query = session.createQuery(hql);
	// query.setParameter("major", major);
	// query.setParameter("course", course);
	// List<CourseSystem> list = query.list();
	// Integer grade = null;
	// for (CourseSystem courseSystem : list) {
	// System.out.println(courseSystem);
	// grade = courseSystem.getGrade();
	// }
	// return grade;
	//
	// }

	public CourseSystem search(Major major, Course course) {
		String hql = "from CourseSystem cs where cs.major=:major and cs.course=:course";
		Query query = session.createQuery(hql);
		query.setParameter("major", major);
		query.setParameter("course", course);
		List<CourseSystem> list = query.list();
		CourseSystem courseSystem = new CourseSystem();
		if (list.size() == 0) {
			return courseSystem;
		} else {
			courseSystem = list.get(0);
			return courseSystem;
		}

	}

}
