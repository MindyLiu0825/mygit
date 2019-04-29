package com.cn.mindy.shop.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtils {

	/**
	 * @param receiver
	 *            收件人
	 * @param code
	 *            激活码
	 */
	public static void sendMail(String receiver, String code) {

		try {
			// 1 获取Mail jar包的 Session连接对象

			/**
			 * props: authenticator:
			 */
			Properties props = new Properties();
			props.setProperty("mail.host", "localhost");// 发送邮件的主键

			Session session = Session.getInstance(props, new Authenticator() {

				@Override // alt+shift+s 选择override
				protected javax.mail.PasswordAuthentication getPasswordAuthentication() {

					return new javax.mail.PasswordAuthentication("service@shop.com", "111111");
				}
			});

			// 2 创建Message邮件对象
			Message message = new MimeMessage(session);
			// 设置发件人
			message.setFrom(new InternetAddress("service@shop.com"));

			// 设置收件人
			// CC 抄送 BC 暗送
			message.setRecipient(RecipientType.TO, new InternetAddress(receiver));

			// 设置标题
			message.setSubject("from 《网上商城》--注册激活邮件");

			// 设置邮件正文
			// 正文内容和格式(超链接和村文本) 不要写locahost 学生点击就给自己发送了
			message.setContent(
					"<h1>网上商城,点击下面的连接来完成激活操作</h1><br/> <h3>"
					+ "<a href='http://localhost:9100/ShopTest/user/activeCode.action?code="+ code + "'>点击激活</a></h3>",
					"text/html;charset=UTF-8");

			// 3 发送对象 transport
			Transport.send(message);

		} catch (MessagingException e) {

			e.printStackTrace();
		}
	}

	// main 方法测试
	public static void main(String[] args) {
		
		MailUtils.sendMail("mindy@shop.com", "123456");
	}

}
