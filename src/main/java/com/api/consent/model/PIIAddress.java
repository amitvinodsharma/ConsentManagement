package com.api.consent.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pii_address")
public class PIIAddress {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	@Column(name ="country")
    private String country;
    
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

	
	@Column(name="locality")
    private String locality;
	
	@Column(name="region")
    private String region;
	
	@Column(name="post_office_box_number")
    private String postOfficeBoxNumber;
	
	@Column(name="postal_code")
    private String postalCode;
	
	@Column(name="street_address")
    private String streetAddress;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getPostOfficeBoxNumber() {
		return postOfficeBoxNumber;
	}

	public void setPostOfficeBoxNumber(String postOfficeBoxNumber) {
		this.postOfficeBoxNumber = postOfficeBoxNumber;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	
	

}
