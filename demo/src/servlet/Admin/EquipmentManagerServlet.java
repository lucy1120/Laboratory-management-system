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
import entity.Equipment;


@WebServlet("/EquipmentManagerServlet")
public class EquipmentManagerServlet extends HttpServlet {
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
			list = abiz.selectAllComputerroom();
			request.setAttribute("computerroomList", list);
			rds = request.getRequestDispatcher("Admin/EquipmentSelect.jsp");
			rds.forward(request, response);
		}else if("selectEquipment".equals(act)){
			list = abiz.selectAllComputerroom();
			request.setAttribute("computerroomList", list);
			//ɾ���û��ı�־
			String del = request.getParameter("del");
			
			//��ò�ѯ��������
			String aact = request.getParameter("aact");
			
			//������ѯ
			String ename = request.getParameter("ename");
			String ecomputerroom = request.getParameter("ecomputerroom");
			
			//��������ѯ��ҳURL��ʹ��
			String ename1 = request.getParameter("ename1");
			
			//������ѯ��ҳ
			if(ename1 == null) {
				ename1 = ename;
			}
			//������ѯ����ҳ
			if(ename == null) {
				ename = ename1;
			}
			//������ѯ
			if("condiction".equals(aact)){
	
				list = abiz.conditionSelectEquipments(ename, ecomputerroom);
				
			}else{
				list = abiz.selectEquipments();
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
				list = abiz.conditionSelectEquipmentsByPage(ename, ecomputerroom, startIndex, perPageSize);
			}else {
				list = abiz.selectAllEquipmentsByPage(startIndex, perPageSize);
			}
			//���Բ�ѯ����
			request.setAttribute("ename1", ename1);
			request.setAttribute("aact", aact);
			request.setAttribute("ecomputerroom", ecomputerroom);
			request.setAttribute("equipmentList", list);
			request.setAttribute("totalPage", totalPage);
			request.setAttribute("pageCur", pageCur);
			//��ѯ
			if("select".equals(aact) || "condiction".equals(aact) && !"del".equals(del)){
				rds = request.getRequestDispatcher("Admin/EquipmentSelect.jsp");
			}
			//ɾ��
			if("select".equals(aact) || "condiction".equals(aact) && "del".equals(del)){
				rds = request.getRequestDispatcher("Admin/EquipmentDelete.jsp");
			}
			rds.forward(request, response);
		}else if("deleteEquipment".equals(act)){
			String eid = request.getParameter("eid");
			if(abiz.deleteEquipment(eid)){
				out.println("<script type=\"text/javascript\">\r\n"
						+ "    var sec = 3;\r\n"
						+ "    function jump(){\r\n"
						+ "        sec--;\r\n"
						+ "        if(sec > 0){\r\n"
						+ "            document.getElementById('good').innerHTML = sec;\r\n"
						+ "            setTimeout(this.jump,1000);\r\n"
						+ "        }else{\r\n"
						+ "            window.location.href = 'EquipmentManagerServlet?act=delete';\r\n"
						+ "        }\r\n"
						+ "    }\r\n"
						+ "    setTimeout(jump,1000);\r\n"
						+ "</script>");
				out.println("<h1>ɾ���ɹ���<span id='good' style='color: red;'>3</span>���ӷ��أ�</h1>");
//				response.setHeader("refresh", "3; url=UserManagerServlet?act=delete");
			}
		}else if("delete".equals(act)){
			list = abiz.selectAllComputerroom();
			request.setAttribute("computerroomList", list);
			rds = request.getRequestDispatcher("Admin/EquipmentDelete.jsp");
			rds.forward(request, response);
		}else if("addEquipment".equals(act)){
			String ename = request.getParameter("ename");
			String emoney = request.getParameter("emoney");
			String ecomputerroom = request.getParameter("ecomputerroom");
			String enumber = request.getParameter("enumber");
			Equipment Equipment = null;
			try {
				Equipment = new Equipment(ename, Integer.parseInt(emoney), ecomputerroom, Integer.parseInt(enumber));
			}catch (Exception e) {
				out.println("<script type=\"text/javascript\">\r\n"
						+ "    var sec = 3;\r\n"
						+ "    function jump(){\r\n"
						+ "        sec--;\r\n"
						+ "        if(sec > 0){\r\n"
						+ "            document.getElementById('good').innerHTML = sec;\r\n"
						+ "            setTimeout(this.jump,1000);\r\n"
						+ "        }else{\r\n"
						+ "            window.location.href = 'EquipmentManagerServlet?act=add';\r\n"
						+ "        }\r\n"
						+ "    }\r\n"
						+ "    setTimeout(jump,1000);\r\n"
						+ "</script>");
				out.println("<h1>���ʧ�ܣ�<span id='good' style='color: red;'>3</span>���ӷ��أ�</h1>");
			}
			if(!"".equals(ename) && !"".equals(ecomputerroom)) {
				if(abiz.addEquipment(Equipment) && abiz.addMoneylog(Equipment)) {
					
					out.println("<script type=\"text/javascript\">\r\n"
							+ "    var sec = 3;\r\n"
							+ "    function jump(){\r\n"
							+ "        sec--;\r\n"
							+ "        if(sec > 0){\r\n"
							+ "            document.getElementById('good').innerHTML = sec;\r\n"
							+ "            setTimeout(this.jump,1000);\r\n"
							+ "        }else{\r\n"
							+ "            window.location.href = 'EquipmentManagerServlet?act=select';\r\n"
							+ "        }\r\n"
							+ "    }\r\n"
							+ "    setTimeout(jump,1000);\r\n"
							+ "</script>");
					out.println("<h1>��ӳɹ���<span id='good' style='color: red;'>3</span>���ӷ��أ�</h1>");
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
							+ "            window.location.href = 'EquipmentManagerServlet?act=add';\r\n"
							+ "        }\r\n"
							+ "    }\r\n"
							+ "    setTimeout(jump,1000);\r\n"
							+ "</script>");
					out.println("<h1>���ʧ�ܣ�<span id='good' style='color: red;'>3</span>���ӷ��أ�</h1>");
//						response.setHeader("refresh", "3; url=UserManagerServlet?act=add");
				}
			}
			
		}else if("add".equals(act)){
			list = abiz.selectAllComputerroom();
			request.setAttribute("computerroomList", list);
			rds = request.getRequestDispatcher("Admin/EquipmentAdd.jsp");
			rds.forward(request, response);
		}else if("modify".equals(act)){
			list = abiz.selectAllComputerroom();
			request.setAttribute("computerroomList", list);
			rds = request.getRequestDispatcher("Admin/EquipmentModify.jsp");
			rds.forward(request, response);
		}else if("modifyEquipment".equals(act)){
			Equipment Equipment = new Equipment();
			String modifyValue = request.getParameter("modifyValue");
			String modifyType = request.getParameter("modifyType");
			String ename = request.getParameter("ename");
			String ecomputerroom = request.getParameter("ecomputerroom");
			boolean modifyIsSuccess = false;
			Equipment.setEname(ename);
			Equipment.setEcomputerroom(ecomputerroom);
			if(!"".equals(modifyValue)) {
				switch(modifyType) {
					case "�豸��": 
						modifyIsSuccess = abiz.modifyEname(Equipment,modifyValue);
						break;
					case "�豸����": 
						Equipment.setEmoney(Integer.parseInt(modifyValue));
						modifyIsSuccess = abiz.modifyEmoney(Equipment);
						break;
					case "���ڻ���": 
						modifyIsSuccess = abiz.modifyEcomputerroom(Equipment,modifyValue);
						break;
					case "�豸����": 
						Equipment.setEnumber(Integer.parseInt(modifyValue));
						modifyIsSuccess = abiz.modifyEnumber(Equipment);
						break;
				}
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
						+ "            window.location.href = 'EquipmentManagerServlet?act=select';\r\n"
						+ "        }\r\n"
						+ "    }\r\n"
						+ "    setTimeout(jump,1000);\r\n"
						+ "</script>");
				out.println("<h1>�޸ĳɹ���<span id='good' style='color: red;'>3</span>���ӷ��أ�</h1>");
			}else {
				out.println("<script type=\"text/javascript\">\r\n"
						+ "    var sec = 3;\r\n"
						+ "    function jump(){\r\n"
						+ "        sec--;\r\n"
						+ "        if(sec > 0){\r\n"
						+ "            document.getElementById('good').innerHTML = sec;\r\n"
						+ "            setTimeout(this.jump,1000);\r\n"
						+ "        }else{\r\n"
						+ "            window.location.href = 'EquipmentManagerServlet?act=modify';\r\n"
						+ "        }\r\n"
						+ "    }\r\n"
						+ "    setTimeout(jump,1000);\r\n"
						+ "</script>");
				out.println("<h1>�޸�ʧ�ܣ������豸�Ƿ���ڣ�<span id='good' style='color: red;'>3</span>������ԣ�</h1>");
			}
		}
	}
}
