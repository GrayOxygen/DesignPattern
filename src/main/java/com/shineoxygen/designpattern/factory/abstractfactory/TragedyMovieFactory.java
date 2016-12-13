package com.shineoxygen.designpattern.factory.abstractfactory;

/**
 * 
 * @author 王辉阳
 * @date 2016年12月13日 下午10:49:53
 * @Description 子工厂：负责创建悲剧电影
 */
public class TragedyMovieFactory implements AbstractMovieFactory {
	private String directorName;
	private String movieName;

	public TragedyMovieFactory(String directorName, String movieName) {
		this.directorName = directorName;
		this.movieName = movieName;
	}

	@Override
	public AbstractMovie createMovie() {
		return new MyTragedyMovie(directorName, movieName);
	}

}
