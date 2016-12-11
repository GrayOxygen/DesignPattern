package com.shineoxygen.designpattern;

public class Thread2 extends Thread {
	public void run() {
		System.out.println("Thread2	:	" + LazyInitializedSingleton.getInstance());
	}
}
