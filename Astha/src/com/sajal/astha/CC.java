package com.sajal.astha;

public class CC {
	
	public String ccName;
	public String ccPhone;
	public String cc_id;
	public CC(String ccName, String ccPhone) {
		super();
		this.ccName = ccName;
		this.ccPhone = ccPhone;
	}
	public String getCcName() {
		return ccName;
	}
	public void setCcName(String ccName) {
		this.ccName = ccName;
	}
	public String getCcPhone() {
		return ccPhone;
	}
	public void setCcPhone(String ccPhone) {
		this.ccPhone = ccPhone;
	}
	public String getCc_id() {
		return cc_id;
	}
	public void setCc_id(String cc_id) {
		this.cc_id = cc_id;
	}
	
}
