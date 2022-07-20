package entity;

public class Admin {
	private int aid;
	private String aname;
	private String apwd;
	private int aage;
	private String asex;
	private String agrade;
	private String amajor;
	private String aclass;
	public Admin() {
		super();
	}
	public Admin(int aid, String aname, String apwd, int aage, String asex, String agrade, String amajor, String aclass) {
		super();
		this.aid = aid;
		this.aname = aname;
		this.apwd = apwd;
		this.aage = aage;
		this.asex = asex;
		this.agrade = agrade;
		this.amajor = amajor;
		this.aclass = aclass;
	}
	public String getAsex() {
		return asex;
	}
	public void setAsex(String asex) {
		this.asex = asex;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getApwd() {
		return apwd;
	}
	public void setApwd(String apwd) {
		this.apwd = apwd;
	}
	public int getAage() {
		return aage;
	}
	public void setAage(int aage) {
		this.aage = aage;
	}
	public String getAgrade() {
		return agrade;
	}
	public void setAgrade(String agrade) {
		this.agrade = agrade;
	}
	public String getAmajor() {
		return amajor;
	}
	public void setAmajor(String amajor) {
		this.amajor = amajor;
	}
	public String getAclass() {
		return aclass;
	}
	public void setAclass(String aclass) {
		this.aclass = aclass;
	}
	
	
}
