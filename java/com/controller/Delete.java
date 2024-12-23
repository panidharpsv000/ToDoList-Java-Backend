package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.ToDoDAO.ToDoDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		int id=Integer.parseInt(request.getParameter("id"));
		ToDoDAO d1=new ToDoDAO();
		out.println("<html>");
        out.println("<head>");
        out.println("<link rel='stylesheet' href='style.css'>");
        out.println("</head>");
        out.println("<body>");
        if(d1.deleteToDo(id)==1) out.println("<h4>ToDo Sucessfully Deleted.</h4>");
        else out.println("<h4>ToDo haven't Deleted.</h4>");
        out.println("<a href='Home.html'>Home</a>");
        out.println("<a href='AddTodo.html'>Add ToDo</a>");
        out.println("<a href='View.jsp'>View ToDo Lists</a>");
        out.println("</body>");
        out.println("</html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}
   
}
