package com.spring.mvc.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mvc.dao.BorderDAO;
import com.spring.mvc.model.BorderDtlModel;
import com.spring.mvc.model.BorderInsertModel;
import com.spring.mvc.model.BorderListModel;
import com.spring.mvc.model.beans.BorderBean;
import com.spring.mvc.service.border.BorderDtlService;
import com.spring.mvc.service.border.BorderInsertService;
import com.spring.mvc.service.border.BorderListSet;

@Controller
public class BorderController {

	@Autowired
	BorderListSet borderListSet;
	
	@Autowired
	BorderDtlService borderDtlService;
	
	@Autowired
	BorderInsertService borderInsertService;
	
	@Autowired
	BorderDAO borderDAO;
	
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
	
	@RequestMapping(value = "/borderinsert", method = RequestMethod.GET)
	public ModelAndView borderInsert() {
		ModelAndView view = new ModelAndView("/border/borderinsert");
		return view;
	}
	
	@RequestMapping(value = "/borderdatainsert", method = RequestMethod.POST)
	public ModelAndView borderDataInsert(BorderInsertModel borderInsertModel, HttpServletRequest request) throws IllegalStateException, IOException {
		ModelAndView view = new ModelAndView("/border/border");
		borderInsertModel.setUser_ip(request.getRemoteAddr());
//		String realPath = request.getServletPath().getRealPath("");
		borderInsertService.fileUpload(borderInsertModel);
		return view;
	}
	
	@RequestMapping(value = "/borderdtl", method = RequestMethod.GET)
	public ModelAndView borderDtl(@RequestParam("border_code")String border_code, @RequestParam("page")String page) {
		ModelAndView view = new ModelAndView("/border/borderdtl");
		BorderDtlModel model = borderDtlService.getBorderDtlModel(border_code);
		model.setPage(page);
		view.addObject("borderDtlModel", model);
		return view;
	}
	
}
