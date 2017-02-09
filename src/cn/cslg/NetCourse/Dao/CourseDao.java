package cn.cslg.NetCourse.Dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.cslg.NetCourse.hibernateSessionFactory.HibernateSessionFactory;
import cn.cslg.NetCourse.pojo.Course;
import cn.cslg.NetCourse.pojo.Teacher;
import cn.cslg.NetCourse.pojo.Video;

public class CourseDao {
	private static Session session = HibernateSessionFactory.getSession();
	private static Transaction tx = null;

	// ��ӿγ�
	public void add(Course course) {

		try {
			tx = session.beginTransaction();
			session.save(course);
			tx.commit();
			System.out.println(course);
			System.out.println("�γ���ӳɹ���");

		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		}
	}

	// ɾ���γ�

	public void delete(Course course) {
		try {
			tx = session.beginTransaction();
			session.delete(course);
			tx.commit();
			// System.out.println(course);
			// System.out.println("�γ�ɾ���ɹ���");

		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		}

	}

	// �޸Ŀγ���Ϣ
	public void update(Course course) {
		try {
			tx = session.beginTransaction();
			session.update(course);
			tx.commit();
			// System.out.println(course);
			// System.out.println("�γ��޸ĳɹ���");

		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		}

	}

	// �Կγ�id���ҿγ���Ϣ
	public Course search(Integer id) {
		// tx = session.beginTransaction();
		Course course = (Course) session.get(Course.class, id);
		// System.out.println(course);
		return course;

	}

	// �Կγ��������γ���Ϣ
	public List<Course> search(String name) {
		String hql = "from Course c where c.courseName=:name";
		List<Course> list = session.createQuery(hql).setParameter("name", name).list();
		// for (Course course : list) {
		// System.out.println(course);
		// }
		return list;

	}

	public List<Course> searchCourses(String courseName) {
		String hql = "from Course c where c.courseName like:name";
//		List<Course> list = session.createQuery(hql).list();
		Query query=session.createQuery(hql);
		query.setParameter("name", "%"+courseName+"%");
		List<Course> list=query.list();
		 for (Course course : list) {
		 System.out.println(course);
		 }
		return list;

	}

	// ����ʦ�����γ���Ϣ
	public List<Course> search(Teacher teacher) {
		String hql = "from Course c Where c.teacher=:teacher";
		List<Course> list = session.createQuery(hql).setParameter("teacher", teacher).list();
		// for (Course course : list) {
		// System.out.println(course);
		// }
		return list;

	}
	public List<Course> search(Teacher teacher,Integer course) {
		String hql = "from Course c Where c.teacher=:teacher and c.courseId=:course";
		Query query=session.createQuery(hql);
		query.setParameter("teacher", teacher);
		query.setParameter("course", course);
		List<Course> list = query.list();
		// for (Course course : list) {
		// System.out.println(course);
		// }
		return list;

	}

	// �������ÿγ̵�������Ƶ
	public Set<Video> search(Course course) {
		Course course2 = (Course) session.get(Course.class, course.getCourseId());
		Set<Video> set = course2.getVideos();
		// for(Video video:set){
		// System.out.println(video);
		// }
		return set;

	}

}
