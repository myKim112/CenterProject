package center.boardQna;

import java.sql.Timestamp;

public class QnaDTO {

	private int num;
	private String center;
	private String title;
	private String content;
	private String writer;
	private String pw;
	private Timestamp regDate;
	private int readCount;
	private int ref;
	private int reLevel;
	private int reStep;
	
	public void setNum(int num) {
		this.num = num;
	}
	public void setCenter(String center) {
		this.center = center;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public void setReLevel(int reLevel) {
		this.reLevel = reLevel;
	}
	public void setReStep(int reStep) {
		this.reStep = reStep;
	}
	
	public int getNum() {
		return num;
	}
	public String getCenter() {
		return center;
	}
	public String getTitle() {
		return title;
	}
	public String getPw() {
		return pw;
	}
	public String getContent() {
		return content;
	}
	public String getWriter() {
		return writer;
	}
	public Timestamp getRegDate() {
		return regDate;
	}
	public int getReadCount() {
		return readCount;
	}
	public int getRef() {
		return ref;
	}
	public int getReLevel() {
		return reLevel;
	}
	public int getReStep() {
		return reStep;
	}
	
}
