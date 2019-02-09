package cn.wlbbs.bean;

/**
 * Created by Y on 2017/4/15.
 */
public  class Reslut {
    int state;
    String tip;
    Object data;

    public Reslut(int state, String tip, Object data) {
        this.state = state;
        this.tip = tip;
        this.data = data;
    }
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
