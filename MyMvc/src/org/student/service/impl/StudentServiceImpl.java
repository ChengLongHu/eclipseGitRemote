package org.student.service.impl;

import java.util.List;

import org.student.dao.IStudentDao;
import org.student.dao.impl.StudentDaoImpl;
import org.student.entity.Student;
import org.student.service.IStudentService;

//ҵ���߼��� :�߼��Ե���ɾ�Ĳ�(��:��+��),��Dao�������װ
public class StudentServiceImpl implements IStudentService{
	IStudentDao studentDao = new StudentDaoImpl();
	
	//ͨ��ѧ�Ų�ѧ��
	@Override
	public Student queryStudentBySno(int sno) {
		return studentDao.queryStudentBySno(sno);
	}

	//��ѯȫ��ѧ��
	@Override
	public List<Student> queryAllStudent() {
		return studentDao.queryAllStudents();
	}

	@Override
	public int getTotalCount() {
		return studentDao.getTotalCount();
	}

	@Override
	public boolean updateStudentBySno(int sno,Student student) {
		if(studentDao.isExist(sno)) {
			return studentDao.updateStudentBySno(sno, student);
		}
		return false;
	}

	@Override
	public boolean deleteStudentBySno(int sno) {
		if(studentDao.isExist(sno)) {
			return studentDao.deleteStudentBySno(sno);
		}
		return false;
	}

	@Override
	public boolean addStudent(Student student) {
		if(!studentDao.isExist(student.getSno())) {//������
			return studentDao.addStudent(student);
		}else {
			System.out.println("�����Ѵ���!");
			return false;
		}
	}

	@Override
	public List<Student> queryStudentsByPage(int currentPage, int pageSize) {
		return studentDao.queryStudentByPage(currentPage, pageSize);
	}
	
}
