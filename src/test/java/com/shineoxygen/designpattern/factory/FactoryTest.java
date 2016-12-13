package com.shineoxygen.designpattern.factory;

import org.junit.Test;

import com.shineoxygen.designpattern.factory.abstractfactory.AbstractMovie;
import com.shineoxygen.designpattern.factory.abstractfactory.AbstractMovieFactory;
import com.shineoxygen.designpattern.factory.abstractfactory.ComedyMovieFactory;
import com.shineoxygen.designpattern.factory.abstractfactory.MyMovieFactory;
import com.shineoxygen.designpattern.factory.abstractfactory.TragedyMovieFactory;
import com.shineoxygen.designpattern.factory.simple.Movie;
import com.shineoxygen.designpattern.factory.simple.MovieFactory;

/**
 * 
 * @author 王辉阳
 * @date 2016年12月13日 下午10:29:13
 * @Description 工厂模式：简单工厂和抽象工厂
 * 
 *              简单工厂： 一般由产品超类、产品子类、简单工厂类构成，工厂类产出抽象的产品
 * 
 *              我认为只要将创建对象的过程封装起来提供外界接口调用的都能算是简单工厂
 * 
 *              缺点是扩展性不好，违背OCP开闭原则
 * 
 *              抽象工厂：相当于工厂的工厂，一个具体工厂对应一些产品的创建
 *              
 *              这里不讨论工厂方法了，就是抽象工厂的特例，相当于一个具体工厂只生产一个产品
 *              
 *              比如：喜剧工厂生产喜剧，悲剧工厂生产悲剧，特例
 *              比如：运动车工厂多个生产方法生产宝马、奔驰、大众的运动车，商务车工厂多个生产方法生产宝马、奔驰、大众的商务车
 *             这是属于抽象工厂，相当于一个工厂生产的是一个产品线，而不是单个工厂了
 *             
 *             实际上简单工厂也算是一个抽象工厂的特例，实际上就一个工厂而已，无抽象概念罢了
 * 
 * 
 */
public class FactoryTest {
	@Test
	public void simpleFactory() {
		Movie comedyMovie = MovieFactory.createMovie("喜剧", "北野武", "菊次郎的夏天");
		Movie tragedyMovie = MovieFactory.createMovie("悲剧", "法兰克·戴伦邦特", "肖申克救赎");
		System.out.println(comedyMovie);
		System.out.println(tragedyMovie);
	}

	@Test
	public void abstractFactory() {
		AbstractMovie comedyMovie = MyMovieFactory.createMovie(new ComedyMovieFactory("北野武", "菊次郎的夏天"));
		AbstractMovie tragedyMovie = MyMovieFactory.createMovie(new TragedyMovieFactory("法兰克·戴伦邦特", "肖申克救赎"));
		System.out.println("抽象工厂：" + comedyMovie);
		System.out.println("抽象工厂：" + tragedyMovie);
	}

}
