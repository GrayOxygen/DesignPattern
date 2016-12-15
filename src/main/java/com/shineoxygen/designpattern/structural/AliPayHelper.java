package com.shineoxygen.designpattern.structural;

/**
 * 
 * @author 王辉阳
 * @date 2016年12月15日 下午10:22:53
 * @Description 支付宝支付接口
 */
public class AliPayHelper {
	public static void pay() {
		System.out.println("支付宝生成一个支付订单");
	}

	public static String searchPay() {
		System.out.println("支付宝订单详情");
		return "支付宝订单详情";
	}
}
