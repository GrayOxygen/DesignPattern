package com.shineoxygen.designpattern.structural;

import org.junit.Test;

/**
 * 
 * @author 王辉阳
 * @date 2016年12月15日 下午10:52:58
 * @Description 门面模式
 * 
 *              不隐藏子系统的接口，而是包装，是使用者关注范围缩小
 * 
 *              接口变得很多时，都可使用门面模式
 * 
 *              子系统的接口并不是感知门面类，无门面类的引用
 * 
 *              工厂模式搭配门面模式使用，可为客户端系统提供更好的接口（使调用者更专注）
 * 
 *              本质上就是个包装类
 * 
 */
public class FacadeTest {
	@Test
	public void test() {
		// 不是使用门面模式的做法
		AliPayHelper.pay();
		JingdongPayHelper.pay();
		WechatPayHelper.pay();
		AliPayHelper.searchPay();
		JingdongPayHelper.searchPay();
		WechatPayHelper.searchPay();

		// 使用门面模式的做法
		FacadeHelper.pay("支付宝");
		FacadeHelper.pay("京东");
		FacadeHelper.pay("微信");
		FacadeHelper.searchPay("支付宝");
		FacadeHelper.searchPay("京东");
		FacadeHelper.searchPay("微信");

	}
}
