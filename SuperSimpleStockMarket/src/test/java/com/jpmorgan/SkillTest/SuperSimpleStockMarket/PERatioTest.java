package com.jpmorgan.SkillTest.SuperSimpleStockMarket;

import static org.junit.Assert.*;

import org.junit.Test;

public class PERatioTest {

	@Test
	public void testTEA() {
		Stock stock = new CommonStock("TEA", 0d, 100d);
		double PERatioValue = stock.PERatio(50d);

		assertEquals(50d / 0d, PERatioValue, 0);
	}

	@Test
	public void testPOP() {
		Stock stock = new CommonStock("POP", 8d, 100d);
		double PERatioValue = stock.PERatio(50d);

		assertEquals(50d / 8d, PERatioValue, 0);
	}

	@Test
	public void testGIN() {
		Stock stock = new PreferredStock("GIN", 8d, 0.02d, 100d);
		double PERatioValue = stock.PERatio(20d);

		assertEquals(20d / 8d, PERatioValue, 0);
	}

}
