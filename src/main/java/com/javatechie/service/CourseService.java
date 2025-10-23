package com.javatechie.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.javatechie.dto.Course;
import com.javatechie.dto.CourseTypeAndCountDTO;

@Service
public class CourseService {

	List<Course> coursesList = new ArrayList<>();
	
	//on board a new course
	public Course onBoardNewCourse(Course course) {
		course.setCourseId(new Random().nextInt(3756));
		coursesList.add(course);
		return course;
	}
	
	// read all courses
	public List<Course> viewAllCourses() {
		return coursesList;
	}
	
	// find course by id
	public Course findCourseById(Integer id) {
      Course course	= coursesList.stream().filter(c -> (c.getCourseId() == id)).findFirst().orElse(null);
	  return course;
	}
	
	// delete the course
	public void removeCourse(int id) {
		Course course = findCourseById(id);
		coursesList.remove(course);
	}
	
	// update the existing course
	public Course updateCourse(int id, Course updatedcourse) {
		Course existingcourse = findCourseById(id);
		coursesList.set(coursesList.indexOf(existingcourse), updatedcourse);
		return updatedcourse;
	}
	
	// get courses count by course type
	public List<CourseTypeAndCountDTO>  getCoursesCountByCourseType() {
		Map<String, Long> map =   coursesList
						.stream()
						.map(c -> c.getCourseType())
						.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(map);
		return map.entrySet().stream().map(m -> new CourseTypeAndCountDTO(m.getKey(), m.getValue())).toList();
		
	}
	
}
