package beanclass;

public class Bean {
	private String name,email,gender,ph,pass,cpass;
	
	private String address;
	public Bean()
	{
		
	}
public Bean(String name,String email,String gender,String ph,String pass,String cpass)
{
this.name=name;
this.email=email;
this.gender=gender;
this.ph=ph;
this.pass=pass;
this.cpass=cpass;
}
public String getAddress() {
	return name;
}
public void setAddress(String address) {
	this.address = address;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getPh() {
	return ph;
}
public void setPh(String ph) {
	this.ph = ph;
}
public String getPass() {
	return pass;
}
public void setPass(String pass) {
	this.pass = pass;
}
public String getCpass() {
	return cpass;
}
public void setCpass(String cpass) {
	this.cpass = cpass;
}
public String toString()
{
	return name+email+gender+ph+pass+cpass;
	
}
}
