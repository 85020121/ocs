package com.hesong.ocs.rules;

import java.util.Date;

import com.hesong.ocs.utilities.DecimalCleaner;
import com.hesong.ocs.utilities.TimeCalculator;

public class LocalCallRule implements IRule {

	private double firstMinutePrice;
	private double pricePerMinuteBeforeN;
	private double pricePerMinuteAfterN;
	private int firstNMinute;
	private int minuteUnit;

	public LocalCallRule(double firstMinutePrice, double pricePerMinuteBeforeN,
			double pricePerMinuteAfterN, int firstNMinute) {
		super();
		this.firstMinutePrice = firstMinutePrice;
		this.pricePerMinuteBeforeN = pricePerMinuteBeforeN;
		this.pricePerMinuteAfterN = pricePerMinuteAfterN;
		this.firstNMinute = firstNMinute;
		this.minuteUnit = 60;
	}

	public LocalCallRule(double firstMinutePrice, double pricePerMinuteBeforeN,
			double pricePerMinuteAfterN, int firstNMinute, int minuteUnit) {
		super();
		this.firstMinutePrice = firstMinutePrice;
		this.pricePerMinuteBeforeN = pricePerMinuteBeforeN;
		this.pricePerMinuteAfterN = pricePerMinuteAfterN;
		this.firstNMinute = firstNMinute;
		this.minuteUnit = minuteUnit;
	}

	@Override
	public double execute(Date start, Date end) {
		int duration = TimeCalculator.duration(start, end);
		duration = duration % this.minuteUnit > 0 ? (duration / this.minuteUnit + 1)
				: duration / this.minuteUnit;
		double price = 0;
		if (duration == 1) {
			price = this.firstMinutePrice;
		} else if (duration <= this.firstNMinute) {
			price = this.pricePerMinuteBeforeN * duration;
		} else if (duration > this.firstNMinute) {
			price = this.pricePerMinuteAfterN * duration;
		}
		return DecimalCleaner.round(price, 3);
	}

}
