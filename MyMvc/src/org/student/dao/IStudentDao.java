package org.student.dao;

import java.util.List;

import org.student.entity.Student;

public interface IStudentDao {
	//����ѧ��
	public boolean addStudent(Student student);
	
	//����ѧ���޸�ѧ��������sno֪�����޸ĵ��ˣ����Ǹ����޸ĳ�student
	public boolean updateStudentBySno(int sno,Student student);
	
	//��ѯѧ������
	public int getTotalCount();
	
	//����ѧ��ɾ��ѧ��
	public boolean deleteStudentBySno(int sno);
	
	public List<Student> queryAllStudents();
	
	//��ѯָ��ҳ���ѧ��
	public List<Student> queryStudentByPage(int currentPage,int pageSize);
	
	//����������ѯ
	//���������ѯ
	//��ѯ�����Ƿ����
	public boolean isExist(int sno);
	
	//����ѧ��  ��ѯѧ��
	public Student queryStudentBySno(int sno);
}
