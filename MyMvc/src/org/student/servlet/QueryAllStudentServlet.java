package org.student.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.student.entity.Student;
import org.student.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class QueryAllStudentServlet
 */
@WebServlet("/QueryAllStudentServlet")
public class QueryAllStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public QueryAllStudentServlet() {
        super();
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		StudentServiceImpl service = new StudentServiceImpl();
		List<Student> students = service.queryAllStudent();
		System.out.println(students);
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		request.setAttribute("students", students);
		request.getRequestDispatcher("QueryStudentByPage").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
