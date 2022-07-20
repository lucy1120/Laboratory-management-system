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
import entity.Computerroom;

@WebServlet("/ComputerroomManagerServlet")
public class ComputerroomManagerServlet extends HttpServlet {
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
			rds = request.getRequestDispatcher("Admin/ComputerroomSelect.jsp");
			rds.forward(request, response);
		}else if("selectComputerroom".equals(act)){
			//ɾ����־
			String del = request.getParameter("del");
			
			//��ò�ѯ��������
			String aact = request.getParameter("aact");
			
			//������ѯ
			String crname = request.getParameter("crname");
			String crtype = request.getParameter("crtype");
			
			//��������ѯ��ҳURL��ʹ��
			String crname1 = request.getParameter("crname1");
			
			//������ѯ��ҳ
			if(crname1 == null) {
				crname1 = crname;
			}
			//������ѯ����ҳ
			if(crname == null) {
				crname = crname1;
			}
			//������ѯ
			if("condiction".equals(aact)){
	
				list = abiz.conditionSelectComputerroom(crname, crtype);
				
			}else{
				list = abiz.selectComputerroom();
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
				list = abiz.conditionSelectComputerroomByPage(crname, crtype, startIndex, perPageSize);
			}else {
				list = abiz.selectAllComputerroomByPage(startIndex, perPageSize);
			}
			//���Բ�ѯ����
			request.setAttribute("crname1", crname1);
			request.setAttribute("aact", aact);
			request.setAttribute("crtype", crtype);
			request.setAttribute("computerroomList", list);
			request.setAttribute("totalPage", totalPage);
			request.setAttribute("pageCur", pageCur);
			//��ѯ
			if("select".equals(aact) || "condiction".equals(aact) && !"del".equals(del)){
				rds = request.getRequestDispatcher("Admin/ComputerroomSelect.jsp");
			}
			//ɾ��
			if("select".equals(aact) || "condiction".equals(aact) && "del".equals(del)){
				rds = request.getRequestDispatcher("Admin/ComputerroomDelete.jsp");
			}
			rds.forward(request, response);
		}else if("deleteComputerroom".equals(act)){
			String crname = request.getParameter("crname");
			if(abiz.deleteComputerroom(crname)){
				out.println("<script type=\"text/javascript\">\r\n"
						+ "    var sec = 3;\r\n"
						+ "    function jump(){\r\n"
						+ "        sec--;\r\n"
						+ "        if(sec > 0){\r\n"
						+ "            document.getElementById('good').innerHTML = sec;\r\n"
						+ "            setTimeout(this.jump,1000);\r\n"
						+ "        }else{\r\n"
						+ "            window.location.href = 'ComputerroomManagerServlet?act=delete';\r\n"
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
			rds = request.getRequestDispatcher("Admin/ComputerroomDelete.jsp");
			rds.forward(request, response);
		}else if("addComputerroom".equals(act)){
			String crname = request.getParameter("crname");
			String craddress = request.getParameter("craddress");
			String crtype = request.getParameter("crtype");
			Computerroom computerroom = new Computerroom(crname,craddress,crtype);
			if(abiz.IsComputerroom(crname).size() == 0 && !"".equals(crname) && !"".equals(craddress)){
				if(abiz.addComputerroom(computerroom)) {
					out.println("<script type=\"text/javascript\">\r\n"
							+ "    var sec = 3;\r\n"
							+ "    function jump(){\r\n"
							+ "        sec--;\r\n"
							+ "        if(sec > 0){\r\n"
							+ "            document.getElementById('good').innerHTML = sec;\r\n"
							+ "            setTimeout(this.jump,1000);\r\n"
							+ "        }else{\r\n"
							+ "            window.location.href = 'ComputerroomManagerServlet?act=select';\r\n"
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
							+ "            window.location.href = 'ComputerroomManagerServlet?act=add';\r\n"
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
						+ "            window.location.href = 'ComputerroomManagerServlet?act=add';\r\n"
						+ "        }\r\n"
						+ "    }\r\n"
						+ "    setTimeout(jump,1000);\r\n"
						+ "</script>");
				out.println("<h1>���ʧ�ܣ�����û����Ƿ��Ѵ��ڣ�<span id='good' style='color: red;'>3</span>���ӷ��أ�</h1>");
//				response.setHeader("refresh", "20; url=UserManagerServlet?act=add");
			}
		}else if("add".equals(act)){
			rds = request.getRequestDispatcher("Admin/ComputerroomAdd.jsp");
			rds.forward(request, response);
		}
	}
}
