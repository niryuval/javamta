package com.example.myproject.servlet;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.algo.service.ServiceManager;

import com.example.myproject.service.PortfolioManager;

@SuppressWarnings("serial")
public class InitServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		super.init();
		PortfolioManager pm = new PortfolioManager();
		ServiceManager.setPortfolioManager(pm);
	}
}
	
