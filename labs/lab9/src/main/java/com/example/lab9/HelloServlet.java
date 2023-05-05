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
*
*
*
*
*
*
* <c:forEach var ="user" items ="${usersFromDb}">
            <tr>
                <td>${user.getName()}</td>
                <td>${user.getSurname()}</td>
                <td>${user.getServer()}</td>
                <td>
                    <a href='<c:url value="/edit?id=${product.id}" />'>Edit</a>
                    <form method="post" action='<c:url value="/delete" />'>
                        <input type="submit" value="Delete">
                    </form>
                </td>
            </tr>
        </c:forEach>
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