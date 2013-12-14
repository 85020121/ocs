package com.hesong.ocs.utilities;

import java.util.Date;

public class TimeCalculator {

	public static final int MilleSecond = 1000;
	public static final int MinutesPerHour = 60;
	public static final int SecondsPerMinute = 60;

	/**
	 * 
	 * @param start
	 *            呼叫连接建立的开始时间
	 * @param end
	 *            呼叫连接的结束时间
	 * @return -1:开始和结束时间出错, >0:呼叫时间，单位：秒
	 */
	public static int duration(Date start, Date end) {
		if (start.after(end))
			return -1;
		double diff = (double)(end.getTime() - start.getTime())/MilleSecond;
		return (int)Math.ceil(diff);
	}
	
	/**
	 * 
	 * @param start
	 *            呼叫连接建立的开始时间
	 * @param end
	 *            呼叫连接的结束时间
	 * @return 格式为'HH小时MM分SS秒'的通话时间
	 */
	public static String HMSFormatDuration(Date start, Date end) {
		return HMSFormatConvertor(duration(start, end), SecondsPerMinute);

	}

	/**
	 * 
	 * @param start
	 *            呼叫连接建立的开始时间
	 * @param end
	 *            呼叫连接的结束时间
	 * @param minuteUnit
	 *            分钟单位，用户自行设定，60秒为默认值
	 * @return 格式为'HH小时MM分SS秒'的通话时间
	 */
	public static String HMSFormatDuration(Date start, Date end, int minuteUnit) {
		return HMSFormatConvertor(duration(start, end), minuteUnit);
	}

	/**
	 * 
	 * @param callDuration
	 *            单位为毫秒的通话时长
	 * @param minuteUnit
	 *            分钟单位，60秒为默认值
	 * @return 格式为'HH小时MM分SS秒'的通话时间
	 */
	public static String HMSFormatConvertor(int callDuration, int minuteUnit) {
		if (callDuration < 0)
			throw new IllegalArgumentException();
		
		int hours = callDuration / (MinutesPerHour * minuteUnit);
		callDuration = callDuration % (MinutesPerHour * minuteUnit);
		int minutes = (int) (callDuration / minuteUnit);
		int seconds = callDuration % minuteUnit;
		return hours + "小时" + minutes + "分" + seconds + "秒";
	}

}
