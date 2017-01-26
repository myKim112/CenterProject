package center.join;

import java.sql.Timestamp;

public class JoinDTO {
	private String id = null;
	private String pw = null;
	private String name = null;
	private int birth = 0;
	private int phone = 0;
	private String address = null;
	private String email = null;
	private int lev = 0;
	private Timestamp regDate= null;
	
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
	
	public int getLev() {return lev;}
	public void setLev(int lev) {this.lev = lev;}
	
	public Timestamp getRegDate() {return regDate;}
	public void setRegDate(Timestamp regDate) {this.regDate = regDate;}
}
