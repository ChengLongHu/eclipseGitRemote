package org.student.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.student.dao.IStudentDao;
import org.student.entity.Student;
import org.student.util.DBUtil;

//数据访问层：原子性的 增删改查
public class StudentDaoImpl implements IStudentDao{
//	public static void main(String[] args) {
//		IStudentDao dao = new StudentDaoImpl();
////		if(dao.addStudent(new Student(111,"lel ", 14, "123"))) {
////			System.out.println("添加成功！");
////		}
//		
////		if(dao.updateStudentBySno(111,new Student("l1el ", 14, "123"))) {
////			System.out.println("修改成功！");
////		}
//		
////		if(dao.deleteStudentBySno(111)) {
////			System.out.println("删除成功！");
////		}
//		System.out.println(dao.queryAllStudents());
//		
//		System.out.println(dao.queryStudentBySno(111));
//		
//	}
	@Override
	public boolean addStudent(Student student) {
		String sql = "insert into student(sno,sname,sage,saddress) values (?,?,?,?)";
		Object[] params = {student.getSno(),student.getSname(),student.getSage(),student.getSaddress()};
		return DBUtil.executeUpdate(sql, params);
	}

	@Override
	public boolean updateStudentBySno(int sno, Student student) {
		String sql = "update student set sname=?,sage=?,saddress=? where sno=?";
		Object[] params = {student.getSname(),student.getSage(),student.getSaddress(),student.getSno()};
		return DBUtil.executeUpdate(sql, params);
	}

	@Override
	public int getTotalCount() {
		String sql = "select count(*) from student";
		return DBUtil.getTotalCount(sql);
	}

	@Override
	public boolean deleteStudentBySno(int sno) {
		String sql = "delete from student where sno = ?";
		Object[] params = {sno};
		return DBUtil.executeUpdate(sql, params);
	}

	public static void main(String[] args) {
		StudentDaoImpl a = new StudentDaoImpl();
		a.queryStudentByPage(1,3);
		
	}
	@Override
	public List<Student> queryStudentByPage(int currentPage, int pageSize) {
		int count = currentPage * pageSize;
		String sql = "select * from student limit ?,?";

		Object[] params = {count,pageSize};
		List<Student> students = new ArrayList<>();
		
		ResultSet rs = DBUtil.executeQuery(sql, params);
		try {
			while(rs.next()) {
				Student student = new Student(rs.getInt("sno"), rs.getString("sname"), rs.getInt("sage"), rs.getString("saddress"));
				students.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(rs, DBUtil.pstmt, DBUtil.connection);
		}
		return students;
	}

	@Override
	public boolean isExist(int sno) {
		return queryStudentBySno(sno)==null ? false : true;
	}

	@Override
	public Student queryStudentBySno(int sno) {
		Student student = null;
		ResultSet rs = null;
		String sql = "select * from student where sno = ?";
		Object[] params = {sno};
		rs = DBUtil.executeQuery(sql, params);
		try {
			if(rs.next()) {
				int no = rs.getInt("sno");
				String name = rs.getString("sname");
				int age = rs.getInt("sage");
				String address = rs.getString("saddress");
				student = new Student(no, name, age, address);
			}
			return student;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(rs, DBUtil.pstmt, DBUtil.connection);
		}
		return null;
	}
	@Override
	public List<Student> queryAllStudents() {
		PreparedStatement pstmt = null;
		Student student = null;
		List<Student> students = new ArrayList<Student>();
		ResultSet rs = null;
		try {
			String sql = "select * from student";
			rs = DBUtil.executeQuery(sql, null);
			while(rs.next()) {
				int no = rs.getInt("sno");
				String name = rs.getString("sname");
				int age = rs.getInt("sage");
				String address = rs.getString("saddress");
				student = new Student(no, name, age, address);
				students.add(student);
			}
			return students;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		finally {
			DBUtil.closeAll(rs, pstmt, DBUtil.connection);
		}
		
	}
	
}
