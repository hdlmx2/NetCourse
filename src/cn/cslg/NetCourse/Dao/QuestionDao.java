package cn.cslg.NetCourse.Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.cslg.NetCourse.hibernateSessionFactory.HibernateSessionFactory;
import cn.cslg.NetCourse.pojo.Question;
import cn.cslg.NetCourse.pojo.Student;
import cn.cslg.NetCourse.pojo.Teacher;
import cn.cslg.NetCourse.pojo.Video;

public class QuestionDao {
	private static Session session = HibernateSessionFactory.getSession();
	private static Transaction tx = null;

	// 添加提问
	public void add(Question question) {
		try {
			tx = session.beginTransaction();
			session.save(question);
			tx.commit();
			// System.out.println(question);
			// System.out.println("添加问题成功！");

		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		}

	}

	// 删除提问
	public void delete(Question question) {
		try {
			tx = session.beginTransaction();
			session.delete(question);
			tx.commit();
			// System.out.println(question);
			// System.out.println("删除问题成功!");

		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		}

	}

	// 修改提问
	public void update(Question question) {
		try {
			tx = session.beginTransaction();
			session.update(question);
			tx.commit();
			// System.out.println(question);
			// System.out.println("修改过问题成功!");

		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		}
	}
	// 以ID查询问题信息

	public Question search(Integer integer) {

		Question question = (Question) session.get(Question.class, integer);
		// System.out.println(question);
		return question;

	}

	// 查找与该教师相关的提问
	public List<Question> search(Teacher teacher) {
		String hql = "from Question q where q.teacher=:teacher";
		List<Question> list = session.createQuery(hql).setParameter("teacher", teacher).list();
		// for (Question question : list) {
		// System.out.println(question);
		// }
		return list;

	}

	// 查找该老师关于该视频的问题
	public List<Question> search(Teacher teacher, Video video) {
		String hql = "from Question q where q.teacher=:teacher and q.video=:video";
		Query query = session.createQuery(hql);
		query.setParameter("teacher", teacher);
		query.setParameter("video", video);
		List<Question> list = query.list();
		// for (Question question : list) {
		// System.out.println(question);
		// }
		return list;

	}

	// 查找该学生所有的提问
	public List<Question> search(Student student) {

		String hql = "from Question q where q.student=:student";
		List<Question> list = session.createQuery(hql).list();
		// for (Question question : list) {
		// System.out.println(question);
		// }
		return list;

	}

	// 查找该学生关于该视频的所有提问
	public List<Question> search(Student student, Video video) {
		String hql = "from Question q where q.student=:student and q.video=:video";
		Query query = session.createQuery(hql);
		query.setParameter("student", student);
		query.setParameter("video", video);
		List<Question> list = query.list();
		// for (Question question : list) {
		// System.out.println(question);
		// }
		return list;

	}

	public List<Question> search(Video video) {
		String hql = "from Question q where q.video=:video";
		Query query = session.createQuery(hql);
		query.setParameter("video", video);
		List<Question> list = query.list();
		for (Question question : list) {
			System.out.println(question);
		}
		return list;

	}

}