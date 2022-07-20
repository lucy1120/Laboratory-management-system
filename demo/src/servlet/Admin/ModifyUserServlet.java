package servlet.Admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.SadminBiz;
import entity.User;


/**
 * Servlet implementation class ModifyMemberServlet
 */
@WebServlet("/ModifyUserServlet")
public class ModifyUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		SadminBiz abiz = new SadminBiz();
		PrintWriter out = response.getWriter();
		String act = request.getParameter("act");
		String uid = request.getParameter("uid");
		RequestDispatcher rds = null;
		if("modify".equals(act)) {
			request.setAttribute("uid", uid);
			rds = request.getRequestDispatcher("Admin/UserModifyInfo.jsp");
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
						case "姓名": 
							user.setUname(modifyValue);
							modifyIsSuccess = abiz.modifyUname(user);
							break;
						case "密码": 
							user.setUpwd(modifyValue);
							modifyIsSuccess = abiz.modifyUpwd(user);
							break;
						case "年龄": 
							user.setUage(Integer.parseInt(modifyValue));
							modifyIsSuccess = abiz.modifyUage(user);
							break;
						case "性别": 
							user.setUsex(modifyValue);
							modifyIsSuccess = abiz.modifyUsex(user);
							break;
						case "年级": 
							user.setUgrade(modifyValue);
							modifyIsSuccess = abiz.modifyUgrade(user);
							break;
						case "专业": 
							user.setUmajor(modifyValue);
							modifyIsSuccess = abiz.modifyUmajor(user);
							break;
						case "班级": 
							user.setUclass(modifyValue);
							modifyIsSuccess = abiz.modifyUclass(user);
							break;
						case "所属机房": 
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
								+ "            window.location.href = 'UserIndexServlet?act=index';\r\n"
								+ "        }\r\n"
								+ "    }\r\n"
								+ "    setTimeout(jump,1000);\r\n"
								+ "</script>");
						out.println("<h1>修改成功！<span id='good' style='color: red;'>3</span>秒钟返回！</h1>");
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
								+ "            window.location.href = 'ModifyUserServlet?act=modify&&uid="+uid+"';\r\n"
								+ "        }\r\n"
								+ "    }\r\n"
								+ "    setTimeout(jump,1000);\r\n"
								+ "</script>");
						out.println("<h1>修改失败！请检查用户是否存在，<span id='good' style='color: red;'>3</span>秒后再试！</h1>");
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
							+ "            window.location.href = 'ModifyUserServlet?act=modify&&uid="+uid+"';\r\n"
							+ "        }\r\n"
							+ "    }\r\n"
							+ "    setTimeout(jump,1000);\r\n"
							+ "</script>");
					out.println("<h1>修改失败！请检查值是否为空，<span id='good' style='color: red;'>3</span>秒后再试！</h1>");
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
						+ "            window.location.href = 'ModifyUserServlet?act=modify&&uid="+uid+"';\r\n"
						+ "        }\r\n"
						+ "    }\r\n"
						+ "    setTimeout(jump,1000);\r\n"
						+ "</script>");
				out.println("<h1>修改失败！请检查用户是否存在，<span id='good' style='color: red;'>3</span>秒后再试！</h1>");
			}
			
		}
		
	}

}
