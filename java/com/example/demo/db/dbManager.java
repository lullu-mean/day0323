package com.example.demo.db;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.BookVo;
import com.example.demo.vo.CartVo;
import com.example.demo.vo.GoodsVo;
import com.example.demo.vo.MemberVo;

public class dbManager {
	
	private static SqlSessionFactory factory;
	
	static {
		try {
			Reader reader = Resources.getResourceAsReader("com/example/demo/db/sqlConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public static List<GoodsVo> listAll(){
		SqlSession session = factory.openSession();
		List<GoodsVo> list = session.selectList("goods.selectAll");
		session.close();
		return list;
	}
	
	public static List<CartVo> selectAll(){
		SqlSession session = factory.openSession();
		List<CartVo> list = session.selectList("cart.selectAll");
		session.close();
		return list;
	}
	
	public static int insert(CartVo vo) {
		SqlSession session = factory.openSession();
		int re = session.insert("cart.insert",vo);
		session.commit();
		session.close();
		return re;
	}
	
	public static MemberVo isMember(MemberVo vo) {
		MemberVo re = null;
		SqlSession session = factory.openSession();
		re = session.selectOne("member.isMember",vo);
		session.close();
		return re;
	}
	
	public static List<BookVo> listBook(){
		SqlSession session = factory.openSession();
		List<BookVo> list = session.selectList("book.listBook");
		session.close();
		return list;
	}
	
}
