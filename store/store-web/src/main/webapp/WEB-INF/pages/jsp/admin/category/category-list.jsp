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
                <li><a href="#">分类管理</a></li>
                <li class="active">数据列表</li>
            </ol>
        </section>
        <!-- 内容头部 /-->

        <!-- 正文区域 -->
        <section class="content">

            <!-- .box-body -->
            <div class="box box-primary">
                <div class="box-header with-border">
                    <h3 class="box-title">列表</h3>
                </div>

                <div class="box-body">

                    <!-- 数据表格 -->
                    <div class="table-box">

                        <!--工具栏-->
                        <div class="pull-right">
                            <div class="form-group form-inline">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-default" title="新建" onclick="location.href='${pageContext.request.contextPath}/adminCategory/showAdd'" >新建</button>
                                </div>
                            </div>
                        </div>
                        <!--/.工具栏-->

                        <!--数据列表-->
                        <table id="dataList" class="table table-bordered table-striped table-hover dataTable">
                            <thead>
                            <tr>
                                <th class="">序号</th>
                                <th class="">分类名称</th>
                                <th class="">编辑</th>
                                <th class="">删除</th>
                            </tr>
                            </thead>
                            <tbody>

                            <c:forEach items="${pageInfo.list}" var="c" varStatus="status">
                            <tr>
                                <td>${status.count}</td>
                                <td>${c.cname}</td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/adminCategory/showEdit/${c.cid}">
                                        <img src="${pageContext.request.contextPath}/img/admin/i_edit.gif" border="0" style="cursor: hand">
                                    </a>
                                </td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/adminCategory/showDel/${c.cid}" onclick="confirm('是否确定删除分类？')">
                                        <img src="${pageContext.request.contextPath}/img/admin/i_del.gif" style="cursor: hand">
                                    </a>
                                </td>
                            </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <!--数据列表/-->

                    </div>
                    <!-- 数据表格 /-->

                </div>
                <!-- /.box-body -->

                <!-- .box-footer-->

                <%-- .分页模块 --%>
                <div class="box-footer">
                    <div class="pull-left">
                        <div class="form-group form-inline">
                            总共${pageInfo.lastPage} 页，共${pageInfo.total} 条数据。 <%--每页
                            <select class="form-control" onchange="mbar(this)">
                                <option value="${pageContext.request.contextPath}/adminCategory/findAll?pageSize=1">1</option>
                                <option value="${pageContext.request.contextPath}/adminCategory/findAll?pageSize=2">2</option>
                                <option value="${pageContext.request.contextPath}/adminCategory/findAll?pageSize=3">3</option>
                                <option value="${pageContext.request.contextPath}/adminCategory/findAll?pageSize=4">4</option>
                                <option value="${pageContext.request.contextPath}/adminCategory/findAll?pageSize=5">5</option>
                            </select> 条--%>
                        </div>
                        <%--<script type="text/javascript">
                            /*$("#sumyear").change(function(){
                                alert($(this).children('option:selected').val());
                            })*/
                            function mbar(sobj) {
                                var docurl =sobj.options[sobj.selectedIndex].value;
                                if (docurl != "") {
                                    open(docurl,'_blank');
                                    sobj.selectedIndex=0;
                                    sobj.blur();
                                }
                            }
                        </script>--%>
                    </div>

                    <div class="box-tools pull-right">
                        <ul class="pagination">
                            <c:if test="${pageInfo.pageNum!=pageInfo.firstPage}">
                                <li>
                                    <a href="${pageContext.request.contextPath}/adminCategory/findAll" aria-label="Previous">首页</a>
                                </li>
                                <li><a href="${pageContext.request.contextPath}/adminCategory/findAll?page=${pageInfo.prePage}">上一页</a></li>
                            </c:if>
                            <c:forEach begin="1" end="${pageInfo.lastPage}" varStatus="status">
                                <c:if test="${pageInfo.pageNum==status.count}">
                                    <li class="disabled"><a href="${pageContext.request.contextPath}/adminCategory/findAll?page=${status.count}">${status.count}</a></li>
                                </c:if>
                                <c:if test="${pageInfo.pageNum!=status.count}">
                                    <li class=""><a href="${pageContext.request.contextPath}/adminCategory/findAll?page=${status.count}">${status.count}</a></li>
                                </c:if>
                            </c:forEach>
                            <c:if test="${pageInfo.pageNum!=pageInfo.lastPage}">
                                <li><a href="${pageContext.request.contextPath}/adminCategory/findAll?page=${pageInfo.nextPage}">下一页</a></li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/adminCategory/findAll?page=${pageInfo.lastPage}" aria-label="Next">尾页</a>
                                </li>
                            </c:if>
                        </ul>
                    </div>

                </div>
                <%-- /.分页模块 --%>

                <!-- /.box-footer-->



            </div>

        </section>
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
