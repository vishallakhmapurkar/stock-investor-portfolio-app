package com.impetus.stockapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author vishal.lakhmapurkar
 * @version $Revision: 1.0 $
 */
@Entity
@Table(name = "investor_tbl", catalog = "stockinvestorapp")
public class Investor {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long    userId;
    @Column(name = "user_name")
    private String  username;
    @Column(name = "first_name")
    private String  firstName;
    @Column(name = "last_name")
    private String  lastName;
    private String  password;
    private String  mobile;
    @Column(name = "email")
    private String  email;

    @Column(name = "address_line_one")
    private String  addressLineOne;
    @Column(name = "address_line_two")
    private String  addressLineTwo;
    private String  city;
    private String  state;
    private String  postalcode;
    private boolean passwordSet;

    /**
     * Method isPasswordSet.
     * 
     * @return boolean
     */
    public boolean isPasswordSet() {
	return passwordSet;
    }

    /**
     * Method setPasswordSet.
     * 
     * @param passwordSet
     *            boolean
     */
    public void setPasswordSet(final boolean passwordSet) {
	this.passwordSet = passwordSet;
    }

    /**
     * Method getUserId.
     * 
     * @return Long
     */
    public Long getUserId() {
	return userId;
    }

    /**
     * Method setUserId.
     * 
     * @param userId
     *            Long
     */
    public void setUserId(final Long userId) {
	this.userId = userId;
    }

    /**
     * Method getUsername.
     * 
     * @return String
     */
    public String getUsername() {
	return username;
    }

    /**
     * Method setUsername.
     * 
     * @param username
     *            String
     */
    public void setUsername(final String username) {
	this.username = username;
    }

    /**
     * Method getFirstName.
     * 
     * @return String
     */
    public String getFirstName() {
	return firstName;
    }

    /**
     * Method setFirstName.
     * 
     * @param firstName
     *            String
     */
    public void setFirstName(final String firstName) {
	this.firstName = firstName;
    }

    /**
     * Method getLastName.
     * 
     * @return String
     */
    public String getLastName() {
	return lastName;
    }

    /**
     * Method setLastName.
     * 
     * @param lastName
     *            String
     */
    public void setLastName(final String lastName) {
	this.lastName = lastName;
    }

    /**
     * Method getPassword.
     * 
     * @return String
     */
    public String getPassword() {
	return password;
    }

    /**
     * Method setPassword.
     * 
     * @param password
     *            String
     */
    public void setPassword(final String password) {
	this.password = password;
    }

    /**
     * Method getMobile.
     * 
     * @return String
     */
    public String getMobile() {
	return mobile;
    }

    /**
     * Method setMobile.
     * 
     * @param mobile
     *            String
     */
    public void setMobile(final String mobile) {
	this.mobile = mobile;
    }

    /**
     * Method getEmail.
     * 
     * @return String
     */
    public String getEmail() {
	return email;
    }

    /**
     * Method setEmail.
     * 
     * @param email
     *            String
     */
    public void setEmail(final String email) {
	this.email = email;
    }

    /**
     * Method getAddressLineOne.
     * 
     * @return String
     */
    public String getAddressLineOne() {
	return addressLineOne;
    }

    /**
     * Method setAddressLineOne.
     * 
     * @param addressLineOne
     *            String
     */
    public void setAddressLineOne(final String addressLineOne) {
	this.addressLineOne = addressLineOne;
    }

    /**
     * Method getAddressLineTwo.
     * 
     * @return String
     */
    public String getAddressLineTwo() {
	return addressLineTwo;
    }

    /**
     * Method setAddressLineTwo.
     * 
     * @param addressLineTwo
     *            String
     */
    public void setAddressLineTwo(final String addressLineTwo) {
	this.addressLineTwo = addressLineTwo;
    }

    /**
     * Method getCity.
     * 
     * @return String
     */
    public String getCity() {
	return city;
    }

    /**
     * Method setCity.
     * 
     * @param city
     *            String
     */
    public void setCity(final String city) {
	this.city = city;
    }

    /**
     * Method getState.
     * 
     * @return String
     */
    public String getState() {
	return state;
    }

    /**
     * Method setState.
     * 
     * @param state
     *            String
     */
    public void setState(final String state) {
	this.state = state;
    }

    /**
     * Method getPostalcode.
     * 
     * @return String
     */
    public String getPostalcode() {
	return postalcode;
    }

    /**
     * Method setPostalcode.
     * 
     * @param postalcode
     *            String
     */
    public void setPostalcode(final String postalcode) {
	this.postalcode = postalcode;
    }

    /**
     * Method toString.
     * 
     * @return String
     */
    @Override
    public String toString() {
	return "Investor [userId=" + userId + ", username=" + username + ", firstName=" + firstName + ", lastName="
		+ lastName + ", password=" + password + ", mobile=" + mobile + ", email=" + email + ", addressLineOne="
		+ addressLineOne + ", addressLineTwo=" + addressLineTwo + ", city=" + city + ", state=" + state
		+ ", postalcode=" + postalcode + "]";
    }

}
