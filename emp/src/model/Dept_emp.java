package model;

public class Dept_emp { //de
	//생성자 메서드(생략됨)
	public Dept_emp() {
		this.empNo = 0;
		this.deptNo = null;
		this.fromDate = null;
		this.toDate = null;
		this.departments = null;
		this.employees = null;
	}
	//컬럼값을 저장할 필드생성
	private int empNo;
	private String deptNo;
	private String fromDate;
	private String toDate;
	private Departments departments;
	private Employees employees;
	
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
	public void setDepartments(Departments departments) {
		this.departments = departments;
	}
	public Departments getDepartments() {
		return departments;
	}
	public Employees getEmployees() {
		return employees;
	}
	public void setEmployees(Employees employees) {
		this.employees = employees;
	}
	
	
	
	
	
	/*
	 * SELECT
	 * de.from_date, 
	 * de.to_date,
	 * de.dept_no,
	 * d.dept_name
	 * de.emp_no....
	 * e.first_name
	 * FROM dept_emp de Inner JOIN department d
	 * INNER JOIN employees
	 * ON de.dept_no = d.dept_no
	 * AND de.emp_no = e.emp_no
	 * WHERE de.emp_no =? AND de.dept_no =?
	 */
}
