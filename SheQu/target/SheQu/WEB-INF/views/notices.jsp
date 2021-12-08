<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/2/3
  Time: 1:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>欢迎页面-X-admin2.0</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/xadmin.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/xadmin.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<script type="text/html" id="barDemo">
    <a title="修改 "   onclick="updateNotices()" href="javascript:;">
        <i class="layui-icon">&#xe642;</i>
    </a>
    <a title="删除"  onclick="deleteNotices()" href="javascript:;" lay-event="edit">
        <i class="layui-icon">&#xe640;</i>
    </a>
</script>
<script type="text/html" id="img">
    <img src="${pageContext.request.contextPath}/img/{{d.img}}" onclick="showBigImage(this)">
</script>
<script type="text/html" id="avatarUrl">
    <img src="${pageContext.request.contextPath}/img/{{d.avatarUrl}}" onclick="showBigImage(this)">
</script>

<body class="layui-anim layui-anim-up">
<div class="x-nav">
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div  style="margin-left: 20px">
 <%--   <form id="userSearch" class="layui-input-inline" method="post" action="" style="margin-top: 20px;">
        <div class="layui-row">
            文章标题搜索：
            <div class="layui-inline">
                <input class="layui-input" name="id" id="demoReload" autocomplete="off">
            </div>
        </div>
    </form>
    <div class="layui-input-inline" style="margin-top: 20px">
        <button class="layui-btn" data-type="reload">条件搜索</button>
    </div>--%>
    <div class="demoTable" >
        <button class="layui-btn layui-btn-danger" onclick="addNotice()">增加文章</button>
    </div>
    <table id="messageInfo" lay-filter="messageInfo"></table>
</div>
</body>
<script>
    layui.use(['table','form'], function(){
        var table = layui.table;
        var form = layui.form;
        var tableIns = table.render({
            elem: '#messageInfo'  //绑定table表格
            ,id:'messageInfo'
            ,method:'post'
            ,url: '${pageContext.request.contextPath}/findAllMessageByPage' //后台springmvc接收路径
            ,page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
                layout: ['limit', 'count', 'prev', 'page', 'next', 'skip'] //自定义分页布局
                //,curr: 5 //设定初始在第 5 页
                ,groups: 1 //只显示 1 个连续页码
                ,first: false //不显示首页
                ,last: false //不显示尾页
                ,limit:3
                ,limits:[3,6,9]
            }
            ,cols: [
                [
                    {type: 'checkbox'}
                    ,{field:'id',title:'id', sort: true}
                    ,{field:'author', title:'作者'}
                    ,{field:'avatarUrl', title:'作者头像',templet:'#avatarUrl'}
                    ,{field:'content', title:'文章内容'}
                    ,{field: 'title', title: '标题'}
                    ,{field: 'img', title: '文章图片',templet:"#img"}
                    ,{field: 'time', title: '发布日期'}
                    ,{field:'operation',title:'操作',toolbar: '#barDemo'}
                ]
            ]
        });
    });

    //文章增加
    function addNotice(){
        layer.open(
            {
                type: 2,
                title: '添加文章',
                skin: 'layui-layer-lan',
                shadeClose: false,
                shade: 0.8,
                area:  ['800px', '500px'],
                resize:true,
                content:'${pageContext.request.contextPath}/notice_add',
                end: function(){
                    window.location.reload(); //刷新父页面
                }
            }
        );
    }
    function deleteNotices() {
        var id="";
        layui.use('table',function(){
            var table = layui.table
            var checkStatus = table.checkStatus('messageInfo');
            id = checkStatus.data[0].id;
            $.ajax({
                url:'${pageContext.request.contextPath}/deleteNotices',
                data:{"id":id},
                type:'POST',
                success:function (data) {
                    console.log(data)
                    layer.msg("删除成功！",function(){

                    });
                },error:function(args){
                    layer.msg("删除失败！",function(){

                    });
                }
            })
        });
    }
    
    function updateNotices() {
        var id="";
        layui.use('table',function(){
            var table = layui.table
            var checkStatus = table.checkStatus('messageInfo');
            id = checkStatus.data[0].id;
        });
        layer.open({
            type: 2,
            title: '修改公告',
            skin: 'layui-layer-molv',
            shadeClose: false,
            shade: 0.8,
            area:  ['700px', '450px'],
            content: 'notice_update?id='+id,
            end: function(){
                window.location.reload(); //刷新父页面
            }
        });
    }
    function showBigImage(e) {
        layer.open({
            type: 1,
            shadeClose: true, //点击阴影关闭
            skin: 'layui-layer-rim',
            end: function (index, layero) {
                return false;
            },
            area: ['80%', '80%'],
            content: "<img src=" + $(e).attr('src') + " />"
        });
    }
</script>
</html>
