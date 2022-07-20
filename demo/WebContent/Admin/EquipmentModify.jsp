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
<title>设备管理</title>
	<style type="text/css">
		table{
		width: 67%;
    	margin: 0 auto;
    	height: 290px;
		}
		th{
		border-top:1px solid #f0f0f0;
		border-bottom:1px solid white;
		background-color:#f2f0f8;
		height:50px;
		font-size: 15px;
		color:#62666e;
		width:25%;
		}
		td{
		border-top:0.5px solid #f0f0f0;
		border-bottom:0.5px solid #f0f0f0;
		}
		input{
		background-color:transparent;
		width: 60%;
    	height: 35px;
    	border: 1px solid #dfdfdf;
   		border-radius: 3px !important;
    	padding: 0rem 0.75rem;
    	font-size: 13px;
    	line-height: 32px;
    	display: inline-block;
    	margin-left:15%;
		}
		select{
		font-size: 13px;color: #666;
		display: block;
		width: 64%;
    	margin-left: 15%;
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
    	#modify{
    	margin: 19% 48%;
    	cursor: pointer;
    	background-color: rgb(98, 83, 232);
    	color: white;
    	position: absolute;
    	width: 15%;
    	}
	</style>
	<script type="text/javascript">
		window.onload = function(){
			var modify = document.getElementById("modify");
			modify.onclick = function(){
				if(window.confirm("是否修改该设备信息？")){
					document.getElementById("form").submit();
				}
			}
		}
		
	</script>
</head>
<body>
<br>
	<form action="EquipmentManagerServlet?act=modifyEquipment" id="form" method="post">
	<table style="border-collapse:collapse;">
	
		<tr>
			<th>请输入要修改设备所属的机房</th>
			<td>
				<select name="ecomputerroom">
					<c:forEach var="n" items="${requestScope.computerroomList}">
						<option>${n.crname}</option>
					</c:forEach>
				 </select>
			</td>
		</tr>
		<tr>
			<th>请输入要修改的设备的名字</th>
			<td><input type="text" name="ename"></td>
		</tr>
		<tr>
			<th>请输入要修改的设备的属性</th>
			<td>
			<select name="modifyType">
				<option>设备名</option>
				<option>所在机房</option>
				<option>设备单价</option>
				<option>设备数量</option>
			</select>
			</td>
		</tr>
		<tr>
			<th>请输入修改后的值</th>
			<td><input type="text" id="modifyValue" name="modifyValue"></td>
		</tr>
		<tr style="border-bottom:0.5px solid #f0f0f0;">
			<th>操作</th>
			<div>
				<input type="button" value="修改" id="modify">
			</div>
		</tr>
	</table>
	</form>
</body>
</html>