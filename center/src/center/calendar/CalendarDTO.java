package center.calendar;

import java.sql.Timestamp;

public class CalendarDTO {
	private int calNum;
	private String calPw;
	private Timestamp calDate;
	private String calTitle;
	private String calContent;
	
	//
	private String memoYear;
	private String memoMonth;
	private String memoDate;
	
	public int getCalNum() {return calNum;}
	public void setCalNum(int calNum) {this.calNum = calNum;}
	
	public String getCalPw() {return calPw;}
	public void setCalPw(String calPw) {this.calPw = calPw;}
	
	public Timestamp getCalDate() {return calDate;}
	public void setCalDate(Timestamp calDate) {this.calDate = calDate;}
	
	public String getCalTitle() {return calTitle;}
	public void setCalTitle(String calTitle) {this.calTitle = calTitle;}
	
	public String getCalContent() {return calContent;}
	public void setCalContent(String calContent) {this.calContent = calContent;}
	
	//
	public String getMemoYear() {return memoYear;}
	public void setMemoYear(String memoYear) {this.memoYear = memoYear;}
	
	public String getMemoMonth() {return memoMonth;}
	public void setMemoMonth(String memoMonth) {this.memoMonth = memoMonth;}
	
	public String getMemoDate() {return memoDate;}
	public void setMemoDate(String memoDate) {this.memoDate = memoDate;}
}