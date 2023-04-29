package com.example.lab9.Task6.post.PFirstServlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "PFirstServlet", value = "/PFirstServlet")
public class PFirstServlet extends HttpServlet {
    String message;
    public void init() {
        message = "Hello from servlet one";
    }
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("Mes",message);
        request.getRequestDispatcher("/FSecond-Servlet").forward(request,response);
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("Mes",message);
		request.getRequestDispatcher("/PSecondServlet").forward(request,response);
	}
}
