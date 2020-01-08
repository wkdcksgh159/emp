package model;
import model.DBHelper;
import java.sql.*;
import java.util.*;
public class DepartmentsDao {
	//리턴값:Departments 메소드명:selectDepartmentsOne(매개변수타입 : String)
	public Departments selectDepartmentsOne(String deptNo) throws Exception { //예외 발생시 상위 메서드로 보냄
		//클래스 DBHelper의 값을 저장할 오브젝트 dbHelper 생성
		DBHelper dbHelper = new DBHelper();
		//연결정보 입력
		Connection conn = dbHelper.getConnection();
		//쿼리문의 내용을 저장할 변수 sql 생성 및 쿼리내용 입력
		String sql = "select dept_no, dept_name FROM departments WHERE dept_no=?";
		//쿼리문을 저장할 변수 stmt 를 생성 후 쿼리문의 내용 sql를 입력
		PreparedStatement stmt = conn.prepareStatement(sql);
		//쿼리 WHERE문의 값을 deptNo에 저장
		stmt.setString(1, deptNo);
		//stmt 쿼리 실행 후 ResultSet의 변수 rs에 저장
		ResultSet rs = stmt.executeQuery();
		//클래스 Departments의 값을 저장할 오브젝트 departments 생성
		Departments departments = null;
		if(rs.next()) {
			//생성한 오브젝트에 값 입력
			departments = new Departments();
			departments.setDeptNo(rs.getString("dept_no"));
			departments.setDeptName(rs.getString("dept_name"));
		}
		conn.close();
		//저장한 값들을 클래스 밖에서 사용하기 위해 오브젝트 departments 반환
		return departments;
	}
	
	public int insertDepartments(Departments departments) throws Exception {
		System.out.println(departments.getDeptNo());
		System.out.println(departments.getDeptName());
		DBHelper dbHelper = new DBHelper();
		Connection conn = dbHelper.getConnection();
		String sql = "INSERT INTO departments(dept_no, dept_name) VALUES (?, ?)";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setString(1, departments.getDeptNo());
		stmt.setString(2, departments.getDeptName());
		
		int resultRowCnt = stmt.executeUpdate();
		
		return resultRowCnt;
	}
	//public Departments[] 배열
	public ArrayList<Departments> selectDepartmentsList(int currentPage, int rowPerPage) throws Exception{
		System.out.println("selectDepartmentsList param currentPage"+currentPage);
		System.out.println("selectDepartmentsList param rowPerPage"+rowPerPage);
		int beginRow = (currentPage-1) * rowPerPage;
		ArrayList<Departments> list = new ArrayList<Departments>();
		DBHelper dbHelper = new DBHelper();
		Connection conn = dbHelper.getConnection();
		String sql = "SELECT dept_no, dept_name FROM departments LIMIT ?, ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, beginRow);
		stmt.setInt(2, rowPerPage);
		
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			Departments departments = new Departments();
			departments.setDeptNo(rs.getString("dept_no"));
			departments.setDeptName(rs.getString("dept_name"));
			list.add(departments);
		}
		return list;
	}
	// totalCount / rowPerPage
	public int selectDepartmentsTotalRow() throws Exception{
		int totalRow = 0;
		DBHelper dbHelper = new DBHelper();
		Connection conn = dbHelper.getConnection();
		String sql = "SELECT count(*) as cnt FROM departments";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			totalRow=rs.getInt(1); //rs.getInt("cnt")
		}
		return totalRow;
	}
	
	public void deleteDepartmentsAction(String deptNo) throws Exception {
		DBHelper dbHelper = new DBHelper();
		Connection conn = dbHelper.getConnection();
		String sql = "DELETE FROM departments WHERE dept_no=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, deptNo);
		stmt.executeUpdate();
		conn.close();
	}
	
	public void updateDepartments(Departments departments) {
		DBHelper dbHelper = new DBHelper();
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = dbHelper.getConnection();
			String sql = "UPDATE departments SET dept_name=? WHERE dept_no=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, departments.getDeptName());
			stmt.setString(2, departments.getDeptNo());
			stmt.executeUpdate();
		} catch(Exception e) {
			System.out.println("예외발생");
			e.printStackTrace(); // console
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
