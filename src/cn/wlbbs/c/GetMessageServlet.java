package cn.wlbbs.c;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cn.wlbbs.bean.UserBean;
import cn.wlbbs.jdbc.Jdbc;

public class GetMessageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String stuid = request.getParameter("stuid");
		Integer a=Integer.valueOf(stuid).intValue();
		UserBean ub =new Jdbc().getMessage(a);
		//System.out.println(psw);
		System.out.println("test");
		response.getWriter().println(JSON.toJSONString(ub));
	}
}
