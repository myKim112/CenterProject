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
	private String center;
    private String className;
    private String teacher;
    private String classDate;
    private String ClassTime;

    public String getCenter() {return center;}
	public void setCenter(String center) {this.center = center;}
	
	public String getClassName() {return className;}
	public void setClassName(String className) {this.className = className;}
	
	public String getTeacher() {return teacher;}
	public void setTeacher(String teacher) {this.teacher = teacher;}
	
	public String getClassDate() {return classDate;}
	public void setClassDate(String classDate) {	this.classDate = classDate;}
	
	public String getClassTime() {return ClassTime;}
	public void setClassTime(String classTime) {ClassTime = classTime;}

    public int getNum() {return num;}
	public void setNum(int num) {this.num = num;}
	
	public String getId() {return id;}
	public void setId(String id) {this.id = id;}
    
	public String getClassCode() {return classCode;}
	public void setClassCode(String classCode) {this.classCode = classCode;}
	
	public String getSum() {return sum;}
	public void setSum(String sum) {this.sum = sum;}
	
	public int getStatus() {return status;}
	public void setStatus(int status) {this.status = status;}

	public Timestamp getReg_date() {return reg_date;}
	public void setReg_date(Timestamp reg_date) {this.reg_date = reg_date;}
	
	public int getMemberCount() {return memberCount;}
	public void setMemberCount(int memberCount) {this.memberCount = memberCount;}

}
