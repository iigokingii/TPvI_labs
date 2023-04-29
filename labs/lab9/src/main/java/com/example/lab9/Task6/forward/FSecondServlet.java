package com.example.lab9.Task6.forward;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "FSecondServlet", value = "/FSecond-Servlet")
public class FSecondServlet extends HttpServlet {
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
