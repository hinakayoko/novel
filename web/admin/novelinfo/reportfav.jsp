<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base target="_self"/>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="<%=path%>/css/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="<%=path%>/css/left.css" rel="stylesheet" type="text/css">
<link href="<%=path%>/css/pdmcontent01.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=path%>/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/layer/layer.js"></script>
<script language="javascript" type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>
<script src="<%=path%>/css/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/jquery-pdm.js"></script>
	<script src="<%=path%>/js/echarts.min.js"></script>
<title>菜单栏</title>
</head>
<body>
	<div class="page-content">
		 
			<div class="panel panel-default">
				<div class="panel-heading">收藏量统计Top10</div>
				 
				 	<div align="center" style="margin-top: 20px;">
	   <div id="main" style="width: 800px; height: 400px;"></div>
	</div>
			</div>
		 
	</div>
</body>
</html>
<script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));

        // 指定图表的配置项和数据
        var option = {
            title: {
                text: '${title}',
                left:'center'
            },
            tooltip: {},
            legend: {
                data:['名称'],
                
            },
            xAxis: {
                data: [${items}],
                  type: 'category',
                  axisTick: {
			alignWithLabel: true
		},
		axisLabel: {    //重点在这一块，其余可以忽略
			interval: 0,   //这个一定要有，别忘记了
			rotate: 15,
			textStyle: {
				color: '#000',
				fontSize: 10
			}
		},
		axisLine: {
			show: true,
			interval: 0,
			lineStyle: {
				color: "RGB(210,221,217)"
			}
		}
            },
            yAxis: {
               minInterval: 1
            },
            series: [{
                 
                type: 'bar',
                 itemStyle : { normal:
                    {
                         label : {show: true,formatter: '{c}' 
                         
                         }
                    }
                 },
                data: [${score}]
            }
           
             ]
        };

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    </script>