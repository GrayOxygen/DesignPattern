package com.shineoxygen.designpattern.structural;

/**
 * 
 * @author 王辉阳
 * @date 2016年12月15日 下午10:23:16
 * @Description 微信支付接口
 */
public class WechatPayHelper {
	public static void pay() {
		System.out.println("微信生成一个支付订单");
	}

	public static String searchPay() {
		System.out.println("微信订单详情");
		return "微信订单详情";
	}
}
