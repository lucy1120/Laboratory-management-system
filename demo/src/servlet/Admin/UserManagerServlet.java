package servlet.Admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.AdminBiz;
import entity.User;

@WebServlet("/UserManagerServlet")
public class UserManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		AdminBiz abiz = new AdminBiz();
		List<Map<String, Object>> list = null;
		PrintWriter out = response.getWriter();
		String act = request.getParameter("act");
		RequestDispatcher rds = null;
		//��ѯ
		if("select".equals(act)){
			rds = request.getRequestDispatcher("Admin/userSelect.jsp");
			rds.forward(request, response);
		}else if("selectUser".equals(act)){
			//ɾ���û��ı�־
			String del = request.getParameter("del");
			
			//��ò�ѯ��������
			String aact = request.getParameter("aact");
			
			//������ѯ
			String uname = request.getParameter("uname");
			String umajor = request.getParameter("umajor");
			
			//��������ѯ��ҳURL��ʹ��
			String uname1 = request.getParameter("uname1");
			
			//������ѯ��ҳ
			if(uname1 == null) {
				uname1 = uname;
			}
			//������ѯ����ҳ
			if(uname == null) {
				uname = uname1;
			}
			//������ѯ
			if("condiction".equals(aact)){
	
				list = abiz.conditionSelectUsers(uname, umajor, null);
				
			}else{
				list = abiz.selectUsers();
			}	
			//��ҳ��ѯ
			int temp = list.size();
			
			request.setAttribute("totalCount", temp);
			
			int totalPage = 0;
			if (temp == 0) {
				totalPage = 0;//��ҳ��
			} else {
				//���ش��ڻ��ߵ���ָ�����ʽ����С����
				totalPage = (int) Math.ceil((double) temp / 10);
				
			}
			String pageCur11 = request.getParameter("pageCur");
			if (pageCur11 == null) {
				pageCur11 = "1";
			}
			int  pageCur = Integer.parseInt(pageCur11);
			if ((pageCur - 1) * 10 > temp) {
				pageCur = pageCur - 1;
			}
			//��ҳ��ѯ
			int startIndex = (pageCur - 1) * 10;//��ʼλ��
			int perPageSize = 10;//ÿҳ10��
			if("condiction".equals(aact)) {
				list = abiz.conditionSelectUsersByPage(uname, umajor, startIndex, perPageSize);
			}else {
				list = abiz.selectAllUsersByPage(startIndex, perPageSize);
			}
			//���Բ�ѯ����
			request.setAttribute("uname1", uname1);
			request.setAttribute("aact", aact);
			request.setAttribute("umajor", umajor);
			request.setAttribute("userList", list);
			request.setAttribute("totalPage", totalPage);
			request.setAttribute("pageCur", pageCur);
			//��ѯ
			if("select".equals(aact) || "condiction".equals(aact) && !"del".equals(del)){
				rds = request.getRequestDispatcher("Admin/userSelect.jsp");
			}
			//ɾ��
			if("select".equals(aact) || "condiction".equals(aact) && "del".equals(del)){
				rds = request.getRequestDispatcher("Admin/userDelete.jsp");
			}
			rds.forward(request, response);
		}else if("selectUserSA".equals(act)){
			String uclassroom = request.getParameter("uclassroom");
			String aact = request.getParameter("aact");
			String uname = request.getParameter("uname");
			String umajor = request.getParameter("umajor");
			if("condiction".equals(aact)){
				list = abiz.conditionSelectUsers(uname, umajor, uclassroom);
			}else{
				list = abiz.selectUsersByUclassroom(uclassroom);
			}
			request.setAttribute("userList", list);
			request.setAttribute("uclassroom", uclassroom);
			rds = request.getRequestDispatcher("Admin/userDeleteSA.jsp");
			rds.forward(request, response);
		}else if("deleteUser".equals(act)){
			String uid = request.getParameter("uid");
			String uclassroom = request.getParameter("uclassroom");
			if(abiz.deleteUser(uid)){
				out.println("<script type=\"text/javascript\">\r\n"
						+ "    var sec = 3;\r\n"
						+ "    function jump(){\r\n"
						+ "        sec--;\r\n"
						+ "        if(sec > 0){\r\n"
						+ "            document.getElementById('good').innerHTML = sec;\r\n"
						+ "            setTimeout(this.jump,1000);\r\n"
						+ "        }else{\r\n"
						+ "            window.location.href = 'UserManagerServlet?act=delete&saclassroom="+uclassroom+"';\r\n"
						+ "        }\r\n"
						+ "    }\r\n"
						+ "    setTimeout(jump,1000);\r\n"
						+ "</script>");
				out.println("<h1>ɾ���ɹ���<span id='good' style='color: red;'>3</span>���ӷ��أ�</h1>");
//				response.setHeader("refresh", "3; url=UserManagerServlet?act=delete");
			}
		}else if("delete".equals(act)){
			String saclassroom = request.getParameter("saclassroom");

			if("".equals(saclassroom) || "null".equals(saclassroom)) {
				rds = request.getRequestDispatcher("Admin/userDelete.jsp");
			}else {
				request.setAttribute("uclassroom", saclassroom);
				rds = request.getRequestDispatcher("Admin/userDeleteSA.jsp");
			}
			rds.forward(request, response);
		}else if("addUser".equals(act)){
			String uid = request.getParameter("uid");
			String uname = request.getParameter("uname");
			String upwd = request.getParameter("upwd");
			String uage = request.getParameter("uage");
			String usex = request.getParameter("usex");
			String ugrade = request.getParameter("ugrade");
			ugrade = ugrade + '��';
			String umajor = request.getParameter("umajor");
			String uclass = request.getParameter("uclass");
			uclass = uclass + '��';
			String uclassroom = request.getParameter("uclassroom");
			User user = null;
			try {
				user = new User(Integer.parseInt(uid),uname, upwd, Integer.parseInt(uage), usex, ugrade, uclass,uclassroom);
			}catch (Exception e) {
				out.println("<script type=\"text/javascript\">\r\n"
						+ "    var sec = 3;\r\n"
						+ "    function jump(){\r\n"
						+ "        sec--;\r\n"
						+ "        if(sec > 0){\r\n"
						+ "            document.getElementById('good').innerHTML = sec;\r\n"
						+ "            setTimeout(this.jump,1000);\r\n"
						+ "        }else{\r\n"
						+ "            window.location.href = 'UserManagerServlet?act=add';\r\n"
						+ "        }\r\n"
						+ "    }\r\n"
						+ "    setTimeout(jump,1000);\r\n"
						+ "</script>");
				out.println("<h1>���ʧ�ܣ�<span id='good' style='color: red;'>3</span>���ӷ��أ�</h1>");
			}
			user.setUmajor(umajor);
			if(abiz.IsUser(uid).size() == 0 && !"".equals(uname) && !"".equals(upwd) && !"".equals(usex)
					&& !"".equals(ugrade) && !"".equals(uclass) && !"".equals(uclassroom)){
				if(abiz.addUser(user)) {
					out.println("<script type=\"text/javascript\">\r\n"
							+ "    var sec = 3;\r\n"
							+ "    function jump(){\r\n"
							+ "        sec--;\r\n"
							+ "        if(sec > 0){\r\n"
							+ "            document.getElementById('good').innerHTML = sec;\r\n"
							+ "            setTimeout(this.jump,1000);\r\n"
							+ "        }else{\r\n"
							+ "            window.location.href = 'UserManagerServlet?act=select';\r\n"
							+ "        }\r\n"
							+ "    }\r\n"
							+ "    setTimeout(jump,1000);\r\n"
							+ "</script>");
					out.println("<h1>��ӳɹ���<span id='good' style='color: red;'>3</span>���ӷ��أ�</h1>");
				}else {
					out.println("<script type=\"text/javascript\">\r\n"
							+ "    var sec = 3;\r\n"
							+ "    function jump(){\r\n"
							+ "        sec--;\r\n"
							+ "        if(sec > 0){\r\n"
							+ "            document.getElementById('good').innerHTML = sec;\r\n"
							+ "            setTimeout(this.jump,1000);\r\n"
							+ "        }else{\r\n"
							+ "            window.location.href = 'UserManagerServlet?act=add';\r\n"
							+ "        }\r\n"
							+ "    }\r\n"
							+ "    setTimeout(jump,1000);\r\n"
							+ "</script>");
					out.println("<h1>���ʧ�ܣ�<span id='good' style='color: red;'>3</span>���ӷ��أ�</h1>");
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
						+ "            window.location.href = 'UserManagerServlet?act=add';\r\n"
						+ "        }\r\n"
						+ "    }\r\n"
						+ "    setTimeout(jump,1000);\r\n"
						+ "</script>");
				out.println("<h1>���ʧ�ܣ�������û��Ƿ��Ѵ��ڣ�<span id='good' style='color: red;'>3</span>���ӷ��أ�</h1>");
//				response.setHeader("refresh", "20; url=UserManagerServlet?act=add");
			}
		}else if("add".equals(act)){
			String saclassroom = request.getParameter("saclassroom");
			if(saclassroom != null) {
				request.setAttribute("uclassroom", saclassroom);
				rds = request.getRequestDispatcher("Admin/userAddSA.jsp");
			}else {
				list = abiz.selectAllComputerroomExceptOnduty();
				request.setAttribute("computerroomList", list);
				rds = request.getRequestDispatcher("Admin/userAdd.jsp");
			}
			
			rds.forward(request, response);
		}else if("modify".equals(act)){
			rds = request.getRequestDispatcher("Admin/userModify.jsp");
			rds.forward(request, response);
		}else if("modifyUser".equals(act)){
			User user = new User();
			String modifyValue = request.getParameter("modifyValue");
			String modifyType = request.getParameter("modifyType");
			String uid = request.getParameter("uid");
			boolean modifyIsSuccess = false;
			try {
				user.setUid(Integer.parseInt(uid));
				if(!"".equals(modifyValue)) {
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
								+ "    var sec = 3;\r\n"
								+ "    function jump(){\r\n"
								+ "        sec--;\r\n"
								+ "        if(sec > 0){\r\n"
								+ "            document.getElementById('good').innerHTML = sec;\r\n"
								+ "            setTimeout(this.jump,1000);\r\n"
								+ "        }else{\r\n"
								+ "            window.location.href = 'UserManagerServlet?act=select';\r\n"
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
								+ "            window.location.href = 'UserManagerServlet?act=modify';\r\n"
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
							+ "            window.location.href = 'UserManagerServlet?act=modify';\r\n"
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
						+ "            window.location.href = 'UserManagerServlet?act=modify';\r\n"
						+ "        }\r\n"
						+ "    }\r\n"
						+ "    setTimeout(jump,1000);\r\n"
						+ "</script>");
				out.println("<h1>�޸�ʧ�ܣ�����ֵ�Ƿ�Ϊ�գ�<span id='good' style='color: red;'>3</span>������ԣ�</h1>");

			}
			
			
		}
		
	}

}
