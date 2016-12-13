package com.shineoxygen.designpattern.factory.abstractfactory;

/**
 * 
 * @author 王辉阳
 * @date 2016年12月13日 下午10:47:27
 * @Description 子产品：喜剧电影
 */
public class MyComedyMovie extends AbstractMovie {
	private String directorName;
	private String movieName;

	MyComedyMovie(String directorName, String movieName) {
		this.directorName = directorName;
		this.movieName = movieName;
	}

	@Override
	public String getDirectorName() {
		return this.directorName;
	}

	@Override
	public String getMovieName() {
		return this.movieName;
	}

	@Override
	public String toString() {
		return "MyComedyMovie [directorName=" + directorName + ", movieName=" + movieName + "]";
	}

}
