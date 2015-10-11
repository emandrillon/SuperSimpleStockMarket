package com.jpmorgan.SkillTest.SuperSimpleStockMarket;

import java.util.Date;

import com.jpmorgan.SkillTest.SuperSimpleStockMarket.Enum.TypeTrade;

/**
 * Trade class use to manage single trade
 * 
 * @author Eric Mandrillon
 * @version 1.0
 */
public class Trade {

	private Stock stock;
	private Date tradeTime;
	private int quantityShares;
	private TypeTrade typeTrade;
	private double price;

	/**
	 * Constructor with all needed data to create a Trade
	 * 
	 * @param stock
	 *            Stock Symbol
	 * @param quantityShares
	 *            Quantity of shares
	 * @param typeTrade
	 *            buy or sell indicator
	 * @param price
	 *            traded price
	 */
	public Trade(Stock stock, int quantityShares, TypeTrade typeTrade, double price) {
		this.setStock(stock);
		this.setTradeTime(new Date());
		this.setQuantityShares(quantityShares);
		this.setTypeTrade(typeTrade);
		this.setPrice(price);
	}

	public int getQuantityShares() {
		return quantityShares;
	}

	public void setQuantityShares(int quantityShares) {
		this.quantityShares = quantityShares;
	}

	public TypeTrade getTypeTrade() {
		return typeTrade;
	}

	public void setTypeTrade(TypeTrade typeTrade) {
		this.typeTrade = typeTrade;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getTradeTime() {
		return tradeTime;
	}

	public void setTradeTime(Date tradeTime) {
		this.tradeTime = tradeTime;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

}
