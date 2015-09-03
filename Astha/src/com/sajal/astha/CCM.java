package com.sajal.astha;

public class CCM {
	
	public String ccm_name;
	public String ccm_phnone;
	public String ccm_mail;
	public String ccm_cc;
	
	public CCM(String ccm_name, String ccm_phnone, String ccm_mail)
	{
		super();
		this.ccm_name = ccm_name;
		this.ccm_phnone = ccm_phnone;
		this.ccm_mail = ccm_mail;
		
	}
	public String getCcm_name() {
		return ccm_name;
	}
	public void setCcm_name(String ccm_name) {
		this.ccm_name = ccm_name;
	}
	public String getCcm_phnone() {
		return ccm_phnone;
	}
	public void setCcm_phnone(String ccm_phnone) {
		this.ccm_phnone = ccm_phnone;
	}
	public String getCcm_mail() {
		return ccm_mail;
	}
	public void setCcm_mail(String ccm_mail) {
		this.ccm_mail = ccm_mail;
	}
	public String getCcm_cc() {
		return ccm_cc;
	}
	public void setCcm_cc(String ccm_cc) {
		this.ccm_cc = ccm_cc;
	}

}
