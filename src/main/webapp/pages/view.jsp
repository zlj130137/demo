<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
    <%@ page import="com.survey.entity.Surveydata" %>
    <%
    List<Surveydata> list = (ArrayList<Surveydata>)request.getAttribute("list");
    String path = request.getContextPath();
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
		<td><a href="<%=path %>/pages/add.jsp">新增</a></td>
	</tr>
</table>
<table border="1">
	<tr>
		<td>问卷题目编号</td>
		<td>问卷题目名</td>
		<td>问卷题目类型</td>
		<td>问卷题目选项</td>
		<td>操作</td>
	</tr>
	<%
	if(list == null){
		response.sendRedirect(path+"/surveydata/list");
	}else{ 
		 for(Surveydata surveydata : list){ 
	%>
	<tr>
		<td><%=surveydata.getId() %></td>
		<td><%=surveydata.getContent() %></td>
		<td><%=surveydata.getBtype() %></td>
		<td><%=surveydata.getBcheck() %></td>
		<td><a href="<%=path %>/surveydata/del?id=<%=surveydata.getId() %>">删除</a></td>
	</tr>
	<% 
		}
	} 
	%>
</table>
</body>
</html>