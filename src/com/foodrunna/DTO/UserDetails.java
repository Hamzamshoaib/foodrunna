package com.foodrunna.DTO;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name="USER_DETAILS")
public class UserDetails {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int userID;
	private String userEmail;
	private String userPassword;
	private String firstName;
	private String lastName;
	private int mobile_Number;
	private String mobile_Number_Verification;
	private String email_Verification;
	@Temporal(TemporalType.DATE) //Saves only date in the database
	private Date dateCreated; //User Registration Date
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
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
	public int getMobile_Number() {
		return mobile_Number;
	}
	public void setMobile_Number(int mobile_Number) {
		this.mobile_Number = mobile_Number;
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