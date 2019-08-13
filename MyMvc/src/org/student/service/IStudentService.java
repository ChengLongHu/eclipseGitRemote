package org.student.service;

import java.util.List;

import org.student.entity.Student;

public interface IStudentService {
	//����ѧ�Ų�ѯѧ������
	public Student queryStudentBySno(int sno);
	//��ѯȫ��ѧ��
	public List<Student> queryAllStudent();
	//��ѯ����
	public int getTotalCount();
	//ͨ��ѧ�Ÿ���ѧ������		��+��
	public boolean updateStudentBySno(int sno,Student student);
	//ͨ��ѧ��ɾ��ѧ��
	public boolean deleteStudentBySno(int sno);
	//����ѧ������
	public boolean addStudent(Student student);
	//ͨ��ҳ���ѯѧ������
	public List<Student> queryStudentsByPage(int currentPage, int pageSize);
}
