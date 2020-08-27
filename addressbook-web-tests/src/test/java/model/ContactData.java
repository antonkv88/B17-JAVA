package model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.io.File;
import java.util.Objects;

@XStreamAlias("contact")
public class ContactData {
  @XStreamOmitField
private int id = Integer.MAX_VALUE;
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
private String allPhones;
private String allEmails;
private File photo;

@Override
public boolean equals(Object o) {
  if (this == o) return true;
  if (o == null || getClass() != o.getClass()) return false;
  ContactData that = (ContactData) o;
  return id == that.id &&
          Objects.equals(firstname, that.firstname) &&
          Objects.equals(lastname, that.lastname);
}

@Override
public int hashCode() {
  return Objects.hash(id, firstname, lastname);
}
public String getAllPhones() {
  return allPhones;
}
public String getAllEmails() {
  return allEmails;
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
public int getId() {
  return id;
}
public void setPhoto(File photo) {
  this.photo = photo;
}
public void setId(int id) {this.id = id;}
public ContactData withId(int id) {
  this.id = id;
  return this;
}
public ContactData withFirstname(String firstname) {
  this.firstname = firstname;
  return this;
}
public ContactData withLastname(String lastname) {
  this.lastname = lastname;
  return this;
}
public ContactData withHome(String home) {
  this.home = home;
  return this;
}
public ContactData withMobile(String mobile) {
  this.mobile = mobile;
  return this;
}
public ContactData withWork(String work) {
  this.work = work;
  return this;
}
public ContactData withFax(String fax) {
  this.fax = fax;
  return this;
}
public ContactData withEmail1(String email1) {
  this.email1 = email1;
  return this;
}
public ContactData withmail2(String email2) {
  this.email2 = email2;
  return this;
}
public ContactData withEmail3(String email3) {
  this.email3 = email3;
  return this;
}
public ContactData withNickname(String nickname) {
  this.nickname = nickname;
  return this;
}
public ContactData withTitle(String title) {
  this.title = title;
  return this;
}
public ContactData withCompany(String company) {
  this.company = company;
  return this;
}
public ContactData withAddress(String address) {
  this.address = address;
  return this;
}
public ContactData withGroup(String group) {
  this.group = group;
  return this;
}
public ContactData withPhoto(File photo) {
  this.photo = photo;
  return this;
}

public ContactData withAllPhones(String allPhones) {
  this.allPhones = allPhones;
  return this;
}

public ContactData withAllEmails(String allEmails) {
  this.allEmails = allEmails;
  return this;
}
}


