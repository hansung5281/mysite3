package com.sds.icto.mysite.domain;

public class BoardVo {
	private String content;
	private String member_name;
	private Long member_no;
	private Long no;
	private String reg_date;
	private String title;
	private Long view_cnt;
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getView_cnt() {
		return view_cnt;
	}
	public void setView_cnt(Long view_cnt) {
		this.view_cnt = view_cnt;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public Long getMember_no() {
		return member_no;
	}
	public void setMember_no(Long member_no) {
		this.member_no = member_no;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	
	
	
}
