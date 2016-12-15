package com.shineoxygen.designpattern.creational.factory.simple;

/**
 * 
 * @author 王辉阳
 * @date 2016年12月13日 下午10:09:45
 * @Description 工厂模式中的超类：抽象类或接口，这是工厂所产出的东西，理解为产品超类
 */
public abstract class Movie {
	public abstract String getDirectorName();

	public abstract String getMovieName();

	@Override
	public String toString() {
		return "Movie [getDirectorName()=" + getDirectorName() + ", getMovieName()=" + getMovieName() + "]";
	}
}
