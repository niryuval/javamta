package com.example.myproject;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Date;

import com.example.myproject.stock;

public class StockDetailsServlet extends HttpServlet 
{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		resp.setContentType("text/html");
		
		java.util.Date date1 = null;
		date1 = new Date(date1.getTime());
		stock stock1 = new stock("PIH",(float)13.1,(float)12.4, date1);
		String resultStr = stock1.getDetails();
		resp.getWriter().println(resultStr);
	}
}



