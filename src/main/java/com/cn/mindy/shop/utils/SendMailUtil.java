package com.cn.mindy.shop.utils;

import com.cn.mindy.shop.pojo.User;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public final class SendMailUtil extends Thread {


	//发送邮件
	public static void send(String mailAdress) {
		try {
			Properties props = new Properties();
			props.setProperty("mail.host", "smtp.163.com");
			props.setProperty("mail.transport.protocol", "smtp");
			props.setProperty("mail.smtp.auth", "true");//请求认证，与JavaMail的实现有关
			Session session = Session.getInstance(props);
			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress("itheimacloud@163.com"));//  noreply webmaster等一些官方含义的邮件
			msg.setRecipients(Message.RecipientType.TO, mailAdress);
			msg.setSubject("来自XX书店的激活邮件");

			//msg.setContent("感谢您注册成为我们的会员<br/>请猛点下方激活您的账户<br/><a href='http://localhost:8080/day23_00_bookstore/servlet/ControllerServlet?op=active&username="+c.getUsername()+"&code="+c.getCode()+"'>猛点</a>", "text/html;charset=UTF-8");
			msg.saveChanges();

			Transport ts = session.getTransport();
			ts.connect("itheimacloud", "iamsorry");
			ts.sendMessage(msg, msg.getAllRecipients());
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("发送邮件失败");
		}

	}

}
