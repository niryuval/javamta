package com.example.myproject;

import java.util.Date;


public class stock {
	private String symbol;
	private float ask, bid;
	private java.util.Date dateS;
	
	public stock(String symbol, float ask, float bid, Date date) {
		setSymbol(symbol);
		setAsk(ask);
		setBid(bid);
		setDate(date);
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public float getAsk() {
		return ask;
	}
	public void setAsk(float ask) {
		this.ask = ask;
	}
	public float getBid() {
		return bid;
	}
	public void setBid(float bid) {
		this.bid = bid;
	}
	public java.util.Date getDate() {
		return dateS;
	}
	public void setDate(java.util.Date date) {
		this.dateS = date;
	}
	public String getDetails()
	{
		String line1 = new String("Stock Symbol: " + getSymbol());
		String line2 = new String("Stock Ask price: " + getAsk());
		String line3 = new String("Stock Bid price: " + getBid());
		String line4 = new String("Stock Date price: " + getDate());
		String resultStr = line1 + "<br>" + line2 + "<br>" + line3 + "<br>" + line4;
		return resultStr;
	}
	
	
}
