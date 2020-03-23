package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.BookDao;
import com.example.demo.vo.BookVo;
import com.google.gson.Gson;

@RestController
public class BookController {

	@Autowired
	private BookDao dao;
	public void setDao(BookDao dao) {
		this.dao = dao;
	}

	@RequestMapping(value = "getBook",produces = "application/json;charset=UTF-8")
	public String listBook() {
		String str = "";
		List<BookVo> list = dao.listBook();
		Gson gson = new Gson();
		str = gson.toJson(list);
		return str;
	}
}
