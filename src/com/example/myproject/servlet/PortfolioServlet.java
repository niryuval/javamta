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
               
                Portfolio portfolio1 = portfolioManager.getPortfolio();
                portfolio1.setTitle("<h1> Portfolio #1</h1>");
               
                Portfolio portfolio2 =  new Portfolio (portfolio1);
                portfolio2.setTitle("<h1> Portfolio #2</h1>");
               
                resp.getWriter().println(portfolio1.getHtmlString() + portfolio2.getHtmlString());
               
                portfolio1.removeFromList(0);
                resp.getWriter().println(portfolio1.getHtmlString() + portfolio2.getHtmlString());
                portfolio2.getStock().get(2).setBid(55.55f);
                resp.getWriter().println(portfolio1.getHtmlString() + portfolio2.getHtmlString());
        }
}