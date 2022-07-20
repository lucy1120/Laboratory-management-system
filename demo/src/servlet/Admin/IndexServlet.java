package servlet.Admin;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.AdminBiz;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(true);
		String adminid = (String) session.getAttribute("adminid");
		int aid = Integer.parseInt(adminid);
		AdminBiz abiz = new AdminBiz();
		List<Map<String, Object>> adminlist = null;
		String act = request.getParameter("act");
		RequestDispatcher rds = null;
		//查询
		if("index".equals(act)){
			
			int SoftwareEngineering = abiz.selectMajorPeople("软件工程");
			int ComputerClass = abiz.selectMajorPeople("计算机类");
			int NetworkEngineering = abiz.selectMajorPeople("网络工程");
			int ComputerScience = abiz.selectMajorPeople("计算机科学与技术");
			int AI = abiz.selectMajorPeople("人工智能");
			int g2019 = abiz.selectGradePeople("2019级");
			int g2020 = abiz.selectGradePeople("2020级");
			int boy = abiz.selectSexPeople("男");
			int girl = abiz.selectSexPeople("女");
			request.setAttribute("boy",boy);
			request.setAttribute("girl",girl);
			request.setAttribute("g2019",g2019);
			request.setAttribute("g2020",g2020);
			request.setAttribute("ComputerClass",ComputerClass);
			request.setAttribute("SoftwareEngineering",SoftwareEngineering);
			request.setAttribute("NetworkEngineering",NetworkEngineering);
			request.setAttribute("ComputerScience",ComputerScience);
			request.setAttribute("AI",AI);
			
			adminlist = abiz.selectAdminID(aid);
			request.setAttribute("adminList", adminlist);
			rds = request.getRequestDispatcher("Admin/message.jsp");
			rds.forward(request, response);
			
		}
	}
}

