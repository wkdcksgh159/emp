package model;
import model.DBHelper;
import java.sql.*;
import java.util.*;
//employees 테이블과 관련 기능을 묶은 클래스
public class EmployeesDao {
	//리턴값 : Employees 메소드명 : selectEmployeesOne(매개변수타입 : int)
	public Employees selectEmployeesOne(int empNo) throws Exception{ //예외 발생시 상위 메서드로 보냄
		//클래스 DBHelper의 값을 저장할 오브젝트 dbHelper 생성
		DBHelper dbHelper = new DBHelper();
		//연결정보 입력
		Connection conn = dbHelper.getConnection("jdbc:mariadb://127.0.0.1:3306/employees", "root", "java1234");
		//쿼리내용을 저장하기 위한 변수 sql 생성
		String sql = "SELECT emp_no, birth_date, first_name, last_name, gender, hire_date FROM employees WHERE emp_no=?";
		//쿼리를 저장하기 위한 변수 stmt 생성 후 쿼리내용을 저장한 변수 sql를 입력
		PreparedStatement stmt = conn.prepareStatement(sql);
		//쿼리내용수정 where문의 empNo의 값을 ?에 입력
		stmt.setInt(1, empNo);
		//stmt에 저장된 쿼리를 실행 후 ResultSet의 변수 rs에 저장
		ResultSet rs = stmt.executeQuery();
		//클래스 Employees의 값을 저장할 오브젝트 employees생성
		Employees employees = null;
		if(rs.next()) {
			//오브젝트 employees에 값 입력
			employees = new Employees();
			employees.setEmpNo(rs.getInt("emp_no"));
			employees.setBirthDate(rs.getString("birth_date"));
			employees.setFirstName(rs.getString("first_name"));
			employees.setLastName(rs.getString("last_name"));
			employees.setGender(rs.getString("gender"));
			employees.setHireDate(rs.getString("hire_date"));
		}
		conn.close();
		//저장한 값들을 클래스 밖에서 사용하기 위해 오브젝트 employees 반환
		return employees;
	}
	
	public ArrayList<Employees> selectEmployeesList(int currentPage, int rowPerPage) throws Exception{
		//매개변수값 확인
		System.out.println("currentPage : " + currentPage);
		System.out.println("rowPerPage : " + rowPerPage);
		
		
		//페이지당 보여줄 항목의 시작 설정
		int beginRow = (currentPage-1) * rowPerPage;
		//ArrayList타입 오브젝트 list 생성
		ArrayList<Employees> list = new ArrayList<Employees>();
		//db 불러오기
		DBHelper dbHelper = new DBHelper();
		Connection conn = dbHelper.getConnection("jdbc:mariadb://127.0.0.1:3306/employees", "root", "java1234");
		String sql = "";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		// 쿼리정보 입력
		sql = "SELECT emp_no, birth_date, first_name, last_name, gender, hire_date FROM employees LIMIT ?,?";
		stmt = conn.prepareStatement(sql);
		// 쿼리정보 수정 (limit의 값 입력)
		stmt.setInt(1, beginRow);
		stmt.setInt(2, rowPerPage);
		//쿼리실행 후 ResultSet에 저장
		rs = stmt.executeQuery();
		//저장한 쿼리를 한행씩불러온뒤 쿼리값 저장
		while(rs.next()) {
			Employees employees = new Employees();
			employees.setEmpNo(rs.getInt("emp_no"));
			employees.setBirthDate(rs.getString("birth_date"));
			employees.setFirstName(rs.getString("first_name"));
			employees.setLastName(rs.getString("last_name"));
			employees.setGender(rs.getString("gender"));
			employees.setHireDate(rs.getString("hire_date"));
			list.add(employees);
		}
		conn.close();
		return list;
	}
	
	public ArrayList<Employees> selectEmployeesList2(String gender, int currentPage, int rowPerPage) throws Exception{
		//매개변수값 확인
		System.out.println("currentPage : " + currentPage);
		System.out.println("rowPerPage : " + rowPerPage);
		
		
		//페이지당 보여줄 항목의 시작 설정
		int beginRow = (currentPage-1) * rowPerPage;
		//ArrayList타입 오브젝트 list 생성
		ArrayList<Employees> list = new ArrayList<Employees>();
		//db 불러오기
		DBHelper dbHelper = new DBHelper();
		Connection conn = dbHelper.getConnection("jdbc:mariadb://127.0.0.1:3306/employees", "root", "java1234");
		String sql = "";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		// 쿼리정보 입력
		sql = "SELECT emp_no, birth_date, first_name, last_name, gender, hire_date FROM employees WHERE gender=? LIMIT ?,?";
		stmt = conn.prepareStatement(sql);
		// 쿼리정보 수정 (limit의 값 입력)
		stmt.setString(1, gender);
		stmt.setInt(2, beginRow);
		stmt.setInt(3, rowPerPage);
		//쿼리실행 후 ResultSet에 저장
		rs = stmt.executeQuery();
		//저장한 쿼리를 한행씩불러온뒤 쿼리값 저장
		while(rs.next()) {
			Employees employees = new Employees();
			employees.setEmpNo(rs.getInt("emp_no"));
			employees.setBirthDate(rs.getString("birth_date"));
			employees.setFirstName(rs.getString("first_name"));
			employees.setLastName(rs.getString("last_name"));
			employees.setGender(rs.getString("gender"));
			employees.setHireDate(rs.getString("hire_date"));
			list.add(employees);
		}
		conn.close();
		return list;
	}
	
	public ArrayList<Employees> selectEmployeesList3(String gender, int currentPage, int rowPerPage) throws Exception{
		//매개변수값 확인
		System.out.println("currentPage : " + currentPage);
		System.out.println("rowPerPage : " + rowPerPage);
		
		
		//페이지당 보여줄 항목의 시작 설정
		int beginRow = (currentPage-1) * rowPerPage;
		//ArrayList타입 오브젝트 list 생성
		ArrayList<Employees> list = new ArrayList<Employees>();
		//db 불러오기
		DBHelper dbHelper = new DBHelper();
		Connection conn = dbHelper.getConnection("jdbc:mariadb://127.0.0.1:3306/employees", "root", "java1234");
		String sql = "";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		// 쿼리정보 입력
		sql = "SELECT emp_no, birth_date, first_name, last_name, gender, hire_date FROM employees WHERE gender=? AND first_name LIKE %word% LIMIT ?,?";
		stmt = conn.prepareStatement(sql);
		// 쿼리정보 수정 (limit의 값 입력)
		stmt.setString(1, gender);
		stmt.setInt(2, beginRow);
		stmt.setInt(3, rowPerPage);
		//쿼리실행 후 ResultSet에 저장
		rs = stmt.executeQuery();
		//저장한 쿼리를 한행씩불러온뒤 쿼리값 저장
		while(rs.next()) {
			Employees employees = new Employees();
			employees.setEmpNo(rs.getInt("emp_no"));
			employees.setBirthDate(rs.getString("birth_date"));
			employees.setFirstName(rs.getString("first_name"));
			employees.setLastName(rs.getString("last_name"));
			employees.setGender(rs.getString("gender"));
			employees.setHireDate(rs.getString("hire_date"));
			list.add(employees);
		}
		conn.close();
		return list;
	}
	
	public int selectEmployeesTotalRow() throws Exception{
		int totalRow = 0;
		DBHelper dbHelper = new DBHelper();
		Connection conn = dbHelper.getConnection("jdbc:mariadb://127.0.0.1/employees", "root", "java1234");
		String sql = "SELECT count(*) as cnt FROM employees";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			totalRow=rs.getInt(1);
		}
		return totalRow;
	}
	
	public int insertEmployees(Employees employees) throws Exception {
		System.out.println(employees.getEmpNo());
		System.out.println(employees.getBirthDate());
		System.out.println(employees.getFirstName());
		System.out.println(employees.getLastName());
		System.out.println(employees.getGender());
		System.out.println(employees.getHireDate());
		//db 불러오기
		DBHelper dbHelper = new DBHelper();
		Connection conn = dbHelper.getConnection("jdbc.mariadb://127.0.0.1/employees", "root", "java1234");
		
		//쿼리정보 입력
		String sql = "INSERT INTO employees(emp_no, birth_date, first_name, last_name, gender, hire_date) VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, employees.getEmpNo());
		stmt.setString(2, employees.getBirthDate());
		stmt.setString(3, employees.getFirstName());
		stmt.setString(4, employees.getLastName());
		stmt.setString(5, employees.getGender());
		stmt.setString(6, employees.getHireDate());
		
		int resultRowCnt = stmt.executeUpdate();
		
		return resultRowCnt;
		
	}
	
	public void deleteEmployeesAction(int empNo) throws Exception {
		//db불러오기
		DBHelper dbHelper = new DBHelper();
		Connection conn = dbHelper.getConnection("jdbc:mariadb://127.0.0.1/employees", "root", "java1234");
		//쿼리정보 입력
		String sql = "DELETE FROM employees WHERE emp_no=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, empNo);
		stmt.executeUpdate();
		conn.close();
	}
	
	public void updateEmployees(Employees employees) throws Exception {
		//db불러오기
		DBHelper dbHelper = new DBHelper();
		Connection conn = dbHelper.getConnection("jdbc:mariadb://127.0.0.1:3306/employees", "root", "java1234");
		//쿼리정보 입력
		String sql = "UPDATE employees SET birth_date=?, first_name=?, last_name=?, gender=?, hire_date=? WHERE emp_no=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		//클래스 Employees의 오브젝트 employees의 값에 저장
		stmt.setString(1, employees.getBirthDate());
		stmt.setString(2, employees.getFirstName());
		stmt.setString(3, employees.getLastName());
		stmt.setString(4, employees.getGender());
		stmt.setString(5, employees.getHireDate());
		stmt.setInt(6, employees.getEmpNo());
		stmt.executeUpdate();
		conn.close();
	}
}
