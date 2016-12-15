package com.shineoxygen.designpattern.creational.singleton;

import java.lang.reflect.Constructor;

import org.junit.Test;

import com.shineoxygen.designpattern.creational.singleton.BillPughSingleton;

/**
 * 
 * @author 王辉阳
 * @date 2016年12月12日 下午12:07:11
 * @Description 反射破坏单例唯一性
 */
public class ReflectionSingletonTest {
	/**
	 * 这里以静态内部类单例作为破坏示例，其他实现一样可被反射破坏
	 */
	@Test
	public void destroySingleton() {
		BillPughSingleton instanceOne = BillPughSingleton.getSingleton();
		BillPughSingleton instanceTwo = null;
		try {
			Constructor[] constructors = BillPughSingleton.class.getDeclaredConstructors();
			for (Constructor constructor : constructors) {
				// 反射创建一个新的对象，导致单例不唯一
				constructor.setAccessible(true);
				instanceTwo = (BillPughSingleton) constructor.newInstance();
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 字节码不一致：单例被破坏
		System.out.println(instanceOne);
		System.out.println(instanceTwo);
	}
}
