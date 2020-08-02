package model;

public class ContactData {
private String home;
private String mobile;
private String work;
private String fax;
private String email1;
private String email2;
private String email3;

private void fillEmails(String email1, String email2, String email3) {
  this.email1 = email1;
  this.email2 = email2;
  this.email3 = email3;
}

private void fillTelephoneNumbers(String home, String mobile, String work, String fax) {
  this.home = home;
  this.mobile = mobile;
  this.work = work;
  this.fax = fax;
}

public ContactData(String home, String mobile, String work, String fax, String email1, String email2, String email3) {
  fillTelephoneNumbers(home, mobile, work, fax);
  fillEmails(email1, email2, email3);
}

public String getEmail1() {
  return email1;
}
public String getEmail2() {
  return email2;
}
public String getEmail3() {
  return email3;
}
public String getHome() {
  return home;
}
public String getMobile() {
  return mobile;
}
public String getWork() {
  return work;
}
public String getFax() {
  return fax;
}
}
