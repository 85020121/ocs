package com.hesong.ocs.factories;

import java.util.Date;

import com.hesong.ocs.pojo.CallInfo;

public class CallInfoFactory {

    public static CallInfo getCallInfo(long callId, long companyId,
            long clientId, int callType, Date start, boolean isConnected) {
        if (isConnected) {
            return new CallInfo(callId, companyId, clientId, callType, start);
        } else {
            return new CallInfo(callId, companyId, clientId);
        }
    }

    public static CallInfo getCallInfo(long callId, long companyId,
            long clientId, int callType, Date start, Date end) {
        return new CallInfo(callId, companyId, clientId, callType, start, end);
    }

}
