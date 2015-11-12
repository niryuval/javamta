package com.example.myproject;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Exercise3 extends HttpServlet 
{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		String line1 = new String("calculation 1: Area of circle with radius 50 is : " + calcCircleArea (50));
		String line2 = new String("calculation 2: Length of opposite where angle B is 30, is: " + calcTriangle(30));
		String line3 = new String("calculation 3: Power of 20 with exp of 12 is: " + calcPow(20,12));
		String resultStr = line1 + "<br>" + line2 + "<br>" + line3;
		resp.getWriter().println(resultStr);
}

	public static double calcCircleArea (int x)
	{
		int radious = x;
		double result;
		result = Math.pow(radious, 2) * Math.PI;
		return result;
	}
	
	public static double calcTriangle (double x)
	{
		double opposite;
		int hypotenuse = 50;
		double angleB = Math.toRadians(x);
		opposite = Math.sinh(angleB) * hypotenuse;
		return opposite;
	}
	
	public static int calcPow (int x, int y)
	{
		int result;
		int base = x;
		int exp = y;
		result = (int)Math.pow(base, exp);
		return result;
	}
}



