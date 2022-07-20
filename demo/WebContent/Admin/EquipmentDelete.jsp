<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta content="text/html;charset=UTF-8">
<title>用户管理</title>
	<style type="text/css">
		table{
			text-align: center;
			border-collapse: collapse;
			border:1px solid #f0f0f0;
		}
		th{
		border-top:1px solid #f0f0f0;
		border-bottom:1px solid white;
		background-color:#f2f0f8;
		height:50px;
		font-size: 15px;
		color:#62666e;
		width:5%;
		border:1px solid #f0f0f0;
		}
		td{
		border-top:0.5px solid #f0f0f0;
		border-bottom:0.5px solid #f0f0f0;
		border:1px solid #f0f0f0;
		}
		tr{
			height: 40px
		}
		input{
		background-color:transparent;
    	height: 35px;
    	border: 1px solid #dfdfdf;
   		border-radius: 3px !important;
    	padding: 0rem 0.75rem;
    	font-size: 13px;
    	line-height: 32px;
    	display: inline-block;
    	margin-left:15%;
		}
		.bgcolor{
		  	background-color: #6d61ea;
		  	color: #fff;
		}
		input:-webkit-autofill , textarea:-webkit-autofill, select:-webkit-autofill {
		-webkit-box-shadow: 0 0 0px 1000px transparent  inset !important;
    	background-color:transparent;
   		background-image: none;
    	transition: background-color 50000s ease-in-out 0s;
		}
		select {
   		font-size: 13px;
    	color: #666;
    	display: block;
    	width: 90%;
    	margin-left: -10%;
    	margin-top: 5%;
   	    height: calc(2.25rem + 2px);
    	padding: 0.375rem 0.75rem;
    	font-size: 13px;
    	font-weight: 400;
    	line-height: 1.5;
    	color: #495057;
    	background-color: #fff;
    	background-clip: padding-box;
   		border: 1px solid #ced4da;
    	border-radius: 0.25rem;
    	transition: border-color .15s ease-in-out,box-shadow .15s ease-in-out;
		}
	</style>
	<script type="text/javascript">
		function changeColor(obj){
			obj.className="bgcolor"
		}
		function changeColor1(obj){
			obj.className=""
		}
		function checkDel(eid){
  			if(window.confirm("是否删除此设备？")){
  				window.location.href="EquipmentManagerServlet?act=deleteEquipment&eid="+eid;
  			}
  		}
	</script>
</head>
<body>
	<form action="EquipmentManagerServlet?act=selectEquipment&&del=del" method="post">
		<table style="margin:0 auto;border:0;"> 
			<tr>
				<td style="border:none;width:300px;">
				<a style="margin-left: -20%;margin-top: 0.4%;position: absolute;">设备名：</a>
					<input type="text" name="ename" value="${ename1}" style="margin-left: -60%;">
				</td>
				<td style="border:none;width:300px;">
				<a style="position: absolute;margin-left: -20%;margin-top: 20px;">所在机房:</a>
					<select name="ecomputerroom" style="margin-top: 5%;margin-bottom: 5%;">
						<option value="all">全部</option>
						<c:forEach var="n" items="${requestScope.computerroomList}">
							<option>${n.crname}</option>
						</c:forEach>
					 </select>
					<input type="hidden" name="aact" value="condiction"/>   
					<input type="submit" value="条件查询" style="position: absolute;margin-top: -4%;margin-left: 9%;width: 15%;"/>   
				</td>
			</tr>
		</table>
		<br>
	</form>
	<table border="1" style="margin:0 auto;">
		<tr>
			<th>设备名</th>
			<th>设备单价</th>
			<th>设备所在机房</th>
			<th>设备数量</th>
			<th>删除</th>
		</tr>
		<c:forEach var="n" items="${requestScope.equipmentList}">
		<tr onmousemove="changeColor(this)" onmouseout="changeColor1(this)">
			<td>${n.ename}</td>
			<td>${n.emoney}</td>
			<td>${n.ecomputerroom}</td>
			<td>${n.enumber}</td>
			<td>
				<a href="javaScript:checkDel('${n.eid}')" style="text-decoration:none;color:#2996e3;">删除</a>
			</td>
		</tr>
		</c:forEach>
		<tr>
		<c:if test="${pageCur != null}">
			<td colspan="9" align="right">
				&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;共${totalCount}条记录&nbsp;&nbsp;共${totalPage}页&nbsp;&nbsp;
				第${pageCur}页&nbsp;&nbsp;
				<c:url var="url_pre" value="EquipmentManagerServlet?aact=${aact }&&ename1=${ename1}&&ecomputerroom=${ecomputerroom}&&act=selectEquipment&&del=del">
					<c:param name="pageCur" value="${pageCur - 1 }"/>
				</c:url>
				<c:url var="url_next" value="EquipmentManagerServlet?aact=${aact }&&ename1=${ename1}&&ecomputerroom=${ecomputerroom}&&act=selectEquipment&&del=del">
					<c:param name="pageCur" value="${pageCur + 1 }"/>
				</c:url>
				<!-- 第一页没有上一页 -->
				<c:if test="${pageCur != 1 && pageCur != null}">
					<a href="${url_pre}" style="color:#6d61ea;text-decoration:none;">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
				</c:if>
				<!-- 最后一页，没有下一页 -->
				<c:if test="${pageCur != totalPage && totalPage !=0 }">
					<a href="${url_next}" style="color:#6d61ea;text-decoration:none;">下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
				</c:if>
			</td>
		</c:if>
		</tr>
	</table>
</body>
</html>