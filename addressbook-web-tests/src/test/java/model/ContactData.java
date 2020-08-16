package model;

import java.util.Objects;

public class ContactData {
private String firstname;
private String lastname;
private String home;
private String mobile;
private String work;
private String fax;
private String email1;
private String email2;
private String email3;
private String nickname;
private String title;
private String company;
private String address;
private String group;

public ContactData(String firstname, String lastname) {
  this(firstname,lastname,null,null,null,null,null,null,null,null,null,null,null,null);
}

@Override
public boolean equals(Object o) {
  if (this == o) return true;
  if (o == null || getClass() != o.getClass()) return false;
  ContactData that = (ContactData) o;
  return Objects.equals(firstname, that.firstname) &&
          Objects.equals(lastname, that.lastname);
}

@Override
public int hashCode() {
  return Objects.hash(firstname, lastname);
}

private void fillGroup (String group) {
this.group = group;
}

private void fillNickname(String nickname) {
  this.nickname = nickname;
}

private void fillTitle(String title) {
  this.title = title;
}

private void fillCompany(String company) {
  this.company = company;
}

private void fillAddess(String address) {
  this.address = address;
}

private void fillNames(String firstname, String lastname){
  this.firstname = firstname;
  this.lastname = lastname;
}

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

public ContactData(String firstname, String lastname, String nickname, String title, String company, String address, String home, String mobile, String work, String fax, String email1, String email2, String email3, String group) {
  fillTelephoneNumbers(home, mobile, work, fax);
  fillEmails(email1, email2, email3);
  fillNames(firstname,lastname);
  fillNickname(nickname);
  fillTitle(title);
  fillCompany(company);
  fillAddess(address);
  fillGroup(group);
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
public String getFirstname() {
  return firstname;
}
public String getLastname() {
  return lastname;
}
public String getNickname() {
  return nickname;
}
public String getTitle() {
  return title;
}
public String getCompany() {
  return company;
}
public String getAddress() {
  return address;
}

public String getGroup() {
  return group;
}
}
