package com.example.lab9.Task6.forwards;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "FOSecondServlet", value = "/FOSecondServlet")
public class FOSecondServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var mes = request.getAttribute("Mes");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2> Message from first FOservlet: \"" + mes.toString() + "\"</h2>");
        out.println("</body></html>");
        out.close();
    }
}
