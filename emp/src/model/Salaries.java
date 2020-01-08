package model;

public class Salaries {
	//생성자 메서드(생략됨)
	public Salaries() {
		this.empNo = 0;
		this.salary = 0;
		this.fromDate = null;
		this.toDate = null;
	}
	//컬럼값을 저장할 필드생성
	public int empNo;
	public int salary;
	public String fromDate;
	public String toDate;
	
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
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
