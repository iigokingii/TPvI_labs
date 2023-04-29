package com.example.lab9.Task7;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

public class GFirstServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var num1 = 5;
        request.setAttribute("number1", num1);
        //вызов 2сервлета
        request.getRequestDispatcher("/GSecondServlet").include(request, response);
        var num2 = request.getAttribute("number2");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>" + num2 + "</h2>");   // и получилось 6 вау
        out.println("</body></html>");
        out.close();
        
	}
 
}
