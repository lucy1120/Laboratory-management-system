<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">

<head>
	<base href="<%=basePath%>">
    <meta charset="UTF-8">
    <title>PersonnelMajorDistribution</title>
    <style>
        .main {
            height: 600px;
        }
    </style>
</head>

<body>

    <div class="main" id="main"></div>
    <script src="js/echarts.min.js"></script>
    <script type="text/javascript">
        var chartDom = document.getElementById('main');
        var myChart = echarts.init(chartDom);
        var option;

        option = {
            title: {
                text: '人员情况',
                subtext: '性别分布',
                left: 'center'
            },
            tooltip: {
                trigger: 'item',
                formatter: '{b} : {c} 人 ({d}%)'
            },
            legend: {
                bottom: 10,
                left: 'center',
                data: ['boy', 'girl'],
            },
            series: [{
                type: 'pie',
                radius: '65%',
                center: ['50%', '50%'],
                selectedMode: 'single',
                data: [{
                    value: ${boy},
                    name: 'boy'
                }, {
                    value: ${girl},
                    name: 'girl'
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

        option && myChart.setOption(option);
    </script>
</body>


</html>