package cn.cslg.NetCourse.Action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;


import cn.cslg.NetCourse.Dao.CourseDao;
import cn.cslg.NetCourse.Dao.CourseSystemDao;
import cn.cslg.NetCourse.Dao.HasLearnedDao;
import cn.cslg.NetCourse.Dao.MajorDao;
import cn.cslg.NetCourse.pojo.Course;
import cn.cslg.NetCourse.pojo.CourseSystem;
import cn.cslg.NetCourse.pojo.Major;
import cn.cslg.NetCourse.pojo.Student;

public class MajorAction implements RequestAware {
	private Map<String, Object> request;
	CourseDao courseDao = new CourseDao();
	MajorDao majorDao = new MajorDao();
	Major major = new Major();
	Student student=new Student();
	CourseSystem courseSystem = new CourseSystem();
	CourseSystemDao courseSystemDao = new CourseSystemDao();
	HasLearnedDao hasLearnedDao=new HasLearnedDao();
//查看课程系统方法
	public String list() {
		HttpServletRequest httpRequest = ServletActionContext.getRequest();
		String id = httpRequest.getParameter("id");
		Integer majorid = Integer.parseInt(id);
		System.out.println(majorid);
		// 根据专业id搜索出整个专业的信息，封装成对象
		major = majorDao.search(majorid);
		List<Course> grade1 = courseSystemDao.search(major, 1);
		List<Course> grade2 = courseSystemDao.search(major, 2);
		List<Course> grade3 = courseSystemDao.search(major, 3);
		List<Course> grade4 = courseSystemDao.search(major, 4);
		request.put("grade1", grade1);
		request.put("grade2", grade2);
		request.put("grade3", grade3);
		request.put("grade4", grade4);
		request.put("major", major);

		return "success";
	}



	@Override
	public void setRequest(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;

	}

}
