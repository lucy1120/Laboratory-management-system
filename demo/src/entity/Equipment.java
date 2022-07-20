package entity;

public class Equipment {
	private int eid;
	private String ename;
	private int emoney;
	private String ecomputerroom;
	private int enumber;
	public Equipment(String ename, int emoney, String ecomputerroom, int enumber) {
		super();
		this.ename = ename;
		this.emoney = emoney;
		this.ecomputerroom = ecomputerroom;
		this.enumber = enumber;
	}
	public Equipment() {
		super();
	}
	
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getEmoney() {
		return emoney;
	}
	public void setEmoney(int emoney) {
		this.emoney = emoney;
	}
	public String getEcomputerroom() {
		return ecomputerroom;
	}
	public void setEcomputerroom(String ecomputerroom) {
		this.ecomputerroom = ecomputerroom;
	}
	public int getEnumber() {
		return enumber;
	}
	public void setEnumber(int enumber) {
		this.enumber = enumber;
	}	
}
