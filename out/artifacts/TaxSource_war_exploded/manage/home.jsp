<%--
  Created by IntelliJ IDEA.
  User: 丛爸爸
  Date: 2021/10/20
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="/TaxSource/">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>欢迎页面</title>

    <link href="../static/css/base.css" rel="stylesheet">
    <link rel="stylesheet" href="../static/easyui/uimaker/easyui.css">
    <link rel="stylesheet" href="../static/css/home.css">
</head>
<body>
<div class="container">
    <div id="hd">

    </div>

    <div id="bd">
        <div class="bd-content">
            <div class="right-zone">
                <div class="inform item-box">
                    <div class="inform-hd">
                        <label>通知公告</label>
                        <a href="javascript:;">更多<span>&gt;</span></a>
                    </div>
                    <ul>
                        <li>
                            <span></span>
                            <a href="javascript:;" class="ellipsis">金税三期税源巡查系统正式上线通知<i></i></a>
                            <label>04-13</label>
                        </li>
                        <li>
                            <span></span>
                            <a href="javascript:;" class="ellipsis">我区税务工作取到重大突破<i></i></a>
                            <label>04-12</label>
                        </li>
                        <li>
                            <span></span>
                            <a href="javascript:;" class="ellipsis">2015年IT行业纳税情况调查</a>
                            <label>04-11</label>
                        </li>
                        <li>
                            <span></span>
                            <a href="javascript:;" class="ellipsis">2017年我区将对中小企业进行税务宣传</a>
                            <label>04-10</label>
                        </li>
                        <li>
                            <span></span>
                            <a href="javascript:;" class="ellipsis">我区对区辖企业进行税务普查</a>
                            <label>04-09</label>
                        </li>
                        <li>
                            <span></span>
                            <a href="javascript:;" class="ellipsis">依法纳税，服务纳税人</a>
                            <label>04-08</label>
                        </li>
                    </ul>
                </div>
                <div class="attached item-box">
                    <div class="inform-hd">
                        <label>常用附件下载</label>
                        <a href="javascript:;">更多<span>&gt;</span></a>
                    </div>
                    <div class="attached-tab">
                        <a href="javascript:;" class="current item-left" attached="public-attached">公开附件</a>
                        <a href="javascript:;" class="item-right" attached="inner-attached">内部附件</a>
                    </div>
                    <ul class="public-attached">
                        <li>
                            <span></span>
                            <a href="javascript:;" class="ellipsis">界面设计作品PSD源文件免费下载</a>
                        </li>
                        <li>
                            <span></span>
                            <a href="javascript:;" class="ellipsis">uimaker版权所有禁止转载发布</a>
                        </li>
                        <li>
                            <span></span>
                            <a href="javascript:;" class="ellipsis">意见建议反馈内容模版</a>
                        </li>
                        <li>
                            <span></span>
                            <a href="javascript:;" class="ellipsis">系统错误修复文档下载分布</a>
                        </li>
                        <li>
                            <span></span>
                            <a href="javascript:;" class="ellipsis">采集信息管理系统后台界面</a>
                        </li>
                        <li>
                            <span></span>
                            <a href="javascript:;" class="ellipsis">用户管理信息文件同步</a>
                        </li>
                    </ul>
                    <ul class="inner-attached hide">
                        <li>
                            <span></span>
                            <a href="javascript:;" class="ellipsis">意见建议反馈内容模版</a>
                        </li>
                        <li>
                            <span></span>
                            <a href="javascript:;" class="ellipsis">这里显示的不同内容</a>
                        </li>
                        <li>
                            <span></span>
                            <a href="javascript:;" class="ellipsis">界面设计作品PSD源文件免费下载</a>
                        </li>
                        <li>
                            <span></span>
                            <a href="javascript:;" class="ellipsis">系统错误修复文档下载分布</a>
                        </li>
                        <li>
                            <span></span>
                            <a href="javascript:;" class="ellipsis">采集信息管理系统后台界面</a>
                        </li>
                        <li>
                            <span></span>
                            <a href="javascript:;" class="ellipsis">用户管理信息文件同步</a>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="center-part">
                <div class="center-items todo">
                    <div class="calendar-part">
                        <div class="easyui-calendar" style="width:205px;height:231px;"></div>
                    </div>
                    <ul class="work-items clearfix">
                        <li>
                            <div class="work-inner">
                                <div class="work-item green">
                                    <i class="iconfont">&#xe61f;</i>
                                    <span class="num">14&nbsp;<span class="unit">个</span></span>
                                    <label>待办未处理</label>
                                </div>
                            </div>
                        </li>
                        <li>
                            <div class="work-inner">
                                <div class="work-item red">
                                    <i class="iconfont">&#xe622;</i>
                                    <span class="num">6&nbsp;<span class="unit">条</span></span>
                                    <label>预警信息未读</label>
                                </div>
                            </div>
                        </li>
                        <li>
                            <div class="work-inner">
                                <div class="work-item yellow">
                                    <i class="iconfont">&#xe61d;</i>
                                    <span class="num">9&nbsp;<span class="unit">封</span></span>
                                    <label>邮件未读</label>
                                </div>
                            </div>
                        </li>
                        <li>
                            <div class="work-inner">
                                <div class="work-item blue">
                                    <i class="iconfont">&#xe621;</i>
                                    <span title="2000,00万" class="num">2000,00&nbsp;<span class="unit">万</span></span>
                                    <label>预期年度应税总额</label>
                                </div>
                            </div>
                        </li>
                        <li>
                            <div class="work-inner">
                                <div class="work-item purple">
                                    <i class="iconfont">&#xe61e;</i>
                                    <span title="2000,00万" class="num">100,00&nbsp;<span class="unit">万</span></span>
                                    <label>已完成的金额</label>
                                </div>
                            </div>
                        </li>
                        <li>
                            <div class="work-inner">
                                <div class="work-item gray">
                                    <i class="iconfont">&#xe620;</i>
                                    <span class="num">10&nbsp;<span class="unit">个</span></span>
                                    <label>纳税人</label>
                                </div>
                            </div>
                        </li>
                    </ul>
                </div>
                <div class="center-items chart0 clearfix">
                    <div class="chart0-item">
                        <div class="item-inner">
                            <div class="item-content">
                                <div class="content-hd">税源风险</div>
                                <div class="chart-chart" id="chart0"></div>
                            </div>
                        </div>
                    </div>
                    <div class="chart0-item">
                        <div class="item-inner">
                            <div class="item-content">
                                <div class="content-hd">缴税及时率</div>
                                <div class="chart-chart" id="chart1"></div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="center-items chart1">
                    <div class="chart1-inner">
                        <div class="item-hd">巡查正常率</div>
                        <div class="chart1-chart" id="chart3"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div id="ft"></div>
</div>
<div class="todo-panel">
    <div class="todo-title">
        <i class="iconfont">&#xe61f;</i>
        <span class="num">14&nbsp;<span class="unit">个</span></span>
        <label>待办未处理</label>
    </div>
</div>
<script type="text/javascript" src="../static/jquery/jquery.min.js"></script>
<script type="text/javascript" src="../static/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../static/easyui/easyui-lang-zh_CN.js"></script>
<!-- <script type="text/javascript" src="js/menu.js"></script> -->
<script type="text/javascript" src="../static/js/echarts-all.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
        var option0 = {
            tooltip : {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            legend: {
                orient : 'vertical',
                x : 'left',
                data:['金融行业','科技行业','交通行业','保险行业','医疗行业'],
                show:false
            },
            toolbox: {
                show : false,
                feature : {
                    mark : {show: true},
                    dataView : {show: true, readOnly: false},
                    magicType : {
                        show: true,
                        type: ['pie', 'funnel'],
                        option: {
                            funnel: {
                                x: '25%',
                                width: '50%',
                                funnelAlign: 'center',
                                max: 1548
                            }
                        }
                    },
                    restore : {show: true},
                    saveAsImage : {show: true}
                }
            },
            calculable : true,
            series : [
                {
                    name:'行业数据',
                    type:'pie',
                    radius : ['50%', '70%'],
                    itemStyle : {
                        normal : {
                            label : {
                                show : false
                            },
                            labelLine : {
                                show : false
                            }
                        },
                        emphasis : {
                            label : {
                                show : true,
                                position : 'center',
                                textStyle : {
                                    fontSize : '30',
                                    fontWeight : 'bold'
                                }
                            }
                        }
                    },
                    data:[
                        {value:335, name:'金融行业'},
                        {value:310, name:'科技行业'},
                        {value:234, name:'保险行业'},
                        {value:135, name:'交通行业'},
                        {value:1548, name:'医疗行业'}
                    ]
                }
            ]
        };

        var myChart0 = echarts.init(document.getElementById('chart0'));
        myChart0.setOption(option0);

        //chart1
        var option1 = {
            tooltip : {
                trigger: 'axis'
            },
            legend: {
                data:['金融行业','科技行业','交通行业','保险行业','医疗行业'],
                show:false
            },
            toolbox: {
                show : false,
                feature : {
                    mark : {show: true},
                    dataView : {show: true, readOnly: false},
                    magicType : {show: true, type: ['line', 'bar', 'stack', 'tiled']},
                    restore : {show: true},
                    saveAsImage : {show: true}
                }
            },
            calculable : true,
            xAxis : [
                {
                    type : 'category',
                    boundaryGap : false,
                    data : ['第一周','第二周','第三周','第四周','第五周','第六周','第七周']
                }
            ],
            yAxis : [
                {
                    type : 'value'
                }
            ],
            series : [
                {
                    name:'金融行业',
                    type:'line',
                    stack: '总量',
                    data:[120, 132, 101, 134, 90, 230, 210]
                },
                {
                    name:'科技行业',
                    type:'line',
                    stack: '总量',
                    data:[220, 182, 191, 234, 290, 330, 310]
                },
                {
                    name:'交通行业',
                    type:'line',
                    stack: '总量',
                    data:[150, 232, 201, 154, 190, 330, 410]
                },
                {
                    name:'保险行业',
                    type:'line',
                    stack: '总量',
                    data:[320, 332, 301, 334, 390, 330, 320]
                },
                {
                    name:'医疗行业',
                    type:'line',
                    stack: '总量',
                    data:[820, 932, 901, 934, 1290, 1330, 1320]
                }
            ]
        };
        var myChart1 = echarts.init(document.getElementById('chart1'));
        myChart1.setOption(option1);

        var option3 = {
            tooltip : {
                trigger: 'axis'
            },
            legend: {
                data:['主要行业税源巡查量'],
                show:false
            },
            toolbox: {
                show : false,
                feature : {
                    mark : {show: true},
                    dataView : {show: true, readOnly: false},
                    magicType : {show: true, type: ['line', 'bar']},
                    restore : {show: true},
                    saveAsImage : {show: true}
                }
            },
            calculable : true,
            xAxis : [
                {
                    type : 'category',
                    data:['金融行业','科技行业','交通行业','保险行业','医疗行业',"房地产业","通信行业"]
                }
            ],
            yAxis : [
                {
                    type : 'value'
                }
            ],
            series : [
                {
                    name:'巡查量',
                    type:'bar',
                    data:[60, 45, 73, 23, 37, 48, 18],
                    markPoint : {
                        data : [
                            {type : 'max', name: '最大值'},
                            {type : 'min', name: '最小值'}
                        ]
                    },
                    markLine : {
                        data : [
                            {type : 'average', name: '平均值'}
                        ]
                    }
                }
            ]
        };

        var myChart3 = echarts.init(document.getElementById('chart3'));
        myChart3.setOption(option3);

        //我的待办点击事件
        $(document).on('click','.work-item.green',function(event){
            var width = (2 * $(this).width()) + 10;
            $(".todo-panel").width(width -2).css({top:$(this).offset().top,left:$(this).offset().left}).show();
            event.stopPropagation();
        });
        $(".todo-panel").click(function(){
            event.stopPropagation();
        });
        $(document).click(function(){
            $(".todo-panel").hide();
        });

    });

    //公开附件tab事件处理
    $(".attached-tab").on("click","a",function(){
        $(this).closest(".attached-tab").find("a").removeClass("current");
        $(this).addClass("current");
        $(this).closest(".attached").find("ul").addClass("hide");
        $(this).closest(".attached").find("ul." + $(this).attr("attached")).removeClass("hide");
    })

</script>
</body>
</html>
