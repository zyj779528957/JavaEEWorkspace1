package com.service.impl;

import java.io.StringWriter;

import com.sun.mail.imap.protocol.*;
import com.sun.mail.imap.protocol.BASE64MailboxEncoder;


/**
 * cookie工具类
 * cookie中文字符转换成 英文与数字
 *
 */
public class AppUtil {

	/**
	 * 加密中文(即将中文转换为英文字符)
	 * @param s2
	 * @return
	 */
	public static String encode(String s2){
		String ss = null;
		StringWriter sw = new StringWriter();
		BASE64MailboxEncoder be = new BASE64MailboxEncoder(sw);

		ss = be.encode(s2);

		return ss;
	}


	/**
	 * 解密中文(即将转换回中文)
	 * @param s2
	 * @return
	 */
	public static String decode(String s2){	
		String ss = "";
		BASE64MailboxDecoder bd = new BASE64MailboxDecoder();
		ss = bd.decode(s2);
		
		return ss;
		
	}
}
