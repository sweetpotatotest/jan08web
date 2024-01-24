package com.kgb4232.dto;

import com.kgb4232.util.Util;

public class CommentDTO {
	private int cno, board_no, clike, mno;
	private String comment, mid, mname, cdate, ip;

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public int getBoard_no() {
		return board_no;
	}

	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}

	public int getClike() {
		return clike;
	}

	public void setClike(int clike) {
		this.clike = clike;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getCdate() {
		return cdate;
	}

	public void setCdate(String cdate) {
		this.cdate = cdate;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getIp() {
		return Util.ipMasking(ip);
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

}
