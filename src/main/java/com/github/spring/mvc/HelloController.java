package com.github.spring.mvc;

import com.github.spring.utils.SystemProperties;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 吴海旭
 * Date: 2018-05-10
 * Time: 下午5:31
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

	@Autowired
	private SystemProperties systemProperties;
	@Autowired
	private HikariDataSource dataSource;

	@RequestMapping
	public ModelAndView hello(ModelAndView modelAndView) {
		modelAndView.setViewName("hello");
		modelAndView.getModel().put("uploadDir", systemProperties.getUploadDir());
		modelAndView.getModel().put("url", dataSource.getJdbcUrl());
		modelAndView.getModel().put("username", dataSource.getUsername());
		modelAndView.getModel().put("password", dataSource.getPassword());
		return modelAndView;
	}
}
