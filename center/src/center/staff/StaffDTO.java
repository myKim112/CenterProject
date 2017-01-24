package center.staff;

import java.sql.Timestamp;

public class StaffDTO {
	private String id;
	private String pw;
	private String name;
	private int birth;
	private int phone;
	private String address;
	private String email;
	private String bankName;
	private int bankAccount;
	private String lev;
	private Timestamp regDate;
	
	public String getId() {return id;}
	public void setId(String id) {this.id = id;}
	
	public String getPw() {return pw;}
	public void setPw(String pw) {this.pw = pw;}
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	public int getBirth() {return birth;}
	public void setBirth(int birth) {this.birth = birth;}
	
	public int getPhone() {return phone;}
	public void setPhone(int phone) {this.phone = phone;}
	
	public String getAddress() {return address;}
	public void setAddress(String address) {this.address = address;}
	
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}
	
	public String getBankName() {return bankName;}
	public void setBankName(String bankName) {this.bankName = bankName;}
	
	public int getBankAccount() {return bankAccount;}
	public void setBankAccount(int bankAccount) {this.bankAccount = bankAccount;}
	
	public String getLev() {return lev;}
	public void setLev(String lev) {this.lev = lev;}
	
	public Timestamp getRegDate() {return regDate;}
	public void setRegDate(Timestamp regDate) {this.regDate = regDate;}
}
