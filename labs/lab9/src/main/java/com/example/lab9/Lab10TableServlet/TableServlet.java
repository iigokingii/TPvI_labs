package com.example.lab9.Lab10TableServlet;

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

@WebServlet(name = "TableServlet", value = "/Table-Servlet")
public class TableServlet extends HttpServlet {
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
        List<Stud_Serv> users = dbcommands.GetListStud("STUD_SERV");
		request.setAttribute("users",users);
		getServletContext().getRequestDispatcher("/main.jsp").forward(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
