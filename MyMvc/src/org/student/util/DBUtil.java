package org.student.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.student.entity.Student;


public class DBUtil {
	private static final String URL = "jdbc:mysql://localhost:3306/mydb?useSSL:false";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "123456";
	public static PreparedStatement pstmt = null;
	public static Connection connection = null;
	public static ResultSet rs = null;
	
	public static void main(String[] args) {
		System.out.println(getTotalCount("select count(*) from student"));
	}
	
	/**
	 * 查询总数
	 * @param sql
	 * @return
	 */
	public static int getTotalCount(String sql) {
		int count = -1;
		try {
			pstmt = createPreparedStatement(sql, null);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll(rs, pstmt, connection);
		}
		return count;
	}
	
	/**
	 * 通用的查询
	 * @param sql
	 * @param params
	 * @return
	 */
	public static ResultSet executeQuery(String sql,Object[] params) {
		Student student = null;
		List<Student> students = new ArrayList<>();
		try {
			pstmt = createPreparedStatement(sql, params);
			rs = pstmt.executeQuery();
			return rs;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 通用的增删改
	 * @param sql
	 * @param params
	 * @return
	 */
	public static boolean executeUpdate(String sql,Object[] params) {
		try {
			pstmt = createPreparedStatement(sql, params);
			int count = pstmt.executeUpdate();
			if(count > 0)
				return true;
			else 
				return false;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			closeAll(null,pstmt,connection);
		}
		
	}
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection(URL,USERNAME,PASSWORD);
	}
	
	public static PreparedStatement createPreparedStatement(String sql,Object[] params) throws ClassNotFoundException, SQLException {
		pstmt = getConnection().prepareStatement(sql);
		if(params != null) {
			for(int i = 0;i < params.length;i++) {
				pstmt.setObject(i+1, params[i]);
			}
		}
		return pstmt;
	}
	
	public static void closeAll(ResultSet rs,Statement pstmt,Connection connection) {
		try {
			if(rs != null)	rs.close();
			if(pstmt!=null) pstmt.close();
			if(connection!=null) connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}
