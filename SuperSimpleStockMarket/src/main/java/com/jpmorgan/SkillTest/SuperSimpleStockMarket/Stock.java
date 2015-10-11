package com.jpmorgan.SkillTest.SuperSimpleStockMarket;

/**
 * Abstract class for Stock with base components
 * 
 * @author Eric Mandrillon
 * @version 1.0
 */
public abstract class Stock {

	private double lastDividend;
	private double fixedDividend;
	private double parValue;
	private String stockSymbol;

	public double getLastDividend() {
		return lastDividend;
	}

	public void setLastDividend(double lastDividend) {
		this.lastDividend = lastDividend;
	}

	public double getFixedDividend() {
		return fixedDividend;
	}

	public void setFixedDividend(double fixedDividend) {
		this.fixedDividend = fixedDividend;
	}

	public double getParValue() {
		return parValue;
	}

	public void setParValue(double parValue) {
		this.parValue = parValue;
	}

	public String getStockSymbol() {
		return stockSymbol;
	}

	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}

	/**
	 * Constructor for super stock
	 * 
	 * @param stockSymbol
	 * @param lastDividend
	 * @param parValue
	 */
	public Stock(String stockSymbol, double lastDividend, double parValue) {

		this.setStockSymbol(stockSymbol);
		this.setLastDividend(lastDividend);
		this.setParValue(parValue);
	}

	/**
	 * Abstract method use to calculate the dividend yield
	 * 
	 * @param price
	 * @return
	 */
	public abstract double dividendYield(double price);

	/**
	 * Calculate the P/E Ratio
	 * 
	 * @param price
	 * @return
	 */
	public double PERatio(double price) {
		return price / this.getLastDividend();
	}

}
