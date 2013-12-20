package com.hesong.ocs.factories;

import java.util.Date;

import com.hesong.ocs.pojo.CallInfo;

public class CallFactory {

	public static CallInfo getCallInfo(long callId, long companyId,
			long clientId, int callType, Date start, boolean isConnected) {
		if(isConnected){
			return new CallInfo(callId, companyId, clientId, callType, start);
		} else {
			return new CallInfo(callId, companyId, clientId);
		}
	}

}
