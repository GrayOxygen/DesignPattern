package com.shineoxygen.designpattern.singleton;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

import com.shineoxygen.designpattern.singleton.LazyInitializedSingleton;
import com.shineoxygen.designpattern.singleton.ThreadSafeSingleton;
import com.shineoxygen.designpattern.singleton.ThreadSafeSingletonDoubleCheckLock;

/**
 * 
 * @author 王辉阳
 * @date 2016年12月12日 下午12:11:39
 * @Description 测试所用线程
 */
public class ThreadTest implements Runnable {
	// 存放单例对象，使用Set是为了不存放重复元素
	public Set singles = new HashSet();
	private Class clazz;
	private CountDownLatch countDownLatch;

	ThreadTest(Class clazz, CountDownLatch countDownLatch) {
		this.clazz = clazz;
		this.countDownLatch = countDownLatch;
	}

	@Override
	public void run() {
		if (clazz == LazyInitializedSingleton.class) {
			singles.add(LazyInitializedSingleton.getInstance());
		}
		if (clazz == ThreadSafeSingleton.class) {
			singles.add(ThreadSafeSingleton.getInstance());
		}
		if (clazz == ThreadSafeSingletonDoubleCheckLock.class) {
			singles.add(ThreadSafeSingletonDoubleCheckLock.getInstance());
		}
		System.out.println(Thread.currentThread().getName() + "--->" + singles.size());
		// 计数器，用于统计时间，一个线程结束后计数器递减
		if (null != countDownLatch) {
			countDownLatch.countDown();
		}
	}
}
