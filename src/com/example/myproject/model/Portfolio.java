package com.example.myproject.model;
import java.util.ArrayList;
import java.util.List;

import org.algo.model.PortfolioInterface;
import org.algo.model.StockInterface;
 


public class Portfolio implements PortfolioInterface {
		enum ALGO_RECOMMENDATION
		{
			BUY(0), SELL(1), REMOVE(2), HOLD(3);
			private int option_Num;
			private ALGO_RECOMMENDATION(int option_Num)
			{this.option_Num = option_Num;}
			public int getOption_Num() {return option_Num;}
			public static int getMaxPortfolioSize() {
				return MAX_PORTFOLIO_SIZE;
			}
		}
	
		public enum ERROR_MESSAGE
		{
			NEGATIVE_BALANCE("Insufficent funds to complete transaction."), 
			NEGATIVE_STOCK_QUANTITY("Not enough stocks to sell.");
			private String message_content;
			private ERROR_MESSAGE(String message_content)
			{this.message_content = message_content;}
			public String getMessage_Content() {return message_content;}
		}
		private static final int MAX_PORTFOLIO_SIZE = 5;
		private float balance;
		private String title = new String ();
		private ArrayList<StockInterface> stocks = new ArrayList<StockInterface>();

		
		public Portfolio(){
		}
		
      /**
       * copy constractor
       * @param stocks
       * @param title
       * @param balance
       */
       public Portfolio(ArrayList<StockInterface> stocks, String title, float balance){  // copy constructor
   		ArrayList<StockInterface> si = new ArrayList<StockInterface>(stocks.size());
   		for(StockInterface s1: stocks){
   			si.add(new Stock(s1));
   		}
   		this.stocks = si;
   		setTitle(title);
   		setBalance(balance);
        }
       
       /**
        * copy c'tor
        * @param portfolio
        */
       public Portfolio(Portfolio portfolio){
    	   portfolio.stocks = this.stocks;
    	   portfolio.title = this.title;
    	   portfolio.balance = this.balance;
       }
       
       /**
       *
       * Portfolio copy c'tor's overload.
       */
   	public Portfolio(List<Stock> stockList) {
		ArrayList<StockInterface> si = new ArrayList<StockInterface>(stockList.size());
		for(StockInterface s1: stockList){
			si.add(new Stock(s1));
		}
		this.stocks = si;
	}
		@Override
		public StockInterface[] getStocks(){
			StockInterface[] stockArray = new StockInterface[stocks.size()];
			stocks.toArray(stockArray);
			return stockArray;
		}

		
		/*
		public void setStocks(ArrayList<StockInterface> stocks) {
			this.stocks = stocks;
		}
		 */
 
       
 
        public ArrayList<StockInterface> getStock(){
                return stocks;
        }
       /**
        * 
        * @param index
        * Method removes a stock from the portfolio
        */
        public void removeFromList(int index){
        	
                stocks.remove(index);
        }
 
        public String getTitle() {
                return title;
        }
 
        public void setTitle(String string) {
                this.title = string;
        }
       
        /**
         * 
         * @param stock
         * Method used to add a stock to the portfolio.
         */
        public void addStock(StockInterface stock){
        	Boolean stockExists = false;
        	if(this.stocks.size() == 0){
        		((Stock) stock).setStockQuantity(0);
    			stocks.add(stock);
        	}
        	else{
	        	for (StockInterface stocks: this.stocks)
	        	{
	        		if(stocks.getSymbol() == stock.getSymbol())
	        		{
	        			stockExists = true;
	        		}
	        	}
        	}
        	if(!stockExists)
        	{
        		stocks.add(stock);
        	}
        
        }
      
       public float getBalance() {
			return this.balance;
		}

		public void setBalance(float balance) {
			this.balance = 0;
		}
		
		/**
		 * 
		 * @param amount
		 * Method used to update portfolio's balance.
		 */
		public void updateBalance(float amount)
		{
			if(balance + amount >= 0)
			{
				balance += amount; 
			}
			else
			{
				System.out.println(ERROR_MESSAGE.NEGATIVE_BALANCE);
			}
		}
		/**
		 * 
		 * @param symbol
		 * @return
		 * Method used to remove a stock from portfolio, by selling all stocks of the input symbol.
		 */
		public Boolean removeStock(String symbol)
		{
			Boolean stockExists = false, operationSuccessful = false;
			int i=0;
        	for (StockInterface stocks: stocks)
        	{
        		
        		if (stocks.getSymbol().equals(symbol))
        		{
        			stockExists = true;
        			continue;
        		}
        		i++;
        	}
        	if(stockExists)
        	{
        		operationSuccessful = stockExists && sellStock(symbol, -1);
    			stocks.remove(i);
        	}
        	return operationSuccessful;
		}
		
		/**
		 * 
		 * @param symbol
		 * @param quantity
		 * @return
		 * Method used to sell stocks of input symbol by quantity.
		 */
		public Boolean sellStock(String symbol, int quantity)
		{
			Boolean operationSuccessful = false;
			for(StockInterface stocks: stocks)
			{
				if(stocks.getSymbol().equals(symbol))
				{
					if(quantity == -1)
					{
						updateBalance(stocks.getBid()*((Stock)stocks).getStockQuantity());
						((Stock)stocks).setStockQuantity(0);
						operationSuccessful = true;
					}
					
					else if(quantity > ((Stock)stocks).getStockQuantity())
					{
						operationSuccessful = false;
					}
					
					else
					{
						updateBalance(stocks.getBid()*quantity);
						((Stock)stocks).setStockQuantity((((Stock) stocks).getStockQuantity() - quantity));
						operationSuccessful = true;
					}
				}
			}
			if(!operationSuccessful)
			{
				System.out.println(ERROR_MESSAGE.NEGATIVE_STOCK_QUANTITY);
			}
			return operationSuccessful;
		}
		
		/**
		 * 
		 * @param stock
		 * @param quantity
		 * @return
		 * Method used to buy stocks of input symbol by quantity.
		 */
		public Boolean buyStock(StockInterface stock, int quantity)
		{
			Boolean operationSuccessful = false, stockExists = false;
			int actualQuantity;
			for(StockInterface stocks: stocks)
			{
				if(stocks.getSymbol() == stock.getSymbol())
				{
					stockExists = true;
					continue;
				}
			}
			if(!stockExists)
			{
				stocks.add(stock);
			}
			
			for(StockInterface stocks: stocks)
			{
				if(stocks.getSymbol() == stock.getSymbol())
				{
					if(quantity == -1)
					{
						actualQuantity = (int)(getBalance()/stocks.getAsk());
						updateBalance(stocks.getAsk()*actualQuantity*(-1));
						((Stock) stocks).setStockQuantity(((Stock) stocks).getStockQuantity()+actualQuantity);
						operationSuccessful = true;
					}
					
					else if(quantity*stocks.getAsk() > getBalance())
					{
						operationSuccessful = false;
						
					}
					
					else
					{
						if(stocks.getAsk()*quantity <= getBalance())
						{
							updateBalance(stocks.getAsk()*quantity*(-1));
							((Stock) stocks).setStockQuantity(((Stock) stocks).getStockQuantity() + quantity);
							operationSuccessful = true;
						}
						else
						{
							System.out.println(ERROR_MESSAGE.NEGATIVE_BALANCE);
						}
					}
					continue;
				}
			}
			return operationSuccessful;
		}
		
		/**
		 * 
		 * @return
		 * Method used to retrieve the total value of all stocks in portfolio.
		 */
		public float getStocksValue()
		{
			float sum = 0;
			for(StockInterface stocks: stocks)
			{
				sum += stocks.getBid()*((Stock) stocks).getStockQuantity();
			}
			return sum;
		}
		
		
		public Stock findStock(String symbol){
			Stock s1 = null;
			for(StockInterface s: this.stocks){
				if(s.getSymbol().equals(symbol)){
					s1 = (Stock) s;
					break;
				}
			}
			return s1;
		}
		
		public static int getMaxSize(){
			return MAX_PORTFOLIO_SIZE;
		}
		
		
		/**
		 * 
		 * @return
		 * Method used to return the total value of all portfolio assets(stocks and balance).
		 */
		public float getPortfolioValue()
		{
			float value = (getStocksValue() + getBalance());
			return value;
		}

	/**
        * 
        * @return
        * Method returns a HTML string of stocks.
        */
        public String getHtmlString() {
                String result = "";
                result = (result + "<br></br>" + "Total Portfolio Value: " + getPortfolioValue() + "$" + "<br></br>"
                + "Total Stocks Value: " + getStocksValue() + "$" + "<br></br>" 
                + "Total Portfolio Balance: " + getBalance() + "$" + "<br></br>");
                for(StockInterface stocks: stocks){
                        result = (result + ((Stock) stocks).getHtmlDescription() + "<br></br>");
                }
                return (title+result);
        }
       
        
        
        
}

       
