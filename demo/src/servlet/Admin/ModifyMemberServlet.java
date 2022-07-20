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
import entity.User;


/**
 * Servlet implementation class ModifyMemberServlet
 */
@WebServlet("/ModifyMemberServlet")
public class ModifyMemberServlet extends HttpServlet {
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
			rds = request.getRequestDispatcher("Admin/MemberModifyInfo.jsp");
			rds.forward(request, response);
		}else if("modifyUser".equals(act)){
			User user = new User();
			String modifyValue = request.getParameter("modifyValue");
			String modifyType = request.getParameter("modifyType");
			uid = request.getParameter("uid");
			boolean modifyIsSuccess = false;
			try {
				if(!"".equals(modifyValue)) {
					user.setUid(Integer.parseInt(uid));
					switch(modifyType) {
						case "����": 
							user.setUname(modifyValue);
							modifyIsSuccess = abiz.modifyUname(user);
							break;
						case "����": 
							user.setUpwd(modifyValue);
							modifyIsSuccess = abiz.modifyUpwd(user);
							break;
						case "����": 
							user.setUage(Integer.parseInt(modifyValue));
							modifyIsSuccess = abiz.modifyUage(user);
							break;
						case "�Ա�": 
							user.setUsex(modifyValue);
							modifyIsSuccess = abiz.modifyUsex(user);
							break;
						case "�꼶": 
							user.setUgrade(modifyValue);
							modifyIsSuccess = abiz.modifyUgrade(user);
							break;
						case "רҵ": 
							user.setUmajor(modifyValue);
							modifyIsSuccess = abiz.modifyUmajor(user);
							break;
						case "�༶": 
							user.setUclass(modifyValue);
							modifyIsSuccess = abiz.modifyUclass(user);
							break;
						case "��������": 
							user.setUclassroom(modifyValue);
							modifyIsSuccess = abiz.modifyUclassroom(user);
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
								+ "            window.location.href = 'MemberIndexServlet?act=index';\r\n"
								+ "        }\r\n"
								+ "    }\r\n"
								+ "    setTimeout(jump,1000);\r\n"
								+ "</script>");
						out.println("<h1>�޸ĳɹ���<span id='good' style='color: red;'>3</span>���ӷ��أ�</h1>");
//						response.setHeader("refresh", "3; url=UserManagerServlet?act=select");
					}else {
						out.println("<script type=\"text/javascript\">\r\n"
								+ "    var sec = 3;\r\n"
								+ "    function jump(){\r\n"
								+ "        sec--;\r\n"
								+ "        if(sec > 0){\r\n"
								+ "            document.getElementById('good').innerHTML = sec;\r\n"
								+ "            setTimeout(this.jump,1000);\r\n"
								+ "        }else{\r\n"
								+ "            window.location.href = 'ModifyMemberServlet?act=modify&&uid="+uid+"';\r\n"
								+ "        }\r\n"
								+ "    }\r\n"
								+ "    setTimeout(jump,1000);\r\n"
								+ "</script>");
						out.println("<h1>�޸�ʧ�ܣ������û��Ƿ���ڣ�<span id='good' style='color: red;'>3</span>������ԣ�</h1>");
//						response.setHeader("refresh", "3; url=UserManagerServlet?act=modify");
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
							+ "            window.location.href = 'ModifyMemberServlet?act=modify&&uid="+uid+"';\r\n"
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
						+ "            window.location.href = 'ModifyMemberServlet?act=modify&&uid="+uid+"';\r\n"
						+ "        }\r\n"
						+ "    }\r\n"
						+ "    setTimeout(jump,1000);\r\n"
						+ "</script>");
				out.println("<h1>�޸�ʧ�ܣ������û��Ƿ���ڣ�<span id='good' style='color: red;'>3</span>������ԣ�</h1>");
			}
			
		}
		
	}

}
