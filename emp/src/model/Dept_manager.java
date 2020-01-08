package model;

public class Dept_manager {
	//생성자 메서드(생략됨)
		public Dept_manager() {
			this.empNo = 0;
			this.deptNo = null;
			this.fromDate = null;
			this.toDate = null;
		}
	//컬럼값을 저장할 변수 생성(필드)
	private int empNo;
	private String deptNo;
	private String fromDate;
	private String toDate;
	
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
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
