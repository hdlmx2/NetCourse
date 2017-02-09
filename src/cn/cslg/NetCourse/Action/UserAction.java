package cn.cslg.NetCourse.Action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;

import cn.cslg.NetCourse.Dao.CourseDao;
import cn.cslg.NetCourse.Dao.HasLearnedDao;
import cn.cslg.NetCourse.Dao.StudentDao;
import cn.cslg.NetCourse.pojo.Course;
import cn.cslg.NetCourse.pojo.HasLearned;
import cn.cslg.NetCourse.pojo.Student;

public class UserAction implements SessionAware, RequestAware {
	private Map<String, Object> session;
	private Map<String, Object> request;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String orginPassword;
	private String newPassword;
	private String confimPassword;
	private String email;
	StudentDao studentDao = new StudentDao();
	Student student = new Student();
	HasLearnedDao hasLearnedDao = new HasLearnedDao();
	CourseDao courseDao = new CourseDao();

	// �û���¼
	public String login() {
		// HttpServletRequest httpRequest = ServletActionContext.getRequest();

		Student user = studentDao.search(username);

		if (user != null && password.equals(user.getPassword())) {
			student = user;
			session.put("student", student);
			return "success";
		} else {
			return "fail";
		}

	}

	// ��¼�˳�
	public String exit() {
		// Map<String, Object> getCurrentSession =
		// ActionContext.getContext().getSession();
		// System.err.println("�����ǰsession��");
		// Student user = (Student) getCurrentSession.get("student");
		this.student = null;
		session.put("student", student);
		// System.err.println(user);

		return "success";
	}

	// �û�ע��
	public String reg() {
		Student user = studentDao.search(username);
		if (user == null) {
			student.setUsername(username);
			student.setPassword(password);
			student.setEmail(email);
			studentDao.add(student);
			return "success";
		}
		// System.out.println(username + password + email);
		else {
			return "fail";
		}
	}

	// ѧ���޸ĸ�����Ϣ
	public String modify() {
		Map<String, Object> getCurrentSession = ActionContext.getContext().getSession();
		Student user = (Student) getCurrentSession.get("student");
		// ��������ԭʼ������ȷ���޸���Ϣ�����Ұѵ�ǰsession�е�student��Ϊnull�����µ�¼�����򷵻ش���
		if (user.getPassword().equals(orginPassword)) {

			user.setEmail(email);
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setPassword(confimPassword);
			studentDao.update(user);
			session.put("student", null);
			return "success";

		} else {
			return "fail";
		}

	}

	// �ղؿγ�
	public String addCourse() {
		Map<String, Object> getCurrentSession = ActionContext.getContext().getSession();
		Student user = (Student) getCurrentSession.get("student");
		HttpServletRequest httpRequest = ServletActionContext.getRequest();
		String course = httpRequest.getParameter("course");
		Integer courseId = Integer.parseInt(course);
		if (user == null) {
			return "fail";
		} else {
			HasLearned hasLearned = new HasLearned();
			Course fromCourse = courseDao.search(courseId);
			hasLearned.setCourse(fromCourse);
			hasLearned.setStudent(user);
			hasLearnedDao.add(hasLearned);
			List<Course> courses=hasLearnedDao.search(user);
			request.put("mycourse", courses);
			request.put("myIndex", 0);
			return "success";

		}

	}

	/*
	 * ��ת����������ҳ�棬���������з���myindexָ������û��myClass,jpsҳ������ΰ����ĸ�ҳ��
	 * myindex==1��ʾ��������student_class.jspҳ�� myindex==2��ʾ��������student_dynamic.jspҳ��
	 * myindex==3��ʾ��������student_setting.jspҳ��
	 */
	public String myCourse() {
		Map<String, Object> getCurrentSession = ActionContext.getContext().getSession();
		System.err.println("�����ǰsession��");
		Student user = (Student) getCurrentSession.get("student");
		List<Course> haslearned = hasLearnedDao.search(user);
		request.put("mycourse", haslearned);
		request.put("myIndex", 0);
		return "success";

	}

	public String dynamic() {
		request.put("myIndex", 2);
		return "success";
	}

	public String setting() {
		request.put("myIndex", 3);
		return "success";
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}

	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getOrginPassword() {
		return orginPassword;
	}

	public void setOrginPassword(String orginPassword) {
		this.orginPassword = orginPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfimPassword() {
		return confimPassword;
	}

	public void setConfimPassword(String confimPassword) {
		this.confimPassword = confimPassword;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
