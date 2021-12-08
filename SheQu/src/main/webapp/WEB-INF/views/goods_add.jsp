<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/2/6
  Time: 0:06
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
<body class="layui-unselect lau-sign-body" style="padding-top: 0px " >
    <form  class="layui-form">
        <div>
            <label class="layui-form-label"><i class="layui-icon layui-icon-password"></i> 图书标题</label>
            <div class="layui-input-block">
                <input type="text" name="goods_title" placeholder="请输入图书标题" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div >
            <label class="layui-form-label"><i class="layui-icon layui-icon-password"></i>图书寄语</label>
            <div class="layui-input-block">
                <input type="text" name="goods_desc" placeholder="请输入图书寄语" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div>
            <label class="layui-form-label" ><i class="layui-icon layui-icon-password"></i>图书图片</label>
            <div class="layui-input-block" id="goods_img_div">
                <button id="goods" type="button" class="layui-btn layui-btn-primary" ><i class="layui-icon">&#xe67c;</i>选择文件</button>
                <img   id="goods_img"  style="width:30px;height:30px;">
            </div>
        </div>
        <div >
            <label class="layui-form-label"><i class="layui-icon layui-icon-password"></i>捐赠人信息</label>
            <div class="layui-input-block">
                <input type="text" name="goods_price" placeholder="请输入捐赠人信息" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div>
            <label class="layui-form-label">选择添加人：</label>
            <div class="layui-input-block">
                <select lay-filter="publisher_id" id="publisher_id">
                </select>
            </div>
        </div>
        <div class="layui-form-item lau-sign-other" style="margin-top: 20px;text-align:center">
            <button type="button" class="layui-btn layui-btn-normal" lay-submit="" lay-filter="insertGoods" style="margin-right: 100px">提交</button>
        </div>
    </form>
</body>
<script>
    var goods_img,publisher_id;
    layui.use(['upload','form'], function(){
        var $ = layui.jquery,upload = layui.upload,form=layui.form;
        var uploadInst = upload.render({//作者头像上传
            elem: '#goods'
            , url: '${pageContext.request.contextPath}/uploadAvatar'
            , field: "photo"  //默认是file
            , before: function (obj) {
                //预读本地文件示例，不支持ie8
                obj.preview(function (index, file, result) {
                    console.log("file:"+file.name)
                    path = '${pageContext.request.contextPath}/img/'+file.name
                    console.log("path:"+path)
                    $('#goods_img').attr('src', path); //图片链接（base64）
                });
            }
            , done: function (res) {
                console.log(res.data)
                //如果上传失败
                if (res.code > 0) {
                    return layer.msg('上传失败');
                }else{
                    goods_img = res.data;
                    console.log("goods_img:"+goods_img)
                    return layer.msg('上传图片成功');
                }
            }
            , error: function () {
                //演示失败状态，并实现重传
                var demoText = $('#goods_img_div');
                demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
                demoText.find('.layui-btn layui-btn-primary').on('click', function () {
                    uploadInst.upload();
                });
            }
        });
        form.on('select(publisher_id)', function(data){
            publisher_id = data.value;
            console.log(publisher_id)
        });
        form.on('submit(insertGoods)', function(result) {
            console.log("result.field:"+typeof (result.field))//object
            res = result.field
            res.goods_img = goods_img
            res.publisher_id = publisher_id
            data = JSON.stringify(res)//把js对象转换成json字符串,string
            console.log("data:"+typeof (data))
            //var person={"name":"zhangsan","sex":"男","age":"24"}
            //console.log("person:"+typeof (person))
            //sconsole.log(data.field.type())
            $.ajax({
                url : '${pageContext.request.contextPath}/insertGoods',
                data : data,
                type:'POST',
                dataType:'text',
                contentType : 'application/json',
                success:function(data){
                    if(data=="success"){
                        layer.msg("成功！",function(){

                        });
                    }else{
                        layer.msg("失败！",function(){

                        });
                    }
                },
                error:function(args){
                    layer.msg("失败！",function(){

                    });
                }
            });
        });
    })

    $(function () {
        $.ajax({
            url: '${pageContext.request.contextPath}/findAllAccount',
            dataType: 'json',
            type: 'post',
            success: function (data) {
                console.log(data)
                $('#publisher_id').html('')
                $('#publisher_id').append(new Option('请选择添加人','请选择添加人'))
                $.each(data, function (index, item) {
                    $('#publisher_id').append(new Option(item.name, item.account));// 下拉菜单里添加元素
                });
                layui.form.render("select");
            }
        });
    })
</script>
</html>
