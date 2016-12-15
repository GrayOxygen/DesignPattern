package com.shineoxygen.designpattern.creational.factory.abstractfactory;

/**
 * 
 * @author 王辉阳
 * @date 2016年12月13日 下午10:57:21
 * @Description 提供工厂生产的方法即对外返回创建对象的接口
 * 
 *              这里封装了一层，仅仅让具体工厂类隐藏起来，统一下接口调用而不直接依赖具体工厂
 */
public class MyMovieFactory {
	public static AbstractMovie createMovie(AbstractMovieFactory factory) {
		return factory.createMovie();
	}
}
