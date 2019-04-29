package com.cn.mindy.shop.pojo.vo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 购物车实体类
 * @author Mindy
 *
 */
@Repository("cart")
@Scope("prototype")
public class Cart implements Serializable{

	
	private static final long serialVersionUID = -4150849641626180620L;
	
//	//线程安全的单例
//	private  static final Cart CART = new Cart();
//	
//	
//	//私有构造函数
//	private Cart(){
//		
//		
//	}
//	
//	//获取单例对象
//	public static  Cart getInstance(){
//		
//		return CART;
//		
//	}
	
	
	//购物项集合
	private Map<Long,CartItem>  cartItems = new LinkedHashMap<Long,CartItem>();

	private Float total= 0.0f;  //总计
	
	//private Collection<CartItem> list_CartItem = new LinkedList<CartItem>();

	public Map<Long, CartItem> getCartItems() {
		return cartItems;
	}
	public void setCartItems(Map<Long, CartItem> cartItems) {
		this.cartItems = cartItems;
	}
	public Float getTotal() {
		return total;
	}
	public void setTotal(Float total) {
		this.total = total;
	}

	
//	public Collection<CartItem> getList_CartItem() {
//		
//		//将map集合转换成list集合
//		list_CartItem = cartItems.values();
//		
//		return list_CartItem;
//	
//	}
//	
//
//	//将map转换成list
//	public void setList_CartItem() {
//		
//		//将map集合转换成list集合
//		Collection collection_CartItem = cartItems.values();
//		
//		this.list_CartItem = collection_CartItem;
//		
//		
//	}

	
	/**
	 * 添加购物车
	 */
	
	public void addProductToCart(CartItem  cartItem) {
		
		/**
		 * 遍历集合---判断是否存在
		 * 如果已经存在该购物项:  合并数量和小计
		 * 如果不存在则向集合(Map)中添加一个购物项
		 */
		Map<Long,CartItem> cartItrems = this.getCartItems();
		
		//遍历集合---判断是否存在
		Long pid = cartItem.getProduct().getPid();
		
		if(cartItrems.containsKey(pid)){
			
			//如果已经存在该购物项:  合并数量和小计
			int num = cartItem.getNum();//数量
			Float subTotal = cartItem.getSubTotal();//小计
			
			CartItem  old_CartItem = cartItrems.get(pid);
			
			//合并
			old_CartItem.setNum(old_CartItem.getNum()+num);
			old_CartItem.setSubTotal(old_CartItem.getSubTotal()+subTotal);
			
			//cartItrems.put(pid,old_CartItem);

		}else{

			//如果不存在则向集合(Map)中添加一个购物项
			cartItem.setNum(1);
			cartItrems.put(pid, cartItem);
		}
		
		//修改总计
		this.setTotal(this.getTotal()+cartItem.getSubTotal());
		
		//return cart;
	}

	
	/**
	 * 删除指定购物项
	 */
	public void delCartItemByPid(Integer pid){
		
		CartItem reove_CartItem = cartItems.remove(pid);
		
		//重修改总计
		this.setTotal(this.getTotal()-reove_CartItem.getSubTotal());
		
	}

	
	/**
	 * 清空整个购物车
	 */
	
	public void clearCart()  {
		
		//Cart cart = Cart.getInstance();
		
		this.setTotal(0f);
		
		this.getCartItems().clear();
		
	}


	@Override
	public String toString() {
		return "Cart [cartItems=" + cartItems + ", total=" + total + "]";
	}
	
	
	
	
	
	
	

}
