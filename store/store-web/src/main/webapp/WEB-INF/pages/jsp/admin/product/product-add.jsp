<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <!-- 页面meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>数据列表</title>
    <meta name="description" content="AdminLTE2定制版">
    <meta name="keywords" content="AdminLTE2定制版">

    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/plugins/ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/plugins/iCheck/square/blue.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/plugins/morris/morris.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/plugins/datepicker/datepicker3.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/plugins/daterangepicker/daterangepicker.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/plugins/datatables/dataTables.bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/plugins/treeTable/jquery.treetable.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/plugins/treeTable/jquery.treetable.theme.default.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/plugins/select2/select2.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/plugins/colorpicker/bootstrap-colorpicker.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/plugins/bootstrap-markdown/css/bootstrap-markdown.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/plugins/adminLTE/css/skins/_all-skins.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/plugins/ionslider/ion.rangeSlider.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/plugins/ionslider/ion.rangeSlider.skinNice.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/plugins/bootstrap-slider/slider.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.css">
</head>

<body class="hold-transition skin-purple sidebar-mini">

<div class="wrapper">

    <!-- 页面头部 -->
    <jsp:include page="../header.jsp" />
    <!-- 页面头部 /-->

    <!-- 导航侧栏 -->
    <jsp:include page="../aside.jsp" />
    <!-- 导航侧栏 /-->

    <!-- 内容区域 -->
    <div class="content-wrapper">

        <!-- 内容头部 -->
        <section class="content-header">
            <h1>
                数据管理
                <small>数据列表</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="#">商品管理</a></li>
                <li class="active">数据列表</li>
            </ol>
        </section>
        <!-- 内容头部 /-->

        <!-- 正文区域 -->
        <form action="${pageContext.request.contextPath}/adminProduct/add" method="post" enctype="multipart/form-data">
            <!-- 正文区域 -->

            <!--商品信息-->
            <section class="content">

                <div class="panel panel-default">
                    <div class="panel-heading">编辑商品</div>
                    <div class="row data-type">

                        <div class="col-md-2 title">商品名称</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" name="pname"
                                   placeholder="商品名称" value="">
                        </div>
                        <div class="col-md-2 title">是否热门</div>
                        <div class="col-md-4 data">
                            <select class="form-control select2" style="width: 100%" name="is_hot">
                                <option value="0" selected="selected">是</option>
                                <option value="1">否</option>
                            </select>
                        </div>
                        <div class="col-md-2 title">市场价格</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" name="shop_price"
                                   placeholder="市场价格" value="">
                        </div>
                        <div class="col-md-2 title">商城价格</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" name="market_price"
                                   placeholder="商城价格" value="">
                        </div>


                        <div class="col-md-4 title">商品图片</div>
                        <div class="col-md-8 data">
                            <input type="file" name="upload" />
                        </div>
                        <div class="col-md-4 title">所属分类：</div>
                        <div class="col-md-8 data">
                            <select class="form-control" name="cid">
                                <c:forEach items="${category}" var="c">
                                    <option value="${c.cid}">${c.cname}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="col-md-4 title rowHeight2x">商品描述</div>
                        <div class="col-md-8 data rowHeight2x">
                            <textarea class="form-control" rows="3" name="pdesc" placeholder="请输入..."></textarea>
                        </div>

                    </div>
                </div>
                <!--商品信息/-->

                <!--工具栏-->
                <div class="box-tools text-center">
                    <button type="submit" class="btn bg-maroon">保存</button>
                    <button type="button" class="btn bg-default"
                            onclick="history.back(-1);">返回</button>
                </div>
                </section>
                <!--工具栏/-->

            <!-- 正文区域 /-->
        </form>
        <!-- 正文区域 /-->

    </div>
    <!-- 内容区域 /-->

    <!-- 底部导航 -->
    <jsp:include page="../footer.jsp" />
    <!-- 底部导航 /-->

</div>


<script src="${pageContext.request.contextPath}/admin/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/jQueryUI/jquery-ui.min.js"></script>
<script>
    $.widget.bridge('uibutton', $.ui.button);
</script>
<script src="${pageContext.request.contextPath}/admin/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/raphael/raphael-min.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/morris/morris.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/sparkline/jquery.sparkline.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/knob/jquery.knob.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/daterangepicker/moment.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/daterangepicker/daterangepicker.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/daterangepicker/daterangepicker.zh-CN.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/datepicker/bootstrap-datepicker.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/fastclick/fastclick.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/iCheck/icheck.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/adminLTE/js/app.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/treeTable/jquery.treetable.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/select2/select2.full.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.zh-CN.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/bootstrap-markdown/js/bootstrap-markdown.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/bootstrap-markdown/locale/bootstrap-markdown.zh.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/bootstrap-markdown/js/markdown.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/bootstrap-markdown/js/to-markdown.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/ckeditor/ckeditor.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/input-mask/jquery.inputmask.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/input-mask/jquery.inputmask.extensions.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/datatables/dataTables.bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/chartjs/Chart.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/flot/jquery.flot.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/flot/jquery.flot.resize.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/flot/jquery.flot.pie.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/flot/jquery.flot.categories.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/ionslider/ion.rangeSlider.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/bootstrap-slider/bootstrap-slider.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.js"></script>
<script src="${pageContext.request.contextPath}/admin/plugins/bootstrap-datetimepicker/locales/bootstrap-datetimepicker.zh-CN.js"></script>
<script>
    $(document).ready(function() {
        // 选择框
        $(".select2").select2();

        // WYSIHTML5编辑器
        $(".textarea").wysihtml5({
            locale: 'zh-CN'
        });
    });


    // 设置激活菜单
    function setSidebarActive(tagUri) {
        var liObj = $("#" + tagUri);
        if (liObj.length > 0) {
            liObj.parent().parent().addClass("active");
            liObj.addClass("active");
        }
    }


    $(document).ready(function() {

        // 激活导航位置
        setSidebarActive("admin-datalist");

        // 列表按钮
        $("#dataList td input[type='checkbox']").iCheck({
            checkboxClass: 'icheckbox_square-blue',
            increaseArea: '20%'
        });
        // 全选操作
        $("#selall").click(function() {
            var clicks = $(this).is(':checked');
            if (!clicks) {
                $("#dataList td input[type='checkbox']").iCheck("uncheck");
            } else {
                $("#dataList td input[type='checkbox']").iCheck("check");
            }
            $(this).data("clicks", !clicks);
        });
    });
</script>
</body>

</html>
