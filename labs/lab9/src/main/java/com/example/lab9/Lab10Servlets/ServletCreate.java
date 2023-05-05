package com.example.lab9.Lab10Servlets;

import com.example.lab9.Task2.classes.DBCommands;
import com.example.lab9.Task2.classes.Database;
import com.example.lab9.Task2.classes.Stud_Serv;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletCreate", value = "/Servlet-Create")
public class ServletCreate extends HttpServlet {
    DBCommands dbcommands;
    @Override
    public void init() throws ServletException {
        String driver ="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url="jdbc:sqlserver://GOKING;databaseName=LAB9_10_TPvI;trustServerCertificate=true;encrypt=false;IntegratedSecurity=false";
        String username = "sa";
        String password = "1111";
        Database db = new Database(driver,url,username,password);
        this.dbcommands = new DBCommands(db);
        super.init();
    }
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    getServletContext().getRequestDispatcher("/create.jsp").forward(request,response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String name =request.getParameter("name");
        String surname = request.getParameter("surname");
        String server = request.getParameter("server");
        int id = dbcommands.GetListStud().size();
        id++;
        Stud_Serv student = new Stud_Serv(id,name,surname,server);
        dbcommands.addStud(student);
		response.sendRedirect(request.getContextPath()+"/main.jsp");
	}
}
