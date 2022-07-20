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
 <script>
 </script>
<title>MoneyInOut</title>
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
	</script>
</head>
<body>
	<form action="MoneyInOutServlet?act=selectMoney" method="post">
	<table style="margin:0 auto;border:0;">
		<tr>
			<td style="border:none;width:300px;"> 
			<a style="margin-left: -30%;margin-top: 24px;position: absolute;">资金情况：</a>
				<select name="mtype" style="margin-top: 5%;margin-bottom: 5%;margin-left: -50%;">
					<option value="all">全部</option>
					<option>流入</option>
					<option>流出</option>
				 </select>
				<input type="hidden" name="aact" value="condiction"/>   
				<input type="submit" value="条件查询" style="position: absolute;margin-top: -4%;margin-left: 9%;width: 15%;"/>   
			</td>
		</tr>
	</table>
	<br>
	</form>
	<table>
		<tr>
			<th>日期</th>
			<th>数量</th>
			<th>备注</th>
			<th>资金情况</th>
		</tr>
		<c:forEach var="n" items="${requestScope.moneyList}">
		<tr onmousemove="changeColor(this)" onmouseout="changeColor1(this)">
			<td>${n.mtime}</td>
			<td>${n.mnumber}</td>
			<td>${n.mremarks}</td>
			<td>${n.mtype}</td>
		</tr>
		</c:forEach>
	</table>
</body>

</html>