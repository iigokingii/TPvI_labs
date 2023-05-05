package com.example.lab9.Lab10Servlets;

import com.example.lab9.Task2.classes.DBCommands;
import com.example.lab9.Task2.classes.Database;
import com.example.lab9.Task2.classes.Stud_Serv;
import com.example.lab9.Task2.classes.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletEdit", value = "/Servlet-Edit")
public class ServletEdit extends HttpServlet {
	private DBCommands dbcommands;

	public void init(){
		String driver ="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url="jdbc:sqlserver://GOKING;databaseName=LAB9_10_TPvI;trustServerCertificate=true;encrypt=false;IntegratedSecurity=false";
		String username = "sa";
		String password = "1111";
		Database db = new Database(driver,url,username,password);
		this.dbcommands = new DBCommands(db);
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Stud_Serv student = dbcommands.getStud_Serv(id);
		if(student!=null){
			request.setAttribute("student",student);
			getServletContext().getRequestDispatcher("/edit.jsp").forward(request, response);
		}
		else {
			getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String server = request.getParameter("server");
		int id = dbcommands.GetListStud().size();
		id++;
		Stud_Serv student = new Stud_Serv(id,name,surname,server);
		dbcommands.update(student);
		response.sendRedirect(request.getContextPath()+"/main.jsp");
	}
}
