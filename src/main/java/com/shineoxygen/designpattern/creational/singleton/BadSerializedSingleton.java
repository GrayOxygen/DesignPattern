package com.shineoxygen.designpattern.creational.singleton;

import java.io.Serializable;

/**
 * 
 * @author 王辉阳
 * @date 2016年12月12日 下午12:23:51
 * @Description 可序列化的单例的有问题的实现：
 * 
 *              分布式环境下会序列化一段时间后反序列用到
 * 
 *              但是反序列化会导致新生成一个实例，破坏唯一性
 */
public class BadSerializedSingleton implements Serializable {
	private static final long serialVersionUID = -3001097691749642431L;

	private BadSerializedSingleton() {
	}

	private static class SingletonHelper {
		private static final BadSerializedSingleton instance = new BadSerializedSingleton();
	}

	public static BadSerializedSingleton getSingleton() {
		return SingletonHelper.instance;
	}

}
