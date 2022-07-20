package entity;

import java.util.Date;

public class Moneylog {
	private Date mtime;
	private int mnumber;
	private String mremarks;
	private String mtype;
	public Moneylog(Date mtime, int mnumber, String mremarks, String mtype) {
		super();
		this.mtime = mtime;
		this.mnumber = mnumber;
		this.mremarks = mremarks;
		this.mtype = mtype;
	}
	public Moneylog() {
		super();
	}
	public Date getMtime() {
		return mtime;
	}
	public void setMtime(Date mtime) {
		this.mtime = mtime;
	}
	public int getMnumber() {
		return mnumber;
	}
	public void setMnumber(int mnumber) {
		this.mnumber = mnumber;
	}
	public String getMremarks() {
		return mremarks;
	}
	public void setMremarks(String mremarks) {
		this.mremarks = mremarks;
	}
	public String getMtype() {
		return mtype;
	}
	public void setMtype(String mtype) {
		this.mtype = mtype;
	}
	
}
