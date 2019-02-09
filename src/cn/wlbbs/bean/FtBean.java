package cn.wlbbs.bean;


public class FtBean {
	public static final int PAGE_SIZE = 8; // 每页记录数
	private int tid;// 编号
	private String tname;
	private String uname;
	private String ttime;
	private String tlocation;
	//private String ttext;

	public int gettid() {
		return tid;
	}

	public void settid(int tid) {
		this.tid = tid;
	}

	public String gettname() {
		return tname;
	}

	public void settname(String tname) {
		this.tname = tname;
	}

	public String getuname() {
		return uname;
	}

	public void setuname(String uname) {
		this.uname = uname;
	}
	public String getttime() {
		return ttime;
	}

	public void setttime(String ttime) {
		this.ttime = ttime;
	}
	public String gettlocation() {
		return tlocation;
	}

	public void settlocation(String tlocation) {
		this.tlocation = tlocation;
	}
}
