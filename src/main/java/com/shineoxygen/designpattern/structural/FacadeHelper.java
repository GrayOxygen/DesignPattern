package com.shineoxygen.designpattern.structural;

/**
 * 
 * @author 王辉阳
 * @date 2016年12月15日 下午10:31:48
 * @Description 门面类：
 * 
 *              实际上就是一个POJO，不过是将一些接口（最好是一些类似的接口）包装了起来
 * 
 *              如此一来，当接口越来越多，我们的关注点则在门面类上而非具体的接口上，关注范围缩小，提升效率
 */
public class FacadeHelper {
	/**
	 * 生成订单
	 * 
	 * @param type
	 */
	public static void pay(String type) {
		switch (type) {
		case "京东":
			JingdongPayHelper.pay();
			return;
		case "支付宝":
			AliPayHelper.pay();
			return;
		case "微信":
			WechatPayHelper.pay();
			return;
		default:
			;
		}
	}

	/**
	 * 查询订单
	 * 
	 * @param type
	 * @return
	 */
	public static String searchPay(String type) {
		switch (type) {
		case "京东":
			return JingdongPayHelper.searchPay();
		case "支付宝":
			return AliPayHelper.searchPay();
		case "微信":
			return WechatPayHelper.searchPay();
		default:
			return null;
		}
	}
}
