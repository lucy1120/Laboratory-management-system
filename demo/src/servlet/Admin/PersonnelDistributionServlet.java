package servlet.Admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.AdminBiz;

@WebServlet("/PersonnelDistributionServlet")
public class PersonnelDistributionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		AdminBiz abiz = new AdminBiz();
		String act = request.getParameter("act");
		RequestDispatcher rds = null;
		//查询
		if("major".equals(act)){

			int SoftwareEngineering = abiz.selectMajorPeople("软件工程");
			int ComputerClass = abiz.selectMajorPeople("计算机类");
			int NetworkEngineering = abiz.selectMajorPeople("网络工程");
			int ComputerScience = abiz.selectMajorPeople("计算机科学与技术");
			int AI = abiz.selectMajorPeople("人工智能");
			request.setAttribute("ComputerClass",ComputerClass);
			request.setAttribute("SoftwareEngineering",SoftwareEngineering);
			request.setAttribute("NetworkEngineering",NetworkEngineering);
			request.setAttribute("ComputerScience",ComputerScience);
			request.setAttribute("AI",AI);
			rds = request.getRequestDispatcher("Admin/PersonnelMajorDistribution.jsp");
			rds.forward(request, response);
			
		} else if ("grade".equals(act)){
			
			int g2019 = abiz.selectGradePeople("2019级");
			int g2020 = abiz.selectGradePeople("2020级");
			request.setAttribute("g2019",g2019);
			request.setAttribute("g2020",g2020);
			rds = request.getRequestDispatcher("Admin/PersonnelGradeDistribution.jsp");
			rds.forward(request, response);
			
		} else if ("sex".equals(act)){
			
			int boy = abiz.selectSexPeople("男");
			int girl = abiz.selectSexPeople("女");
			request.setAttribute("boy",boy);
			request.setAttribute("girl",girl);
			rds = request.getRequestDispatcher("Admin/PersonnelSexDistribution.jsp");
			rds.forward(request, response);
			
		}
	}
}
