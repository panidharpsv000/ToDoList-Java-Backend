<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList ,java.util.List,com.ToDoModelObject.ToDoModelObject ,com.ToDoDAO.ToDoDAO " %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.navBar
{
  margin-top:40px;
}
.navBar a
{ 
    border:2px solid;
     outline:none;
     background-color:green;
     color:white;
     width:20px;
     text-decoration:none;
     padding:8px;
}
button
{
  padding:5px;
  width:7%;
}
.none {
  display:none;
}
</style>
</head>
<body>
  <h3>Enter New Details:</h3>
  <%
     int id=(int)request.getAttribute("id");
     ToDoDAO d1=new ToDoDAO();
     ToDoModelObject t1=d1.getTodoList(id);
     String title=t1.getTitle();
     String description=t1.getDescription();
     String status=t1.getStatus();
     String date=t1.getDate();
  %>
  <form action="edit?id=2" class="editForm">
    <input type="text"  name="id" id="id" value=<%= request.getAttribute("id") %> class="none">
    <div class="input">
    Enter Title:
    <input type="text" id="title" name="title" value="<%=title %>" required>
    </div>
    <br>
    <div class="input">
    Enter Description:
    <input type="text" id="description" name="description" value="<%= description %>" >
    </div>
    <br>
    <div class="input">
    Select Status:
    <input type="radio" id="status" name="status"  value="In pogress" <%= "In pogress".equals(status) ? "checked" : "" %> required>In Pogress
    <input type="radio" id="status" name="status" value="Completed" <%= "Completed".equals(status) ? "checked" : "" %> required>Completed
    </div>
    <br>
    <div class="input">
    Enter Target Date:
    <input type="date" id="date" name="date" value="<%=date %>" required>
    </div>
    <br>
    <div class="input">
    <button type="submit">Submit</button>
    </div>
  </form>
  <div class="navBar">
  <a href="Home.html">Home</a>
  <a href="AddTodo.html">Add ToDo</a>
  <a href='View.jsp'>View ToDo Lists</a>
  </div>
</body>
</html>