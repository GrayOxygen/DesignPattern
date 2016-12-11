package com.shineoxygen.designpattern;

import java.util.HashSet;
import java.util.Set;

public class ThreadTest implements Runnable {
	// 存放单例对象，使用Set是为了不存放重复元素
	public Set<LazyInitializedSingleton> singles = new HashSet<LazyInitializedSingleton>();

	@Override
	public void run() {
		singles.add(LazyInitializedSingleton.getInstance());
		System.out.println(singles.size());
	}
}
