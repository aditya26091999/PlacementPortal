package model;

public class Student {
	private Integer MSN;
	private String fname;
	private String lname;
	private String email;
	private String branch;
	private String college;
	private String Passwd;

	public Student(Integer mSN, String fname, String lname, String email, String branch, String college,
			String Passwd) {
		super();
		MSN = mSN;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.branch = branch;
		this.college = college;
		this.Passwd = Passwd;
	}

	public Student(Integer mSN, String fname, String lname, String email) {
		super();
		MSN = mSN;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
	}

	public Integer getMSN() {
		return MSN;
	}

	public void setMSN(Integer mSN) {
		MSN = mSN;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getPasswd() {
		return Passwd;
	}

	public void setPasswd(String Passwd) {
		this.Passwd = Passwd;
	}
}
