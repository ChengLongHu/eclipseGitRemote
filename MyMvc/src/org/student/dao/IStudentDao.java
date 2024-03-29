package org.student.dao;

import java.util.List;

import org.student.entity.Student;

public interface IStudentDao {
	//增加学生
	public boolean addStudent(Student student);
	
	//根据学号修改学生，根据sno知道待修改的人，把那个人修改成student
	public boolean updateStudentBySno(int sno,Student student);
	
	//查询学生总数
	public int getTotalCount();
	
	//根据学号删除学生
	public boolean deleteStudentBySno(int sno);
	
	public List<Student> queryAllStudents();
	
	//查询指定页码的学生
	public List<Student> queryStudentByPage(int currentPage,int pageSize);
	
	//根据姓名查询
	//根据年龄查询
	//查询此人是否存在
	public boolean isExist(int sno);
	
	//根据学号  查询学生
	public Student queryStudentBySno(int sno);
}
