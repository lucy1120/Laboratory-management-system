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
		<title>主页</title>
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<link rel="stylesheet" type="text/css" href="Admin/css/page.css" />
		<link href="Admin/plugins/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
		<link href="Admin/plugins/css/icons.min.css" rel="stylesheet" type="text/css" />
		<script src="js/vue.min.js"></script>
		<script src="js/jquery.min.js"></script>
	</head>
	<body id="body">
		<div class="page" id="app">
			<div class="nav-left" v-show="navLeftFlag" ref="navLeft">
				<div class="LogoName">
					<a id="topname">欢迎您：${requestScope.adminList[0].aname}</a>	
				</div>
				<div class="navDiv">
					<div class="navName">导航</div>
					<div class="nav-list">
						<ul>
							<li class="nav-tab a_active waves-effect">
								<a href="IndexServlet?act=index" class="li-a active" target="iframe"><i class='bx bx-home-smile'></i> 主页 </a>
							</li>
							<li class="nav-tab nav-ul">
								<a href="javascript:void[0]" class="li-a"><i class='bx bx-layer'></i>人员分布情况
									<i class='bx bx-chevron-right' style="float: right;"></i></a>
								<div class="nav-box">
									<a href="PersonnelDistributionServlet?act=major" class="li-a-a" target="iframe">专业分布</a>
								</div>
								<div class="nav-box">
									<a href="PersonnelDistributionServlet?act=grade" class="li-a-a" target="iframe">年级分布</a>
								</div>
								<div class="nav-box">
									<a href="PersonnelDistributionServlet?act=sex" class="li-a-a" target="iframe">性别分布</a>
								</div>
							</li>
							<li class="nav-tab nav-ul">
								<a href="javascript:void[0]" class="li-a"><i class='bx bx-layer'></i>组员管理
									<i class='bx bx-chevron-right' style="float: right;"></i></a>
								<div class="nav-box">
									<a href="UserManagerServlet?act=add" class="li-a-a" target="iframe">增加组员</a>
								</div>
								<div class="nav-box">
									<a href="Admin/userDelete.jsp" class="li-a-a" target="iframe">删除组员</a>
								</div>
								<div class="nav-box">
									<a href="Admin/userModify.jsp" class="li-a-a" target="iframe">修改组员</a>
								</div>
								<div class="nav-box">
									<a href="Admin/userSelect.jsp" class="li-a-a" target="iframe">查询组员</a>
								</div>
							</li>
							<li class="nav-tab nav-ul">
								<a href="javascript:void[0]" class="li-a"><i class='bx bx-layer'></i>组长管理
									<i class='bx bx-chevron-right' style="float: right;"></i></a>
								<div class="nav-box">
									<a href="SadminManagerServlet?act=add" class="li-a-a" target="iframe">增加组长</a>
								</div>
								<div class="nav-box">
									<a href="Admin/SadminDelete.jsp" class="li-a-a" target="iframe">删除组长</a>
								</div>
								<div class="nav-box">
									<a href="Admin/SadminModify.jsp" class="li-a-a" target="iframe">修改组长</a>
								</div>
								<div class="nav-box">
									<a href="Admin/SadminSelect.jsp" class="li-a-a" target="iframe">查询组长</a>
								</div>
							</li>
							<li class="nav-tab nav-ul">
								<a href="javascript:void[0]" class="li-a"><i class='bx bx-buildings'></i>机房管理
									<i class='bx bx-chevron-right' style="float: right;"></i></a>
								<div class="nav-box">
									<a href="Admin/ComputerroomAdd.jsp" class="li-a-a" target="iframe">增加机房</a>
								</div>
								<div class="nav-box">
									<a href="Admin/ComputerroomDelete.jsp" class="li-a-a" target="iframe">删除机房</a>
								</div>
								<div class="nav-box">
									<a href="Admin/ComputerroomSelect.jsp" class="li-a-a" target="iframe">查看机房</a>
								</div>
							</li>
							<li class="nav-tab nav-ul">
								<a href="javascript:void[0]" class="li-a"><i class='bx bx-layer'></i>设备管理
									<i class='bx bx-chevron-right' style="float: right;"></i></a>
								<div class="nav-box">
									<a href="EquipmentManagerServlet?act=add" class="li-a-a" target="iframe">增加设备</a>
								</div>
								<div class="nav-box">
									<a href="EquipmentManagerServlet?act=delete" class="li-a-a" target="iframe">删除设备</a>
								</div>
								<div class="nav-box">
									<a href="EquipmentManagerServlet?act=modify" class="li-a-a" target="iframe">修改设备</a>
								</div>
								<div class="nav-box">
									<a href="EquipmentManagerServlet?act=select"class="li-a-a" target="iframe">查询设备</a>
								</div>	
							</li>
							<li class="nav-tab nav-ul">
								<a href="javascript:void[0]" class="li-a"><i class='bx bx-edit'></i>值班管理
									<i class='bx bx-chevron-right' style="float: right;"></i></a>
								<div class="nav-box">
									<a href="OndutyManagerServlet?act=add" class="li-a-a" target="iframe">增加值班信息</a>
								</div>
								<div class="nav-box">
									<a href="Admin/OndutyDelete.jsp" class="li-a-a" target="iframe">删除值班信息</a>
								</div>
								<div class="nav-box">
									<a href="Admin/OndutyModify.jsp" class="li-a-a" target="iframe">修改值班信息</a>
								</div>
								<div class="nav-box">
									<a href="Admin/OndutySelect.jsp" class="li-a-a" target="iframe">查看值班信息</a>
								</div>
							</li>
							<li class="nav-tab nav-ul">
								<a href="Admin/MoneyInOut.jsp" class="li-a" target="iframe"><i class='bx bx-edit'></i> 资金流入流出 </a>
							</li>
						</ul>
					</div>
					<a class="loginout" href="LoginOutServlet?act=admin">注 销</a>
				</div>
			</div>
			<div class="nav-right" ref="navRight">
				<div class="nav-top">
					<button type="button" class="btn btn-primary btn-sm hiddenBtn" style="line-height: 10px;" @click="isShowLeft">
						<i class="bx bx-grid-alt" style="font-size: 16px;"></i>
					</button>
					<!-- <button type="button" class="btn btn-primary btn-sm showBtn" style="line-height: 10px; display: none;" onclick="showNavRight">
						<i class="bx bx-expand" style="font-size: 16px;"></i>
					</button> -->
				</div>
				<div class="content-page" ref="cPage">
					<iframe id="topiframe" name="iframe" width="100%" height="100%" frameborder="0" src="IndexServlet?act=index"></iframe>
				</div>
			</div>
		</div>

		<script type="text/javascript">
			$(function() {
				let navflag = false;
				$('.nav-tab').click(function() {
					$(this).siblings().each(function() {
						$(this).removeClass('a_active');
						// $(this).removeClass('a_active');
						$(this).find('.nav-box').css('height', '0')
						//关闭右侧箭头
						if ($(this).attr('class').indexOf('nav-ul') != -1) {
							$(this).find('.bx-chevron-right').css('transform', 'rotateZ(0deg)')
							$(this).find('.bx-chevron-right').css('transition', 'all .5s')
							$(this).removeClass('nav-show')
							// $(this).find('div').removeClass('nav-box')
						}
					})
					//当前选中
					$(this).addClass('a_active')
					$(this).find('.li-a').addClass('active')
					// 打开右侧箭头
					$(this).find('.bx-chevron-right').css('transform', 'rotateZ(90deg)')
					$(this).find('.bx-chevron-right').css('transition', 'all .5s')
					$(this).addClass('nav-show')
					// $(this).find('div').addClass('nav-box')
				})
				/* 二级菜单a点击事件 */
				$(".li-a-a").click(function() {
					$(".li-a-a").each(function() {
						$(this).removeClass('active-li-a');
					})
					$(this).addClass('active-li-a');
				})

			})
			const vue = new Vue({
				el: '#app',
				data: {
					navLeftFlag: true
				},
				methods: {
					isShowLeft() {
						if (this.navLeftFlag ) {
							this.$refs.navRight.style.paddingLeft = '0px'
							this.$refs.cPage.style.left = '0px';
							this.navLeftFlag = false;
							// this.$refs.navLeft.style.width = '0px';
							// setTimeout(()=>{
							// 	this.navLeftFlag = false;
							// },200)
						} else {
							this.$refs.navRight.style.paddingLeft = '200px';
							this.$refs.cPage.style.left = '200px';
							this.navLeftFlag = true;
							// this.$refs.navLeft.style.width = '240px';
							// setTimeout(()=>{
							// 	this.navLeftFlag = true;
							// },200)
						}
					}
				}
			})
		</script>
	</body>
<base href="<%=basePath%>">
</html>