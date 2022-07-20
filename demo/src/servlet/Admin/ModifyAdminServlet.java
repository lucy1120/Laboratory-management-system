package servlet.Admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.AdminBiz;
import entity.Admin;

/**
 * Servlet implementation class ModifyAdminServlet
 */
@WebServlet("/ModifyAdminServlet")
public class ModifyAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		AdminBiz abiz = new AdminBiz();
		PrintWriter out = response.getWriter();
		String act = request.getParameter("act");
		String uid = request.getParameter("uid");
		RequestDispatcher rds = null;
		if("modify".equals(act)) {
			request.setAttribute("uid", uid);
			rds = request.getRequestDispatcher("Admin/AdminModifyInfo.jsp");
			rds.forward(request, response);
		}else if("modifyUser".equals(act)){
			Admin user = new Admin();
			String modifyValue = request.getParameter("modifyValue");
			String modifyType = request.getParameter("modifyType");
			uid = request.getParameter("uid");
			boolean modifyIsSuccess = false;
			try {
				if(!"".equals(modifyValue)) {
					user.setAid(Integer.parseInt(uid));
					switch(modifyType) {
						case "����": 
							user.setAname(modifyValue);
							modifyIsSuccess = abiz.modifyAname(user);
							break;
						case "����": 
							user.setApwd(modifyValue);
							modifyIsSuccess = abiz.modifyApwd(user);
							break;
						case "����": 
							user.setAage(Integer.parseInt(modifyValue));
							modifyIsSuccess = abiz.modifyAage(user);
							break;
						case "�Ա�": 
							user.setAsex(modifyValue);
							modifyIsSuccess = abiz.modifyAsex(user);
							break;
						case "�꼶": 
							user.setAgrade(modifyValue);
							modifyIsSuccess = abiz.modifyAgrade(user);
							break;
						case "רҵ": 
							user.setAmajor(modifyValue);
							modifyIsSuccess = abiz.modifyAmajor(user);
							break;
						case "�༶": 
							user.setAclass(modifyValue);
							modifyIsSuccess = abiz.modifyAclass(user);
							break;
					}
					if(modifyIsSuccess) {
						out.println("<script type=\"text/javascript\">\r\n"
								+ "setTimeout(function(){\r\n"
								+ "            parent.location.reload();\r\n"
								+ "        },3000);"
								+ "</script>");
						out.println("<script type=\"text/javascript\">\r\n"
								+ "    var sec = 3;\r\n"
								+ "    function jump(){\r\n"
								+ "        sec--;\r\n"
								+ "        if(sec > 0){\r\n"
								+ "            document.getElementById('good').innerHTML = sec;\r\n"
								+ "            setTimeout(this.jump,1000);\r\n"
								+ "        }else{\r\n"
								+ "            window.location.href = 'IndexServlet?act=index';\r\n"
								+ "        }\r\n"
								+ "    }\r\n"
								+ "    setTimeout(jump,1000);\r\n"
								+ "</script>");
						out.println("<h1>�޸ĳɹ���<span id='good' style='color: red;'>3</span>���ӷ��أ�</h1>");
						
	//					response.setHeader("refresh", "3; url=UserManagerServlet?act=select");
					}else {
						out.println("<script type=\"text/javascript\">\r\n"
								+ "    var sec = 3;\r\n"
								+ "    function jump(){\r\n"
								+ "        sec--;\r\n"
								+ "        if(sec > 0){\r\n"
								+ "            document.getElementById('good').innerHTML = sec;\r\n"
								+ "            setTimeout(this.jump,1000);\r\n"
								+ "        }else{\r\n"
								+ "            window.location.href = 'ModifyAdminServlet?act=modify&&uid="+uid+"';\r\n"
								+ "        }\r\n"
								+ "    }\r\n"
								+ "    setTimeout(jump,1000);\r\n"
								+ "</script>");
						out.println("<h1>�޸�ʧ�ܣ������û��Ƿ���ڣ�<span id='good' style='color: red;'>3</span>������ԣ�</h1>");
	//					response.setHeader("refresh", "3; url=UserManagerServlet?act=modify");
					}
				}else {
					out.println("<script type=\"text/javascript\">\r\n"
							+ "    var sec = 3;\r\n"
							+ "    function jump(){\r\n"
							+ "        sec--;\r\n"
							+ "        if(sec > 0){\r\n"
							+ "            document.getElementById('good').innerHTML = sec;\r\n"
							+ "            setTimeout(this.jump,1000);\r\n"
							+ "        }else{\r\n"
							+ "            window.location.href = 'ModifyAdminServlet?act=modify&&uid="+uid+"';\r\n"
							+ "        }\r\n"
							+ "    }\r\n"
							+ "    setTimeout(jump,1000);\r\n"
							+ "</script>");
					out.println("<h1>�޸�ʧ�ܣ�����ֵ�Ƿ�Ϊ�գ�<span id='good' style='color: red;'>3</span>������ԣ�</h1>");
				}
			}catch (Exception e) {
				out.println("<script type=\"text/javascript\">\r\n"
						+ "    var sec = 3;\r\n"
						+ "    function jump(){\r\n"
						+ "        sec--;\r\n"
						+ "        if(sec > 0){\r\n"
						+ "            document.getElementById('good').innerHTML = sec;\r\n"
						+ "            setTimeout(this.jump,1000);\r\n"
						+ "        }else{\r\n"
						+ "            window.location.href = 'ModifyAdminServlet?act=modify&&uid="+uid+"';\r\n"
						+ "        }\r\n"
						+ "    }\r\n"
						+ "    setTimeout(jump,1000);\r\n"
						+ "</script>");
				out.println("<h1>�޸�ʧ�ܣ������û��Ƿ���ڣ�<span id='good' style='color: red;'>3</span>������ԣ�</h1>");
			}
		}
	}
}
