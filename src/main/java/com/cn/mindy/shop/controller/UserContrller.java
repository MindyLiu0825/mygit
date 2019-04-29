package com.cn.mindy.shop.controller;

import com.cn.mindy.shop.pojo.User;
import com.cn.mindy.shop.service.UserService;
import com.cn.mindy.shop.utils.*;
import com.cn.mindy.shop.validation.ValidGroup1;
import com.cn.mindy.shop.validation.ValidGroup2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserContrller {

    @Autowired
    private UserService userService;


    @RequestMapping("/loginInit")
    public  String loginInit(){
        return "user/login";
    }

    /**
     * 登录操作
     * @param user
     * @param bindingResults
     */
    @RequestMapping("/login")
    public  String login(@Validated(value={ValidGroup1.class}) User user,BindingResult bindingResults,String captcha,Model model,HttpServletRequest request){

        if(bindingResults.hasErrors()){
            //1 捕获错误信息
            List<ObjectError> errors = bindingResults.getAllErrors();
            ObjectError fe;
            String field;
            String errorMessage;

            for (int i = 0; i < errors.size(); i++) {
                fe= errors.get(i);
                field = fe.getObjectName();//得到那个字段验证出错
                errorMessage=fe.getDefaultMessage();//得到错误消息
                System.out.println("错误字段消息："+field +" : "+errorMessage);
            }
            model.addAttribute("errors",errors);

            //数据错误则返回到登录页面
            return "common/message";

        }else{

            //登录操作
            ReturnObj returnObj = new ReturnObj();
            try {
                //查询用户名和密码是否存在
                //1根据用户名查询用户信息
                User _user = userService.queryUserByUsername(user.getUsername());

                //2 给输入的密码进行加密
                if(null == _user &&  null != _user.getPassword() ){
                    //未被激活
                    returnObj.setSuccess(true);
                    returnObj.setMessage(Common.LOGIN_FAILED);
                }else{
                    String input_pwd =  user.getPassword();
                    boolean result = MD5Util.judgeMD5(input_pwd,_user.getPassword());

                    if(result){
                        //3 判断该查号是否被激活
                        if(  _user.getState() ==Common.STATE_YES){
                            //已被激活--登录成功
                            returnObj.setSuccess(true);
                            returnObj.setMessage(Common.LOGIN_SUCCESS);
                            //将登录信息添加到session中
                            request.getSession().setAttribute("user",_user);
                        }else{
                            //未被激活
                            returnObj.setSuccess(true);
                            returnObj.setMessage(Common.LOGIN_FAILED);
                        }

                    }else{
                        returnObj.setSuccess(true);
                        returnObj.setMessage(Common.LOGIN_FAILED);
                    }
                }

            } catch (Exception e) {
                returnObj.setSuccess(true);
                returnObj.setMessage(Common.SYSTEM_ERROR);
                e.printStackTrace();
            }
            //登录成功或失败都跳转到message.jsp
            model.addAttribute("result",returnObj);
            return "common/message";
        }
    }

    /**
     * 注册页面初始化
     * @param user
     * @return
     */
    @RequestMapping("/registInit")
    public  String registInit(User user){

        return "user/regist";
    }


    /**
     * 注册操作
     * @param user
     * @param session
     * @return
     */
      @RequestMapping("/regist")
      public  String regist(@Validated(value={ValidGroup1.class, ValidGroup2.class}) User user, BindingResult bindingResults,String captcha, HttpSession session,Model model) {

          //1 数据校验
          if (bindingResults.hasErrors()) {
                  //1 捕获错误信息
                  List<ObjectError> errors = bindingResults.getAllErrors();
                  ObjectError fe;
                  String field;
                  String errorMessage;
                  for (int i = 0; i < errors.size(); i++) {
                      fe = errors.get(i);
                      field = fe.getObjectName();//得到那个字段验证出错
                      errorMessage = fe.getDefaultMessage();//得到错误消息
                      System.out.println("错误字段消息：" + field + " : " + errorMessage);
                  }
                   model.addAttribute("errors",errors);
                  //数据错误则返回到登录页面
                  return "common/message";

          } else {

              //2 验证码校验
              //从session中获取已经存入的验证码
              String sessionImg = (String) session.getAttribute("checkcode");

              //注册页面输入的验证码与session中的验证码进行比较
              if(!captcha.equalsIgnoreCase(sessionImg)){
                 model.addAttribute("message",Common.CHECKCODE_ERROR);
                  //数据错误则返回到登录页面
                  return "common/message";
              }

              //3 密码MD5加密
              String _password = user.getPassword();
              try {
                  String new_password = MD5Util.addMD5(_password);
                  user.setPassword(new_password);

              } catch (NoSuchAlgorithmException e) {

                  e.printStackTrace();

              } catch (UnsupportedEncodingException e) {

                  e.printStackTrace();
              }

              //3 生成激活码和激活状态
              user.setCode(UUIDUtils.getUUID());
              user.setState(Common.STATE_NO);

              //4 保存注册信息
              try {
                 if(userService.add(user) > 0){
                     model.addAttribute("message",Common.REGIST_SUCCESS);
                     //5 向邮箱发送激活邮件
                     MailUtils.sendMail(user.getEmail(), user.getCode());
                 }else{
                     model.addAttribute("message",Common.REGIST_FAILED);
                 }
              } catch (Exception e) {
                  e.printStackTrace();
              }

              return "common/message";

          }
      }

    /**
     * 获取验证码
     * @param request
     * @param response
     */
      @RequestMapping("/getImg")
      public  void getImg(HttpServletRequest request, HttpServletResponse response){
          try {
              CheckImgUtils.checkImg(request,response);

          } catch (IOException e) {
              e.printStackTrace();
          }
      }

    /**
     * 查询用户名是否存在
     * @param userName
     * @return
     */
      @RequestMapping("/queryUsername")
      @ResponseBody
          public ReturnObj queryUsername(String userName){

          ReturnObj returnObj = new ReturnObj();
          try {

              if(userService.queryByUsername(userName)){
                  returnObj.setSuccess(true);
                  returnObj.setMessage(Common.USER_NAME_IS_OK);
              }else{
                  returnObj.setSuccess(false);
                  returnObj.setMessage(Common.USER_NAME_IS_NO);
              }
          } catch (Exception e) {
              e.printStackTrace();
          }

          return  returnObj;
      }


    /**
     * 查询用户名是否存在
     * @param userName
     * @return
     */
    @RequestMapping("/queryLoginUsername")
    @ResponseBody
    public ReturnObj queryLoginUsername(String userName){

        ReturnObj returnObj = new ReturnObj();
        try {

            if(userService.queryByUsername(userName)){
                returnObj.setSuccess(false);
                returnObj.setMessage(Common.USER_NAME_IS_NO);

            }else{
                returnObj.setSuccess(true);
                returnObj.setMessage(Common.USER_NAME_IS_OK);
            }
        } catch (Exception e) {
            returnObj.setSuccess(false);
            returnObj.setMessage(Common.USER_NAME_IS_NO);
            e.printStackTrace();
        }

        return  returnObj;

    }

    /**
     * 注册激活操作
     */
    @RequestMapping(value="/activeCode")
    public String activeCode(String code, HttpServletRequest request){

        String path = null;
        String message = null;
        System.out.println(".......activeCode....code = " + code);
        User user = null;
        try {
            //判断code是否存在
            user = userService.queryByCode(code);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(null == user){
            //不存在该注册用户
            message = "注册激活失败!";
        }else{

            //存在该注册用户.进行激活操作 state = 1
            user.setState(Common.STATE_YES);

            //更新用户信息
            try {
                if(userService.updateByUid(user.getUid())){
                    //向session添加user信息
                    request.getSession().setAttribute("user",user);
                    message = "注册激活成功!";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        request.setAttribute(Common.MESSAGE, message);

        return "common/message";

    }


    /**
     * 退出操作
     * @param request
     * @return
     */
    @RequestMapping("/logout")
    public String  logout(HttpServletRequest request) {

          //让所有的session失效
          request.getSession().setAttribute("user",null);

          return "redirect:/main/mainInit.action";

    }

    /**
     * 注解形式的属性编辑器
     * 将之前的initBinder方法copy过来即可
     */
    @InitBinder
    protected void initBinder(HttpServletRequest request,
                              ServletRequestDataBinder binder) throws Exception {
        binder.registerCustomEditor(Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }

    @RequestMapping("/hello")
    public void test(){

        System.out.println("hello....");
    }


}
