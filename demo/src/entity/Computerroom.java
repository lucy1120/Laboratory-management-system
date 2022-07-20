package entity;

public class Computerroom {
	private String crname;
	private String craddress;
	private String crtype;

	public Computerroom() {
		super();
	}
	
	public Computerroom(String crname, String craddress, String crtype) {
		super();
		this.crname = crname;
		this.craddress = craddress;
		this.crtype = crtype;
	}
	
	public String getCrname() {
		return crname;
	}
	public void setCrname(String crname) {
		this.crname = crname;
	}
	public String getCraddress() {
		return craddress;
	}
	public void setCraddress(String craddress) {
		this.craddress = craddress;
	}
	public String getCrtype() {
		return crtype;
	}
	public void setCrtype(String crtype) {
		this.crtype = crtype;
	}
	
}
