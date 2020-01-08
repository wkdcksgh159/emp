package model;

// employees 테이블 행1(튜플)을 저장할 수 있다
public class Employees {
	//생성자 메서드(생략됨)
	public Employees() {
		this.empNo = 0;
		this.birthDate = null;
		this.firstName = null;
		this.lastName = null;
		this.gender = null;
		this.hireDate = null;
		this.salaries = null;
		this.titles = null;
	}
	//컬럼값을 저장할 필드생성
	private int empNo;
	private String birthDate;
	private String firstName;
	private String lastName;
	private String gender;
	private String hireDate;
	private Salaries salaries;
	private Titles titles;
	
	
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getHireDate() {
		return hireDate;
	}
	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}
	public Salaries getSalaries() {
		return salaries;
	}
	public void setSalaries(Salaries salaries) {
		this.salaries = salaries;
	}
	public Titles getTitles() {
		return titles;
	}
	public void setTitles(Titles titles) {
		this.titles = titles;
	}
	
	
}
