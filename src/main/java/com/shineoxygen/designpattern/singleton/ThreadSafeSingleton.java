package com.shineoxygen.designpattern.singleton;

/**
 * 
 * @author 王辉阳
 * @date 2016年12月12日 上午9:27:12
 * @Description 线程安全的单例：懒汉式单例实现上给获取单例方法增加synchronized确保同步
 */
public class ThreadSafeSingleton {
	private static ThreadSafeSingleton SINGLETON;

	private ThreadSafeSingleton() {
	}

	public static synchronized ThreadSafeSingleton getInstance() {
		if (null == SINGLETON) {
			SINGLETON = new ThreadSafeSingleton();
		}
		return SINGLETON;
	}
}
