package com.shineoxygen.designpattern;

/**
 * 
 * @author 王辉阳
 * @date 2016年12月12日 上午1:18:40
 * @Description 懒汉式单例：在需要单例时才实例化单例，但存在线程安全问题
 */
public class LazyInitializedSingleton {
	private static LazyInitializedSingleton SINGLETON;

	private LazyInitializedSingleton() {
	}

	public static LazyInitializedSingleton getInstance() {
		if (null == SINGLETON) {
			SINGLETON = new LazyInitializedSingleton();
		}
		return SINGLETON;
	}
}
