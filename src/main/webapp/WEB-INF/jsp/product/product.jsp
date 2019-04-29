<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="../common/common.jsp"%>
    <link href="${pageContext.request.contextPath}/css/product.css" rel="stylesheet" type="text/css">

</head>
<body>

<div class="container header">
    <%@include file="../common/head.jsp"%>
</div>
<div class="container productContent">
    <section class="row">
        <article class="col-xs-3" style="margin-left: 15px;">
               <%@include file="../common/navigator.jsp"%>
        </article>
        <article class="col-xs-8">
            <section class="span18 last">

                <div class="productImage">
                    <a title="" style="outline-style: none; text-decoration: none;" id="zoom" href="http://image/r___________renleipic_01/bigPic1ea8f1c9-8b8e-4262-8ca9-690912434692.jpg" rel="gallery">
                        <section class="zoomPad">
                            <img style="opacity: 1;" title="" class="medium" src="${pageContext.request.contextPath}/image/${product.image}">
                            <article style="display: block; top: 0px; left: 162px;
                                width: 0px; height: 0px; position: absolute; border-width: 1px;" class="zoomPup">
                            </article>
                            <article style="position: absolute; z-index: 5001; left: 312px; top: 0px; display: block;"
                                 class="zoomWindow">
                                <div style="width: 368px;" class="zoomWrapper">
                                    <section style="width: 100%; position: absolute; display: none;" class="zoomWrapperTitle">
                                    </section>
                                    <section style="width: 0%; height: 0px;" class="zoomWrapperImage">
                                    <img src="%E5%B0%9A%E9%83%BD%E6%AF%94%E6%8B%89%E5%A5%B3%E8%A3%852013%E5%A4%8F%E8%A3%85%E6%96%B0%E6%AC%BE%E8%95%BE%E4%B8%9D%E8%BF%9E%E8%A1%A3%E8%A3%99%20%E9%9F%A9%E7%89%88%E4%BF%AE%E8%BA%AB%E9%9B%AA%E7%BA%BA%E6%89%93%E5%BA%95%E8%A3%99%E5%AD%90%20%E6%98%A5%E6%AC%BE%20-%20Powered%20By%20Mango%20Team_files/6d53c211-2325-41ed-8696-d8fbceb1c199-large.jpg"
                                         style="position: absolute; border: 0px none; display: block; left: -432px; top: 0px;">
                                    </section>
                                </div>
                            </article>
                            <div style="visibility: hidden; top: 129.5px; left: 106px; position: absolute;"
                                 class="zoomPreload">Loading zoom
                            </div>
                        </section>
                    </a>

                </div>

                <div class="name">${product.pname}</div>
                <div class="sn">
                    <div>编号：${product.pid}</div>
                </div>
                <div class="info">
                    <dl>
                        <dt>亿家价:</dt>
                        <dd>
                            <strong>￥：${product.shopPrice}元/份</strong>
                            参 考 价：
                            <del>￥${product.marketPrice}元/份</del>
                        </dd>
                    </dl>
                    <dl>
                        <dt>促销:</dt>
                        <dd>
                            <a target="_blank" title="限时抢购 (2014-07-30 ~ 2015-01-01)">限时抢购</a>
                        </dd>
                    </dl>

                </div>
                <div class="action">

                  <form id="form01" method="post">
                      购买数量: <input  name="num"  id="num"  min="1"  max="10"  type="number" value="1" style="padding: 0px; height: 25px"/>&nbsp;件
                      <div class="buy">
                          <input id="addCart" class="addCart" value="加入购物车" type="button">

                      </div>
                  </form>

                </div>
                <div id="bar" class="bar">
                    <ul>
                        <li id="introductionTab">
                            <a href="#introduction">商品介绍</a>
                        </li>

                    </ul>
                </div>

                <div id="introduction" name="introduction" class="introduction">
                    <div class="title">
                        <strong>商品介绍</strong>
                    </div>
                    <div>
                        <img src="${pageContext.request.contextPath}/image/${product.image}">
                    </div>
                </div>

            </section>
        </article>
    </section>


</div>
<%@include file="../common/footer.jsp"%>

<script type="text/javascript">

    function change(id) {

        if(id == 1){

            document.getElemen1tById("jiesao").style.display="block";
            document.getElementById("pinglun").style.display="none";
            document.getElementById("woyaopinglun").style.display="none";
        }
        if(id == 2){

            document.getElementById("jiesao").style.display="none";
            document.getElementById("pinglun").style.display="block";
            document.getElementById("woyaopinglun").style.display="none";
        }
        if(id == 3){

            document.getElementById("jiesao").style.display="none";
            document.getElementById("pinglun").style.display="none";
            document.getElementById("woyaopinglun").style.display="block";
        }
    }

    $(function(){
        alert(111);

        $("#addCart").click(function(){

            alert(222);
            //商品数量
            var quantity = $("#num").val();
            var pid = ${product.pid};
            alert(pid);
            //跳转  $("#myFormId").action="XXX";  这种写法是不起作用
            //"${pageContext.request.contextPath}/cart/cartInit/quantity/pid)"";
            $("#form01").attr("action","${pageContext.request.contextPath}/cart/cartInit.action?quantity="+quantity+"&pid="+pid);
            $("#form01").submit();

        });

    });

</script>
</body>
</html>
