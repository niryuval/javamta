package com.example.myproject;
import java.io.IOException;
import javax.servlet.http.*;
import com.example.myproject.Exercise3_Servlet;
import com.example.myproject.MathCalc;

@SuppressWarnings("serial")
public class Test_projectServlet extends HttpServlet 
{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		resp.getWriter().println("Hello, world");
	}
}
