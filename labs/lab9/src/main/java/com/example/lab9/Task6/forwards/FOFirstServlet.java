package com.example.lab9.Task6.forwards;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "FOFirstServlet", value = "/FOFirstServlet")
public class FOFirstServlet extends HttpServlet {
    String message;
    public void init() {
        message = "Wassup homie";
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        request.setAttribute("Mes",message);
        request.getRequestDispatcher("/FOSecondServlet").forward(request,response);
    }
}
