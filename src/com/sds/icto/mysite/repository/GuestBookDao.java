package com.sds.icto.mysite.repository;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.sds.icto.mysite.domain.GuestBookVo;

@Repository
public class GuestBookDao {

	@Autowired
	SqlMapClientTemplate sqlMapClientTemplate;
	
	public void guestBookInsert(GuestBookVo vo) throws ClassNotFoundException,
			SQLException {
		sqlMapClientTemplate.insert("guestbook.insert",vo);
	}

	@SuppressWarnings("unchecked")
	public List<GuestBookVo> fetch() throws SQLException {
		
		List<GuestBookVo> list = null;
		list = sqlMapClientTemplate.queryForList("guestbook.list");
		return list;
	}
	
	
	public void guestBookDelete(String no, String password)
			throws ClassNotFoundException, SQLException {
		Map map = new HashMap();
		
		map.put("no", no);
		map.put("password", password);
		
		sqlMapClientTemplate.delete("guestbook.delete",map);
	}
}
