<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <%@include file="../common/common.jsp"%>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
    <style type="text/css">
        body{
            background-image: url("messag.jpeg")s;
        }
    </style>
</head>
<body>


<div id="divcontent">
    <table width="850px" border="0" cellspacing="0">
        <tr>
            <td style="padding:30px; text-align:center"><table width="60%" border="0" cellspacing="0" style="margin-top:70px">
                <tr>
                    <td style="width:98px;"><img src="${pageContext.request.contextPath}/images/IconTexto_WebDev_009.jpg" width="128" height="128" /></td>
                    <td style="padding-top:30px"><font style="font-weight:bold; color:#FF0000">

                        ${message}<br/>
                        ${result.message}<br/>
                        <c:forEach items="${errors}" var="error">
                            ${error.defaultMessage}<br/>
                        </c:forEach>

                    </font>
                        <br />
                        <br />
                        <a href="${ pageContext.request.contextPath }/main/mainInit.action">首页</a>
                        <a href="${ pageContext.request.contextPath }/user/registInit.action">注册</a>
                        <a href="${ pageContext.request.contextPath }/user/loginInit.action">登录</a>
                    </td>
                </tr>
            </table>
                <h1>&nbsp;</h1></td>
        </tr>
    </table>
</div>
</body>
</html>
