package org.student.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.student.entity.Page;
import org.student.entity.Student;
import org.student.service.IStudentService;
import org.student.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class QueryStudentByPage
 */
@WebServlet("/QueryStudentByPage")
public class QueryStudentByPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryStudentByPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		IStudentService studentService = new StudentServiceImpl();
		int count = studentService.getTotalCount();
		
		Page page = new Page();
		
		//currentPageÒ³Âë
		String cPage = request.getParameter("currentPage");
		
		if(cPage == null) {
			cPage = "0";
		}
		
		int currentPage = Integer.parseInt(cPage);
		page.setCurrentPage(currentPage);
		
		int totalCount = studentService.getTotalCount();//×ÜÊý¾Ý
		page.setTotalCount(totalCount);
		int pageSize = 3;
		page.setPageSize(pageSize);
		List<Student> students = studentService.queryStudentsByPage(currentPage, pageSize);
		System.out.println(students);
		System.out.println(count);
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		page.setStudents(students);
		request.setAttribute("p", page);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
