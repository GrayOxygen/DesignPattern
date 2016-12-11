package com.shineoxygen.designpattern;

/**
 * 
 * @author 王辉阳
 * @date 2016年12月12日 上午1:12:22
 * @Description 静态块单例：类初始化时实例化单例
 * 
 *              与饿汉式单例实现类似，但能catch处理异常情况
 */
public class StaticBlockSingleton {
	private static StaticBlockSingleton SINGLETON;

	private StaticBlockSingleton() {
	}

	static {
		try {
			SINGLETON = new StaticBlockSingleton();
			System.out.println(1 == 1 / 0);
		} catch (Exception e) {
			throw new RuntimeException("创建单例时发生异常，进行处理");
		}
	}

	public static StaticBlockSingleton getSingleton() {
		return SINGLETON;
	}
}
