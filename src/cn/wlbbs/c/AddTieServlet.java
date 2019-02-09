package cn.wlbbs.c;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;

import cn.wlbbs.bean.Reslut;
import cn.wlbbs.jdbc.Jdbc;

public class AddTieServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Reslut reslut;
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String name = request.getParameter("name");	
		String data = request.getParameter("data");	
		String zone = request.getParameter("zone");	
		HttpSession session = request.getSession();
		Integer uid = (Integer) session.getAttribute("id");
		if(uid==null){
			System.out.println("no login");
			reslut =new Reslut(-1,"未登录",null);
		}
		else{	
			System.out.println(name);
			Jdbc u=new Jdbc();
			u.addTie(name,uid,data,zone);
			System.out.println("发帖成功！");
			reslut =new Reslut(1,"发帖成功",null);
			}
		response.getWriter().println(JSON.toJSONString(reslut));
	}
}
