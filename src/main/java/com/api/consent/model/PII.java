package com.api.consent.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*
 * This is our model class and it corresponds to pii table in database
 */
@Entity
@Table(name="personal_identifiable_information")
public class PII{
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	@Column(name="pii_controller")
    private String piiController;
	
	@Column(name="contact")
    private String contact;
	
	@Column(name="email")
    private String email;
	
	@Column(name="phone")
    private String phone;
	
	@Column(name="on_behalf")
    private boolean onBehalf;
	
	@Column(name="pii_controller_url")
    private String piiControllerUrl;
    
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="address_id")
    private PIIAddress address;
	
		
	public PII() {
		super();
	}

	/*
	 * public PII(int i, String piiName,long population) { super(); this.id = i;
	 * this.piiName = piiName; this.population=population; }
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public void setPiiController(String piiController) {
		this.piiController = piiController;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public boolean isOnBehalf() {
		return onBehalf;
	}
	public void setOnBehalf(boolean onBehalf) {
		this.onBehalf = onBehalf;
	}
	public String getPiiControllerUrl() {
		return piiControllerUrl;
	}
	public void setPiiControllerUrl(String piiControllerUrl) {
		this.piiControllerUrl = piiControllerUrl;
	}
	public PIIAddress getAddress() {
		return address;
	}
	public void setAddress(PIIAddress address) {
		this.address = address;
	}	
	
}