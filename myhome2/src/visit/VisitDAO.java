package visit;

import java.sql.*;
import java.util.ArrayList;

public class VisitDAO {
	private Connection conn = null;
	private Statement stat = null;
	private PreparedStatement pstat = null;
	
	public VisitDAO() {
		this.connect();
	}
	
	private void connect() {
		try {
			//JDBC 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("JDBC 드라이버 로딩 완료");
			
			//접속 정보
			String url = "jdbc:oracle:thin:@localhost:50000:xe";
			String user = "web_admin";
			String password ="admin";
			
			// DB 접속 객체 생성, 접속 시도
			this.conn = DriverManager.getConnection(url, user, password);
			System.out.println("Oracle DB 접속 완료");
			
			// SQL 구문 작업용 객체 생성
			this.stat = this.conn.createStatement();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public VisitVO getRecord(int id) {
		String sql = "SELECT * FROM visit_t WHERE id = ?";
		VisitVO record = null;
		try {
			pstat = this.conn.prepareStatement(sql);
			pstat.setInt(1, id);
			
			ResultSet res = this.pstat.executeQuery();
			if(res.next()) {
				record = new VisitVO(
					res.getInt("id"),
					res.getString("author"),
					res.getString("context"),
					res.getDate("create_date")
				);
			}
			res.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return record;
	}
	
	public ArrayList<VisitVO> getRecords(Date date) {
		String sql = "";
		sql += "SELECT * FROM visit_t";
		sql += " WHERE TO_CHAR(create_date, 'YYYY-MM-DD') = ?";
		sql += " ORDER BY id DESC";
		
		ArrayList<VisitVO> records = new ArrayList<VisitVO>();
		try {
			pstat = this.conn.prepareStatement(sql);
			pstat.setDate(1, date);
			
			ResultSet res = this.pstat.executeQuery();
			while(res.next()) {
				records.add(new VisitVO(
					res.getInt("id"),
					res.getString("author"),
					res.getString("context"),
					res.getDate("create_date")
				));
			}
			res.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return records;
		
	}
	
	public ArrayList<VisitVO> getAll() {
		String sql = "";
		sql += "SELECT * FROM visit_t";
		sql += " ORDER BY id DESC";
		
		ArrayList<VisitVO> all = new ArrayList<VisitVO>();
		try {
			pstat = this.conn.prepareStatement(sql);
			
			ResultSet res = this.pstat.executeQuery();
			while(res.next()) {
				all.add(new VisitVO(
					res.getInt("id"),
					res.getString("author"),
					res.getString("context"),
					res.getDate("create_date")	
				));
			}
			res.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return all;
	}
	
	public int saveData(VisitVO data) {
		/**
		 *  visit_t 테이블에 데이터를 추가하는 메서드
		 *  	- VisitVO 에는 추가할 데이터의 정보가 있다.
		 *  	- VisitVO 의 id 는 Database에서 자동증가로 
		 *  	  저장하기때문에 별도의 설정은 필요없음
		 *  	- VisitVO 의 create_date는 Database의 
		 *  	  SYSDATE로 저장하기 때문에 별도의 설정이 필요없음
		 */
		int result = 0;		// 저장 처리 유무를 판별
		String sql = "";
		sql += "INSERT INTO visit_t (id, author, context, create_date)";
		sql += "	VALUES(visit_seq.NEXTVAL, ?, ?, SYSDATE)";
		try {
			pstat = this.conn.prepareStatement(sql);
			pstat.setString(1, data.getAuthor());
			pstat.setString(2,  data.getContext());
			
			result = this.pstat.executeUpdate();	// 저장 처리 완료시 1 반환
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return result;
	}
	
	public int updataData(VisitVO data) {
		int result = 0;
		String sql = "";
		sql += "UPDATE visit_t";
		sql += "	SET context=?";
		sql += " WHERE id=?";
		
		try {
			pstat = this.conn.prepareStatement(sql);
			pstat.setString(1, data.getContext());
			pstat.setInt(2, data.getId());
			
			result = this.pstat.executeUpdate();	// 저장 처리 완료시 1 반환
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	public int deleteData(int id) {
		/**
		 * 	visit_t 테이블의 데이터를 삭제하는 메서드
		 * 		- 삭제할 데이터의 id만을 가지고 삭제 처리
		 * 		- visit_t 테이블에서 id컬럼은 primary key로 사용하기 때문에
		 * 		  오직 하나의 데이터만 삭제할 수 있다.
		 */
		int result = 0;
		String sql = "";
		sql += "DELETE FROM visit_t";
		sql += " WHERE id = ?";
		try {
			pstat = this.conn.prepareStatement(sql);
			pstat.setInt(1, id);
			
			result = this.pstat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public void close() {
		// 모든 JDBC 관련 생성 객체 정보 close()
		try {
			this.stat.close();
			this.conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
