<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="AddStudentServlet" method="post" >
		学号：<input type="text" name="sno" id="sno"/><br/>
		姓名：<input type="text" name="sname" id="sname"/><br/>
		年龄：<input type="text" name="sage" id="sage"/><br/>
		地址：<input type="text" name="saddress" id="saddress"/><br/>
		<input type="submit" value="新增"/><br/>
	
	</form>
</body>
</html>