<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head lang="en">
<base href="<%=basePath%>">
    <meta charset="UTF-8">
    <style>
        .main {
            height: 500px;
        }
    </style>
    <link rel="stylesheet" href="Admin/css/demo.css">
    <title></title>
</head>
<body>
    <div class="head">
    	<div class="out"><a href="ModifyAdminServlet?act=modify&&uid=${sessionScope.adminid}">修改个人信息</a></div>
        <img src="Admin/images/211铃铛.png" class="lingdang">
        <div class="message">
            <ul>
                <li id="nameli">${requestScope.adminList[0].aname}</li>
                <li>${sessionScope.admintype}</li>
            </ul>
        </div>
        <div class="photo">
            <img src="Admin/images/系统管理员.png">
        </div>
    </div>
    <div class="title">
        <p>个 人 信 息</p>
    </div>
    <div class="block1">
        <div class="left">
            <img src="Admin/images/系统管理员.png">
            <p class="name">名 字 : ${requestScope.adminList[0].aname}</p>
            <p class="id">学 号 : ${sessionScope.adminid}</p>
        </div>
        <div class="right">
            <p class="name">${requestScope.adminList[0].aname}</p>
            <p class="major">${requestScope.adminList[0].amajor}</p>
            <p class="message">
                机房管理员应认真履行各项机房监控职责，定期按照规定对机房内各类设备进行
                检查和维护，及时发现、报告、解决硬件系统出现的故障，保障系统的正常运行。
                机房内服务器、网络设备、电源、空调等重要设施由专人严格按照规定操作，严
                禁随意开关。系统管理员的操作须严格按照操作规程进行，任何人不得擅自更
                改系统设置。
            </p>
            <div class="foot">
                <div class="grade">
                    <img src="Admin/images/年级.png">
                    <p>${requestScope.adminList[0].agrade}</p>
                </div>
                <div class="grade">
                    <img src="Admin/images/专业.png">
                    <p>${requestScope.adminList[0].amajor}</p>
                </div>
                <div class="grade">
                    <img src="Admin/images/年龄.png">
                    <p>${requestScope.adminList[0].aage}</p>
                </div>
                <div class="grade">
                    <img src="Admin/images/机房设施.png">
                    <p>${requestScope.adminList[0].aclass}</p>
                </div>
            </div>
        </div>
    </div>
    <div class="block2">
        <p>扇形分布图</p>
    </div>
    <div class="block3">
        <div class="right">
            <div class="main" id="main1"></div>
		    
        </div>
        <div class="left">
            <div class="main" id="main2"></div>
        </div>
    </div>
    
</body>
	<script src="js/echarts.min.js"></script>
    <script type="text/javascript">
        var chartDom1 = document.getElementById('main1');
        var myChart1 = echarts.init(chartDom1);
        var option1;
        
        var chartDom2 = document.getElementById('main2');
        var myChart2 = echarts.init(chartDom2);
        var option2;
        
        option1 = {
            title: {
                text: '人员情况',
                subtext: '专业分布',
                left: 'center'
            },
            tooltip: {
                trigger: 'item',
                formatter: '{b} : {c} 人 ({d}%)'
            },
            legend: {
                bottom: 10,
                left: 'center',
                data: ['计算机类', '人工智能', '软件工程', '网络工程', '计算机科学与技术'],
            },
            series: [{
                type: 'pie',
                radius: '65%',
                center: ['50%', '50%'],
                selectedMode: 'single',
                data: [{
                    value: ${ComputerClass},
                    name: '计算机类'
                }, {
                    value: ${AI},
                    name: '人工智能'
                }, {
                    value: ${SoftwareEngineering},
                    name: '软件工程'
                }, {
                    value: ${NetworkEngineering},
                    name: '网络工程'
                }, {
                    value: ${ComputerScience},
                    name: '计算机科学与技术'
                }],
                emphasis: {
                    itemStyle: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }]
        };
        
        option2 = {
                title: {
                    text: '人员情况',
                    subtext: '年级分布',
                    left: 'center'
                },
                tooltip: {
                    trigger: 'item',
                    formatter: '{b} : {c} 人 ({d}%)'
                },
                legend: {
                    bottom: 10,
                    left: 'center',
                    data: ['2019级', '2020级'],
                },
                series: [{
                    type: 'pie',
                    radius: '65%',
                    center: ['50%', '50%'],
                    selectedMode: 'single',
                    data: [{
                        value: ${g2019},
                        name: '2019级'
                    }, {
                        value: ${g2020},
                        name: '2020级'
                    }],
                    emphasis: {
                        itemStyle: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }]
            };
        
        option1 && myChart1.setOption(option1);
        option2 && myChart2.setOption(option2);
    </script>
</html>