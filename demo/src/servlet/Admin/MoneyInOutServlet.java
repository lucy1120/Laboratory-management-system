package servlet.Admin;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.AdminBiz;

/**
 * Servlet implementation class MoneyInOutServlet
 */
@WebServlet("/MoneyInOutServlet")
public class MoneyInOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		AdminBiz abiz = new AdminBiz();
		String mtype = request.getParameter("mtype");
		List<Map<String, Object>> list = null;
		RequestDispatcher rds = null;
		if("all".equals(mtype)) {
			list = abiz.selectAllMoneylog();
			for (Map<String, Object> map : list) {
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				map.replace("mtime", (Object)sdf.format(map.get("mtime")));
			}
		}else {
			list = abiz.selectMoneylogByMtype(mtype);
			for (Map<String, Object> map : list) {
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				map.replace("mtime", (Object)sdf.format(map.get("mtime")));
			}
		}
		request.setAttribute("moneyList", list);
		rds = request.getRequestDispatcher("Admin/MoneyInOut.jsp");
		rds.forward(request, response);
	}

}
