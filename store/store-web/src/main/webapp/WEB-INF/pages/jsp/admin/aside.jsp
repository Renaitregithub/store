<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="${pageContext.request.contextPath}/admin/img/user2-160x160.jpg" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p></p>
                <p>${adminSession.username}</p>
            </div>
        </div>

        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu">
            <li class="header">菜单</li>

            <%--首页--%>
            <li id="admin-index">
                <a href="${pageContext.request.contextPath}/admin/showIndex">
                    <i class="fa fa-dashboard"></i> <span>首页</span>
                </a>
            </li>

            <!-- 菜单 -->

            <%--种类管理--%>
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-folder"></i> <span>分类管理</span>
                    <span class="pull-right-container">
		                        <i class="fa fa-angle-left pull-right"></i>
		                    </span>
                </a>
                <ul class="treeview-menu">
                    <li id="admin-category">
                        <a href="${pageContext.request.contextPath}/adminCategory/findAll">
                            <i class="fa fa-circle-o"></i> 分类管理
                        </a>
                    </li>
                </ul>
            </li>

            <li class="treeview">
                <a href="#">
                    <i class="fa fa-folder"></i> <span>商品管理</span>
                    <span class="pull-right-container">
		                        <i class="fa fa-angle-left pull-right"></i>
		                    </span>
                </a>
                <ul class="treeview-menu">
                    <li id="admin-product">
                        <a href="${pageContext.request.contextPath}/adminProduct/findAll">
                            <i class="fa fa-circle-o"></i> 商品管理
                        </a>
                    <li id="admin-product-pushdown">
                        <a href="${pageContext.request.contextPath}/adminProduct/pushDownUI">
                            <i class="fa fa-circle-o"></i> 已下架商品管理
                        </a>
                    </li>
                </ul>
            </li>

            <li class="treeview">
                <a href="#">
                    <i class="fa fa-folder"></i> <span>订单管理</span>
                    <span class="pull-right-container">
		                        <i class="fa fa-angle-left pull-right"></i>
		                    </span>
                </a>
                <ul class="treeview-menu">
                    <li id="admin-orders">
                        <a href="${pageContext.request.contextPath}/adminOrders/findAll">
                            <i class="fa fa-circle-o"></i> 订单管理
                        </a>
                    </li>
                    <li id="admin-orders1">
                        <a href="${pageContext.request.contextPath}/adminOrders/findAll?state=1">
                            <i class="fa fa-circle-o"></i> 未完成订单管理
                        </a>
                    </li>
                    <li id="admin-orders2">
                        <a href="${pageContext.request.contextPath}/adminOrders/findAll?state=2">
                            <i class="fa fa-circle-o"></i> 带发货订单管理
                        </a>
                    </li>
                    <li id="admin-orders3">
                        <a href="${pageContext.request.contextPath}/adminOrders/findAll?state=3">
                            <i class="fa fa-circle-o"></i> 发货订单管理
                        </a>
                    </li>
                    <li id="admin-orders4">
                        <a href="${pageContext.request.contextPath}/adminOrders/findAll?state=4">
                            <i class="fa fa-circle-o"></i> 已完成订单管理
                        </a>
                    </li>
                </ul>
            </li>

            <li class="treeview">
                <a href="#">
                    <i class="fa fa-folder"></i> <span>用户管理</span>
                    <span class="pull-right-container">
		                        <i class="fa fa-angle-left pull-right"></i>
		                    </span>
                </a>
                <ul class="treeview-menu">
                    <li id="admin-login">
                        <a href="${pageContext.request.contextPath}/adminUser/findAll">
                            <i class="fa fa-circle-o"></i> 用户管理
                        </a>
                    </li>
                </ul>
            </li>

        </ul>
    </section>
    <!-- /.sidebar -->
</aside>
