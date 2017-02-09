package center.classApp;

import java.sql.Timestamp;

public class AppDTO {
	
	private int num;
    private String id;
    private String classCode;
    private int classPay;
    private int status;
    private Timestamp reg_date;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getClassCode() {
		return classCode;
	}
	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}
	public int getClassPay() {
		return classPay;
	}
	public void setClassPay(int classPay) {
		this.classPay = classPay;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Timestamp getReg_date() {
		return reg_date;
	}
	public void setReg_date(Timestamp reg_date) {
		this.reg_date = reg_date;
	}



}
