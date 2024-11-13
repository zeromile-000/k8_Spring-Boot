package com.rubypaper.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class BoardVO {
	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date cteateDate = new Date();
	private int cnt;
	


	
//	// Getter/Setter 
//	public int getSeq() {
//		return seq;
//	}
//	public void setSeq(int seq) {
//		this.seq = seq;
//	}
//	public String getTitle() {
//		return title;
//	}
//	public void setTitle(String title) {
//		this.title = title;
//	}
//	public String getWriter() {
//		return writer;
//	}
//	public void setWriter(String writer) {
//		this.writer = writer;
//	}
//	public String getContent() {
//		return content;
//	}
//	public void setContent(String content) {
//		this.content = content;
//	}
//	public Date getCteateDate() {
//		return cteateDate;
//	}
//	public void setCteateDate(Date cteateDate) {
//		this.cteateDate = cteateDate;
//	}
//	public int getCnt() {
//		return cnt;
//	}
//	public void setCnt(int cnt) {
//		this.cnt = cnt;
//	}
	

}
