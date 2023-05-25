package Task2;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.taglibs.standard.extra.spath.Step;

import java.io.IOException;

@WebServlet(name = "Task2Servlet", value = "/Task2-Servlet")
public class Task2Servlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        //a
		request.setAttribute("Mess","<h1>Hello From Servlet1</h1>");
		request.setAttribute("isVisible",true);
		request.setAttribute("val",3);
		String[]users = new String[]{"Maksim","Alexey","Aleksander"};
		request.setAttribute("users",users);
		//b
		
        getServletContext().getRequestDispatcher("/Task2.jsp").forward(request,response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
}
