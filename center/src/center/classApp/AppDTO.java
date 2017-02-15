package center.classApp;

import java.sql.Timestamp;

public class AppDTO {
	
	private int num;
    private String id;
    private String classCode;
    private String sum;
    private int status;
    private Timestamp reg_date;
    private int memberCount;
    
    // 상태를 보여주기 위함
    private String position;
    
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
	public String getSum() {
		return sum;
	}
	public void setSum(String sum) {
		this.sum = sum;
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
	public int getMemberCount() {
		return memberCount;
	}
	public void setMemberCount(int memberCount) {
		this.memberCount = memberCount;
	}
	//
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}

	

}
