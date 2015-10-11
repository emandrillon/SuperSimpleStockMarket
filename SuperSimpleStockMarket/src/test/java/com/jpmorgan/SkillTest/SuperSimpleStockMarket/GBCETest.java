package com.jpmorgan.SkillTest.SuperSimpleStockMarket;

import static org.junit.Assert.*;

import org.junit.Test;

import com.jpmorgan.SkillTest.SuperSimpleStockMarket.Enum.TypeTrade;

public class GBCETest {

	@Test
	public void GBCE1Trade() {
		TradeRecorder tradeRecorder = new TradeRecorder();
		Stock stock = new CommonStock("TEA", 0d, 100d);
		Trade trade = new Trade(stock, 20, TypeTrade.sell, 500d);
		tradeRecorder.addTrade(trade);

		assertEquals(Math.pow(500d, 1.0 / 1.0), tradeRecorder.computeGBCE(), 0);
	}

	@Test
	public void GBCE5Trade() {
		TradeRecorder tradeRecorder = new TradeRecorder();
		Stock stock1 = new CommonStock("TEA", 0d, 100d);
		Stock stock2 = new CommonStock("POP", 8d, 100d);
		Stock stock3 = new PreferredStock("GIN", 8d, 0.02d, 100d);
		Trade trade1 = new Trade(stock1, 20, TypeTrade.sell, 15d);
		Trade trade2 = new Trade(stock2, 10, TypeTrade.buy, 20d);
		Trade trade3 = new Trade(stock1, 35, TypeTrade.sell, 50d);
		Trade trade4 = new Trade(stock3, 20, TypeTrade.sell, 500d);
		Trade trade5 = new Trade(stock1, 2, TypeTrade.sell, 10d);

		tradeRecorder.addTrade(trade1);
		tradeRecorder.addTrade(trade2);
		tradeRecorder.addTrade(trade3);
		tradeRecorder.addTrade(trade4);
		tradeRecorder.addTrade(trade5);

		assertEquals(Math.pow(15d * 20d * 50d * 500d * 10d, 1.0 / 5.0), tradeRecorder.computeGBCE(), 0);
	}

}
