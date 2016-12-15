package com.shineoxygen.designpattern.creational.factory.simple;

/**
 * 
 * @author 王辉阳
 * @date 2016年12月13日 下午10:16:21
 * @Description 喜剧电影
 */
public class ComedyMovie extends Movie {
	private String directorName;
	private String movieName;

	ComedyMovie(String directorName, String movieName) {
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

}
