package model;
import model.DBHelper;
import java.util.*;
import java.sql.*;
public class Dept_managerDao {
	//리턴값 : Dept_manager 메소드명 : selectDept_managerOne(매개변수타입 : String)
	public Dept_manager selectDept_managerOne(String deptNo) throws Exception { //예외 발생시 상위 메서드로 보냄
		//클래스 DBHelper의 값을 저장할 오브젝트 dbHelper 생성
		DBHelper dbHelper = new DBHelper();
		//연결정보 입력
		Connection conn = dbHelper.getConnection();
		//쿼리내용을 저장하기 위한 변수 sql 생성
		String sql = "select emp_no, dept_no, from_date, to_date FROM dept_manager WHERE dept_no=?";
		//쿼리를 저장하기 위한 변수 stmt 생성 후 쿼리내용을 저장한 변수 sql를 입력
		PreparedStatement stmt = conn.prepareStatement(sql);
		//쿼리내용수정 where문의 deptNo의 값을 ?에 입력
		stmt.setString(1, deptNo);
		//stmt에 저장된 쿼리를 실행 후 ResultSet의 변수 rs에 저장
		ResultSet rs = stmt.executeQuery();
		//클래스 Dept_manager의 값을 저장할 오브젝트 dept_manager생성
		Dept_manager dept_manager = null;
		if(rs.next()) {
			//오브젝트 dept_manager에 값 입력
			dept_manager = new Dept_manager();
			dept_manager.setDeptNo(rs.getString("dept_no"));
			dept_manager.setEmpNo(rs.getInt("emp_no"));
			dept_manager.setFromDate(rs.getString("from_date"));
			dept_manager.setToDate(rs.getString("to_date"));
		}
		conn.close();
		//저장한 값들을 클래스 밖에서 사용하기 위해 오브젝트 dept_manager 반환
		return dept_manager;
	}
	
	public int insertDept_manager(Dept_manager dept_manager) throws Exception {
		System.out.println(dept_manager.getEmpNo());
		System.out.println(dept_manager.getDeptNo());
		System.out.println(dept_manager.getFromDate());
		System.out.println(dept_manager.getToDate());
		
		DBHelper dbHelper = new DBHelper();
		Connection conn = dbHelper.getConnection();
		
		String sql = "INSERT INTO departments(dept_no, from_date, to_date) VALUES (?, ?, ?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setString(1, dept_manager.getDeptNo());
		stmt.setString(2, dept_manager.getFromDate());
		stmt.setString(3, dept_manager.getToDate());
		
		int resultRowCnt = stmt.executeUpdate();
		conn.close();
		return resultRowCnt;
	}
	//ArrayList를 사용 전체목록을 보여주고 int타입 매개변수 currentPage(현재페이지), rowPerPage(제한개수)를 주어 페이징작업을함
	public ArrayList<Dept_manager> selectDept_managerList(int currentPage, int rowPerPage) throws Exception{
		//매개변수 확인
		System.out.println(currentPage);
		System.out.println(rowPerPage);
		//한페이지당 보여줄 항목의 시작 beginRow
		int beginRow = (currentPage-1) * rowPerPage;
		//클래스 ArrayList의 오브젝트 list 생성
		ArrayList<Dept_manager> list = new ArrayList<Dept_manager>();
		//db불러오기
		DBHelper dbHelper = new DBHelper();
		//연결주소, 이름, 비밀번호입력
		Connection conn = dbHelper.getConnection();
		//쿼리정보입력 (전체컬럼을 가져오고 limit를 이용 한페이지당 보여줄 개수)
		String sql = "SELECT dept_no, emp_no, from_date, to_date FROM dept_manager LIMIT ?, ?";
		//쿼리수정 (limit ? 에 값 입력 beginRow, rowPerPage;
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, beginRow);
		stmt.setInt(2, rowPerPage);
		//쿼리실행 후 출력을 위해 클래스타입 ResultSet의 변수 rs 에 저장
		ResultSet rs = stmt.executeQuery();
		//rs의 값을 반복문으로 한행씩 가져와서 한열씩 출력
		while(rs.next()) {
			Dept_manager dept_manager = new Dept_manager();
			dept_manager.setEmpNo(rs.getInt("emp_no"));
			dept_manager.setDeptNo(rs.getString("dept_no"));
			dept_manager.setFromDate(rs.getString("from_date"));
			dept_manager.setToDate(rs.getString("to_date"));
			list.add(dept_manager);
		}
		conn.close();
		//list의 값을 사용하기위해 반환
		return list;
	}
	// 마지막페이지(endPage)를 설정하기 위한 메소드 생성
	// totalCount / rowPerPage
	public int selectDept_managerTotalRow() throws Exception{
		//총 개수를 저장할 변수 생성
		int totalRow = 0;
		//db 불러오기
		DBHelper dbHelper = new DBHelper();
		//연결주소, 이름, 비밀번호 입력
		Connection conn = dbHelper.getConnection();
		//쿼리정보에 넣을 변수입력 ( 쿼리문 count(*)를 이용 컬럼의 총 개수를 가져옴 
		String sql = "SELECT count(*) as cnt FROM dept_manager";
		//쿼리변수를 쿼리정보에 입력
		PreparedStatement stmt = conn.prepareStatement(sql);
		//쿼리실행후 실행한값을 변수 totalRow에 저장하기 위해 변수 rs에 저장
		ResultSet rs = stmt.executeQuery();
		//쿼리 저장한값을 한행 불러옴
		if(rs.next()) {
			//한행 불러온값을 변수 totalRow 에 저장
			totalRow=rs.getInt("cnt");
		}
		conn.close();
		//totalRow 값을 사용하기위해 반환
		return totalRow;
	}
	
}

