package com.example.lab9.Lab10Servlets;

import com.example.lab9.Task2.classes.DBCommands;
import com.example.lab9.Task2.classes.Database;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DeleteServlet", value = "/Delete-Servlet")
public class DeleteServlet extends HttpServlet {
	DBCommands dbcommands;
	public void init(){
		String driver ="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url="jdbc:sqlserver://GOKING;databaseName=LAB9_10_TPvI;trustServerCertificate=true;encrypt=false;IntegratedSecurity=false";
		String username = "sa";
		String password = "1111";
		Database db = new Database(driver,url,username,password);
		this.dbcommands = new DBCommands(db);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			dbcommands.deleteStud(id);
			response.sendRedirect(request.getContextPath()+"/main.jsp");
		}
		catch(Exception ex) {
			getServletContext().getRequestDispatcher("/notFound.jsp").forward(request, response);
		}
		
	}
}
