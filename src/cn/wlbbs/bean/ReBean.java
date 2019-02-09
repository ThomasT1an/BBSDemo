package cn.wlbbs.bean;

public class ReBean {

	public static final int PAGE_SIZE = 8; // 每页记录数
	private int tid;// 编号
	private String ruser;
	private String rtime;
	private String hfnr;
	//private String tlocation;
	//private String ttext;

	public int gettid() {
		return tid;
	}

	public void settid(int tid) {
		this.tid = tid;
	}

	public String getruser() {
		return ruser;
	}

	public void setruser(String ruser) {
		this.ruser = ruser;
	}

	public String getrtime() {
		return rtime;
	}

	public void setrtime(String rtime) {
		this.rtime = rtime;
	}
	public String gethfnr() {
		return hfnr;
	}

	public void sethfnr(String hfnr) {
		this.hfnr= hfnr;
	}
//	public String gettlocation() {
//		return tlocation;
//	}
//
//	public void settlocation(String tlocation) {
//		this.tlocation = tlocation;
//	}

}
