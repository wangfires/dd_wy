package com.baizhi.util;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 * @Description
 *      username  为发送用户的登录账号
 *      password  为发送用户的登录密码
 */
public class SendEmailUtil {

	public static String username = "baizhitest@sina.com";
	private static String password = "baizhitest";
	public static void sendMessage(String email,String message){
		
		//构建会话对象   包括会话类型   和 会话账号密码
		Properties props = System.getProperties();
		//设置主机类型
		props.setProperty("mail.smtp.host", "smtp.sina.com");
		
		
		Session session = Session.getDefaultInstance(props, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(username, password);
			}
		}); 
		session.setDebug(true);
		
		//构建 会话内容
		MimeMessage mimeMessage = new MimeMessage(session);
		
		try {
			//设置发送地址
			InternetAddress fromAddress = new InternetAddress(username);
			mimeMessage.setFrom(fromAddress);

			//设置接收人
			InternetAddress reciAddress = new InternetAddress(email);
			mimeMessage.setRecipient(RecipientType.TO, reciAddress);
			
			mimeMessage.setSubject("当当网验证码！");
			mimeMessage.setContent(message, "text/plain;charset=UTF-8");
			
			//构建连接	
			Transport transport = session.getTransport("smtp");
			transport.connect("smtp.sina.com",username, password);
			transport.sendMessage(mimeMessage,mimeMessage.getAllRecipients());
			transport.close();
			System.out.println("send Message SuccessFul!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("send Message fail!");
			e.printStackTrace();
		} 
		
	}
	
//	@Test
//	public void testSendMessage(){
//		sendMessage("798766028@qq.com", "这就是一个简单的测试！");
//		
//	}
}
