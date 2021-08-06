package com.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mvc.model.Student;

@Controller
public class StudentController {
	
	@RequestMapping(value = "/student/index", method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/student/index"); //view
		mav.addObject("student", new Student()); //model
		return mav;
	}
	
	@RequestMapping(value = "/student/addStudent", method = RequestMethod.POST)
	public ModelAndView addStudent(@ModelAttribute Student student) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/student/addStudent"); //view
		mav.addObject("student", student); //model
		return mav;
	}
	
}
