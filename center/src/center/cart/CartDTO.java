package center.cart;

public class CartDTO {
    
	private int num = 0;
	private int tnum=0;
	private String id = null;
	private String classCode = null;

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getTnum() {
		return tnum;
	}

	public void setTnum(int tnum) {
		this.tnum = tnum;
	}

}
