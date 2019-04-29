package com.cn.mindy.shop.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Category implements Serializable {

    private Integer cid;

    private String cname;

    private Set<Categorysecond> categorysecondSet = new HashSet<>();

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    public Set<Categorysecond> getCategorysecondSet() {
        return categorysecondSet;
    }

    public void setCategorysecondSet(Set<Categorysecond> categorysecondSet) {
        this.categorysecondSet = categorysecondSet;
    }
}