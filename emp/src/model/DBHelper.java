package model;
import java.sql.*;
public class DBHelper {
	//생성자 메서드
	public DBHelper() {
	}
	//db 연결하는 메서드
	//리턴값 : Connection 메소드명 : getConnection(매개변수 : String, String, String) 
	public Connection getConnection() throws Exception { //예외 발생시 상위 메서드로 보냄
		//연결정보를 저장할 변수생성
		Connection conn = null;
		//마리아db 연결
		Class.forName("org.mariadb.jdbc.Driver");
		//연결정보 입력
		conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/wkdcksgh159", "wkdcksgh159", "cksgh159!");
		//연결정보 반환
		return conn;
	}
}
