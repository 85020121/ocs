package com.hesong.ocs.utilities;

import java.math.BigDecimal;

public class DecimalCleaner {

	/**
	 * 
	 * @param value
	 *            需要处理的值，double类型
	 * @param places
	 *            需要保留的小数点位数
	 * @return 去掉多余小数后的值
	 */
	public static double round(double value, int places) {
		if (places < 0)
			throw new IllegalArgumentException();

		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(places, BigDecimal.ROUND_HALF_UP);
		return bd.doubleValue();
	}

}
