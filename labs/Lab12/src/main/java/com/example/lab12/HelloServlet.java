package com.example.lab12;

import java.io.*;

import javax.servlet.http.*;
import javax.servlet.annotation.*;
//netstat -ano | findstr :8080
//taskkill /PID 7364 /F
@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
	private String message;
	
	public void init() {
		message = "Hello World!";
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		
		// Hello
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h1>" + message + "</h1>");
		out.println("</body></html>");
		
		request.setAttribute("Mess","<h1>Hello From Servlet1</h1>");
	}
	
	public void destroy() {
	}
}