package cn.cslg.NetCourse.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.cslg.NetCourse.hibernateSessionFactory.HibernateSessionFactory;
import cn.cslg.NetCourse.pojo.Course;
import cn.cslg.NetCourse.pojo.HasLearned;
import cn.cslg.NetCourse.pojo.Student;

public class HasLearnedDao {
	private static Session session = HibernateSessionFactory.getSession();
	private static Transaction tx = null;

	public void add(HasLearned hasLearned) {

		List<HasLearned> learned = list(hasLearned.getStudent());
		boolean isExist = false;
		for (HasLearned hasLearned1 : learned) {
			if (hasLearned.getCourse().getCourseId().equals(hasLearned1.getCourse().getCourseId())) {
				isExist = true;
				System.out.println("课程已经存在！");
				return;

			}
		}

		if (isExist == false) {
			try {
				tx = session.beginTransaction();
				session.save(hasLearned);
				tx.commit();
				// System.out.println(hasLearned);
				// System.out.println("课程收藏成功！");

			} catch (Exception e) {
				e.printStackTrace();
				if (tx != null) {
					tx.rollback();
				}
			}
		}

	}

	public void delete(HasLearned hasLearned) {
		try {
			tx = session.beginTransaction();
			session.delete(hasLearned);
			tx.commit();

		} catch (Exception e) {

			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		}

	}

	public List<HasLearned> list(Student student) {
		String hql = "from HasLearned h where h.student=:student";
		List<HasLearned> list = session.createQuery(hql).setParameter("student", student).list();
		return list;
	}

	public List<Course> search(Student student) {
		String hql = "from HasLearned h where h.student=:student";
		List<HasLearned> list = session.createQuery(hql).setParameter("student", student).list();
		List<Course> courses = new ArrayList<>();
		for (HasLearned hasLearned : list) {
			courses.add(hasLearned.getCourse());
			System.out.println(hasLearned.getCourse());
		}

		return courses;

	}

	public boolean isAdd(Student student, Course course) {
		String hql = "from HasLearned h where h.student=:student and h.course=:course";
		Query query = session.createQuery(hql);
		query.setParameter("student", student);
		query.setParameter("course", course);
		if (query.list().size() == 0) {
			//没有添加
			return false;
		} else {
			//添加
			return true;
		}
	}

}