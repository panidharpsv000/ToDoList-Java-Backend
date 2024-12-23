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
@WebServlet("/edit")
public class EditToDo extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    PrintWriter out=response.getWriter();
		ToDoModelObject t1=new ToDoModelObject();
		t1.setId(Integer.parseInt(request.getParameter("id")));
		t1.setTitle(request.getParameter("title"));
		t1.setDescription(request.getParameter("description"));
		t1.setStatus(request.getParameter("status"));
		t1.setDate(request.getParameter("date"));
		ToDoDAO d1=new ToDoDAO();
		out.println("<html>");
        out.println("<head>");
        out.println("<link rel='stylesheet' href='style.css'>");
        out.println("</head>");
        out.println("<body>");
        if(d1.updateToDo(t1)==1) out.println("<h4>ToDo Sucessfully Updated.</h4>");
        else out.println("<h4>ToDo haven't Updated.</h4>");
        out.println("<a href='Home.html'>Home</a>");
        out.println("<a href='AddTodo.html'>Add ToDo</a>");
        out.println("<a href='View.jsp'>View ToDo Lists</a>");
        out.println("</body>");
        out.println("</html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}

}
