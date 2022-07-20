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
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(true);
		String adminid = request.getParameter("adminid");
		String admintype = request.getParameter("admintype");
		session.setAttribute("adminid", adminid);
		session.setAttribute("admintype", admintype);
		AdminBiz adminbiz = new AdminBiz();
		RequestDispatcher rds = null;
		if("大组长".equals(admintype)) {
			int aid = Integer.parseInt(adminid);
			List<Map<String, Object>> list = adminbiz.selectAdminID(aid);
			request.setAttribute("adminList", list);
			rds = request.getRequestDispatcher("Admin/AdminIndex.jsp");
			rds.forward(request, response);
		}else if("小组长".equals(admintype)) {
			int aid = Integer.parseInt(adminid);
			List<Map<String, Object>> list = adminbiz.selectUserID(aid);
			request.setAttribute("adminList", list);
			rds = request.getRequestDispatcher("Admin/UserIndex.jsp");
			rds.forward(request, response);
		} else if("组员".equals(admintype)) {
			int aid = Integer.parseInt(adminid);
			List<Map<String, Object>> list = adminbiz.selectMemberID(aid);
			request.setAttribute("adminList", list);
			rds = request.getRequestDispatcher("Admin/MemberIndex.jsp");
			rds.forward(request, response);
		}
	}

}
