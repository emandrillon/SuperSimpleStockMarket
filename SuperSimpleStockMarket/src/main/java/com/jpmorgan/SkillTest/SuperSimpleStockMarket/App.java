package com.jpmorgan.SkillTest.SuperSimpleStockMarket;

import java.util.ArrayList;
import java.util.Random;

import com.jpmorgan.SkillTest.SuperSimpleStockMarket.Enum.TypeTrade;

/**
 *Main
 *
 */
public class App 
{
	public static void main( String[] args )
    {
    	ArrayList<Stock> stockList = new ArrayList<Stock>();
    	Random random = new Random();
    	
    	stockList.add(new CommonStock("TEA",0d,100d));
    	stockList.add(new CommonStock("POP",8d,100d));
    	stockList.add(new CommonStock("ALE",23d,60d));
    	stockList.add(new PreferredStock("GIN", 8d, 0.02d, 100d));
    	stockList.add(new CommonStock("JOE",13d,250d));
    	
    	// Dividend yield
    	System.out.println("Dividend yield");
    	for (Stock stock : stockList){
    		System.out.println(stock.getStockSymbol() + ": " + stock.dividendYield(random.nextInt(50)));
    	}
		
    	// P/E Ratio
    	System.out.println("");
    	System.out.println("P/E Ratio");
    	for (Stock stock : stockList){
    		System.out.println(stock.getStockSymbol() + ": " + stock.PERatio(random.nextInt(50)));
    	}
    	
    	//Trade
    	TradeRecorder tradeRecorder = new TradeRecorder();
    	for(int i = 1; i <= 100; i++){    	
    		tradeRecorder.addTrade(new Trade(stockList.get(new Random().nextInt(5)), random.nextInt(500)+1, random.nextBoolean()?TypeTrade.buy:TypeTrade.sell, random.nextInt(500)+1));
    	}
    	
    	//StockPrice
    	System.out.println("");
    	System.out.println("Volume Weighted Stock Price");
    	for (Stock stock : stockList){
    		System.out.println(stock.getStockSymbol() + ": " + tradeRecorder.computeVolumeWeightedStockPrice(stock));
    	}
    	
    	//GBCE
    	System.out.println("");
    	System.out.println("GBCE All Share Index: " + tradeRecorder.computeGBCE());
    }
}
