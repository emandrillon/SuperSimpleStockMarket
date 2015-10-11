package com.jpmorgan.SkillTest.SuperSimpleStockMarket;

/**
 * Common Stock with specific method
 * 
 * @see Stock
 * @author Eric Mandrillon
 * @version 1.0
 */
public class CommonStock extends Stock {

	/**
	 * Constructor for common Stock
	 * 
	 * @param stockSymbol
	 * @param lastDividend
	 * @param parValue
	 */
	public CommonStock(String stockSymbol, double lastDividend, double parValue) {
		super(stockSymbol, lastDividend, parValue);

	}

	/**
	 * Calculate the dividend yield for common stock
	 * 
	 * @param price
	 */
	@Override
	public double dividendYield(double price) {
		return getLastDividend() / price;

	}

}
