package com.cn.mindy.shop.controller;

import com.cn.mindy.shop.pojo.Orderitem;
import com.cn.mindy.shop.pojo.Orders;
import com.cn.mindy.shop.pojo.User;
import com.cn.mindy.shop.pojo.vo.Cart;
import com.cn.mindy.shop.pojo.vo.CartItem;
import com.cn.mindy.shop.service.OrderService;
import com.cn.mindy.shop.service.UserService;
import com.cn.mindy.shop.utils.Common;
import com.cn.mindy.shop.utils.PaymentUtil;
import com.cn.mindy.shop.utils.UUIDUtils;
import common.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


@Controller
@RequestMapping("/order")
@Scope("prototype")
public class OrderController {

    private Logger log = Logger.getLogger(OrderController.class);

    public Orders orders;

    @Autowired
    public UserService userService;

    @Autowired
    public OrderService orderService;

    /**
     * 提交订单操作
     * @param request
     * @return
     */
    @RequestMapping("/orderInit")
    public String orderInit(HttpServletRequest request,Model model){

        // 1 判断是否已登录
        User user = (User) request.getSession().getAttribute("user");

        if(null == user){
            request.setAttribute(Common.MESSAGE, Common.NO_LOGIN);
            return "common/message";
        }

        /****************封装订单的数据*********/
        orders = new Orders();

        //设置下单时间
        orders.setOrdertime(new Date());

         //设置订单状态
        orders.setState(Common.ORDER_STATE_NOPAY); // 1 未付款   2 已经付款.  3.已经发货   4 订单结束.

        // 有些数据需要从购物车中获取:

        // 获得购物车:
        Cart cart = (Cart) request.getSession().getAttribute("cart");

        if(cart == null){
            request.setAttribute(Common.MESSAGE, Common.ORDER_NO_SHOPPING);
            return "common/message";
        }

        log.debug("..................cart................."+cart.toString()+"....+..."+cart.getCartItems().toString());
        orders.setTotal(Double.valueOf(cart.getTotal()));


       // log.debug("......................username....................."+user.getUsername());
        User existUser = null;
        try {
              existUser = userService.queryUserByUsername(user.getUsername());

            if(existUser == null){

                request.setAttribute(Common.MESSAGE, Common.NO_LOGIN);

                return "common/message";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //设置订单用户
        orders.setUid(existUser.getUid());
        orders.setUser(existUser);
        orders.setName(existUser.getName());
        orders.setAddr(existUser.getAddr());
        orders.setPhone(existUser.getPhone());

        /********************封装订单项数据*************/
        // 订单项数据从 购物项的数据获得.
        Map<Long, CartItem> cartItems = cart.getCartItems();

        Set<Long> sets = cartItems.keySet();

        Iterator<Long> its = sets.iterator();

        while(its.hasNext()){

            Long key  =its.next();
            CartItem cartItem= cartItems.get(key);

            log.debug("............cartItem = "+cartItem.toString());
            if(null != cartItem){

                Orderitem orderItem = new Orderitem();
                orderItem.setCount(cartItem.getNum()==0?0:cartItem.getNum());
                orderItem.setSubtotal(Double.valueOf(cartItem.getSubTotal()));
                orderItem.setProduct(cartItem.getProduct());
                orderItem.setOrders(orders);
                orderItem.setPid(cartItem.getProduct().getPid());
                orders.getOrderItems().add(orderItem);
            }

        }
        // 清空购物车.
        cart.clearCart();

        //获取新生成的Order No
        orders.setOrderno(UUIDUtils.getUUID());

        log.debug("get a bew orderNo......." + orders.getOrderno());

        try {
            // 保存订单:
            Integer count = orderService.addOrders(orders);

        } catch (Exception e) {
            e.printStackTrace();
        }
        //设置响应数据
        model.addAttribute("orders",orders);
        return "orders/order";

    }



    /**
     * 确认订单
     */
    @RequestMapping("/payOrder")
//	    public String  payOrder(@Validated(value=(ValidationOrderGroup.class))Order order,String pd_FrpId){
    public String  payOrder(Orders orders,String pd_FrpId){
        log.debug("......payOrder()......order.getOrderNo() = "+orders.getOrderno()+"...pd_FrpId="+pd_FrpId);


//	    	private String pd_FrpId;

//	    	// 付款成功后的需要的参数:
//	    	private String r3_Amt;
//	    	private String r6_Order;

        //根据订单新输入的收货人信息修改Order
        Orders currOrder = new Orders();
        try {
            currOrder = orderService.findByOrderNo(orders.getOrderno());
        } catch (Exception e) {
            e.printStackTrace();
        }

        currOrder.setAddr(orders.getAddr());
        currOrder.setName(orders.getName());
        currOrder.setPhone(orders.getPhone());


        //修改订单操作
        try {
            orderService.update(currOrder);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 付款:
        // 定义付款的参数:
        String p0_Cmd = "Buy";
        String p1_MerId = "10001126856";
        String p2_Order = currOrder.getOid().toString();
        String p3_Amt = "0.01";
        String p4_Cur = "CNY";
        String p5_Pid = "";
        String p6_Pcat = "";
        String p7_Pdesc = "";
        String p8_Url = "http://localhost:8080/ShopTest/order/callBack.action";
        String p9_SAF = "";
        String pa_MP = "";
        String pr_NeedResponse = "1";
        String keyValue = "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl";
        String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt, p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP,pd_FrpId , pr_NeedResponse, keyValue);

        StringBuffer sb = new StringBuffer("https://www.yeepay.com/app-merchant-proxy/node?");
        sb.append("p0_Cmd=").append(p0_Cmd).append("&");
        sb.append("p1_MerId=").append(p1_MerId).append("&");
        sb.append("p2_Order=").append(p2_Order).append("&");
        sb.append("p3_Amt=").append(p3_Amt).append("&");
        sb.append("p4_Cur=").append(p4_Cur).append("&");
        sb.append("p5_Pid=").append(p5_Pid).append("&");
        sb.append("p6_Pcat=").append(p6_Pcat).append("&");
        sb.append("p7_Pdesc=").append(p7_Pdesc).append("&");
        sb.append("p8_Url=").append(p8_Url).append("&");
        sb.append("p9_SAF=").append(p9_SAF).append("&");
        sb.append("pa_MP=").append(pa_MP).append("&");
        sb.append("pd_FrpId=").append(pd_FrpId).append("&");
        sb.append("pr_NeedResponse=").append(pr_NeedResponse).append("&");
        sb.append("hmac=").append(hmac);

        log.debug("pay money.......begin................");

        return "redirect:"+sb.toString();

    }




    /**
     * 付款成功后的回调方法
     * http://localhost:8080/ShopTest/order/callBack.action?
     * p1_MerId=10001126856&
     * r0_Cmd=Buy&
     * r1_Code=1&
     * r2_TrxId=916211245359303I&
     * r3_Amt=0.01&
     * r4_Cur=RMB&
     * r5_Pid=&
     * r6_Order=9044&
     * r7_Uid=&
     * r8_MP=&
     * r9_BType=1&
     * ru_Trxtime=20180616093918&
     * ro_BankOrderId=5258995445180616&
     * rb_BankId=CCB-NET&
     * rp_PayDate=20180616093907&
     * rq_CardNo=&rq_SourceFee=0.0&
     * rq_TargetFee=0.0&
     * hmac=a9cf35d111c3f67b312fa6555c9f8eb8&
     * hmac_safe=d4c948b6ce9ab373bb65f8fe1a68a9a6
     */
    @RequestMapping("/callBack")
    public String callBack( HttpServletRequest request){


       Integer r6_Order = null;
       if(null  != request.getParameter("r6_Order")){
           r6_Order = Integer.valueOf(request.getParameter("r6_Order"));
       }
        String r3_Amt = null;
        if(null  != request.getParameter("r3_Amt")){
            r3_Amt = String.valueOf(request.getParameter("r3_Amt"));
        }
        log.debug("......callBack().......r6_Order = "+ r6_Order + "...r3_Amt=" + r3_Amt+"....");


        Integer  r1_Code = -1;
        if(null  != request.getParameter("r1_Code")){
            r1_Code = Integer.valueOf(request.getParameter("r1_Code"));
        }

        if(r1_Code !=1){

            //支付失败
            request.setAttribute(Common.MESSAGE,"订单付款失败!订单号:"+r6_Order+" 付款金额:"+r3_Amt);

            return "common/message";

        }

        Orders currOrder = null;
        try {
            currOrder = orderService.findByOid(r6_Order);
        } catch (Exception e) {
            e.printStackTrace();
        }

        currOrder.setState(Common.ORDER_STATE_PAYED);// 修改订单状态.
        try {

            orderService.update(currOrder);

        } catch (Exception e) {
            e.printStackTrace();
        }


        request.setAttribute(Common.MESSAGE,"订单付款成功!订单号:"+r6_Order+" 付款金额:"+r3_Amt);

        return "common/message";

    }



//
//		/**
//		 * 按用户id查询订单:
//		 */
//		public String findByUid(HttpServletRequest request){
//			// 获得用户对象:
//			String userName = request.getSession().getAttribute("userName");
//
//
//			List<Order> oList = orderService.findByUid(existUser);
//
//			// 压栈
//			ActionContext.getContext().getValueStack().set("oList", oList);
//			return "findByUidSuccess";
//		}

		/**
		 * 查询订单:
		 */
		@RequestMapping("/findByOid")
		public String findByOid(Integer oid){

            try {
                orders = orderService.findByOid(oid);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return "findByOidSuccess";
		}


        /**
         * 根据用户id查询其所有订单
         * @param uid
         * @return
         */
          @RequestMapping("/orderlist")
          public String orderlist(Long uid){


            return  null;

          }

}
