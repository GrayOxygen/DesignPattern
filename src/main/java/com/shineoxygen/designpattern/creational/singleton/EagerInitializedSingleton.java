package com.shineoxygen.designpattern.creational.singleton;

/**
 * 
 * @author 王辉阳
 * @date 2016年12月12日 上午12:54:55
 * @Description 饿汉式单例模式：类加载时实例化单例
 * 
 *              1，文件操作相关的操作
 * 
 *              2，数据库连接的初始化
 * 
 *              大部分情况如上述两种很可能占用较多资源，应在使用单例时再初始化单例，该实现不合适
 * 
 */
public class EagerInitializedSingleton {
	private static final EagerInitializedSingleton SINGLETON = new EagerInitializedSingleton();

	private EagerInitializedSingleton() {
	}

	public static EagerInitializedSingleton getSingleton() {
		return SINGLETON;
	}
}