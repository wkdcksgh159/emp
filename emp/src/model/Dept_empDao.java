package model;
import model.DBHelper;
import java.util.*;
import java.sql.*;
public class Dept_empDao {
	//리턴값 : Dept_emp 메소드명 : selectDept_empOne(매개변수타입 : int)
	public Dept_emp selectDept_empOne(String deptNo, int empNo) throws Exception { //예외 발생시 상위 메서드로 보냄
		//클래스 DBHelper의 값을 저장할 오브젝트 dbHelper 생성
		DBHelper dbHelper = new DBHelper();
		//연결정보 입력
		Connection conn = dbHelper.getConnection();
		//쿼리내용을 저장하기 위한 변수 sql 생성
		String sql = "select de.from_date, de.to_date, de.dept_no, d.dept_name, de.emp_no, e.first_name FROM dept_emp de INNER JOIN departments d INNER JOIN employees e ON de.dept_no = d.dept_no AND de.emp_no = e.emp_no WHERE de.dept_no=? AND de.emp_no=?";
		//쿼리를 저장하기 위한 변수 stmt 생성 후 쿼리내용을 저장한 변수 sql를 입력
		PreparedStatement stmt = conn.prepareStatement(sql);
		//쿼리내용수정 where문의 empNo의 값을 ?에 입력
		stmt.setString(1, deptNo);
		stmt.setInt(2, empNo);
		System.out.println("Dept_empDao : "+deptNo);
		System.out.println("Dept_empDao : "+empNo);
		//stmt에 저장된 쿼리를 실행 후 ResultSet의 변수 rs에 저장
		ResultSet rs = stmt.executeQuery();
		//클래스 Dept_emp의 값을 저장할 오브젝트 dept_emp생성
		Dept_emp dept_emp = null;
		if(rs.next()) {
			dept_emp = new Dept_emp();
			// Departments = new Department();
			//오브젝트 dept_emp에 클래스 Departments 생성
			dept_emp.setDepartments(new Departments());
			//오브젝트 dept_emp에 Departments의 setDeptNo 를 가져와서 de.dept_no의 값을 세팅 
			dept_emp.setDeptNo(rs.getString("de.dept_no"));
			dept_emp.setFromDate(rs.getString("de.from_date"));
			dept_emp.setToDate(rs.getString("de.to_date"));
			dept_emp.getDepartments().setDeptName(rs.getString("d.dept_name"));
			dept_emp.setEmployees(new Employees());
			dept_emp.setEmpNo(rs.getInt("de.emp_no"));
			dept_emp.getEmployees().setFirstName(rs.getString("e.first_name"));
		}
		conn.close();
		//저장한 값들을 클래스 밖에서 사용하기 위해 오브젝트 dept_emp 반환
		return dept_emp;
	}
	//ArrayList타입으로 목록 전체 출력
	public ArrayList<Dept_emp> selectDept_empList(int currentPage, int rowPerPage) throws Exception {
		System.out.println("selectDept_empList currentPage : "+currentPage);
		System.out.println("selectDept_empList rowPerPage : "+rowPerPage);
		int beginRow = (currentPage-1) * rowPerPage;
		ArrayList<Dept_emp> list = new ArrayList<Dept_emp>();
		DBHelper dbHelper = new DBHelper();
		Connection conn = dbHelper.getConnection();
		String sql = "SELECT emp_no, dept_no, from_date, to_date FROM dept_emp LIMIT ?,?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, beginRow);
		stmt.setInt(2, rowPerPage);
		
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			Dept_emp dept_emp = new Dept_emp();
			dept_emp.setEmpNo(rs.getInt("emp_no"));
			dept_emp.setDeptNo(rs.getString("dept_no"));
			dept_emp.setFromDate(rs.getString("from_date"));
			dept_emp.setToDate(rs.getString("to_date"));
			list.add(dept_emp);
		}
		return list;
	}
	
	public int selectDept_empTotalRow() throws Exception {
		int totalRow = 0;
		DBHelper dbHelper = new DBHelper();
		Connection conn = dbHelper.getConnection();
		String sql = "SELECT count(*) as cnt FROM dept_emp";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			totalRow = rs.getInt("cnt");
		}
		return totalRow;
	}
}
