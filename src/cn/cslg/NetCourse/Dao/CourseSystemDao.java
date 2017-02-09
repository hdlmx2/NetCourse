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
	 * 添加课程体系信息； 1、首先检查年级的设置是否符合要求； 2、检查该课程是否在制定的专业和年级添加过 ； 3、检查该课程是否在其他年级添加过；
	 */ public void add(CourseSystem courseSystem) {
		// 检查年级信息：
		if (courseSystem.getGrade() > 4 || courseSystem.getGrade() < 1) {
			System.out.println("年级不符合要求！");
			return;
		}
		// 检查该课程是否添加过
		List<Course> list = search(courseSystem.getMajor(), courseSystem.getGrade());
		boolean isExist = false;
		for (Course course : list) {

			if (course.getCourseId().equals(courseSystem.getCourse().getCourseId())) {
				isExist = true;
				System.out.println("该课程已经在该专业的课程体系中存在！");
				return;
			}

		}
		// 检查该课程是否在其他年级添加过
		Integer grade = search(courseSystem.getMajor(), courseSystem.getCourse()).getGrade();
		System.out.println(grade);

		if (grade != null) {
			System.out.println("该课程已经在其他年级添加过了！");
			return;
		}

		try {
			tx = session.beginTransaction();
			session.save(courseSystem);
			tx.commit();
//			System.out.println(courseSystem);
//			System.out.println("课程成功添加到该专业！");

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
//			System.out.println("该课程成功从该专业中删除！");

		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();

		}
	}

	// 修改课程系统信息
	public void update(CourseSystem courseSystem) {
		try {
			tx = session.beginTransaction();
			session.update(courseSystem);
			tx.commit();
//			System.out.println(courseSystem);
//			System.out.println("课程体系修改成功！");

		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();

		}

	}

	// 以年级和专业搜索该专业的制定年级课程
	public List<Course> search(Major major, Integer grade) {

		String hql = "from CourseSystem cs where cs.major=:major and cs.grade=:grade";
		Query query = session.createQuery(hql);
		query.setParameter("major", major);
		query.setParameter("grade", grade);
		List<CourseSystem> list = query.list();
		// 强list中的课程放入到courseLlist中
		List<Course> courseList = new ArrayList<Course>();
		for (int i = 0; i < list.size(); i++) {
			courseList.add(list.get(i).getCourse());
//			System.out.println(list.get(i));
		}
		return courseList;
	}

	/*
	 * 根据专业和课程查找该信息所在的年级
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
