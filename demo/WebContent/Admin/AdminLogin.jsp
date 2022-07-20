<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<base href="<%=basePath%>">
    	<meta charset="utf-8">
    	<title>登录界面</title>
    	<link rel="stylesheet" href="Admin/css/normalize.min.css">
    	<link rel="stylesheet" href="Admin/css/style.css">
    	<script src="js/jquery.min.js"></script>
    	
    	<style>
    		#formContainer{
    			height: 430px;
    		}
	    	.input_text {
			    width: 300px;
			    height: 34px;
			    background: transparent;
			    border-radius: 3px;
			    color: #E9E9E9;
			    display: block;
			    border: 1px solid #626263;
			}
			.input_text>option{
				background: black;
			}
			.m_input {
			    position: absolute;
			    left: 27px;
			    margin-top: 26px;
			}
    	</style>
	</head>
<body>
  	<div id="formContainer" class="dwo">
        <div class="formLeft">
            <img src="Admin/images/head.jpg">
        </div>
        <div class="formRight">
            <!-- Login form -->
            <form id="form1" action="javascript:void();" method="post">
                <header>
                    <h1>实验室管理系统</h1>
                    <br>
                </header>
                <section>
                    <label style="margin-left:3px;">
                        <p>学号</p>
                        <input type="text" placeholder=" " id="adminid" name="adminid">
                        <div class="border"></div>
                    </label>
                    <label style="margin-left:3px;">
                        <p>密码</p>
                        <input type="password" placeholder=" " id="adminpwd" name="adminpwd">
                        <div class="border"></div>
                    </label>
                    <table border="0" style="margin-right:243px;margin-top:-25px;">
                    <tbody style="margin-left:20px;">
                    <tr>
						<th width="200px" style="color: #fff;font-weight: 600;font-size: 12px;opacity: 0.5;">账户类型</th>
						<br>
						<td>
							<select class="m_input input_text" id="admintype" name="admintype">
								<option style="font-size: 12px;">大组长</option>
								<option style="font-size: 12px;">小组长</option>
								<option style="font-size: 12px;">组员</option>
				 			</select>
						</td>
					</tr>
					</tbody>
                    </table>
                    <br>
                    <br>
                    <button style="margin-left:3px;margin-top:45px;" id="loginbutton">登 录</button>
                	<h4 id="error" style="color: red"></h4>
                	<script>
	                    window.onload = function(){
	                    	var f = document.getElementById("form1");
	            			var adminid = document.getElementById("adminid");
	            			var adminpwd = document.getElementById("adminpwd");
	            			var loginbutton = document.getElementById("loginbutton");
	            			loginbutton.onclick = function(){
	            				if(adminid.value == "" && adminpwd.value != ""){
	            					$("#error").html("<span>请输入学号</span>");
	            				}else if(adminid.value != "" && adminpwd.value == ""){
	            					$("#error").html("<span>请输入密码</span>");
	            				}else if(adminid.value == "" && adminpwd.value == ""){
	            					$("#error").html("<span>请输入学号和密码</span>");
	            				}else{
		            				var formParam = $("#form1").serialize();
		            				//alert(formParam);
					           		$.ajax({
					           			type:"post",
					           			url:"LoginAjaxServlet",
					           			dataType:"json",
					           			data:formParam,
					           			cache:false,
					           			success:function(data){
					           				if(data.errcroe == "400"){
					           					$("#error").html("<span>"+data.msg+"</span>");
					           				}else{
					           					$("#error").html("");
					           					f.action = "AdminLoginServlet";
								           		f.submit();
					           				}
					           			},
					            		error:function(){
					                     console.log("提交ajax函数异常");
					                 	}
					           		});
	            				}
	            			}
	            		}
					</script>
                </section>
            </form>
            
        </div>
    </div>
	
</body>
<script src="js/script.js"></script>
</html>