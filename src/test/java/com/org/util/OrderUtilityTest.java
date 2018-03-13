package com.org.util;

import org.junit.Assert;
import org.junit.Test;

public class OrderUtilityTest {

	OrderUtility orderUtils = new OrderUtility();

	@Test
	public void testConvertDate() {
		Assert.assertTrue("2017-09-23".equals(orderUtils.convertDate((long) 1506176687)));
	}

}
