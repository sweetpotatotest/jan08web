package com.kgb4232.dto;

/*
 * Map을 쓰면 만들지 않아도 된다.
 */


public class IpDTO {
	private int ino;
	private String iip, idate, iurl, idata;
	public int getIno() {
		return ino;
	}
	public void setIno(int ino) {
		this.ino = ino;
	}
	public String getIip() {
		return iip;
	}
	public void setIip(String iip) {
		this.iip = iip;
	}
	public String getIdate() {
		return idate;
	}
	public void setIdate(String idate) {
		this.idate = idate;
	}
	public String getIurl() {
		return iurl;
	}
	public void setIurl(String iurl) {
		this.iurl = iurl;
	}
	public String getIdata() {
		return idata;
	}
	public void setIdata(String idata) {
		this.idata = idata;
	}
	
}
