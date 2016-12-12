package com.shineoxygen.designpattern;

/**
 * 
 * @author 王辉阳
 * @date 2016年12月12日 上午9:27:12
 * @Description 线程安全的单例：懒汉式单例实现上给获取单例方法增加synchronized确保同步
 * 
 *              双重检查是否为null，提升效率：
 * 
 *              单例永远是一个，如果已经实例化过，就无需锁在方法外，直接返回省去等待时间
 */
public class ThreadSafeSingletonDoubleCheckLock {
	private static ThreadSafeSingletonDoubleCheckLock SINGLETON;

	private ThreadSafeSingletonDoubleCheckLock() {
	}

	public static ThreadSafeSingletonDoubleCheckLock getInstance() {
		if (null == SINGLETON) {
			synchronized (ThreadSafeSingletonDoubleCheckLock.class) {
				if (null == SINGLETON) {
					SINGLETON = new ThreadSafeSingletonDoubleCheckLock();
				}
			}
		}
		return SINGLETON;
	}
}
