package com.cn.mindy.shop.pojo;


import java.io.Serializable;
import java.util.*;

public class Orders implements Serializable {

    private Integer oid;

    private String orderno; //订单编号

    private Double total;  //订单金额总结

    private Date ordertime;   //创建订单时间

    private Integer state;  // 1:未付款   2:订单已经付款   3:已经发货   4:订单结束

    private String name;    //订单名称


    private String phone;  //收货电话

    private String addr;  //收货人地址
    private Integer uid;  //用户的外键


    private User user;       // 用户的外键:对象

    private Set<Orderitem> orderItems = new HashSet<Orderitem>(); // 配置订单项的集合


//    private List<Orderitem> items = new LinkedList<Orderitem>(); // 配置订单项的集合
    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno == null ? null : orderno.trim();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Orderitem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<Orderitem> orderItems) {
        this.orderItems = orderItems;
    }

//    public List<Orderitem> getItems() {
//        return items;
//    }
//
//    public void setItems(List<Orderitem> items) {
//        this.items = items;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return Objects.equals(oid, orders.oid) &&
                Objects.equals(orderno, orders.orderno) &&
                Objects.equals(total, orders.total) &&
                Objects.equals(ordertime, orders.ordertime) &&
                Objects.equals(state, orders.state) &&
                Objects.equals(name, orders.name) &&
                Objects.equals(phone, orders.phone) &&
                Objects.equals(addr, orders.addr) &&
                Objects.equals(uid, orders.uid) &&
                Objects.equals(user, orders.user) &&
                Objects.equals(orderItems, orders.orderItems);
    }

    @Override
    public int hashCode() {

        return Objects.hash(oid, orderno, total, ordertime, state, name, phone, addr, uid, user, orderItems);
    }


}