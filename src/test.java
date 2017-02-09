import java.util.List;

import cn.cslg.NetCourse.Dao.CourseDao;
import cn.cslg.NetCourse.Dao.CourseSystemDao;
import cn.cslg.NetCourse.Dao.HasLearnedDao;
import cn.cslg.NetCourse.Dao.InstituteDao;
import cn.cslg.NetCourse.Dao.MajorDao;
import cn.cslg.NetCourse.Dao.QuestionDao;
import cn.cslg.NetCourse.Dao.StudentDao;
import cn.cslg.NetCourse.Dao.TeacherDao;
import cn.cslg.NetCourse.Dao.VideoDao;
import cn.cslg.NetCourse.pojo.Course;
import cn.cslg.NetCourse.pojo.CourseSystem;
import cn.cslg.NetCourse.pojo.HasLearned;
import cn.cslg.NetCourse.pojo.Institute;
import cn.cslg.NetCourse.pojo.Major;
import cn.cslg.NetCourse.pojo.Question;
import cn.cslg.NetCourse.pojo.Student;
import cn.cslg.NetCourse.pojo.Teacher;
import cn.cslg.NetCourse.pojo.Video;

public class test {

	public static void main(String[] args) {
		// Dao��������
		InstituteDao instituteDao = new InstituteDao();
		TeacherDao teacherDao = new TeacherDao();
		MajorDao majorDao = new MajorDao();
		CourseDao courseDao = new CourseDao();
		VideoDao videoDao = new VideoDao();
		StudentDao studentDao = new StudentDao();
		HasLearnedDao hasLearnedDao = new HasLearnedDao();
		CourseSystemDao courseSystemDao = new CourseSystemDao();
		QuestionDao questionDao=new QuestionDao();

		// pojo��������
		Teacher teacher = new Teacher();
		Major major = new Major();
		Institute institute = new Institute();
		Course course = new Course();
		Video video = new Video();
		Student student = new Student();
//		HasLearned hasLearned = new HasLearned();
//		CourseSystem courseSystem = new CourseSystem();
//		Question question=new Question();

		// ������������
		// institute.setInstituteId(1);
		// institute.setInstituteName("����ѧԺ");
		//
		// teacher.setUsername("rw1003");
		// teacher.setPassword("1234566");
		// teacher.setInstitute(institute);
		//
		// major.setMajorId(2001);
		// major.setMajorName("��ʷѧ");
		// major.setInstitute(institute);
		// institute.getMajors().add(major);
		// instituteDao.add(institute);
		// major = majorDao.search(1001);

		//
		// course.setCourseId(100002);
		// course.setCourseName("Java�������");
		// course.setTeacher(teacher);
		//
		// major.setMajorId(1001);
		// major.setInstitute(institute);
		// major.setMajorName("�������ѧ�뼼��");
		//
		// institute.getMajors().add(major);
		// Video
		// Course course2 = courseDao.search(100001);
		// video.setVideoId(100004);
		// video.setVideoName("Hello world");
		// video.setCourse(course2);
		// course.getVideos().add(video);

		// student.setUsername("st1002");
		// student.setPassword("123456");
		// student.setMajor(major);
		//
		// hasLearned.setCourse(course);
		// hasLearned.setStudent(student);
		// Course course2 = courseDao.search(100002);
		// Major major2 = majorDao.search(1001);
		// courseSystem.setCourse(course2);
		// courseSystem.setGrade(2);
		// courseSystem.setMajor(major2);
		// course = courseDao.search(1025);
		// major = majorDao.search(101);
		// courseSystem.setCourse(course);
		// courseSystem.setMajor(major);
		// courseSystem.setGrade(4);
		// courseSystemDao.add(courseSystem);
		student=studentDao.search("ZB1014119");
//		teacher=teacherDao.search("se1001");
//		video=videoDao.search(1001001);
//		String context="��֪������˵ʲô";
		
//		question.setContext(context);
//		question.setStudent(student);
//		question.setTeacher(teacher);
//		question.setVideo(video);
		
//		questionDao.search(video);
		/*
		 * Dao������������
		 * 
		 */
		course=courseDao.search(1001);
		teacher=teacherDao.search("se1001");
		System.out.println(courseDao.search(teacher, 1001));
		
	}

}
