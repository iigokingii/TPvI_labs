package com.example.lab9.Task3;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletCookie", value = "/Servlet-Cookie")
public class ServletCookie extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        
        Cookie[] cookies = request.getCookies();
        String cookielogin = "Login";
        String cookieRole = "Role";
        String cookieDate = "Date";
        Cookie CookieLogin = null;
        Cookie CookieRole = null;
		Cookie CookieDate = null;
        if(cookies!=null){
            for (Cookie cookie : cookies){
                if(cookielogin.equals(cookie.getName())){
                    CookieLogin = cookie;
                }
                if(cookieRole.equals(cookie.getName())){
                    CookieRole = cookie;
                }
				if(cookieDate.equals(cookie.getName())){
					CookieDate = cookie;
				}
            }
        }
        PrintWriter writer = response.getWriter();
        writer.println("<html><body>");
        writer.println("<h1>Information from Cookies:</h1>");
		
		if(CookieLogin!=null)
        writer.println("<h3>Login: "+CookieLogin.getValue()+ "</h3>");
		if(CookieRole!=null)
        writer.println("<h3>Role: " +CookieRole.getValue()+"</h3>");
		if(CookieDate!=null)
		writer.println("<h3>Date: " +CookieDate.getValue()+"</h3>");
		
        writer.println("</body></html>");
		writer.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
}
