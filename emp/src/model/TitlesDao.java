package model;
import model.DBHelper;
import java.sql.*;
public class TitlesDao {
		//리턴값 : Titles 메소드명 : selectTitlesOne(매개변수타입 : int)
		public Titles selectTitlesOne(int empNo) throws Exception{ //예외 발생시 상위 메서드로 보냄
			//클래스 DBHelper의 값을 저장할 오브젝트 dbHelper 생성
			DBHelper dbHelper = new DBHelper();
			//연결정보 입력
			Connection conn = dbHelper.getConnection("jdbc:mariadb://127.0.0.1:3306/employees", "root", "java1234");
			//쿼리내용을 저장하기 위한 변수 sql 생성
			String sql = "select emp_no, title, from_date, to_date from titles WHERE emp_no=?";
			//쿼리를 저장하기 위한 변수 stmt 생성 후 쿼리내용을 저장한 변수 sql를 입력
			PreparedStatement stmt = conn.prepareStatement(sql);
			//쿼리내용수정 where문의 empNo의 값을 ?에 입력
			stmt.setInt(1, empNo);
			//stmt에 저장된 쿼리를 실행 후 ResultSet의 변수 rs에 저장
			ResultSet rs = stmt.executeQuery();
			//클래스 Titles의 값을 저장할 오브젝트 titles생성
			Titles titles = null;
			if(rs.next()) {
				//오브젝트 titles에 값 입력
				titles = new Titles();
				titles.setEmpNo(rs.getInt("emp_no"));
				titles.setTitle(rs.getString("title"));
				titles.setFromDate(rs.getString("from_date"));
				titles.setToDate(rs.getString("to_date"));
			}
			conn.close();
			//저장한 값들을 클래스 밖에서 사용하기 위해 오브젝트 dept_emp 반환
			return titles;
		}
}
