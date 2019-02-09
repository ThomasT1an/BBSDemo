package cn.wlbbs.c;


import com.alibaba.fastjson.JSON;

import cn.wlbbs.bean.*;
import cn.wlbbs.jdbc.Jdbc;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by Y on 2017/4/15.
 */
public class UserRegister extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Reslut reslut;
        HttpSession session= request.getSession();
        request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
        String stuid= (String) request.getParameter("stuid");//学号，登录的唯一验证
        String pass= (String) request.getParameter("pass");//密码
        System.out.println(stuid+pass);
        Jdbc jdbc=new Jdbc();
        int reCode = jdbc.stuidCheck(stuid);
        System.out.println(" UserRegister stuidCheck reCode="+reCode);
        if(reCode==1){
        	 Integer reCode1 = jdbc.register(stuid,pass);
             System.out.println("UserServlet reCode="+reCode);
             if(reCode==1){
                 session.setAttribute("id",reCode1.toString());
                 reslut =new Reslut(1,"注册成功",null);
             }else if(reCode==-3){
             	reslut =new Reslut(-3,"用户名或密码为空",null);
             }
             else{
                 reslut = new Reslut(-5, "连接错误", null);
             }
        }
        else {
        	 reslut = new Reslut(-1, "用户名已存在", null);
        }
        response.getWriter().println(JSON.toJSONString(reslut));
    }
}
