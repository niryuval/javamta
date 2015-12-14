package com.example.myproject.model;
import java.util.ArrayList;
 
 
public class Portfolio {
        private String title = new String ();
        private ArrayList<Stock> stocks = new ArrayList<Stock>();
       
        /**
         *
         * Portfolio c'tor
         */
        public Portfolio(ArrayList<Stock> stocks, String title) {
                this.stocks = new ArrayList<Stock>(stocks);
                this.title = title;
        }
       
        /**
         *
         * Copy c'tor of Portfolio
         */
        public Portfolio (Portfolio portfolio){
                ArrayList<Stock> arr = new ArrayList<Stock>(portfolio.stocks.size());
                        for (Stock stock: portfolio.stocks){
                        arr.add(new Stock(stock));
                        }
                this.stocks = arr;
                setTitle(portfolio.getTitle());
        }
 
        public Portfolio() {
        }
 
        public ArrayList<Stock> getStock(){
                return stocks;
        }
       
        public void removeFromList(int index){
                stocks.remove(index);
        }
 
        public String getTitle() {
                return title;
        }
 
        public void setTitle(String title) {
                this.title = title;
        }
       
        public void addStock(Stock stock){
                stocks.add(stock);
        }
       
        public String getHtmlString() {
                String result = "";
                for(Stock stocks: stocks){
                        result = (result + stocks.getHtmlDescription() + "<br></br>");
                }
                return (title+result);
        }
       
}