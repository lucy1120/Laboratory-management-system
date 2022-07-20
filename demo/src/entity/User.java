package entity;

public class User {
	private int uid;
	private String uname;
	private String upwd;
	private int uage;
	private String usex;
	private String ugrade;
	private String umajor;
	private String uclass;
	private String uclassroom;
	public User(int uid, String uname, String upwd, int uage, String usex, String ugrade, String uclass, String uclassroom) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upwd = upwd;
		this.uage = uage;
		this.usex = usex;
		this.ugrade = ugrade;
		this.uclass = uclass;
		this.uclassroom = uclassroom;
	}
	public User() {
		super();
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public int getUage() {
		return uage;
	}
	public void setUage(int uage) {
		this.uage = uage;
	}
	public String getUsex() {
		return usex;
	}
	public void setUsex(String usex) {
		this.usex = usex;
	}
	public String getUgrade() {
		return ugrade;
	}
	public void setUgrade(String ugrade) {
		this.ugrade = ugrade;
	}
	public String getUmajor() {
		return umajor;
	}
	public void setUmajor(String umajor) {
		this.umajor = umajor;
	}
	public String getUclass() {
		return uclass;
	}
	public void setUclass(String uclass) {
		this.uclass = uclass;
	}
	public String getUclassroom() {
		return uclassroom;
	}
	public void setUclassroom(String uclassroom) {
		this.uclassroom = uclassroom;
	}
	
	
	
}
