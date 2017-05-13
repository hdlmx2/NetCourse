package cn.cslg.NetCourse.Action;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;

import cn.cslg.NetCourse.Dao.QuestionDao;
import cn.cslg.NetCourse.Dao.TeacherDao;
import cn.cslg.NetCourse.Dao.VideoDao;
import cn.cslg.NetCourse.pojo.Question;
import cn.cslg.NetCourse.pojo.Student;
import cn.cslg.NetCourse.pojo.Teacher;
import cn.cslg.NetCourse.pojo.Video;

public class QuestionAction implements RequestAware, SessionAware {
	private String context;
	private String videoId;
	private String teacherId;
	private Video video = new Video();
	private Teacher teacher = new Teacher();
	private Student student = new Student();
	private Question question = new Question();

	private VideoDao videoDao = new VideoDao();
	private TeacherDao teacherDao = new TeacherDao();
	private QuestionDao questionDao = new QuestionDao();

	private Map<String, Object> request;
	private Map<String, Object> session;

	public String addQuestion() {

		video = videoDao.search(Integer.parseInt(videoId));
		teacher = teacherDao.search(teacherId);
		// 获取当前session中的用户信息
		Map<String, Object> getCurrentSession = ActionContext.getContext().getSession();
		student = (Student) getCurrentSession.get("student");
		// 封装question
		question.setContext(context);
		question.setStudent(student);
		question.setVideo(video);
		question.setTeacher(teacher);

		questionDao.add(question);
		System.err.println(question);
		return "success";
	}

	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;

	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getVideoId() {
		return videoId;
	}

	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}

	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}

}