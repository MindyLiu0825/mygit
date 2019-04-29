package com.cn.mindy.shop.utils;

import java.util.UUID;

/**
 * 生成激活码
 * @author Mindy
 *
 */
public class UUIDUtils {
	
	public static String getUUID(){
		
		
		
		return UUID.randomUUID().toString().replace("-", "");
	}
	
	public static void main(String[] args) {
		
		System.out.println( UUID.randomUUID().toString().replace("-", ""));
	}
	
}
