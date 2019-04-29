<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container header">

    <div class="row">

        <section class="span5">
            <div class="logo col-xs-12" >
                <a href="${pageContext.request.contextPath}/main/mainInit.action">
                    <img src="${pageContext.request.contextPath}/image/r___________renleipic_01/logo.gif" alt="MIndy"/>
                </a>
            </div>
        </section>
        <section class="span9 col-xs-8 pull-right">
            <div class="headerAd">
                <img src="${pageContext.request.contextPath}/image/header.jpg" width="320" height="50" alt="正品保障" title="正品保障"/>
            </div>
        </section>
        <section class="col-xs-12">
            <div class="topNav clearfix col-xs-4">
                <ul style="margin-left: 0px;">
                    <c:choose>
                        <c:when test="${null == user}">
                            <li id="headerLogin" class="headerLogin" style="display: list-item;">
                                <a href="${pageContext.request.contextPath}/user/loginInit.action">登录</a>|
                            </li>
                            <li id="headerRegister" class="headerRegister" style="display: list-item;">
                                <a href="${pageContext.request.contextPath}/user/registInit.action">注册
                            <li id="headerUsername" class="headerUserna</a>|
                              </li>me"></li>
                        </c:when>
                        <c:otherwise>
                            <li>欢迎登录....${user.username}</li>
                            <li id="headerLogout"><a  href="${pageContext.request.contextPath}/order/orderlist.action">[我的订单]</a>|</li>
                            <li id="headerLogout"><a  href="${pageContext.request.contextPath}/user/logout.action">[退出]</a>|</li>

                        </c:otherwise>
                    </c:choose>


                    <li><a>会员中心</a>|</li>
                    <li><a>购物指南</a>|</li>
                    <li><a>关于我们</a></li>
                </ul>
            </div>
            <div class="cart col-xs-3" style="width: 100px;" >
                <a  href="${pageContext.request.contextPath}/cart/cartInit.action">购物车</a>
            </div>
            <div class="phone col-xs-3 pull-right" style="">
                客服热线:  <strong>96008/53277764</strong>
            </div>
        </section>
    </div>

    <div class="span24">
        <ul class="mainNav" style="width: 100%">
            <li>
                <a href="${pageContext.request.contextPath}/main/mainInit.action">首页</a>
                |
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/main/mainInit.action">论坛</a>
                |
            </li>
            <c:forEach items="${categories}" var="category">
                <li>
                    <a href="${pageContext.request.contextPath}/product/categorylist.action?cid=${category.cid}">${category.cname}</a>
                    |
                </li>
            </c:forEach>

            <li>
                <a href="${pageContext.request.contextPath}/main/mainInit.action">关于我们</a>
                |
            </li>
        </ul>
    </div>


</div>


