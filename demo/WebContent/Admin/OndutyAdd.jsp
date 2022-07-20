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
		body{
		margin:0 auto;
		}
		input:-webkit-autofill , textarea:-webkit-autofill, select:-webkit-autofill {
		-webkit-text-fill-color: #ededed !important;
		-webkit-box-shadow: 0 0 0px 1000px transparent  inset !important;
    	background-color:transparent;
   		background-image: none;
    	transition: background-color 50000s ease-in-out 0s;
		}

		table{
		width:80%;
		margin:0 auto;
		height: 400px;
		}
		th{
		border-top:1px solid #f0f0f0;
		border-bottom:1px solid white;
		background-color:#f2f0f8;
		height:50px;
		font-size: 15px;
		color:#62666e;
		width:15%;
		}
		td{
		border-top:0.5px solid #f0f0f0;
		border-bottom:0.5px solid #f0f0f0;
		}
		input{
		background-color:transparent;
		width: 60% !important;
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
		width: 67%;
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
    	#add{
    	margin:0 20%;
    	cursor:pointer;
    	background-color:rgb(98, 83, 232);
    	color:white;}
	</style>
	<script type="text/javascript">
		window.onload = function(){
			var add = document.getElementById("add");
			add.onclick = function(){
				if(window.confirm("是否添加该用户？")){
					document.getElementById("form").submit();
				}
			}
		}
		
	</script>
</head>
<body>
	<div style="width:100%;height: 85px;margin-bottom:1%;border-bottom:0.5px solid #f0f0f0;">
		<p style="font-size:35px;font-weight:300;margin-left:30px;">添加</p>
	</div>
	<form action="OndutyManagerServlet?act=addOnduty" id="form" method="post">
	<table style="border-collapse:collapse;">
		<tr>
			<th>学号</th>
			<td><input type="text" name="oid"></td>
			<th>姓名</th>
			<td><input type="text" name="oname"></td>
		</tr>
		<tr>
			<th>值班日期</th>
			<td>
				<select name="oweekday">
					<option>周一</option>
					<option>周二</option>
					<option>周三</option>
					<option>周四</option>
					<option>周五</option>
					<option>周六</option>
					<option>周日</option>
				 </select>
			</td>
			<th>值班开始时间</th>
			<td><input type="time" step="1" name="obegintime"></td>
		</tr>
		<tr>
			<th>值班结束时间</th>
			<td><input type="time" step="1" name="oendtime"></td>
			<th>所在值班室</th>
			<td>
				<select name="oroom">
					<c:forEach var="n" items="${requestScope.computerroomList}">
						<option>${n.crname}</option>
					</c:forEach>
				 </select>
			</td>
		</tr>
		<tr>
			<th>操作</th>
			<td style="border-right: 0.5px solid #f0f0f0;">
				<div>
					<input type="button" value="添加" id="add">
				</div>
			</td>
		</tr>	
	</table>
	</form>
<hr style="margin-top:1%;background-color:#f0f0f0;height:1px;border:none;">
</body>
<base href="<%=basePath%>">
</html>