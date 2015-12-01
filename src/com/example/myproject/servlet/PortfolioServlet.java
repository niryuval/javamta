package com.example.myproject.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.myproject.model.Portfolio;
import com.example.myproject.service.PortfolioManager;

public class PortfolioServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		PortfolioManager portfolioManager = new PortfolioManager();
		Portfolio portfolio = portfolioManager.getPortfolio();
		resp.getWriter().println(portfolio.getHtmlString());
	}
}