package com.example.myproject.model;

import java.util.Arrays;

import com.example.myproject.Stock;

public class Portfolio {
	private String title = new String ("<h1> Portfolio </h1>");
	final static int MAX_PORTFOLIO_SIZE = 5;
	private Stock[] stocks;
	private int portfolioSize=0;
	
	public int getMaxPortfolioSize() {
		return MAX_PORTFOLIO_SIZE;
	}

	public void setStocks(Stock[] stocks) {
		this.stocks = stocks;
	}

	public Portfolio() {
		stocks = new Stock [MAX_PORTFOLIO_SIZE];
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void addStock (Stock stock){
		if(portfolioSize < MAX_PORTFOLIO_SIZE){
			stocks[portfolioSize] = stock;
			portfolioSize++;
		}
		else
			return;
	}

	public Stock[] getStocks() {
		return stocks;
	}
	
	public String getHtmlString() {
		String result="";
		for (int i=0; i<portfolioSize ; i++){
			result = result + (stocks[i].getHtmlDescription() + "<br>");
		}
			return (title+result);
	}
	
}
