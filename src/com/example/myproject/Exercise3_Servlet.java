package com.example.myproject;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.myproject.MathCalc;

public class Exercise3_Servlet extends HttpServlet 
{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		resp.setContentType("text/html");
		
		
		MathCalc mathCalc = new MathCalc(50, 30, 50, 20, 13);
		String resultStr = MathCalc.getResults();
		resp.getWriter().println(resultStr);
	}
}



