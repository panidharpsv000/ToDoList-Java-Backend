package com.ToDoDAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.ToDoModelObject.ToDoModelObject;
public class ToDoDAO {
	private String url="jdbc:mysql://localhost:3306/saitama";
    private String user="root";
    private String password="301112";
    Connection connection=null;
    private Connection generateCon()
    {
    	if(connection==null)
    	{
    		try {
    			Class.forName("com.mysql.jdbc.Driver");
				connection= DriverManager.getConnection(url,user,password);
			} catch (Exception e) {  }
    	}
    	return connection;
    }
    
    public int addToDo(ToDoModelObject t1)
    {
    	try {
    	Connection con=generateCon();
    	String title=t1.getTitle();
    	String description=t1.getDescription();
    	String status=t1.getStatus();
    	String date=t1.getDate();
    	String query="INSERT INTO todoList(title,description,status,date) VALUES(?,?,?,?)";
    	PreparedStatement st=con.prepareStatement(query);
    	st.setString(1, title);
    	st.setString(2,description );
    	st.setString(3, status);
    	st.setString(4, date);
    	return st.executeUpdate();
    	}catch(Exception e) {return 0;}
    }
    public List<ToDoModelObject> getTodoLists()
    {
    	try {
        	Connection con=generateCon();
        	String query="SELECT * FROM todoList";
        	PreparedStatement st=con.prepareStatement(query);
        	ResultSet rs=st.executeQuery();
        	List<ToDoModelObject> ans=new ArrayList<ToDoModelObject>();
        	while(rs.next())
        	{
        		ToDoModelObject t1=new ToDoModelObject();
        		t1.setId(rs.getInt(1));
        		t1.setTitle(rs.getString(2));
        		t1.setDescription(rs.getString(3));
        		t1.setStatus(rs.getString(4));
        		t1.setDate(rs.getString(5));
        		ans.add(t1);
        	}
        	return ans;
        	}catch(Exception e) {return new ArrayList<ToDoModelObject>();}
    }

	public int deleteToDo(int id) {
		try {
	    	Connection con=generateCon();
	    	String query="DELETE FROM todoList WHERE id=?";
	    	PreparedStatement st=con.prepareStatement(query);
	    	st.setInt(1, id);
	    	return st.executeUpdate();
	    	}catch(Exception e) {return 0;}
	}
	public ToDoModelObject getTodoList(int id)
    {
    	try {
    	Connection con=generateCon();
    	String query="SELECT * FROM todoList WHERE id=?";
    	PreparedStatement st=con.prepareStatement(query);
    	st.setInt(1, id);
    	ResultSet rs=st.executeQuery();
    	rs.next();
    	ToDoModelObject t1=new ToDoModelObject();
    	t1.setTitle(rs.getString(2));
    	t1.setDescription(rs.getString(3));
    	t1.setStatus(rs.getString(4));
    	t1.setDate(rs.getString(5));
    	return t1;
    	}catch(Exception e) {return new ToDoModelObject();}
    }

	public int updateToDo(ToDoModelObject t1) {
		try {
	    	Connection con=generateCon();
	    	int id=t1.getId();
	    	String title=t1.getTitle();
	    	String description=t1.getDescription();
	    	String status=t1.getStatus();
	    	String date=t1.getDate();
	    	String query="UPDATE todoList SET title=?, description=? ,status=? ,date=? WHERE id=?";
	    	PreparedStatement st=con.prepareStatement(query);
	    	st.setString(1, title);
	    	st.setString(2,description );
	    	st.setString(3, status);
	    	st.setString(4, date);
	    	st.setInt(5, id);
	    	return st.executeUpdate();
	    	}catch(Exception e) {return 0;}

		
	}
}
