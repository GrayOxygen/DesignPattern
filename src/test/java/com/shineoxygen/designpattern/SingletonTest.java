package com.shineoxygen.designpattern;

import org.junit.Assert;
import org.junit.Test;

public class SingletonTest {
	@Test
	public void eagerInitializedSingletonTest() {
		Assert.assertEquals(EagerInitializedSingleton.getSingleton(), EagerInitializedSingleton.getSingleton());
	}

	@Test
	public void staticBlockSingletonTest() {
		Assert.assertEquals(StaticBlockSingleton.getSingleton(), StaticBlockSingleton.getSingleton());
	}

	@Test
	public void lazyInitializedSingletonTest() {
		// 打印结果大于1时则存在线程安全问题
		int i = 0;
		ThreadTest thread = new ThreadTest();
		while (i++ < 11000) {
			new Thread(thread).start();
		}
	}

}
