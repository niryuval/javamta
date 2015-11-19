package com.example.myproject;

public class MathCalc {
	static int radius, angleB, hypotenuse, base , exp;
	
	public MathCalc (int radiusValue, int angleBValue, int hypotenuseValue, int baseValue , int expValue)
	{
		radius = radiusValue;
		angleB = angleBValue;
		hypotenuse = hypotenuseValue;
		base = baseValue;
		exp = expValue;
	}
	
	public static double calcCircleArea ()
	{
		return Math.PI * Math.pow(radius,2);
	}
	
	public static double calcTriangle ()
	{
		return Math.sinh(Math.toRadians(angleB)) * hypotenuse;
	}

	public static double calcPow ()
	{
		return Math.pow (base , exp);
	}
	
	public static String getResults() 
	{
		String line1 = new String("calculation 1: Area of circle with radius " + radius + " is : " + calcCircleArea () + " square-cm");
		String line2 = new String("calculation 2: Length of opposite where angle B is " + angleB + " and hypotenuse is " + hypotenuse + " is: " + calcTriangle() + " cm");
		String line3 = new String("calculation 3: Power of " + base + " with the exp " + exp + " is: " + calcPow());
		String resultStr = line1 + "<br>" + line2 + "<br>" + line3;
		return resultStr;
	}	
}
	

