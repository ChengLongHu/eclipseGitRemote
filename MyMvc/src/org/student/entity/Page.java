package org.student.entity;

import java.util.List;

//分页帮助类
public class Page {
	//当前页
	private int currentPage;
	//页面大小
	private int pageSize;
	//总数据
	private int totalCount;
	//总页数
	private int totalPage;
	//当前页的数据集合students
	private List<Student> students;
	public Page() {
		super();
		// TODO 自动生成的构造函数存根
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
		//自动计算出总页数
		//总页数 = 数据总数 % 页面大小 == 0 ? 数据总数/页面大小:数据总数/页面大小+1;
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
	//给总页数赋值
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
