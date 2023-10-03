package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.ToDoDetails;
//this is used to add data in database
public class TodoDAO {
   private Connection con;

public TodoDAO(Connection con) {
	super();
	this.con = con;
}
   public boolean addTodo(String name,String todo,String status)
   {
	   boolean f = false;
	   try {
		   String query = "insert into todo_app(name,todo,status) values(?,?,?)";
		   PreparedStatement pstm = con.prepareStatement(query);
		   pstm.setString(1, name);
		   pstm.setString(2, todo);
		   pstm.setString(3, status);
		   int i = pstm.executeUpdate();
		   if(i==1) {
			   f = true;
		   }else {
			   f= false;
		   }
	   }
	   catch (Exception e) {
		// TODO: handle exception
		   e.printStackTrace();
	}
	   return f;
}
   
   public List<ToDoDetails> getTodo(){
	   List<ToDoDetails> list = new ArrayList<>();
	   ToDoDetails t = null;
	   
	   try {
		   String query = "select * from todo_app";
		   PreparedStatement pstm = con.prepareStatement(query);
		   ResultSet rs = pstm.executeQuery();
		   while(rs.next()) {
			   t = new ToDoDetails();
			   t.setId(rs.getInt(1));
			   t.setName(rs.getString(2));
			   t.setTodo(rs.getString(3));
			   t.setStatus(rs.getString(4));
			   list.add(t);
		   }
	   }
	   catch(Exception e) {
		   e.printStackTrace();
	   }
	   return list;
   }
   
   public ToDoDetails getTodoById(int id) {
	   ToDoDetails t = null;
	  try {
		  String query = "select * from todo_app where id=?";
		   PreparedStatement pstm = con.prepareStatement(query);
		   pstm.setInt(1, id);
		   ResultSet rs = pstm.executeQuery();
		   while(rs.next()) {
			   t = new ToDoDetails();
			   t.setId(rs.getInt(1));
			   t.setName(rs.getString(2));
			   t.setTodo(rs.getString(3));
			   t.setStatus(rs.getString(4));
			   
		   }
	  }catch(Exception e) {
		  e.printStackTrace();
	  }
	  return t;
   }
   
   
   
   public boolean updateTodo(ToDoDetails t) {
	   boolean f = false;
	   try {
		   String query = "update todo_app set name=?,todo=?,status=? where id=? ";
		   PreparedStatement pstm = con.prepareStatement(query);
		   pstm.setString(1, t.getName());
		   pstm.setString(2, t.getTodo());
		   pstm.setString(3, t.getStatus());
		   pstm.setInt(4, t.getId());
		    int i = pstm.executeUpdate();
		    if(i==1) {
		    	f= true;
		    }else {
		    	f = false;
		    }
	   }catch (Exception e) {
		// TODO: handle exception
		   e.printStackTrace();
	}
	   return f;
   }
   
   public boolean deleteTodo(int id) {
	   boolean f = false;
	   
	   try {
		String query  = "delete from todo_app where id=?";
		PreparedStatement pstm = con.prepareStatement(query);
		pstm.setInt(1, id);
		int i = pstm.executeUpdate();
		if(i == 1) {
			f = true;
		}else {
			f = false;
		}
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	   return f;
   }
   
}