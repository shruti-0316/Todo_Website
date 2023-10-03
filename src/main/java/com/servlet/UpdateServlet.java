package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.TodoDAO;
import com.DB.DBConnect;
import com.entity.ToDoDetails;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String username = req.getParameter("username");
		String todo = req.getParameter("todo");
		String status = req.getParameter("status");
		
		TodoDAO dao = new TodoDAO(DBConnect.getConn());
		ToDoDetails t = new ToDoDetails();
		t.setId(id);
		t.setName(username);
		t.setTodo(todo);
		t.setStatus(status);
		
		boolean f = dao.updateTodo(t);
		HttpSession session = req.getSession();
		if(f) {
			session.setAttribute("sucMsg", "ToDo update successfully");
			resp.sendRedirect("index.jsp");
		}
		else {
			session.setAttribute("failed", "something wrong on something");
			System.out.println("index.jsp");

		}	
	
	}

}
