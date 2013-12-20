package com.hesong.ocs.pojo;

import java.util.Date;

public class CallInfo {
	
	private long callId;
	private long companyId;
	private long clientId;
	private int callType;
	private Date start;
	private Date end;
	private double price;
	
	public CallInfo() {
		super();
	}

	public CallInfo(long callId, long companyId, long clientId) {
		super();
		this.callId = callId;
		this.companyId = companyId;
		this.clientId = clientId;
	}

	public CallInfo(long callId, long companyId, long clientId, int callType,
			Date start) {
		super();
		this.callId = callId;
		this.companyId = companyId;
		this.clientId = clientId;
		this.callType = callType;
		this.start = start;
	}

	public CallInfo(long callId, long companyId, long clientId, int callType,
            Date start, Date end) {
        super();
        this.callId = callId;
        this.companyId = companyId;
        this.clientId = clientId;
        this.callType = callType;
        this.start = start;
        this.end = end;
    }

    public long getCallId() {
		return callId;
	}

	public void setCallId(long callId) {
		this.callId = callId;
	}

	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}

	public long getClientId() {
		return clientId;
	}

	public void setClientId(long clientId) {
		this.clientId = clientId;
	}

	public int getCallType() {
		return callType;
	}

	public void setCallType(int callType) {
		this.callType = callType;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	

}
