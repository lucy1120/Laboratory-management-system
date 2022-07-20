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
		function checkDel(uid){
  			if(window.confirm("是否删除该用户？")){
  				window.location.href="UserManagerServlet?act=deleteUser&uid="+uid;
  			}
  		}
	</script>
</head>
<body>




	<form action="UserManagerServlet?act=selectUser&&del=del" method="post">
		<table style="margin:0 auto;border:0;">
			<tr>
				<td style="border:none;width:300px;">
					
					<a style="margin-left: -20%;margin-top: 0.4%;position: absolute;">用户名：</a>
					<input type="text" name="uname" value="${uname1}" style="margin-left: -60%;">
				</td>
				<td style="border:none;width:300px;">
					<a style="position: absolute;margin-left: -20%;margin-top: 20px;">专业:</a>
					<select name="umajor" style="margin-top: 5%;margin-bottom: 5%;">
						<option value="all">全部</option>
						<option>软件工程</option>
						<option>网络工程</option>
						<option>计算机科学与技术</option>
						<option>计算机类</option>
						<option>人工智能</option>
					 </select>
					<input type="hidden" name="aact" value="condiction"/>   
					<input type="submit" value="条件查询" style="position: absolute;margin-top: -4%;margin-left: 9%;width: 15%;"/>   
				</td>
			</tr>
		</table>
	</form>
	<table border="1" style="margin:0 auto;">
		<tr>
			<th style="width:140px;">学号</th>
			<th style="width:140px;">姓名</th>
			<th style="width:140px;">年龄</th>
			<th style="width:140px;">性别</th>
			<th style="width:140px;">年级</th>
			<th style="width:140px;">专业</th>
			<th style="width:140px;">班级</th>
			<th style="width:140px;">所属机房</th>
			<th style="width:140px;">删除</th>
		</tr>
		<c:forEach var="n" items="${requestScope.userList}">
		<tr onmousemove="changeColor(this)" onmouseout="changeColor1(this)">
			<td>${n.uid}</td>
			<td>${n.uname}</td>
			<td>${n.uage}</td>
			<td>${n.usex}</td>
			<td>${n.ugrade}</td>
			<td>${n.umajor}</td>
			<td>${n.uclass}</td>
			<td>${n.uclassroom}</td>
			<td>
				<a href="javaScript:checkDel('${n.uid}')" style="text-decoration:none;color:#2996e3;">删除</a>
			</td>
		</tr>
		</c:forEach>
		<tr>
		<c:if test="${pageCur != null}">
			<td colspan="10" align="right">
				&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;共${totalCount}条记录&nbsp;&nbsp;共${totalPage}页&nbsp;&nbsp;
				第${pageCur}页&nbsp;&nbsp;
				<c:url var="url_pre" value="UserManagerServlet?aact=${aact }&&uname1=${uname1}&&umajor=${umajor}&&act=selectUser&&del=del">
					<c:param name="pageCur" value="${pageCur - 1 }"/>
				</c:url>
				<c:url var="url_next" value="UserManagerServlet?aact=${aact }&&uname1=${uname1}&&umajor=${umajor}&&act=selectUser&&del=del">
					<c:param name="pageCur" value="${pageCur + 1 }"/>
				</c:url>
				<!-- 第一页没有上一页 -->
				<c:if test="${pageCur != 1 && pageCur != null}">
					<a href="${url_pre}" style="text-decoration:none;color:#6d61ea;">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
				</c:if>
				<!-- 最后一页，没有下一页 -->
				<c:if test="${pageCur != totalPage && totalPage !=0 }">
					<a href="${url_next}" style="text-decoration:none;color:#6d61ea;">下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
				</c:if>
			</td>
		</c:if>
		</tr>
	</table>
</body>

</html>