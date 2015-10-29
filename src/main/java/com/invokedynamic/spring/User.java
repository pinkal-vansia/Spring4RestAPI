package com.invokedynamic.spring;

public class User {
  private String username;
  private String password;
  private String email;
  private String country;
   
  public User() {
  }
   
  public User(String username, String password, String email, String country) {
	setUsername(username);
	setPassword(password);
	setEmail(email);
    setCountry(country);
  }
   
  public String getUsername() {
    return username;
  }
   
  public void setUsername(String username) {
    this.username = username;
  }
   
  public String getPassword() {
    return password;
  }
   
  public void setPassword(String password) {
    this.password = password;
  }
   
  public String getEmail() {
    return email;
  }
   
  public void setEmail(String email) {
    this.email = email;
  }
   
  public String getCountry() {
    return country;
  }
   
  public void setCountry(String country) {
    this.country = country;
  }
   
  public String toString() {
    return "[" + getUsername()
        + ", " + getEmail()
        + ", " + getPassword()
        + ", " + getCountry()
        + "]";
  }
}
