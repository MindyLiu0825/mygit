package com.cn.mindy.shop.pojo;

import java.io.Serializable;
import java.util.Objects;

public class Orderitem  implements Serializable{
    private Integer itemid;

    private Integer count;

    private Double subtotal;

    private Long pid;

    private Integer oid;

    private Product product;  // 商品外键:对象

    private Orders orders;   // 订单外键:对象



    public Integer getItemid() {
        return itemid;
    }

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orderitem orderitem = (Orderitem) o;
        return Objects.equals(itemid, orderitem.itemid) &&
                Objects.equals(count, orderitem.count) &&
                Objects.equals(subtotal, orderitem.subtotal) &&
                Objects.equals(pid, orderitem.pid) &&
                Objects.equals(oid, orderitem.oid) &&
                Objects.equals(product, orderitem.product) &&
                Objects.equals(orders, orderitem.orders);
    }

    @Override
    public int hashCode() {

        return Objects.hash(itemid, count, subtotal, pid, oid, product, orders);
    }


    @Override
    public String toString() {
        return "Orderitem{" +
                "itemid=" + itemid +
                ", count=" + count +
                ", subtotal=" + subtotal +
                ", pid=" + pid +
                ", oid=" + oid +
                '}';
    }
}