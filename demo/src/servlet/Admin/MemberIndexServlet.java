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
@WebServlet("/MemberIndexServlet")
public class MemberIndexServlet extends HttpServlet {
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
		List<Map<String, Object>> memberlist = null;
		String act = request.getParameter("act");
		RequestDispatcher rds = null;
		//��ѯ
		if("index".equals(act)){
			
			int SoftwareEngineering = abiz.selectMajorPeople("�������");
			int ComputerClass = abiz.selectMajorPeople("�������");
			int NetworkEngineering = abiz.selectMajorPeople("���繤��");
			int ComputerScience = abiz.selectMajorPeople("�������ѧ�뼼��");
			int AI = abiz.selectMajorPeople("�˹�����");
			int g2019 = abiz.selectGradePeople("2019��");
			int g2020 = abiz.selectGradePeople("2020��");
			int boy = abiz.selectSexPeople("��");
			int girl = abiz.selectSexPeople("Ů");
			request.setAttribute("boy",boy);
			request.setAttribute("girl",girl);
			request.setAttribute("g2019",g2019);
			request.setAttribute("g2020",g2020);
			request.setAttribute("ComputerClass",ComputerClass);
			request.setAttribute("SoftwareEngineering",SoftwareEngineering);
			request.setAttribute("NetworkEngineering",NetworkEngineering);
			request.setAttribute("ComputerScience",ComputerScience);
			request.setAttribute("AI",AI);
			
			memberlist = abiz.selectMemberID(aid);
			request.setAttribute("adminList", memberlist);
			rds = request.getRequestDispatcher("Admin/message2.jsp");
			rds.forward(request, response);
			
		}
	}
}

