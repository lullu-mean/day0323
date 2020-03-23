package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.dbManager;
import com.example.demo.vo.BookVo;

@Repository
public class BookDao {

	public List<BookVo> listBook(){
		return dbManager.listBook();
	}
}
