package com.shineoxygen.designpattern.creational.factory.simple;

/**
 * 
 * @author 王辉阳
 * @date 2016年12月13日 下午10:20:04
 * @Description 简单工厂：将对象的创建过程细节封装起来提供方法创建具体对象，我都认为是简单工厂(即使无产品超类)
 * 
 *              缺点：通过if...else这种判断来区分创建何种类型的对象，缺乏扩展性，也违背了开闭原则OCP
 * 
 *              （再添加惊悚电影，工厂类需要更改，若工厂类不让人改或为第三方类库为了稳定性别改，那么扩展性就不行了）
 */
public class MovieFactory {
	public static Movie createMovie(String type, String directorName, String movieName) {
		if ("喜剧".equalsIgnoreCase(type))
			return new ComedyMovie(directorName, movieName);
		else if ("悲剧".equalsIgnoreCase(type))
			return new TragedyMovie(directorName, movieName);

		return null;
	}
}
