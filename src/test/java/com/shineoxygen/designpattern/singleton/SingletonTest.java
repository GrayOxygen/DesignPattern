package com.shineoxygen.designpattern.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.junit.Assert;
import org.junit.Test;

import com.shineoxygen.designpattern.creational.singleton.BadSerializedSingleton;
import com.shineoxygen.designpattern.creational.singleton.BillPughSingleton;
import com.shineoxygen.designpattern.creational.singleton.EagerInitializedSingleton;
import com.shineoxygen.designpattern.creational.singleton.EnumSingleton;
import com.shineoxygen.designpattern.creational.singleton.GoodSerializedSingleton;
import com.shineoxygen.designpattern.creational.singleton.LazyInitializedSingleton;
import com.shineoxygen.designpattern.creational.singleton.StaticBlockSingleton;
import com.shineoxygen.designpattern.creational.singleton.ThreadSafeSingleton;
import com.shineoxygen.designpattern.creational.singleton.ThreadSafeSingletonDoubleCheckLock;
/**
 * 
 * @author 王辉阳
 * @date     2016年12月12日 下午12:42:40
 * @Description  单例实现总结：
 * 
 * 单例必须满足：
 * 1，单例类的单例变量为私有静态变量
 * 2，单例类的构造器为私有的
 * 3，单例类提供获取单例的公有静态方法
 * 
 * 饿汉式单例：不能catch创建实例的异常（变量直接赋值有异常就直接抛出了），不能懒加载
 * 静态块单例（也可算作饿汉式）：可catch创建的异常，不能懒加载
 * 懒汉式单例：可catch创建单例的异常，可懒加载，线程不安全
 * 线程安全单例：一次null检查和两次null检查，后者性能好，可catch创建单例的异常，可懒加载，线程安全
 * 静态内部类单例：可catch创建单例时的异常，可懒加载，线程安全
 * 
 * 但是上述单例均可被反射创建多个实例从而破坏单例的唯一性
 * 
 * 枚举单例：防止反射破坏单例唯一性，可catch创建单例时的异常，不可懒加载，线程安全
 * 序列化单例：需要添加readResolve方法返回单例，实现反序列化时单例的唯一性
 * 序列化单例仅强调序列化，可对线程安全单例序列化，静态块单例序列化，都可以
 * 所以不讨论能否异常的处理、能否懒加载、线程是否安全的问题
 * 
 * 
 */
public class SingletonTest {
	/**
	 * 饿汉式单例
	 */
	@Test
	public void eagerInitializedSingletonTest() {
		Assert.assertEquals(EagerInitializedSingleton.getSingleton(), EagerInitializedSingleton.getSingleton());
	}

	/**
	 * 静态块单例，也算作饿汉式单例
	 */
	@Test
	public void staticBlockSingletonTest() {
		Assert.assertEquals(StaticBlockSingleton.getSingleton(), StaticBlockSingleton.getSingleton());
	}

	/**
	 * 懒汉式单例
	 */
	@Test
	public void lazyInitializedSingletonTest() {
		// 多次运行存在打印结果大于1的情况，则存在线程安全问题
		int i = 0;
		ThreadTest thread = new ThreadTest(LazyInitializedSingleton.class, null);
		while (i++ < 11000) {
			new Thread(thread).start();
		}
	}

	/**
	 * 线程安全的单例实现：比较两种实现的性能
	 */
	@Test
	public void threadSafeSingletonTest() {
		// 比较线程单例实现的两种运行时间，做了双重检查的单例实现的性能有所提升，因为获取单例时已实例化过直接返回的情况不会直接被锁在方法外
		System.out.println(counter(ThreadSafeSingletonDoubleCheckLock.class, 112000) - counter(ThreadSafeSingleton.class, 112000));
	}

	/**
	 * 计时器：计算多个线程执行完的时间
	 * 
	 * @param clazz
	 * @return
	 */
	private long counter(Class clazz, int n) {
		long start = System.currentTimeMillis();
		List<Thread> threads = new ArrayList<Thread>();
		int i = 0;
		CountDownLatch countDownLatch = new CountDownLatch(n);
		ThreadTest thread = new ThreadTest(clazz, countDownLatch);
		while (i++ < n) {
			new Thread(thread).start();
		}

		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} // 用join()等待所有的线程。先后顺序无所谓，当这段执行完，肯定所有线程都结束了。
		return System.currentTimeMillis() - start;
	}

	/**
	 * 静态内部类单例实现：一般情况下推荐使用这种，既好理解也无线程安全问题
	 */
	@Test
	public void billPughSingletonTest() {
		int i = 0;
		ThreadTest thread = new ThreadTest(BillPughSingleton.class, null);
		while (i++ < 11000) {
			new Thread(thread).start();
		}
	}

	/**
	 * 枚举类单例实现
	 */
	@Test
	public void enumSingletonTest() {
		int i = 0;
		ThreadTest thread = new ThreadTest(EnumSingleton.class, null);
		while (i++ < 11000) {
			new Thread(thread).start();
		}
	}

	/**
	 * 序列化单例实现：反序列化时不能保证单例唯一性
	 */
	@Test
	public void badSerializedSingletonTest() {
		try {
			BadSerializedSingleton instanceOne = BadSerializedSingleton.getSingleton();
			ObjectOutput out = new ObjectOutputStream(new FileOutputStream("bad"));
			out.writeObject(instanceOne);
			out.close();
			ObjectInput in = new ObjectInputStream(new FileInputStream("bad"));
			BadSerializedSingleton instanceTwo = (BadSerializedSingleton) in.readObject();
			in.close();
			// 字节码不一致：反序列化后都会生成新的实例，不能保证唯一性
			System.out.println("instanceOne  =" + instanceOne);
			System.out.println("instanceTwo  =" + instanceTwo);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 序列化单例实现：反序列化时保证单例唯一性
	 */
	@Test
	public void goodSerializedSingletonTest() {
		try {
			GoodSerializedSingleton instanceOne = GoodSerializedSingleton.getSingleton();
			ObjectOutput out = new ObjectOutputStream(new FileOutputStream("good"));
			out.writeObject(instanceOne);
			out.close();
			ObjectInput in = new ObjectInputStream(new FileInputStream("good"));
			GoodSerializedSingleton instanceTwo = (GoodSerializedSingleton) in.readObject();
			in.close();
			// 字节码不一致：反序列化后都会生成新的实例，不能保证唯一性
			System.out.println("instanceOne  =" + instanceOne);
			System.out.println("instanceTwo  =" + instanceTwo);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
