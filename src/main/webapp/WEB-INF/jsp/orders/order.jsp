<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>网上商城-购物车页面</title>
	<%@include file="../common/common.jsp"%>
	<link href="${pageContext.request.contextPath}/css/cart.css"	rel="stylesheet" type="text/css">

</head>
<body>

<%@ include file="../common/head.jsp"%>

	<form id="orderForm"
		action="${pageContext.request.contextPath }/order/payOrder.action" 	method="post">
		<div class="container cart">

			<div class="span24">

				<div class="step step1" style="width: 800px">
					<ul  style="width: 800px">

						<li class="current"></li>
						<li>生成订单成功</li>
						<li>订单号:${orders.orderno}</li>
					</ul>
				</div>

				<table>
					<tbody>
						<tr>
							<th>图片</th>
							<th>商品</th>
							<th>价格</th>
							<th>数量</th>
							<th>小计</th>
						</tr>

						<c:forEach items="${orders.orderItems}" var="orderItem">
							${orderItem.product.shopPrice}
							<tr>
								<td width="60">
									<img src="${pageContext.request.contextPath }/image/${orderItem.product.image}" />
								</td>
								<td><a target="_blank">${orderItem.product.pname}</a></td>
								<td>${orderItem.product.shopPrice}</td>
								<td class="quantity" width="60">${orderItem.count}</td>
								<td width="140"><span class="subtotal">￥${orderItem.subtotal}</span>
								</td>
							</tr>

						</c:forEach>
					</tbody>
				</table>
				<dl id="giftItems" class="hidden" style="display: none;">
				</dl>
				<div class="total">
					<em id="promotion"></em> 商品金额: <strong id="effectivePrice">￥${orders.total}元</strong>
				</div>

                <input type="hidden" name="uid" value="${orders.uid}" />
                <input type="hidden" name="total" value="${orders.total}" />
                <input type="hidden" name="orderno" value="${orders.orderno}" />

				
				<div class="span24">
					<p>
						收货地址：<input name="addr" type="text" value="${orders.addr}"
							style="width: 350px" /> <br /> 收货人&nbsp;&nbsp;&nbsp;：<input
							name="name" type="text" value=" ${orders.name}"
							style="width: 150px" /> <br /> 联系方式：<input name="phone"
							type="text" value="${orders.phone}" style="width: 150px" />

					</p>
					<hr />
					<p>
						选择银行：<br /> <input type="radio" name="pd_FrpId"
							value="ICBC-NET-B2C" checked="checked" />工商银行 <img
							src="${pageContext.request.contextPath}/bank_img/icbc.bmp"
							align="middle" />&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio"
							name="pd_FrpId" value="BOC-NET-B2C" />中国银行 <img
							src="${pageContext.request.contextPath}/bank_img/bc.bmp"
							align="middle" />&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio"
							name="pd_FrpId" value="ABC-NET-B2C" />农业银行 <img
							src="${pageContext.request.contextPath}/bank_img/abc.bmp"
							align="middle" /> <br /> <input type="radio" name="pd_FrpId"
							value="BOCO-NET-B2C" />交通银行 <img
							src="${pageContext.request.contextPath}/bank_img/bcc.bmp"
							align="middle" />&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio"
							name="pd_FrpId" value="PINGANBANK-NET" />平安银行 <img
							src="${pageContext.request.contextPath}/bank_img/pingan.bmp"
							align="middle" />&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio"
							name="pd_FrpId" value="CCB-NET-B2C" />建设银行 <img
							src="${pageContext.request.contextPath}/bank_img/ccb.bmp"
							align="middle" /> <br /> <input type="radio" name="pd_FrpId"
							value="CEB-NET-B2C" />光大银行 <img
							src="${pageContext.request.contextPath}/bank_img/guangda.bmp"
							align="middle" />&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio"
							name="pd_FrpId" value="CMBCHINA-NET-B2C" />招商银行 <img
							src="${pageContext.request.contextPath}/bank_img/cmb.bmp"
							align="middle" />
					</p>
					<hr />

					<p style="text-align: right">
						<a
							href="javascript:document.getElementById('orderForm').submit();">
							<img src="${pageContext.request.contextPath}/images/finalbutton.gif"
							width="204" height="51" border="0" />
						</a>
					</p>
				</div>
			  </div>
		  </div>
	</form>

     <%@ include file="../common/footer.jsp"%>
</body>
</html>