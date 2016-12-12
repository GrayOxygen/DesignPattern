package com.shineoxygen.designpattern;

import java.io.Serializable;

/**
 * 
 * @author 王辉阳
 * @date 2016年12月12日 下午12:23:51
 * @Description 可序列化的单例的正确实现：
 * 
 *              分布式环境下会序列化一段时间后反序列用到
 * 
 *              但是反序列化会导致新生成一个实例，破坏唯一性
 * 
 *              解决：
 * 
 *              无论是实现Serializable接口，或是Externalizable接口，
 *              当从I/O流中读取对象时，readResolve()方法都会被调用到
 *              
 *              添加返回单例的readResolve方法则能保证反序列化的唯一性
 */
public class GoodSerializedSingleton implements Serializable {
	private static final long serialVersionUID = -3001097691749642431L;

	private GoodSerializedSingleton() {
	}

	private static class SingletonHelper {
		private static final GoodSerializedSingleton instance = new GoodSerializedSingleton();
	}

	public static GoodSerializedSingleton getSingleton() {
		return SingletonHelper.instance;
	}

	/**
	 * Serializable的单例类必须添加该方法否则会反序列化多个实例
	 * 
	 * @return
	 */
	protected Object readResolve() {
		return getSingleton();
	}
}
