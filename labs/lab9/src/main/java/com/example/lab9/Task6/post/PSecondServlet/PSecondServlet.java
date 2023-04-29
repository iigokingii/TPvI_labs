package com.example.lab9.Task6.post.PSecondServlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "PSecondServlet", value = "/PSecondServlet")
public class PSecondServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var mes = request.getAttribute("Mes");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2> Message from first servlet: \"" + mes.toString() + "\"</h2>");
        out.println("</body></html>");
        out.close();
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//task 6
		var mes = request.getAttribute("Mes");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h2> Message from first servlet: \"" + mes.toString() + "\"</h2>");
		out.println("</body></html>");
		out.close();
	}
}
