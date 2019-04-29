package com.cn.mindy.shop.pojo.vo;

import com.cn.mindy.shop.pojo.Product;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * 购物记录实体类
 * @author Mindy
 *
 */
@Repository("cartItem")
@Scope("prototype")
public class CartItem implements Serializable{
	

	private static final long serialVersionUID = -5566635591795197026L;

	private Product product;//商品
	
	private int num;//数量
	
	private Float subTotal;//小计
	

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Float getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Float subTotal) {
		this.subTotal = subTotal;
	}
	

	@Override
	public String toString() {
		return "CartItem [product=" + product + ", num=" + num + ", subTotal="
				+ subTotal + "]";
	}

	
}
