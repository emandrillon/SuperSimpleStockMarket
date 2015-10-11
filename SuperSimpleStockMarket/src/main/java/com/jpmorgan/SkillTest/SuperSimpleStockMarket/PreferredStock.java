package com.jpmorgan.SkillTest.SuperSimpleStockMarket;

/**
 * Preferred Stock with specific method
 * 
 * @see Stock
 * @author Eric Mandrillon
 * @version 1.0
 */
public class PreferredStock extends Stock {

	/**
	 * Constructor for preferred Stock
	 * 
	 * @param stockSymbol
	 * @param lastDividend
	 * @param fixedDividend
	 * @param parValue
	 */
	public PreferredStock(String stockSymbol, double lastDividend, double fixedDividend, double parValue) {
		super(stockSymbol, lastDividend, parValue);

		setFixedDividend(fixedDividend);
	}

	/**
	 * Calculate the dividend yield for preferred stock
	 * 
	 * @param price
	 */
	@Override
	public double dividendYield(double price) {
		return getFixedDividend() * getParValue() / price;

	}

}
