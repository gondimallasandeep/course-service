package com.javatechie.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.dto.Course;
import com.javatechie.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {

	private CourseService courseService;

	public CourseController(CourseService courseService) {
		super();
		this.courseService = courseService;
	}
	
	// web service to on board a course
	@PostMapping
	public ResponseEntity<?> onBoardACourse(@RequestBody Course course) {
		Course newcourse = courseService.onBoardNewCourse(course);
		return new ResponseEntity<>(newcourse, HttpStatus.CREATED);
	}
	
	// web service to read all courses
	@GetMapping
	public ResponseEntity<?> viewAllCourses() {
		return new ResponseEntity<>(courseService.viewAllCourses(), HttpStatus.OK);
	}
	
	// web service read course by course id using path variable
	@GetMapping("/search/path/{courseId}")
	public ResponseEntity<?> getCourseById(@PathVariable Integer courseId){
		Course course = courseService.findCourseById(courseId);
		return new ResponseEntity<>(course, HttpStatus.OK);
	}
	
	// web service read course using query param
	@GetMapping("/search/request")
	public ResponseEntity<?> getCourseByIdUsingRequestParam(@RequestParam(required = false) Integer courseId){
		Course course = courseService.findCourseById(courseId);
		return new ResponseEntity<>(course, HttpStatus.OK);
	}
	
	// web service to update course
	@PutMapping("{courseId}")
	public ResponseEntity<?> updateCourse(@PathVariable Integer courseId, @RequestBody Course course) {
		return new ResponseEntity<>(courseService.updateCourse(courseId, course),HttpStatus.OK);
	}
	
	// web service to delete the course
	@DeleteMapping("/delete/{courseId}")
	public ResponseEntity<?> deleteCourse(@PathVariable int courseId) {
		courseService.removeCourse(courseId);
		return new ResponseEntity<>("", HttpStatus.NO_CONTENT);
	}
	
	// web service to get course count by course type
	@GetMapping("/courseCountByCourseType")
	public ResponseEntity<?> getCoursesCountByCourseType() {
		return new ResponseEntity<>(courseService.getCoursesCountByCourseType(), HttpStatus.OK);
	}
	
}
