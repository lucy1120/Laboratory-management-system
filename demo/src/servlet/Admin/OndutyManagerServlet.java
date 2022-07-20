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
import entity.Onduty;

@WebServlet("/OndutyManagerServlet")
public class OndutyManagerServlet extends HttpServlet {
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
			rds = request.getRequestDispatcher("Admin/OndutySelect.jsp");
			rds.forward(request, response);
		}else if("selectOnduty".equals(act)){
			//ɾ���ı�־
			String del = request.getParameter("del");
			
			//��ò�ѯ��������
			String aact = request.getParameter("aact");
			
			//������ѯ
			String oname = request.getParameter("oname");
			String oweekday = request.getParameter("oweekday");
			
			//��������ѯ��ҳURL��ʹ��
			String oname1 = request.getParameter("oname1");
			
			//������ѯ��ҳ
			if(oname1 == null) {
				oname1 = oname;
			}
			//������ѯ����ҳ
			if(oname == null) {
				oname = oname1;
			}
			//������ѯ
			if("condiction".equals(aact)){
	
				list = abiz.conditionSelectOnduty(oname, oweekday);
				
			}else{
				list = abiz.selectOnduty();
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
				list = abiz.conditionSelectOndutyByPage(oname, oweekday, startIndex, perPageSize);
			}else {
				list = abiz.selectAllOndutyByPage(startIndex, perPageSize);
			}
			//���Բ�ѯ����
			request.setAttribute("oname1", oname1);
			request.setAttribute("aact", aact);
			request.setAttribute("oweekday", oweekday);
			request.setAttribute("ondutyList", list);
			request.setAttribute("totalPage", totalPage);
			request.setAttribute("pageCur", pageCur);
			//��ѯ
			if("select".equals(aact) || "condiction".equals(aact) && !"del".equals(del)){
				rds = request.getRequestDispatcher("Admin/OndutySelect.jsp");
			}
			//ɾ��
			if("select".equals(aact) || "condiction".equals(aact) && "del".equals(del)){
				rds = request.getRequestDispatcher("Admin/OndutyDelete.jsp");
			}
			rds.forward(request, response);
		}else if("deleteOnduty".equals(act)){
			String oid = request.getParameter("oid");
			if(abiz.deleteOnduty(oid)){
				out.println("<script type=\"text/javascript\">\r\n"
						+ "    var sec = 3;\r\n"
						+ "    function jump(){\r\n"
						+ "        sec--;\r\n"
						+ "        if(sec > 0){\r\n"
						+ "            document.getElementById('good').innerHTML = sec;\r\n"
						+ "            setTimeout(this.jump,1000);\r\n"
						+ "        }else{\r\n"
						+ "            window.location.href = 'OndutyManagerServlet?act=delete';\r\n"
						+ "        }\r\n"
						+ "    }\r\n"
						+ "    setTimeout(jump,1000);\r\n"
						+ "</script>");
				out.println("<h1>ɾ���ɹ���<span id='good' style='color: red;'>3</span>���ӷ��أ�</h1>");
//				response.setHeader("refresh", "3; url=UserManagerServlet?act=delete");
			}
		}else if("delete".equals(act)){
	//		list = abiz.selectUsers();
	//		request.setAttribute("userList", list);
			rds = request.getRequestDispatcher("Admin/OndutyDelete.jsp");
			rds.forward(request, response);
		}else if("addOnduty".equals(act)){
			String oid = request.getParameter("oid");
			String oname = request.getParameter("oname");
			String oweekday = request.getParameter("oweekday");
			String obegintime = request.getParameter("obegintime");
			String oendtime = request.getParameter("oendtime");
			String oroom = request.getParameter("oroom");
			Onduty onduty = null;
			try {
				onduty = new Onduty(Integer.parseInt(oid),oname, oweekday, oroom);
			}catch (Exception e) {
				out.println("<script type=\"text/javascript\">\r\n"
						+ "    var sec = 3;\r\n"
						+ "    function jump(){\r\n"
						+ "        sec--;\r\n"
						+ "        if(sec > 0){\r\n"
						+ "            document.getElementById('good').innerHTML = sec;\r\n"
						+ "            setTimeout(this.jump,1000);\r\n"
						+ "        }else{\r\n"
						+ "            window.location.href = 'OndutyManagerServlet?act=add';\r\n"
						+ "        }\r\n"
						+ "    }\r\n"
						+ "    setTimeout(jump,1000);\r\n"
						+ "</script>");
				out.println("<h1>���ʧ�ܣ�<span id='good' style='color: red;'>3</span>���ӷ��أ�</h1>");
			}
			onduty.setObegintime(obegintime);
			onduty.setOendtime(oendtime);
			if(abiz.IsOnduty(oid).size() == 0 && !"".equals(oname) && !"".equals(oweekday) && !"".equals(oroom)){
				if(abiz.addOnduty(onduty)) {
					out.println("<script type=\"text/javascript\">\r\n"
							+ "    var sec = 3;\r\n"
							+ "    function jump(){\r\n"
							+ "        sec--;\r\n"
							+ "        if(sec > 0){\r\n"
							+ "            document.getElementById('good').innerHTML = sec;\r\n"
							+ "            setTimeout(this.jump,1000);\r\n"
							+ "        }else{\r\n"
							+ "            window.location.href = 'OndutyManagerServlet?act=select';\r\n"
							+ "        }\r\n"
							+ "    }\r\n"
							+ "    setTimeout(jump,1000);\r\n"
							+ "</script>");
					out.println("<h1>��ӳɹ���<span id='good' style='color: red;'>3</span>���ӷ��أ�</h1>");
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
							+ "            window.location.href = 'OndutyManagerServlet?act=add';\r\n"
							+ "        }\r\n"
							+ "    }\r\n"
							+ "    setTimeout(jump,1000);\r\n"
							+ "</script>");
					out.println("<h1>���ʧ�ܣ�<span id='good' style='color: red;'>3</span>���ӷ��أ�</h1>");
//					response.setHeader("refresh", "3; url=UserManagerServlet?act=add");
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
						+ "            window.location.href = 'OndutyManagerServlet?act=add';\r\n"
						+ "        }\r\n"
						+ "    }\r\n"
						+ "    setTimeout(jump,1000);\r\n"
						+ "</script>");
				out.println("<h1>���ʧ�ܣ�������û��Ƿ��Ѵ��ڣ�<span id='good' style='color: red;'>3</span>���ӷ��أ�</h1>");
//				response.setHeader("refresh", "20; url=UserManagerServlet?act=add");
			}
		}else if("add".equals(act)){
			list = abiz.selectAllComputerroomOnlyOnduty();
			request.setAttribute("computerroomList", list);
			rds = request.getRequestDispatcher("Admin/OndutyAdd.jsp");
			rds.forward(request, response);
		}else if("modify".equals(act)){
			rds = request.getRequestDispatcher("Admin/OndutyModify.jsp");
			rds.forward(request, response);
		}else if("modifyOnduty".equals(act)){
			Onduty onduty = new Onduty();
			String modifyValue = request.getParameter("modifyValue");
			String modifyType = request.getParameter("modifyType");
			String oid = request.getParameter("oid");
			boolean modifyIsSuccess = false;
			try {
				onduty.setOid(Integer.parseInt(oid));
				if(!"".equals(modifyValue)) {
					switch(modifyType) {
						case "����": 
							onduty.setOname(modifyValue);
							modifyIsSuccess = abiz.modifyOname(onduty);
							break;
						case "ֵ������": 
							onduty.setOweekday(modifyValue);
							modifyIsSuccess = abiz.modifyOweekday(onduty);
							break;
						case "ֵ�࿪ʼʱ��": 
							onduty.setObegintime(modifyValue);
							modifyIsSuccess = abiz.modifyObegintime(onduty);
							break;
						case "ֵ�����ʱ��": 
							onduty.setOendtime(modifyValue);
							modifyIsSuccess = abiz.modifyOendtime(onduty);
							break;
						case "����ֵ����": 
							onduty.setOroom(modifyValue);
							modifyIsSuccess = abiz.modifyOroom(onduty);
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
								+ "            window.location.href = 'OndutyManagerServlet?act=select';\r\n"
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
								+ "            window.location.href = 'OndutyManagerServlet?act=modify';\r\n"
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
							+ "            window.location.href = 'OndutyManagerServlet?act=modify';\r\n"
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
						+ "            window.location.href = 'OndutyManagerServlet?act=modify';\r\n"
						+ "        }\r\n"
						+ "    }\r\n"
						+ "    setTimeout(jump,1000);\r\n"
						+ "</script>");
				out.println("<h1>�޸�ʧ�ܣ�����ֵ�Ƿ�Ϊ�գ�<span id='good' style='color: red;'>3</span>������ԣ�</h1>");
			}
			
		}
		
	}

}
