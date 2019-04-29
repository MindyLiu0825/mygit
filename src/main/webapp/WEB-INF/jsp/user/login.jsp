<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <%@include file="../common/common.jsp"%>

    <style type="text/css">
        red{
            color:red;
        }
        green{
            color:green;
        }
    </style>
</head>
<body>
<div class="container header">
    <%@include file="../common/head.jsp"%>
    <link href="${pageContext.request.contextPath}/css/login.css"  	rel="stylesheet" type="text/css" />
</div>
<div class="container login">
    <div class="row">
        <section class="col-xs-4">
            <div class="ad">
                <img src="${pageContext.request.contextPath}/image/login.jpg" width="500" height="330" alt="会员登录" title="会员登录">
            </div>
        </section>
        <section class="col-xs-1"></section>
        <section class="last col-xs-7">
            <div class="wrap">
                <div class="main">
                    <div class="title">
                        <strong>会员登录</strong>USER LOGIN
                    </div>
                    <div>
                        <c:forEach items="${errors}" var="error">
                            &nbsp;&nbsp; &nbsp;&nbsp;<span style="color:red;">${error.defaultMessage}</span> <br/>
                        </c:forEach>
                    </div>
                    <form id="loginForm"  method="post" action="${pageContext.request.contextPath}/user/login.action">

                        <table>
                            <tbody>
                            <tr>
                                <th>
                                    <label><span class="requiredField">*</span>用户名:</label>
                                </th>
                                <td>
                                    <input type="text" id="username" name="username" class="text"/>

                                </td>
                            </tr>
                            <tr>
                                <th>
                                    <span class="requiredField">*</span>密&nbsp;&nbsp;码:
                                </th>
                                <td>
                                    <input type="password" id="password" name="password" class="text">
                                </td>
                            </tr>

                            <tr>
                                <th>
                                    <span class="requiredField">*</span>验证码:
                                </th>
                                <td>
                                    <span class="fieldSet">
                                        <input type="text" id="captcha" name="captcha" class="text captcha" maxlength="4"  required="required">
                                          <img  id="captchaImage"
                                                class="captchaImage"
                                                src="${pageContext.request.contextPath}/user/getImg.action"
                                                title="点击更换验证码"  onclick="this.src='${pageContext.request.contextPath}/user/getImg.action?num='+Math.random();"/>
                                    </span>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <input type="submit" class="btn btn-danger" value="登 录">
                                </td>
                            </tr>

                            </tbody>
                        </table>
                        <div class="col-xs-7 register">
                            <dl>
                                <dt>还没有注册账号？</dt>
                                <dd>
                                    立即注册即可体验在线购物！
                                    <a href="${pageContext.request.contextPath}/user/registInit.action">立即注册</a>
                                </dd>
                            </dl>
                        </div>

                    </form>
                </div>
            </div>
        </section>
    </div>


</div>
<div class="container footer">
    <%@include file="../common/footer.jsp"%>
</div>
 <script type="text/javascript">
     $(function () {
         alert(222);
         $("#username").blur(function () {
                // alert(1212);
                var _username = $(this).val();
                $.post(
                    '${pageContext.request.contextPath}/user/queryLoginUsername.action',
                    {'userName':_username},
                    function (data) {
                        alert(data.message);
                        // if(data.success){
                        //     $("#username_message").html("<span class='green' id='username_message'>"+data.message+"</span>");
                        // }else{
                        //     $("#username_message").html("<span class='red' id='username_message'>"+data.message+"</span>");
                        // }

                    });
         });


         alert(111);
         $("#loginForm").validate({
             rules:{
                 username:{
                     required:true,
                     checkName:true
                 },
                 password:{
                     required:true,
                     checkName:true
                 },
                 captcha:{
                     required:true,
                     checkCaptcha:true
                 }
             },
             messages: {
                 username: {
                     required:"&nbsp;&nbsp;用户名必填"
                 },
                 password: {
                     required:"&nbsp;&nbsp;密码必填"
                 },
                 captcha: {
                     required:"&nbsp;&nbsp;验证码必填"
                 }
             }
         });//end of validate

     });// end of function

     //自定义校验规则
     $.validator.addMethod("checkName",function(value,element,params){
         var checkName = /^[a-zA-Z0-9_$]{6,18}$/g;
         return this.optional(element)||(checkName.test(value));
     },"&nbsp;&nbsp;只允许6-18位数字、字母、下画线或$");

     $.validator.addMethod("checkPwd",function(value,element,params){
         var checkPwd = /^[a-zA-Z0-9_$]{6,18}$/g;
         return this.optional(element)||(checkPwd.test(value));
     },"&nbsp;&nbsp;只允许6-18位数字、字母、下画线或$");

     $.validator.addMethod("checkCaptcha",function(value,element,params){
         var length = value.length;
         return this.optional(element)||(length == 4);
     },"&nbsp;&nbsp;验证码必须4位");

 </script>
</body>
</html>
