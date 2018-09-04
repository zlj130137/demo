<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
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
		<tr><h1>请在此处添加问题</h1></tr>
</table>
<form action="<%=path %>/surveydata/add" method="post">
	<table>
		<tr>
			<td>问卷题目：</td>
			<td><input type="text" name="content"></td>
		</tr>
		<tr>
			<td>选项类型：</td>
			<td><input type="radio" name="btype" value=0>单选
			<input type="radio" name="btype" value=1>选填</td>
		</tr>
		<tr>
			<td>问卷选项：</td>
			<td><input type="checkbox" name="bcheck" value="nostudy">未学过
			<input type="checkbox" name="bcheck" value="yes">是
			<input type="checkbox" name="bcheck" value="no">否
			<input type="checkbox" name="bcheck" value="nouse">未用过
			<input type="checkbox" name="bcheck" value="baseuse">基本掌握
			<input type="checkbox" name="bcheck" value="gen">一般
			<input type="checkbox" name="bcheck" value="very">熟练
			<input type="checkbox" name="bcheck" value="checktxt">选填内容</td>
		</tr>
		<tr>
			<td><input type="submit" value="添加"></td>
		</tr>
	</table>
</form>
<a href="<%=path %>/surveydata/list">查看所有调查问卷的问题</a>
</body>
</html>