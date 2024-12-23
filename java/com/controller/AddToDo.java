package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.ToDoDAO.ToDoDAO;
import com.ToDoModelObject.ToDoModelObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/addToDo")
public class AddToDo extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       response.setContentType("text/html");
		   PrintWriter out=response.getWriter();
           String title=request.getParameter("title");
           String desc=request.getParameter("desc");
           String status=request.getParameter("status");
           String date=request.getParameter("date");
           ToDoModelObject t1=new ToDoModelObject();
           t1.setDate(date);
           t1.setDescription(desc);
           t1.setStatus(status);
           t1.setTitle(title);
           ToDoDAO d1=new ToDoDAO();
           int flag=(d1.addToDo(t1));
           out.println("<html>");
           out.println("<head>");
           out.println("<link rel='stylesheet' href='style.css'>");
           out.println("</head>");
           out.println("<body>");
           if(flag==1) out.println("<h4>ToDo added Sucessfully.</h4>");
           else out.println("<h4>ToDo haven't added.</h4>");
           out.println("<a href='Home.html'>Home</a>");
           out.println("<a href='AddTodo.html'>Add ToDo</a>");
           out.println("<a href='View.jsp'>View ToDo Lists</a>");
           out.println("</body>");
           out.println("</html>");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
   
}
