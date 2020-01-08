package model;

public class Departments {
	//생성자 메서드(생략됨)
	public Departments(){
		this.deptNo = null;
		this.deptName = null;
	}
	//db 컬럼값을 저장할 변수 생성(필드)
	private String deptNo;
	private String deptName;
	public String getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
}

