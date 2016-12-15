package com.shineoxygen.designpattern.structural;

/**
 * 
 * @author 王辉阳
 * @date 2016年12月15日 下午10:23:06
 * @Description 京东支付接口
 */
public class JingdongPayHelper {
	public static void pay() {
		System.out.println("京东生成一个支付订单");
	}

	public static String searchPay() {
		System.out.println("京东订单详情");
		return "京东订单详情";
	}
}
