package com.sds.icto.mysite.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.sds.icto.mysite.domain.MemberVo;

@Repository
public class MemberDao {

	@Autowired
	SqlMapClientTemplate sqlMapClientTemplate;
	
	public void insert(MemberVo vo) {

		sqlMapClientTemplate.insert("member.insert",vo);
	}

	public MemberVo getMember(MemberVo vo) {
		MemberVo vo2 = null;
		
		vo2 = (MemberVo) sqlMapClientTemplate.queryForObject("member.getMember",vo);
		return vo2;
	}
	
	public void changeMember(MemberVo vo) {
		sqlMapClientTemplate.update("member.change",vo);
		
	}
	

}
