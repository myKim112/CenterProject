package center.myReviewPost;

import java.sql.Timestamp;

public class MyReviewDTO {
	
	private int num;
	private String center;
	private String writer;
	private String pw;
	private String title;
	private String content;
	private Timestamp regDate;
	private int readCount;
	private String orgName;
	private String sysName;	
	private int ref;
	private int reStep;
	private int reLevel;	
	
	public void setNum(int num) {
		this.num = num;
	}
	public void setCenter(String center) {
		this.center = center;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}	
	public void setSysName(String sysName) {
		this.sysName = sysName;
	}	
	public void setRef(int ref) {
		this.ref = ref;
	}
	public void setReStep(int reStep) {
		this.reStep = reStep;
	}
	public void setReLevel(int reLevel) {
		this.reLevel = reLevel;
	}
	
	public int getNum() {
		return num;
	}
	public String getCenter() {
		return center;
	}
	public String getWriter() {
		return writer;
	}
	public String getPw() {
		return pw;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public Timestamp getRegDate() {
		return regDate;
	}
	public int getReadCount() {
		return readCount;
	}
	public String getOrgName() {
		return orgName;
	}
	public String getSysName() {
		return sysName;
	}	
	public int getRef() {
		return ref;
	}
	public int getReStep() {
		return reStep;
	}
	public int getReLevel() {
		return reLevel;
	}
	
}
