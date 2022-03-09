package com.diploma.admisssion.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.diploma.admisssion.model.Course;
import com.diploma.admisssion.repository.CourseDao;


@Service
public class CourseServiceimpl implements CourseService{
	
  // List<Course> list;
	@Autowired
	private CourseDao courseDao;
    public CourseServiceimpl() {
	 //  list=new ArrayList<>();
	 //list.add(new Course(145,"java parth","Maths"));
	 //list.add(new Course(146,"Economic","English"));
   }
	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		//return list;
		return courseDao.findAll();
	}
	@Override
	public Course getCourse(long courseId) {
		// TODO Auto-generated method stub
		//Course c=null;
		//for(Course course:list) {
		//	if(course.getId()==courseId) {
		//		c=course;
		//		break;
		//	}
		//}
		return courseDao.getOne(courseId);
	}
	@Override
	public Course addCourse(Course course) {
		
		//list.add(course);
		courseDao.save(course);
		return course;
		
	}
	@Override
	public Course updateCourse(Course course) {
		// TODO Auto-generated method stub
		//list.forEach(e ->{
		//	if(e.getId() ==course.getId()){
		//		e.setTitle(course.getTitle());
		//		e.setDescription(course.getDescription());
		//	}
		//});
		courseDao.save(course);
		return course;
	}
	@Override
	public void deleteCourse(long parseLong) {
		//	list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
		Course entity=courseDao.getOne(parseLong);
		courseDao.delete(entity);
	}

}
