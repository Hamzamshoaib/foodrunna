package com.foodrunna.DTO;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name="USER_DETAILS")
public class UserDetails implements Serializable {
	
	public UserDetails() {
	}
	
	
	public UserDetails(String userID, String userEmail, String userPassword,
			String firstName, String lastName, String mobile_Number,
			Status status, String mobile_Number_Verification,
			String email_Verification, Date dateCreated) {
		this.userID = userID;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobile_Number = mobile_Number;
		this.status = status;
		this.mobile_Number_Verification = mobile_Number_Verification;
		this.email_Verification = email_Verification;
		this.dateCreated = dateCreated;
	}


	@Id //@GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name="USER_ID")
	private String userID;
	
	@Column (name="USER_EMAIL")
	private String userEmail;
	
	@Column (name = "USER_PASSWORD")
	private String userPassword;
	
	@Column (name = "FIRSTNAME")
	private String firstName;
	
	@Column (name = "LASTNAME")
	private String lastName;
	
	@Column (name="MOBILE_NUMBER")
	private String mobile_Number;
	
	@Column (name="USER_STATUS")
	@Enumerated (EnumType.STRING)
	private Status status; //Enum class with 3 values
	
	@Column (name="MOBILE_NUMBER_VERIFICATION")
	private String mobile_Number_Verification;
	
	@Column (name="EMAIL_VERIFICATION")
	private String email_Verification;
	
	@Temporal(TemporalType.DATE) //Saves only date in the database
	private Date dateCreated; //User Registration Date
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMobile_Number() {
		return mobile_Number;
	}
	public void setMobile_Number(String mobile_Number) {
		this.mobile_Number = mobile_Number;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public String getMobile_Number_Verification() {
		return mobile_Number_Verification;
	}
	public void setMobile_Number_Verification(String mobile_Number_Verification) {
		this.mobile_Number_Verification = mobile_Number_Verification;
	}
	public String getEmail_Verification() {
		return email_Verification;
	}
	public void setEmail_Verification(String email_Verification) {
		this.email_Verification = email_Verification;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}


}
//If you need more than 255 char space in database then use @LOB annotation

//@Embedded //Not mandatory if already done for the class