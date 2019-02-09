package cn.wlbbs.c;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;

import cn.wlbbs.bean.Reslut;
import cn.wlbbs.jdbc.Jdbc;

public class UpdateServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Reslut reslut;
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String where = request.getParameter("where"); //列名
		String what = request.getParameter("what");   //改成什么
		HttpSession session = request.getSession();
		Integer id = (Integer) session.getAttribute("id");
		System.out.println(id);
		if(id==null){
			System.out.println("no login");
			reslut =new Reslut(-1,"未登录",null);
		}
		else{	
			try {
				Jdbc.update(where,what,id);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
		
		System.out.println("修改成功！");
		reslut =new Reslut(1,"修改成功",null);
	}
		response.getWriter().println(JSON.toJSONString(reslut));
	}
		

}
