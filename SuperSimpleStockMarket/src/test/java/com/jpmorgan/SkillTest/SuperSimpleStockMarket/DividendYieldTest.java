package com.jpmorgan.SkillTest.SuperSimpleStockMarket;

import static org.junit.Assert.*;
import org.junit.Test;

public class DividendYieldTest {

	@Test
	public void testTEA() {
		Stock stock = new CommonStock("TEA", 0d, 100d);

		double dividendYieldValue = stock.dividendYield(50d);

		assertEquals(0d / 50d, dividendYieldValue, 0);

	}

	@Test
	public void testPOP() {
		Stock stock = new CommonStock("POP", 8d, 100d);

		double dividendYieldValue = stock.dividendYield(20d);

		assertEquals(8d / 20d, dividendYieldValue, 0);

	}

	@Test
	public void testGIN() {
		Stock stock = new PreferredStock("GIN", 8d, 0.02d, 100d);

		double dividendYieldValue = stock.dividendYield(20d);

		assertEquals(0.02d * 100 / 20d, dividendYieldValue, 0);

	}

}
