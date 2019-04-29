<%--
  Created by IntelliJ IDEA.
  User: Mindy
  Date: 2018/6/11
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>分类页面</title>
    <%@include file="../common/common.jsp"%>

    <link href="${pageContext.request.contextPath}/css/product.css" rel="stylesheet" type="text/css">
</head>
<body>

<%@include file="../common/head.jsp"%>
<div class="container productList" style="width: 80%">
    <article class="row">
        <section class="col-xs-3">
            <%@include file="../common/navigator.jsp"%>
        </section>
        <section class="col-xs-9">
            <article class="row">
                <section  class=" col-xs-12" >
                    <!-- 1 轮播图容器 -->
                    <div id="carousel_container" class="carousel slide"   data-ride="carousel">
                        <!-- 2 设置图片容器
                            class="carousel-inner": 会使得图片隐藏
                            active: 将第2张图显示出来
                        -->
                        <div class="carousel-inner">
                            <div class="item"> <img src="${pageContext.request.contextPath}/images/products/bg01.jpg" ></div>
                            <div class="item active"> <img src="${pageContext.request.contextPath}/images/products/bg04.jpg"></div>
                            <div class="item"> <img src="${pageContext.request.contextPath}/images/products/bg01.jpg"></div>
                            <div class="item"> <img src="${pageContext.request.contextPath}/images/products/bg04.jpg" ></div>
                        </div>

                        <!--
                          3 图片制作完后,接着制作小圆圈
                        -->
                        <ol class="carousel-indicators">
                            <li data-slide-to="0" data-target="#carousel_container"></li>
                            <li data-slide-to="1" data-target="#carousel_container"></li>
                            <li data-slide-to="2" data-target="#carousel_container"></li>
                            <li data-slide-to="3" data-target="#carousel_container"></li>
                        </ol>

                        <!--
                          4 制作左右按钮
                         -->
                        <a href="#carousel_container"  data-slide="prev"  class="left carousel-control">
                            <span class="glyphicon glyphicon-chevron-left"></span>
                        </a>
                        <a href="#carousel_container" data-slide="next"   class="right carousel-control">
                            <span class="glyphicon glyphicon-chevron-right"></span>
                        </a>

                    </div>
                    <div style="width: 550px; height: 50px;"></div>

                </section>
                <section class=" col-xs-12">

                    <form id="productForm" action="./image/蔬菜 - Powered By Mango Team.htm" method="get">
                        <input type="hidden" id="brandId" name="brandId" value="">
                        <input type="hidden" id="promotionId" name="promotionId" value="">
                        <input type="hidden" id="orderType" name="orderType" value="">
                        <input type="hidden" id="pageNumber" name="pageNumber" value="1">
                        <input type="hidden" id="pageSize" name="pageSize" value="20">

                        <div id="result" class="result table clearfix">
                            <ul>
                                <c:forEach items="${pageInfo.list}" var="product">
                                    <li>
                                        <a href="${pageContext.request.contextPath}/product/list.action?pid=${product.pid}">
                                            <img src="${pageContext.request.contextPath}/image/${product.image}" width="170" height="170"  style="display: inline-block;">

                                            <span style='color:green'>
                                                    ${product.pname}
                                            </span>

                                            <span class="price">
												商城价： ￥	${product.shopPrice}/份
										</span>

                                        </a>
                                    </li>
                                </c:forEach>

                            </ul>
                        </div>

                        <%--pageNum <li> ${pageInfo.pageNum}</li>--%>
                        <ul class="pagination pagination pull-right">
                            <!-- 首页 -->
                            ${pageInfo.pageNum}

                            <c:choose>
                                <c:when test="${pageInfo.pageNum >1}">
                                    <li><a class="page" href="${pageContext.request.contextPath}/product/categorylist.action?cid=${cid}">首页</a></li>

                                </c:when>
                                <c:otherwise>
                                    <li><a class="page"  href="#" disabled="disabled" readonly="readonly" style="background-color:lightblue;">首页</a></li>
                                </c:otherwise>
                            </c:choose>

                            <!-- 上一页  -->

                            <c:choose>
                                <c:when test="${pageInfo.pageNum-1 >=1}">
                                    <li><a  class="page"  href="${pageContext.request.contextPath}/product/categorylist.action?starPage=${pageInfo.pageNum - 1}&cid=${cid}">上一页</a></li>
                                </c:when>
                                <c:otherwise>
                                    <li><a class="page"  href="#" disabled="disabled" style="background-color:lightblue;">上一页</a></li>
                                </c:otherwise>
                            </c:choose>

                            <!-- 下一页 -->
                            <c:choose>
                                <c:when test="${pageInfo.pageNum+1 <=pageInfo.pages}">
                                    <li><a class="page" href="${pageContext.request.contextPath}/product/categorylist.action?starPage=${pageInfo.pageNum + 1}&cid=${cid}">下一页</a></li>

                                </c:when>
                                <c:otherwise>
                                    <li><a class="page" href="#" disabled="disabled" readonly="readonly" style="background-color:lightblue;">下一页</a></li>
                                </c:otherwise>
                            </c:choose>

                            <!-- 尾页 -->
                            <c:choose>
                                <c:when test="${pageInfo.pageNum !=pageInfo.pages}">
                                    <li><a class="page" href="${pageContext.request.contextPath}/product/categorylist.action?starPage=${pageInfo.pages}&cid=${cid}">尾页</a></li>

                                </c:when>
                                <c:otherwise>
                                    <li><a class="page" href="#" disabled="disabled" readonly="readonly" style="background-color:lightblue;">尾页</a></li>
                                </c:otherwise>
                            </c:choose>

                        </ul>


                    </form>
                </section>
            </article>
        </section>

    </article>



</div>
<%@include file="../common/footer.jsp"%>
<script type="text/javascript">

</script>
</body>
</html>
