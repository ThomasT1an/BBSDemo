package cn.wlbbs.c;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.wlbbs.jdbc.Jdbc;

public class SearchServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
//修改 ？ 为？where stuid=？ 1.改什么？ 2.stuid
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String pinglun = request.getParameter("pinglun");
		String psw =new Jdbc().findComment(pinglun);
		System.out.println("test");
	}

}
