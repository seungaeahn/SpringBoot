<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="com.kh.model.vo.DTO" %>
<%@ page import="com.kh.model.dao.DAO" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>search Result</title>
	</head>
	<body>
		<h1>�˻� ���</h1>
		<table border="1">
			<thead>
				<tr>
					<th>��ȣ</th>
					<th>���̵�</th>
					<th>�̸�</th>
					<th>����</th>
				</tr>
			</thead>
			<tbody>
				<%
					List<DTO> userList = (List<DTO>)request.getAttribute("userList");
					
					for(DTO d : userList){
				%>
						<tr>
							<td><%= d.getUser_number() %></td>
							<td><%= d.getUser_id() %></td>
							<td><%= d.getUser_name() %></td>
							<td><%= d.getUser_age() %></td>
						</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</body>
</html>