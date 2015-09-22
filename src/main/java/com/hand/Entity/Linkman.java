package com.hand.Entity;


/**
 * Linkman generated by hbm2java
 */
public class Linkman implements java.io.Serializable {

	private int customerId;
	private Customer customer;
	private String mailfrom;
	private String prepoMailto;
	private String poMailto;
	private String ocpiMailto;
	private String invPklistMailto;

	public Linkman() {
	}

	public Linkman(Customer customer) {
		this.customer = customer;
	}

	public Linkman(Customer customer, String mailfrom, String prepoMailto, String poMailto, String ocpiMailto,
			String invPklistMailto) {
		this.customer = customer;
		this.mailfrom = mailfrom;
		this.prepoMailto = prepoMailto;
		this.poMailto = poMailto;
		this.ocpiMailto = ocpiMailto;
		this.invPklistMailto = invPklistMailto;
	}

	public int getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getMailfrom() {
		return this.mailfrom;
	}

	public void setMailfrom(String mailfrom) {
		this.mailfrom = mailfrom;
	}

	public String getPrepoMailto() {
		return this.prepoMailto;
	}

	public void setPrepoMailto(String prepoMailto) {
		this.prepoMailto = prepoMailto;
	}

	public String getPoMailto() {
		return this.poMailto;
	}

	public void setPoMailto(String poMailto) {
		this.poMailto = poMailto;
	}

	public String getOcpiMailto() {
		return this.ocpiMailto;
	}

	public void setOcpiMailto(String ocpiMailto) {
		this.ocpiMailto = ocpiMailto;
	}

	public String getInvPklistMailto() {
		return this.invPklistMailto;
	}

	public void setInvPklistMailto(String invPklistMailto) {
		this.invPklistMailto = invPklistMailto;
	}

}
