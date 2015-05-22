package com.sds.icto.mysite.repository;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.sds.icto.mysite.domain.BoardVo;


@Repository
public class BoardDao {
	
	
	@Autowired
	SqlMapClientTemplate sqlMapClientTemplate;

	public void boardInsert(BoardVo vo) throws ClassNotFoundException,
			SQLException {
		sqlMapClientTemplate.insert("board.write",vo);
	}
	

	// 삭제
	public void boardDelete(Long no) throws SQLException {
		sqlMapClientTemplate.delete("board.delete",no);
	}

	// 수정
	public void boardChange(BoardVo vo) throws ClassNotFoundException,
			SQLException {
		sqlMapClientTemplate.update("board.change",vo);
	}

	public List<BoardVo> simFetch() throws ClassNotFoundException, SQLException {

		List<BoardVo> list = sqlMapClientTemplate.queryForList("board.list");
		return list;
	}
	
	public BoardVo deFetch(Long no, Long view_cnt) throws ClassNotFoundException, SQLException {
		Map map = new HashMap();
		map.put("no", no);
		map.put("view_cnt", view_cnt);
		
		BoardVo vo = (BoardVo) sqlMapClientTemplate.queryForObject("board.view",map);
		return vo;
	}
	
	public BoardVo deFetch(Long no) throws ClassNotFoundException, SQLException {
		Map map = new HashMap();
		map.put("no", no);
		
		BoardVo vo = (BoardVo) sqlMapClientTemplate.queryForObject("board.view",map);
		return vo;
	}
	
	
	public List<BoardVo> searchByTitle(String keyword) throws SQLException {

		System.out.println(keyword);
		List<BoardVo> list = sqlMapClientTemplate.queryForList("board.search",keyword);
		
		
		System.out.println("여기 사이즈 : " + list.size());
		return list;
	}
//	
//	public List<BoardVo> searchByMembername(String keyword) throws ClassNotFoundException, SQLException {
//
//		List<BoardVo> list = new ArrayList<BoardVo>();
//
//		Connection conn = getConnection();
//		PreparedStatement st =null;
//		ResultSet rs = null;
//
//		String sql = "select * from board where member_name like ?";
//		st = conn.prepareStatement(sql);
//		
//		st.setString(1, "%"+keyword+"%");
//		
//		rs = st.executeQuery();
//
//		while (rs.next()) {
//			Long num = rs.getLong("no");
//			String title = rs.getString("title");
//			String name = rs.getString("member_Name");
//
//			BoardVo vo = new BoardVo();
//			vo.setNo(num);
//			vo.setTitle(title);
//			vo.setMemberName(name);
//
//			list.add(vo);
//
//		}
//		if (st != null) {
//			st.close();
//		}
//		if (conn != null) {
//			conn.close();
//		}
//		if (rs != null) {
//			rs.close();
//		}
//
//		return list;
//	}
}
