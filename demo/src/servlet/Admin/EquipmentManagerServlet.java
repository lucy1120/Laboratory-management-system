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
		//查询
		if("select".equals(act)){
			list = abiz.selectAllComputerroom();
			request.setAttribute("computerroomList", list);
			rds = request.getRequestDispatcher("Admin/EquipmentSelect.jsp");
			rds.forward(request, response);
		}else if("selectEquipment".equals(act)){
			list = abiz.selectAllComputerroom();
			request.setAttribute("computerroomList", list);
			//删除用户的标志
			String del = request.getParameter("del");
			
			//获得查询动作类型
			String aact = request.getParameter("aact");
			
			//条件查询
			String ename = request.getParameter("ename");
			String ecomputerroom = request.getParameter("ecomputerroom");
			
			//在条件查询分页URL中使用
			String ename1 = request.getParameter("ename1");
			
			//条件查询首页
			if(ename1 == null) {
				ename1 = ename;
			}
			//条件查询非首页
			if(ename == null) {
				ename = ename1;
			}
			//条件查询
			if("condiction".equals(aact)){
	
				list = abiz.conditionSelectEquipments(ename, ecomputerroom);
				
			}else{
				list = abiz.selectEquipments();
			}	
			//分页查询
			int temp = list.size();
			
			request.setAttribute("totalCount", temp);
			
			int totalPage = 0;
			if (temp == 0) {
				totalPage = 0;//总页数
			} else {
				//返回大于或者等于指定表达式的最小整数
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
			//分页查询
			int startIndex = (pageCur - 1) * 10;//起始位置
			int perPageSize = 10;//每页10个
			if("condiction".equals(aact)) {
				list = abiz.conditionSelectEquipmentsByPage(ename, ecomputerroom, startIndex, perPageSize);
			}else {
				list = abiz.selectAllEquipmentsByPage(startIndex, perPageSize);
			}
			//回显查询条件
			request.setAttribute("ename1", ename1);
			request.setAttribute("aact", aact);
			request.setAttribute("ecomputerroom", ecomputerroom);
			request.setAttribute("equipmentList", list);
			request.setAttribute("totalPage", totalPage);
			request.setAttribute("pageCur", pageCur);
			//查询
			if("select".equals(aact) || "condiction".equals(aact) && !"del".equals(del)){
				rds = request.getRequestDispatcher("Admin/EquipmentSelect.jsp");
			}
			//删除
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
				out.println("<h1>删除成功！<span id='good' style='color: red;'>3</span>秒钟返回！</h1>");
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
				out.println("<h1>添加失败！<span id='good' style='color: red;'>3</span>秒钟返回！</h1>");
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
					out.println("<h1>添加成功！<span id='good' style='color: red;'>3</span>秒钟返回！</h1>");
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
					out.println("<h1>添加失败！<span id='good' style='color: red;'>3</span>秒钟返回！</h1>");
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
					case "设备名": 
						modifyIsSuccess = abiz.modifyEname(Equipment,modifyValue);
						break;
					case "设备单价": 
						Equipment.setEmoney(Integer.parseInt(modifyValue));
						modifyIsSuccess = abiz.modifyEmoney(Equipment);
						break;
					case "所在机房": 
						modifyIsSuccess = abiz.modifyEcomputerroom(Equipment,modifyValue);
						break;
					case "设备数量": 
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
				out.println("<h1>修改成功！<span id='good' style='color: red;'>3</span>秒钟返回！</h1>");
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
				out.println("<h1>修改失败！请检查设备是否存在，<span id='good' style='color: red;'>3</span>秒后再试！</h1>");
			}
		}
	}
}
