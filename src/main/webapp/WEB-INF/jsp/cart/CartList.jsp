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
	<div class="container header">

		<%@include file="../common/head.jsp"%>
	</div>

	<div class="container cart">
		<div class="span24">
			<div class="step step1"></div>
			<table>
				<tbody>
					<tr>
						<th>图片</th>
						<th>商品</th>
						<th>价格</th>
						<th>数量</th>
						<th>小计</th>
						<th>操作</th>
					</tr>
					<c:forEach items="${cart.cartItems}" var="cartItem">

						<tr>
							<td width="60"><input type="hidden" name="id" value="22">
								<img
								src="${pageContext.request.contextPath}/image/${cartItem.value.product.image}">
							</td>
							<td><a target="_blank"> ${cartItem.value.product.pname}</a>
							</td>
							<td>￥${cartItem.value.product.shopPrice}</td>
							<td class="quantity" width="60">${cartItem.value.num}</td>
							<td width="140"><span class="subtotal">￥${cartItem.value.subTotal}</span>
							</td>
							<td><a href="cart?type=2&pid=${cartItem.value.product.pid}"
								class="delete">删除</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<dl id="giftItems" class="hidden" style="display: none;">
			</dl>
			<div class="total">
				<em id="promotion"></em> <em> 登录后确认是否享有优惠 </em> 赠送积分: <em
					id="effectivePoint">596</em> 商品金额: <strong id="effectivePrice">￥${cart.total}元</strong>
			</div>
			<div class="bottom">
				<a href="cart?type=3" id="clear" class="clear">清空购物车</a> 
				<a href="${pageContext.request.contextPath}/order/orderInit.action" id="subOrder" class="submit">提交订单</a>
			</div>
		</div>
	</div>

	<%@include file="../common/footer.jsp"%>
</body>
</html>