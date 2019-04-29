package com.cn.mindy.shop.pojo;

import com.cn.mindy.shop.validation.ValidGroup1;
import com.cn.mindy.shop.validation.ValidGroup2;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {
    private Integer uid;
//    @Size(min = 6,max = 18,message="{用户名必须是6-18位之间的数字、字母、下划线和$}", groups={ValidGroup1.class})
    @Pattern(regexp = "^[a-zA-Z_]\\w{6,18}$",message="{用户名必须是6-18位之间的数字、字母或下划线}", groups={ValidGroup1.class})
    private String username;

//    @Size(min = 6,max = 18, message="{密码必须是6-18位之间的数字、字母、下划线和$}", groups={ValidGroup1.class})
    @Pattern(regexp = "^[a-zA-Z0-9_$]{6,18}$",message = "{密码必须是6-18位之间的数字、字母或下划线}",groups={ValidGroup1.class})
    private String password;

    private String name;


    @NotEmpty(message="邮箱不能为空", groups={ValidGroup2.class})
    @Email(message="邮箱格式不正确", groups={ValidGroup2.class})
    private String email;

//    @Pattern(regexp = "^1(3[0-9]|5[189]|8[6789])[0-9]{8}$",message = "手机格式有误", groups={ValidGroup2.class})
    private String phone;

    @Size(max = 200,message="{地址最多200个字符}", groups={ValidGroup2.class})
    private String addr;

    private Integer state; // 0 未激活  1 已激活

    private String code;   //激活码

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }
}