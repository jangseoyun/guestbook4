package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestbookVo;

@Repository
public class GuestBookDao {
	
	@Autowired
	private SqlSession sqlsession;

	
	// ------------List-----------------------------
	public List<GuestbookVo> getList() {
		
		List<GuestbookVo> guestList = sqlsession.selectList("guestbook.list");
		System.out.println(guestList);
		
		return guestList;
	}
	
	
	// ------------insert-----------------------------

	public int guestbookInsert(GuestbookVo guestbookVo) {
		
		System.out.println("guestbookInsert 접근");
		return sqlsession.insert("guestbook.insert", guestbookVo);
	}

	// ------------delete-----------------------------

	public int guestbookDelete(int no, String password) {
		
		System.out.println("guestbookDelete 접근");
		
		GuestbookVo guestbookVo = new GuestbookVo(no,password);
		return sqlsession.delete("guestbook.delete", guestbookVo);
	}

}
