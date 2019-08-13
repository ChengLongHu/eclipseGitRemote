package org.student.entity;

import java.util.List;

//��ҳ������
public class Page {
	//��ǰҳ
	private int currentPage;
	//ҳ���С
	private int pageSize;
	//������
	private int totalCount;
	//��ҳ��
	private int totalPage;
	//��ǰҳ�����ݼ���students
	private List<Student> students;
	public Page() {
		super();
		// TODO �Զ����ɵĹ��캯�����
	}
	public Page(int currentPage, int pageSize, int totalCount, int totalPage, List<Student> students) {
		super();
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.totalPage = totalPage;
		this.students = students;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		//�Զ��������ҳ��
		//��ҳ�� = �������� % ҳ���С == 0 ? ��������/ҳ���С:��������/ҳ���С+1;
		this.totalPage = this.totalCount % this.pageSize == 0 ? this.totalCount / this.pageSize - 1 : this.totalCount / this.pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	//����ҳ����ֵ
//	public void setTotalPage(int totalPage) {
//		this.totalPage = totalPage;
//	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	
}
