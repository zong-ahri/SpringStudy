package com.spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mvc.dao.BorderDAO;
import com.spring.mvc.model.BorderListModel;
import com.spring.mvc.service.border.BorderListSet;

@Controller
public class BorderController {

	@Autowired
	BorderListSet borderListSet;
	
	@RequestMapping(value = "/border", method = RequestMethod.GET)
	public ModelAndView borderIndex() {
		ModelAndView view = new ModelAndView("/border/border");
		BorderListModel model = new BorderListModel();
		model.setPage(1);
		model.setBorderList(borderListSet.getBorderList(model.getPage()));
		model.setTotalPage(borderListSet.getTotalPage());
		model.setPageStart(borderListSet.getPageStart(model.getPage()));
		model.setPageEnd(borderListSet.getPageEnd(model.getPage()));
		view.addObject("borderModel", model);
		return view;
	}
	
	@RequestMapping(value = "/borderp", method = RequestMethod.GET)
	public ModelAndView borderIndex2(@RequestParam("page")String page) {
		ModelAndView view = new ModelAndView("/border/border");
		BorderListModel model = new BorderListModel();
		model.setPage(Integer.parseInt(page));
		model.setBorderList(borderListSet.getBorderList(model.getPage()));
		model.setTotalPage(borderListSet.getTotalPage());
		model.setPageStart(borderListSet.getPageStart(model.getPage()));
		model.setPageEnd(borderListSet.getPageEnd(model.getPage()));
		view.addObject("borderModel", model);
		return view;
	}
}
