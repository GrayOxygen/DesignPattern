package com.shineoxygen.designpattern.creational.factory.abstractfactory;

/**
 * 
 * @author 王辉阳
 * @date 2016年12月13日 下午10:49:53
 * @Description 子工厂：负责创建喜剧电影
 */
public class ComedyMovieFactory implements AbstractMovieFactory {
	private String directorName;
	private String movieName;

	public ComedyMovieFactory(String directorName, String movieName) {
		this.directorName = directorName;
		this.movieName = movieName;
	}

	@Override
	public AbstractMovie createMovie() {
		return new MyComedyMovie(directorName, movieName);
	}

}
