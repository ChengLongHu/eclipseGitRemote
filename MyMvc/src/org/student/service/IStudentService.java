package org.student.service;

import java.util.List;

import org.student.entity.Student;

public interface IStudentService {
	//根据学号查询学生对象
	public Student queryStudentBySno(int sno);
	//查询全部学生
	public List<Student> queryAllStudent();
	//查询总数
	public int getTotalCount();
	//通过学号更新学生对象		查+改
	public boolean updateStudentBySno(int sno,Student student);
	//通过学号删除学生
	public boolean deleteStudentBySno(int sno);
	//增加学生对象
	public boolean addStudent(Student student);
	//通过页码查询学生集合
	public List<Student> queryStudentsByPage(int currentPage, int pageSize);
}
