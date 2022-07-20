package servlet.Admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONObject;

import biz.AdminBiz;

/**
 * Servlet implementation class LoginAjaxServlet
 */
@WebServlet("/LoginAjaxServlet")
public class LoginAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAjaxServlet() {
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
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(true);
		String adminid = request.getParameter("adminid");
		String adminpwd = request.getParameter("adminpwd");
		String admintype = request.getParameter("admintype");
		session.setAttribute("adminid", adminid);
		session.setAttribute("admintype", admintype);
		AdminBiz adminbiz = new AdminBiz();
		PrintWriter out = null;
		if("大组长".equals(admintype)) {
			try {
				int aid = Integer.parseInt(adminid);
				if(adminbiz.Alogin(aid, adminpwd)) {
					JSONObject jsonObject=new JSONObject();
					out=response.getWriter();
					out.println(jsonObject);
					out.close();
				}else {
					JSONObject jsonObject=new JSONObject();
					jsonObject.put("errcroe", "400");
					jsonObject.put("msg", "学号或者密码错误");
					out=response.getWriter();
					out.println(jsonObject);
					out.close();	
				}
			} catch (Exception e) {
				JSONObject jsonObject=new JSONObject();
				jsonObject.put("errcroe", "400");
				jsonObject.put("msg", "学号或者密码错误");
				out=response.getWriter();
				out.println(jsonObject);
				out.close();
			}
		}else if("小组长".equals(admintype)) {
			
			try {
				int aid = Integer.parseInt(adminid);
				if(adminbiz.Ulogin(aid, adminpwd)) {
					JSONObject jsonObject=new JSONObject();
					out=response.getWriter();
					out.println(jsonObject);
					out.close();
				}else {
					JSONObject jsonObject=new JSONObject();
					jsonObject.put("errcroe", "400");
					jsonObject.put("msg", "学号或者密码错误");
					out=response.getWriter();
					out.println(jsonObject);
					out.close();
				}
			} catch (Exception e) {
				JSONObject jsonObject=new JSONObject();
				jsonObject.put("errcroe", "400");
				jsonObject.put("msg", "学号或者密码错误");
				out=response.getWriter();
				out.println(jsonObject);
				out.close();
			}
		} else if("组员".equals(admintype)) {	
			try {
				int aid = Integer.parseInt(adminid);
				if(adminbiz.Mlogin(aid, adminpwd)) {
					JSONObject jsonObject=new JSONObject();
					out=response.getWriter();
					out.println(jsonObject);
					out.close();
				}else {
					JSONObject jsonObject=new JSONObject();
					jsonObject.put("errcroe", "400");
					jsonObject.put("msg", "学号或者密码错误");
					out=response.getWriter();
					out.println(jsonObject);
					out.close();
				}
			} catch (Exception e) {
				JSONObject jsonObject=new JSONObject();
				jsonObject.put("errcroe", "400");
				jsonObject.put("msg", "学号或者密码错误");
				out=response.getWriter();
				out.println(jsonObject);
				out.close();
			}
		}else {
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("errcroe", "400");
			jsonObject.put("msg", "学号或者密码错误");
			out=response.getWriter();
			out.println(jsonObject);
			out.close();
		}
	}

}
