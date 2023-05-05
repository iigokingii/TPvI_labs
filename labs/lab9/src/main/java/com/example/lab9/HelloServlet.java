package com.example.lab9;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
//netstat -ano | findstr :8080
//taskkill /PID 7364 /F
/*
* <p><a href="'<c:url value ="#"/>'">Create New</a></p>
        <table>
            <tr>
                <th>Name</th>
                <th>Surname</th>
                <th>Server</th>
            </tr>
            <c:forEach var ="user" items ="${users}">
                <tr>
                    <td>${user.Name}</td>
                    <td>${user.Surname}</td>
                    <td>${user.Server}</td>
                </tr>
            </c:forEach>
        </table>
*
* */





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
	}
	
	public void destroy() {
	}
}