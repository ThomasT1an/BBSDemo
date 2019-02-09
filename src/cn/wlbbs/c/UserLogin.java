package cn.wlbbs.c;


import com.alibaba.fastjson.JSON;


import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import cn.wlbbs.bean.*;
import cn.wlbbs.jdbc.Jdbc;
/**
 * Created by Y on 2017/4/15.2
 */
public class UserLogin extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Reslut reslut;
        request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
        HttpSession session= request.getSession();
        String stuid= (String) request.getParameter("stuid");
        String pass= (String) request.getParameter("pass");
        
        System.out.println(stuid);
        System.out.println(pass);
        
        Jdbc jdbc=new Jdbc();
        int reCode = jdbc.login(stuid,pass);
        System.out.println(" UserServlet reCode="+reCode);
        if(reCode>0){
           session.setAttribute("id",reCode);
            reslut =new Reslut(reCode,"登陆成功",null);
           System.out.println("session:"+session.getAttribute("id"));
        
            
        }else if(reCode==-1){
            reslut =new Reslut(-1,"密码错误",null);
        }else if(reCode==-2){
            reslut =new Reslut(-2,"用户不存在",null);
        }else if(reCode==-3){
            reslut =new Reslut(-3,"帐号或密码为空",null);
        }else {
            reslut = new Reslut(-5, "连接错误", null);
        }
        response.getWriter().println(JSON.toJSONString(reslut));
    }
}
