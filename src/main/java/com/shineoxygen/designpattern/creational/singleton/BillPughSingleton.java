package com.shineoxygen.designpattern.creational.singleton;

/**
 * 
 * @author 王辉阳
 * @date 2016年12月12日 上午11:52:29
 * @Description 静态内部类单例实现：
 * 
 *              内部类在调用时加载，静态内部类仅加载一次，从而解决了线程安全问题
 */
public class BillPughSingleton {

	private BillPughSingleton() {
	}

	private static class SingletonHelper {
		private static final BillPughSingleton SINGLETON = new BillPughSingleton();
	}

	public static BillPughSingleton getSingleton() {
		return SingletonHelper.SINGLETON;
	}
}
