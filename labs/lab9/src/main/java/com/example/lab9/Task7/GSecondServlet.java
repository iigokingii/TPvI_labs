package com.example.lab9.Task7;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "GSecondServlet", value = "/GSecondServlet")
public class GSecondServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var num1 = (int)request.getAttribute("number1");
        num1++;
        request.setAttribute("number2", num1);
	}
}
