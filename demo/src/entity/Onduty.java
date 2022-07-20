package entity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Onduty {
	private int oid;
	private String oname;
	private String oweekday;
	private Date obegintime;
	private Date oendtime;
	private String oroom;
		
	public Onduty() {
		super();
	}

	
	public Onduty(int oid, String oname, String oweekday, String oroom) {
		super();
		this.oid = oid;
		this.oname = oname;
		this.oweekday = oweekday;
		this.oroom = oroom;
	}


	public String getOname() {
		return oname;
	}


	public void setOname(String oname) {
		this.oname = oname;
	}


	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public String getOweekday() {
		return oweekday;
	}

	public void setOweekday(String oweekday) {
		this.oweekday = oweekday;
	}

	public Date getObegintime() {
		return obegintime;
	}

	public void setObegintime(String obegintime) {
		try {
			DateFormat sdf = new SimpleDateFormat("hh:mm:ss");
			Date time = sdf.parse(obegintime);
			this.obegintime = time;
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public Date getOendtime() {
		return oendtime;
	}

	public void setOendtime(String oendtime) {
		try {
			DateFormat sdf = new SimpleDateFormat("hh:mm:ss");
			Date time = sdf.parse(oendtime);
			this.oendtime = time;
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public String getOroom() {
		return oroom;
	}

	public void setOroom(String oroom) {
		this.oroom = oroom;
	}
}
