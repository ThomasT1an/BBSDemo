package cn.wlbbs.bean;

public class UserBean {
	 String stuid;
	 String name;
	 String birthday;
	 String school;
	 String major;
	 String note;
	 String email;
	    public UserBean(String stuid,String name,String birthday,String school,String major,String note,String email) {
	        this.stuid = stuid;
	        this.name=name;
	        this.birthday=birthday;
	        this.school=school;
	        this.major=major;
	        this.note=note;
	        this.email=email;
	    }
	    public String getStuid() {
	        return stuid;
	    }
	    public void setStuid(String stuid) {
	        this.stuid = stuid;
	    }
	    
	    public String getName() {
	        return name;
	    }
	    public void setName(String name) {
	        this.name = name;
	    }
	    
	    public String getBirthday() {
	        return birthday;
	    }
	    public void setBirthday(String birthday) {
	        this.birthday= birthday;
	    }
	    
	    public String getSchool() {
	        return school;
	    }
	    public void setSchool(String school) {
	        this.school = school;
	    }
	    
	    public String getMajor() {
	        return major;
	    }
	    public void setMajor(String major) {
	        this.major = major;
	    }
	    
	    public String getNote() {
	        return note;
	    }
	    public void setNote(String note) {
	        this.note = note;
	    }
	    
	    public String getEmail() {
	        return email;
	    }
	    public void setEmail(String email) {
	        this.email = email;
	    }
}
