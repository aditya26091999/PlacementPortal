package model;

public class Drive {
	private Integer DID;
	private String Dname;
	private String Ddate;
	private String DXthMin;
	private String DXIIthMin;
	private String DBEMin;
	private String MaxLiveBack;
	private String MaxDeadBack;
	private String Branch;
	private String Ctc;
	public Drive(Integer dID, String dname, String ddate, String dXthMin, String dXIIthMin, String dBEMin,
			String maxLiveBack, String maxDeadBack, String branch, String ctc) {
		super();
		DID = dID;
		Dname = dname;
		Ddate = ddate;
		DXthMin = dXthMin;
		DXIIthMin = dXIIthMin;
		DBEMin = dBEMin;
		MaxLiveBack = maxLiveBack;
		MaxDeadBack = maxDeadBack;
		Branch = branch;
		Ctc = ctc;
	}
	
	public Drive(String dname, String ddate, String ctc) {
		Dname = dname;
		Ddate = ddate;
		Ctc = ctc;
	}
	public Integer getDID() {
		return DID;
	}
	public void setDID(Integer dID) {
		DID = dID;
	}
	public String getDname() {
		return Dname;
	}
	public void setDname(String dname) {
		Dname = dname;
	}
	public String getDdate() {
		return Ddate;
	}
	public void setDdate(String ddate) {
		Ddate = ddate;
	}
	public String getDXthMin() {
		return DXthMin;
	}
	public void setDXthMin(String dXthMin) {
		DXthMin = dXthMin;
	}
	public String getDXIIthMin() {
		return DXIIthMin;
	}
	public void setDXIIthMin(String dXIIthMin) {
		DXIIthMin = dXIIthMin;
	}
	public String getDBEMin() {
		return DBEMin;
	}
	public void setDBEMin(String dBEMin) {
		DBEMin = dBEMin;
	}
	public String getMaxLiveBack() {
		return MaxLiveBack;
	}
	public void setMaxLiveBack(String maxLiveBack) {
		MaxLiveBack = maxLiveBack;
	}
	public String getMaxDeadBack() {
		return MaxDeadBack;
	}
	public void setMaxDeadBack(String maxDeadBack) {
		MaxDeadBack = maxDeadBack;
	}
	public String getBranch() {
		return Branch;
	}
	public void setBranch(String branch) {
		Branch = branch;
	}
	public String getCtc() {
		return Ctc;
	}
	public void setCtc(String ctc) {
		Ctc = ctc;
	}
}
