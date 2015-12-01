package com.example.myproject.service;
import java.util.Date;
import com.example.myproject.Stock;
import com.example.myproject.model.Portfolio;

public class PortfolioManager {

	private Portfolio portfolio = new Portfolio();
	public Portfolio getPortfolio(){
		Portfolio portfolio = new Portfolio();
		Stock stock1 = new Stock ("PIH" , 13.1f , 12.4f ,new Date("11/15/2015"));
		portfolio.addStock(stock1);
		Stock stock2 = new Stock ("AAL" , 5.78f , 5.5f ,new Date("11/15/2015"));
		portfolio.addStock(stock2);
		Stock stock3 = new Stock ("CAAS" , 32.2f , 31.5f ,new Date("11/15/2015"));
		portfolio.addStock(stock3);
		return portfolio;
	}
}


