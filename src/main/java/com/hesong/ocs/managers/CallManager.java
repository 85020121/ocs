package com.hesong.ocs.managers;

import java.util.Date;

import com.hesong.ocs.beans.CallInfo;
import com.hesong.ocs.rules.IRule;

public class CallManager {
	public static void setStartTime(CallInfo ci, Date start){
		ci.setStart(start);
	}
	
	public static void setEndTime(CallInfo ci, Date start){
		ci.setStart(start);
	}
	
	public static double getPrice(CallInfo ci, IRule rule){
		return rule.execute(ci.getStart(), ci.getEnd());
	}
}
