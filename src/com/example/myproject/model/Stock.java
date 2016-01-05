package com.example.myproject.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.algo.model.StockInterface;

/**
 * 
 * @author Yuval Chlebowski
 * Class used to define a stock.
 */
public class Stock implements StockInterface {
	public enum ALGO_RECOMMENDATION {BUY , SELL , REMOVE , HOLD , NOTHING};
	private String symbol;
	private float ask, bid;
	private Date date;
	private int stockQuantity;
	private ALGO_RECOMMENDATION recommendation;
		
	
	/**
	 * Stock c'tor
	 */
	public Stock(){
		date = new Date();
		recommendation = ALGO_RECOMMENDATION.NOTHING;
	}
	
	/**
	 * 
	 * @param symbol
	 * @param ask
	 * @param bid
	 * @param date
	 * @param stockQuantity
	 * @param recommendation
	 */
	public Stock(String symbol, float ask, float bid, Date date, ALGO_RECOMMENDATION recommendation) {
		setSymbol(symbol);
		setAsk(ask);
		setBid(bid);
		setDate(date);
		setRecommendation(recommendation);
	}
	


	/**
	 * 
	 * @param stock
	 *  Stock's copy constructor.
	 */
	public Stock(StockInterface stock) { 
		this(stock.getSymbol(), stock.getAsk(), stock.getBid(), stock.getDate(), ((Stock)stock).getRecommendation());
		Date tempDate = new Date(stock.getDate().getTime());
		setDate(tempDate);
		setStockQuantity(((Stock) stock).getStockQuantity());
	}
	
	@Override
	public String getSymbol() {
		return symbol;
	}
	
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	@Override
	public float getAsk() {
		return ask;
	}
	
	public void setAsk(float ask) {
		this.ask = ask;
	}
	
	@Override
	public float getBid() {
		return bid;
	}
	
	public void setBid(float bid) {
		this.bid = bid;
	}
	
	@Override
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public ALGO_RECOMMENDATION getRecommendation() {
		return recommendation;
	}

	public void setRecommendation(ALGO_RECOMMENDATION recommendation) {
		this.recommendation = recommendation;
	}

	/**
	 * 
	 * @return
	 * Returns HTML description of stock
	 */
	
	public synchronized String getHtmlDescription() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		String line = (" <b> Stock symbol: </b> " + getSymbol() + " <b> ask: </b> " + 
		getAsk() + " <b> bid: </b> " + getBid() + " <b> date: </b> " + 
		sdf.format(getDate()) + " <b> quantity: </b>" + getStockQuantity());
		return line;
	}
	

}
