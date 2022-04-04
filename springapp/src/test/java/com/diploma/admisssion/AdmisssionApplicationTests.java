package com.diploma.admisssion;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.diploma.admisssion.model.Courses;
import com.diploma.admisssion.model.User;
import com.diploma.admisssion.repository.CourseRepo;
import com.diploma.admisssion.repository.UserRepo;
import com.diploma.admisssion.service.CourseService;
import com.diploma.admisssion.service.UserService;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class AdmisssionApplicationTests {

	@Autowired
	private CourseService courseservice;
	@Autowired
	private UserService userservice;

	@MockBean
	private CourseRepo courserepo;
	@MockBean
	private UserRepo userrepo;



	@Test
	void getCoursesTest() {
		when(courserepo.findAll()).thenReturn(Stream.of(new Courses(1,"Java","java desc",1004, "RMK", "2022-25", "3 Years"), new Courses(2,"Python","python desc",1004, "RMK", "2022-25", "3 Years")).collect(Collectors.toList()));
		assertEquals(2, courseservice.getAllCourses().size());
	}

	@Test
	public void addCourseTest() {
		Courses course= new Courses(4,"React","React desc",1002, "IIT", "2022-25", "3 Years");
		when(courserepo.save(course)).thenReturn(course);
	}

	@Test
	public void saveUserTest() {
		User user = new User(3,"1","anirudh@gmail.com","Anirudh","9875698756","ani@1608","ani@1608");
		when(userrepo.save(user)).thenReturn(user);

	}

	@Test
     public void getAllUserTest()
	 {
		when(userrepo.findAll()).thenReturn(Stream.of(new User(2, "2","vikram@gmail.com","Vikram","8888898888","NVRoaGhoWWI=","NVRoaGhoWWI="), new User( 1,"1","lokesh@gmail.com", "Lokesh","8888899888", "dmlra2k=","dmlra2k="
		)).collect(Collectors.toList()));
		assertEquals(2, userservice.getAllUsers().size());
	 }

}
