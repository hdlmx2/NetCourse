package cn.cslg.NetCourse.Action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;

import cn.cslg.NetCourse.Dao.CourseDao;
import cn.cslg.NetCourse.Dao.CourseSystemDao;
import cn.cslg.NetCourse.Dao.MajorDao;
import cn.cslg.NetCourse.Dao.QuestionDao;
import cn.cslg.NetCourse.Dao.VideoDao;
import cn.cslg.NetCourse.pojo.Course;
import cn.cslg.NetCourse.pojo.CourseSystem;
import cn.cslg.NetCourse.pojo.Major;
import cn.cslg.NetCourse.pojo.Question;
import cn.cslg.NetCourse.pojo.Video;

public class PlayAction implements RequestAware {
	private Map<String, Object> request;
	MajorDao majorDao = new MajorDao();
	CourseDao courseDao = new CourseDao();
	VideoDao videoDao = new VideoDao();
	CourseSystemDao courseSystemDao = new CourseSystemDao();
	CourseSystem courseSystem = new CourseSystem();
	QuestionDao questionDao = new QuestionDao();

	public String play() {

		HttpServletRequest httpRequest = ServletActionContext.getRequest();
		String courseid = httpRequest.getParameter("course");
		String videoid = httpRequest.getParameter("video");
		String majorid = null;
		majorid = httpRequest.getParameter("major");
		System.err.println("MajorId" + majorid);

		// 将请求参数中的courseid和videoid转换成整形
		Integer courseId = Integer.parseInt(courseid);
		Integer voideId = Integer.parseInt(videoid);
		Integer majorId = null;
		Major major = null;

		Course course = courseDao.search(courseId);
		// 当用户在老师的页面，查看其所授课程跳转过来时，请求参数是不带major的，此时转型会出现异常，要用if判断一下
		if (majorid == "") {
			 System.err.println(majorid);
			

		} else {
			majorId = Integer.parseInt(majorid);
			major = majorDao.search(majorId);
			courseSystem = courseSystemDao.search(major, course);
			request.put("major", major);

		}

		// 根据请求参数的courseid查找课程返回对象

		// 根据课程对象查找出该课程的所有视频
		List<Video> videos = videoDao.search(course);

		Video toPlay = null;
		/*
		 * 判断播放哪个视频 如果是从课程页面跳转过来的话，要播放的视频的id是1指向视频列表的第一个视频
		 * 如果是从播放页面跳转过来的话，是什么id就是什么视频；
		 */

		if (voideId == 1) {
			toPlay = videos.get(0);
		} else {
			toPlay = videoDao.search(voideId);

		}
		// 遍历正在播放的视频的所有提问
		List<Question> questions = questionDao.search(toPlay);

		request.put("course", course);
		request.put("videos", videos);
		request.put("toPlay", toPlay);
		request.put("questions", questions);

		return "success";
	}

	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;
	}

}
