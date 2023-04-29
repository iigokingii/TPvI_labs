package com.example.lab9.Task1Servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;

@WebServlet(name = "DemoServlet", value = "/Demo-servlet")
public class DemoServlet extends HttpServlet {
    public DemoServlet() {
        super();
    }
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("init");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse
            response)
            throws ServletException, IOException {
        Date date = new Date();
        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>Task1</h1>");
        response.getWriter().println("<h3>Current date and time: "+date.toString()+"</h3>");
        response.getWriter().println("<h3>Information about client:"+"</h3>");
        response.getWriter().println("<h3>Protocol :"+request.getProtocol()+"</h3>");
        response.getWriter().println("<h3>IP adress: "+request.getRemoteAddr()+"</h3>");
        response.getWriter().println("<h3>Name: "+request.getRemoteHost()+ request.getRemoteUser()+"</h3>");
        response.getWriter().println("<h3>Method: "+request.getMethod()+"</h3>");
        response.getWriter().println("<h3>URL: "+request.getRequestURL()+"</h3>");
        response.getWriter().println("<h3>Information about headers:"+"</h3>");
        //response.getWriter().println("b)");
        Enumeration<String> temp = request.getHeaderNames();
        while (temp.hasMoreElements()){
            String name = temp.nextElement();
            String value = request.getHeader(name);
            response.getWriter().println(name + " --> " + value);
        }
        response.getWriter().println("</body></html>");
    
    }
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        Date date = new Date();
        
        
        response.setContentType("text/html");
        response.getWriter().println("Task1\na)");
        response.getWriter().println("\tCurrent date and time: "+date.toString());
        response.getWriter().println("\tInformation about client:");
        response.getWriter().println("\tProtocol :"+request.getProtocol());
        response.getWriter().println("\tIP adress: "+request.getRemoteAddr());
        response.getWriter().println("\tName: "+request.getRemoteHost()+ request.getRemoteUser());
        response.getWriter().println("\tMethod: "+request.getMethod());
        response.getWriter().println("\tURL: "+request.getRequestURL());
        response.getWriter().println("\tInformation about headers:");
        response.getWriter().println("b)");
        Enumeration<String> temp = request.getHeaderNames();
        while (temp.hasMoreElements()){
            String name = temp.nextElement();
            String value = request.getHeader(name);
            response.getWriter().println(name + " --> " + value);
        }
        
    }
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        super.service(req, res);
        System.out.println("service");
    }
    public void destroy() {
        super.destroy();
        System.out.println("destroy");
    }


}
