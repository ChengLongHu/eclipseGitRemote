<%@page import="org.student.entity.Page"%>
<%@page import="org.student.entity.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String error = (String)request.getAttribute("error");
		if(error != null){
			if(error.equals("addError")){
				out.print("增加失败！");
			}else if(error.equals("noaddError")){
				out.print("增加成功！");
			}
		}
	
	%>
	<table border="1px">
		<tr>
			<th>学号</th>
			<th>姓名</th>
			<th>年龄</th>
			<th>操作</th>
		</tr>
		<%
			//获取request域中的数据
			Page p = (Page)request.getAttribute("p");
			//List<Student> students = //(List<Student>)request.getAttribute("students");
			for(Student student:p.getStudents()){
		%>
		<tr>
		<td><a href="QueryStudentBySnoServlet?sno=<%=student.getSno()%>"><%=student.getSno()%></a></td>
		<td><%=student.getSname() %></td>
		<td><%=student.getSage() %></td>
		<td><a href="DeleteStudentServlet?sno=<%=student.getSno()%>">删除</a></td>
		</tr>
		<%
			}
		%>
	</table>
	<a href="add.jsp">新增</a><br>
	
	<%
		if(p.getCurrentPage() == p.getTotalPage()){	//尾页
	%>
		<a href="QueryStudentByPage?currentPage=0">首页</a>
		<a href="QueryStudentByPage?currentPage=<%=p.getCurrentPage()-1%>">上一页</a>
	<%
		}else if(p.getCurrentPage() == 0){
	%>	<a href="QueryStudentByPage?currentPage=<%=p.getCurrentPage()+1%>">下一页</a>
		<a href="QueryStudentByPage?currentPage=<%=p.getTotalPage()%>">尾页</a>
	<%
		}else{
	%>	
			<a href="QueryStudentByPage?currentPage=0">首页</a>
			<a href="QueryStudentByPage?currentPage=<%=p.getCurrentPage()-1%>">上一页</a>
			<a href="QueryStudentByPage?currentPage=<%=p.getCurrentPage()+1%>">下一页</a>
			<a href="QueryStudentByPage?currentPage=<%=p.getTotalPage()%>">尾页</a>
	<%	
		}
	%>
	
	<br/>
	每页显示
	<select>
		<option value="3">3</option>
		<option value="5">5</option>
		<option value="10">10</option>
	</select>
	条
</body>
</html>