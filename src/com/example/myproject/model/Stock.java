package com.example.myproject.model;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author nir
 *	This Class is creation of Stock Object
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Stock {
	private String symbol;
	private float ask, bid;
	private Date date = new Date();
	private SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	private int recommendation , stockQuantity;
	final private int BUY=0 , SELL = 1 , REMOVE = 2 , HOLD = 3;
	

	/**
	 * Stock c'tor
	 */
	public Stock(String symbol, float ask, float bid, Date date) {
		this.symbol = symbol;
		this.ask = ask;
		this.bid = bid;
		this.date = date;
	}
	
	/**
	 * Copy c'tor of stock
	 */
	public Stock (Stock stock){
		symbol = stock.symbol;
		ask = stock.ask;
		bid = stock.bid;
		date = stock.date;
	}
	
	
	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	/**
	 * return Html description of stock.
	 */
	public String getHtmlDescription() {
		String line = ("<b> Stock symbol: </b> " + getSymbol() + " <b> ask: </b> " 
				+ getAsk() + " <b> bid: </b> " + getBid() + " <b> date: </b> " 
				+ sdf.format(getDate()));
		return line;
	}

}
