package com.hesong.ocs.rules;

import java.util.Date;

import com.hesong.ocs.utilities.DecimalCleaner;
import com.hesong.ocs.utilities.TimeCalculator;

public class TollCallRule implements IRule {

	private int countUnit;
	private double pricePerUnit;

	public TollCallRule(double pricePerUnit) {
		super();
		this.pricePerUnit = pricePerUnit;
		this.countUnit = 6;
	}

	public TollCallRule(int countUnit, double pricePerUnit) {
		super();
		this.countUnit = countUnit;
		this.pricePerUnit = pricePerUnit;
	}

	@Override
	public double execute(Date start, Date end) {
		int duration = TimeCalculator.duration(start, end);
		duration = duration % this.countUnit > 0 ? duration / this.countUnit
				+ 1 : duration / this.countUnit;
		double price = this.pricePerUnit * duration;
		return DecimalCleaner.round(price, 3);
	}

}
