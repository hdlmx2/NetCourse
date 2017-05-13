package cn.cslg.NetCourse.Action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;

import cn.cslg.NetCourse.Dao.CourseDao;
import cn.cslg.NetCourse.Dao.TeacherDao;
import cn.cslg.NetCourse.pojo.Course;
import cn.cslg.NetCourse.pojo.Teacher;

public class TeacherAction implements RequestAware, SessionAware {
	private String username;
	private String password;
	private CourseDao courseDao = new CourseDao();
	private TeacherDao teacherDao = new TeacherDao();
	private Map<String, Object> request;
	private Map<String, Object> session;
	private String courseTitle;
	private String courseIntroduce;
	private String courseId;

	Teacher teacher = new Teacher();

	public String teacher() {
		HttpServletRequest httpRequest = ServletActionContext.getRequest();
		String username = httpRequest.getParameter("id");
		// 根据用户名查找教师
		Teacher teacher = teacherDao.search(username);
		// System.out.println(teacher);
		// 根据教师查找他所教的课程
		List<Course> courses = courseDao.search(teacher);

		request.put("teacher", teacher);
		request.put("courses", courses);
		return "success";

	}

	public String teacherLogin() {
		Teacher user = teacherDao.search(username);
		// System.err.println(username+password);
		if (user != null && password.equals(user.getPassword())) {
			teacher = user;
			// teacherCourse();
			session.put("teacher", teacher);

			return "success";
		} else {
			return "fail";
		}

	}

	public String teacherCourse() {
		Map<String, Object> getCurrentSession = ActionContext.getContext().getSession();
		Teacher user = (Teacher) getCurrentSession.get("teacher");
		List<Course> courses = courseDao.search(user);
		request.put("teacherCourse", courses);
		request.put("test", "test");

		System.err.println(request.get("teacherCourse"));
		return "success";

	}

	public String courseDetail() {
		HttpServletRequest httpRequest = ServletActionContext.getRequest();
		Map<String, Object> getCurrentSession = ActionContext.getContext().getSession();
		// 获取请求courseId参数
		String course = httpRequest.getParameter("course");
		// 获取当前session中的用户，以防止访问其他老师的课程
		Teacher currentTeacher = (Teacher) getCurrentSession.get("teacher");
		if (currentTeacher == null) {
			return "fail";

		} else {
			Integer courseId = Integer.parseInt(course);
			List<Course> list = courseDao.search(currentTeacher, courseId);
			if (list.size() == 0) {
				return "fail";
			} else {
				request.put("thisCourse", list.get(0));
				return "success";
			}

		}

	}

	public String modifyCourse() {

		HttpServletRequest httpRequest = ServletActionContext.getRequest();
		Map<String, Object> getCurrentSession = ActionContext.getContext().getSession();
		// 获取请求courseId参数
		String course = httpRequest.getParameter("course");
		// 获取当前session中的用户，以防止访问其他老师的课程
		Teacher currentTeacher = (Teacher) getCurrentSession.get("teacher");
		if (currentTeacher == null) {
			return "fail";

		} else {
			Integer courseId = Integer.parseInt(course);
			List<Course> list = courseDao.search(currentTeacher, courseId);
			if (list.size() == 0) {
				return "fail";
			} else {
				request.put("thisCourse", list.get(0));
				return "success";
			}

		}
	}

	public String saveCourse() {
		System.err.println(courseIntroduce);

		Map<String, Object> getCurrentSession = ActionContext.getContext().getSession();
		Teacher teacher = (Teacher) getCurrentSession.get("teacher");
		if (teacher == null) {
			return "fail";
		} else {
			Integer courseId = Integer.parseInt(this.courseId);
			Course newCourse = courseDao.search(courseId);
			newCourse.setCourseTitle(courseTitle);
			newCourse.setCourseIntroduce(courseIntroduce);
			courseDao.update(newCourse);
			request.put("thisCourse", newCourse);
			return "success";
		}
	}

	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;
		// this.teacherRequest = arg0;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public String getCourseIntroduce() {
		return courseIntroduce;
	}

	public void setCourseIntroduce(String courseIntroduce) {
		this.courseIntroduce = courseIntroduce;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

}