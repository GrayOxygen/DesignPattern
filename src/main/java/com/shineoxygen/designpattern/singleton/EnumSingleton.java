package com.shineoxygen.designpattern.singleton;

/**
 * 
 * @author 王辉阳
 * @date 2016年12月12日 下午12:19:59
 * @Description 枚举类单例实现：
 * 
 *              枚举类全局唯一从而保证单例唯一性
 * 
 *              可防止反射破坏
 * 
 *              但无法懒加载单例(一开始就初始化枚举类了)
 */
public enum EnumSingleton {
	SINGLETON;

	public static void doSomething() {
		// ...
	}
}
