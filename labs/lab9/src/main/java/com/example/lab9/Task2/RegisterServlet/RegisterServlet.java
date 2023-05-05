package com.example.lab9.Task2.RegisterServlet;

import com.example.lab9.Task2.classes.DBCommands;
import com.example.lab9.Task2.classes.Database;
import com.example.lab9.Task2.classes.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "RegisterServlet", value = "/Register-Servlet")
public class RegisterServlet extends HttpServlet {
	private DBCommands dbcommands;
	public List<User> users = new ArrayList<>();
	public void init(){
		String driver ="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url="jdbc:sqlserver://GOKING;databaseName=LAB9_10_TPvI;trustServerCertificate=true;encrypt=false;IntegratedSecurity=false";
		String username = "sa";
		String password = "1111";
		Database db = new Database(driver,url,username,password);
		this.dbcommands = new DBCommands(db);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		response.setCharacterEncoding("UTF-8");
		String Login = request.getParameter("Login");
		String Password = request.getParameter("Password");
		boolean find = false;
		if(Login.equals("") || Password.equals("")){
			response.sendRedirect("registration.jsp?error=true&Message=Имя пользователя уже используется");
		}
		else{
			List<User>users = dbcommands.GetList();
			for (User user:users) {
				if(user.GetLogin().equals(Login)){
					find = true	;
				}
			}
			if(find)
				response.sendRedirect("registration.jsp?error=true&Message=Имя пользователя уже используется");
			else{
				dbcommands.addUser(Login,Password);
//		writer.println("<html><body>");
//		writer.println("<h1>You're registrated</h1>");
//		writer.println("</body></html>");
				request.getRequestDispatcher("/login.jsp").forward(request,response);
			}
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
}
