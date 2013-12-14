package com.hesong.ocs.rules;

import java.util.Date;

public interface IRule {
	/**
	 * 
	 * @param duration
	 *            通话时长
	 * @return 实时话费
	 */
	public double execute(Date start, Date end);

}
