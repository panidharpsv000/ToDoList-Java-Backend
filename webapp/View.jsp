<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList ,java.util.List,com.ToDoModelObject.ToDoModelObject ,com.ToDoDAO.ToDoDAO " %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="view.css">
</head>
<body>
  <div class="main">
    <table>
    <tr>
      <th>Title</th>
      <th>Description</th>
      <th>Status</th>
      <th>Target Date</th>
      <th>Edit</th>
      <th>Delete</th>
    </tr>
    <%
    ToDoDAO d1=new ToDoDAO();
     List<ToDoModelObject> ans=d1.getTodoLists();
     for(ToDoModelObject t1 : ans)
     {
    	 out.println("<tr>");
    	 out.println("<td>"+t1.getTitle()+"</td>");
    	 out.println("<td>"+t1.getDescription()+"</td>");
    	 out.println("<td>"+t1.getStatus()+"</td>");
    	 out.println("<td>"+t1.getDate()+"</td>");
    	 String edit="Edit?id="+t1.getId();
    	 String delete="Delete?id="+t1.getId();
    	 out.println("<td><a href="+edit+">Edit</a></td>");
    	 out.println("<td><a href="+delete+">Delete</a></td>");
    	 out.println("</tr>");
     }
  %>
  </table>
  <a href="Home.html">Home</a>
  <a href="AddTodo.html">Add ToDo</a>
  <a href='View.jsp'>View ToDo Lists</a>
  </div>
</body>
</html>