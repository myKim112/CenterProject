package center.calendar;

import java.sql.Timestamp;

public class CalendarDTO {
	private String calPw;
	private Timestamp calDate;
	private String calTitle;
	private String calContent;
	
	public String getCalPw() {return calPw;}
	public void setCalPw(String calPw) {this.calPw = calPw;}
	
	public Timestamp getCalDate() {return calDate;}
	public void setCalDate(Timestamp calDate) {this.calDate = calDate;}
	
	public String getCalTitle() {return calTitle;}
	public void setCalTitle(String calTitle) {this.calTitle = calTitle;}
	
	public String getCalContent() {return calContent;}
	public void setCalContent(String calContent) {this.calContent = calContent;}
}
