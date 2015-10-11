package com.jpmorgan.SkillTest.SuperSimpleStockMarket;

import static org.junit.Assert.*;
import org.junit.Test;
import com.jpmorgan.SkillTest.SuperSimpleStockMarket.Enum.TypeTrade;

public class VolumeWeightedStockPriceTest {

	@Test
	public void Test1Trade() {

		TradeRecorder tradeRecorder = new TradeRecorder();
		Stock stock = new CommonStock("TEA", 0d, 100d);
		Trade trade = new Trade(stock, 20, TypeTrade.sell, 500d);
		tradeRecorder.addTrade(trade);

		assertEquals(500d * 20 / 20, tradeRecorder.computeVolumeWeightedStockPrice(stock), 0);
	}

	@Test
	public void Test5Trade() {

		TradeRecorder tradeRecorder = new TradeRecorder();
		Stock stock1 = new CommonStock("TEA", 0d, 100d);
		Stock stock2 = new CommonStock("POP", 8d, 100d);
		Stock stock3 = new PreferredStock("GIN", 8d, 0.02d, 100d);
		Trade trade1 = new Trade(stock1, 20, TypeTrade.sell, 500d);
		Trade trade2 = new Trade(stock2, 50, TypeTrade.sell, 50d);
		Trade trade3 = new Trade(stock1, 10, TypeTrade.sell, 500d);
		Trade trade4 = new Trade(stock2, 6, TypeTrade.sell, 60d);
		Trade trade5 = new Trade(stock3, 20, TypeTrade.sell, 500d);
		tradeRecorder.addTrade(trade1);
		tradeRecorder.addTrade(trade2);
		tradeRecorder.addTrade(trade3);
		tradeRecorder.addTrade(trade4);
		tradeRecorder.addTrade(trade5);

		assertEquals((500d * 20 +  500d * 10) / (20 + 10),
				tradeRecorder.computeVolumeWeightedStockPrice(stock1), 0);
		assertEquals((50d * 50 + 60 * 6) / (50 + 6), tradeRecorder.computeVolumeWeightedStockPrice(stock2), 0);
		assertEquals(500d * 20 / 20, tradeRecorder.computeVolumeWeightedStockPrice(stock3), 0);
	}

}
