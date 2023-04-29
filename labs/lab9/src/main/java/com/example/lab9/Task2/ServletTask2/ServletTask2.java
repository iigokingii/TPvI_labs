package com.example.lab9.Task2.ServletTask2;

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

@WebServlet(name = "ServletTask2", value = "/Servlet-Task2")
public class ServletTask2 extends HttpServlet {
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
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Date date = new Date();
		boolean isHere = false;
		this.users = dbcommands.GetList();
		
		String Login = request.getParameter("Login");
		String Password = request.getParameter("Password");
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter printer = response.getWriter();
		printer.println("<html><body>");
		Boolean isFind =false;
		String LoginCookie="Test",RoleCookie="Test",DateCookie="Starting Date" ;
		for (User user : users){
			if(user.GetLogin().equals(Login) && user.GetPassword().equals(Password)){
				request.setAttribute("Login",user.GetLogin());
				request.setAttribute("Role",user.GetRole());
				request.setAttribute("Date",date);
				isFind= true;
				LoginCookie = user.GetLogin();
				RoleCookie = user.GetRole();
				DateCookie = date.toString();
			}
		}
		//Task4(with Cookies)
		HttpSession session = request.getSession();
		Cookie cookielog = new Cookie("Login",LoginCookie);
		Cookie cookieRole = new Cookie("Role",RoleCookie);
		//Cookie cookieDate = new Cookie("Date",DateCookie);
		response.addCookie(cookieRole);
		response.addCookie(cookielog);
		//response.addCookie(cookieDate);
		if(isFind)
			request.getRequestDispatcher("/main.jsp").forward(request,response);
		else
			request.getRequestDispatcher("/registration.jsp").forward(request,response);
		printer.println("</body></html>");
		printer.close();
	}
	
}
