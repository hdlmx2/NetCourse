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

		// ����������е�courseid��videoidת��������
		Integer courseId = Integer.parseInt(courseid);
		Integer voideId = Integer.parseInt(videoid);
		Integer majorId = null;
		Major major = null;

		Course course = courseDao.search(courseId);
		// ���û�����ʦ��ҳ�棬�鿴�����ڿγ���ת����ʱ����������ǲ���major�ģ���ʱת�ͻ�����쳣��Ҫ��if�ж�һ��
		if (majorid == "") {
			 System.err.println(majorid);
			

		} else {
			majorId = Integer.parseInt(majorid);
			major = majorDao.search(majorId);
			courseSystem = courseSystemDao.search(major, course);
			request.put("major", major);

		}

		// �������������courseid���ҿγ̷��ض���

		// ���ݿγ̶�����ҳ��ÿγ̵�������Ƶ
		List<Video> videos = videoDao.search(course);

		Video toPlay = null;
		/*
		 * �жϲ����ĸ���Ƶ ����Ǵӿγ�ҳ����ת�����Ļ���Ҫ���ŵ���Ƶ��id��1ָ����Ƶ�б�ĵ�һ����Ƶ
		 * ����ǴӲ���ҳ����ת�����Ļ�����ʲôid����ʲô��Ƶ��
		 */

		if (voideId == 1) {
			toPlay = videos.get(0);
		} else {
			toPlay = videoDao.search(voideId);

		}
		// �������ڲ��ŵ���Ƶ����������
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
