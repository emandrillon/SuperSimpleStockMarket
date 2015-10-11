package com.jpmorgan.SkillTest.SuperSimpleStockMarket;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Tools to record trade and compute for statistics results
 * 
 * @author Eric Mandrillon
 *
 */
public class TradeRecorder {

	private ArrayList<Trade> tradeList;

	/**
	 * Constructor : Init the record list of trades
	 */
	public TradeRecorder() {
		tradeList = new ArrayList<Trade>();
	}

	/**
	 * Get the full list of trade recorded
	 * 
	 * @return
	 */
	public ArrayList<Trade> getTrades() {
		return tradeList;
	}

	/**
	 * Record a single trade
	 * 
	 * @param trade
	 */
	public void addTrade(Trade trade) {
		tradeList.add(trade);
	}

	/**
	 * Calculate Volume Weighted Stock Price based on trades in past 15 minutes
	 * 
	 * @param stock
	 * @return
	 */
	public double computeVolumeWeightedStockPrice(Stock stock) {
		Calendar timeRange = Calendar.getInstance();
		double priceQuantitySum = 0;
		double QuantitySum = 0;

		// remove 15 minutes from the current time
		timeRange.add(Calendar.MINUTE, -15);

		for (Trade trade : tradeList) {
			if (trade.getTradeTime().after(timeRange.getTime()) && trade.getStock().equals(stock)) {
				priceQuantitySum += trade.getPrice() * trade.getQuantityShares();
				QuantitySum += trade.getQuantityShares();
			}
		}
		return priceQuantitySum / QuantitySum;
	}

	/**
	 * Calculate the GBCE All Share Index using the geometric mean of prices for
	 * all stocks
	 * 
	 * @return
	 */
	public double computeGBCE() {
		double priceMultiplication = 1d;
		for (Trade trade : tradeList) {
			priceMultiplication *= trade.getPrice();
		}
		return Math.pow(priceMultiplication, 1.0 / tradeList.size());
	}

}
