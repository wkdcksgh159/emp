package model;

public class Titles {
	// 생성자 메서드(생략됨)
	public Titles() {
		this.empNo = 0;
		this.title = null;
		this.fromDate = null;
		this.toDate = null;
		}

	// 컬럼값을 저장할 필드생성
	private int empNo;
	private String title;
	private String fromDate;
	private String toDate;
	
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	
	
}
