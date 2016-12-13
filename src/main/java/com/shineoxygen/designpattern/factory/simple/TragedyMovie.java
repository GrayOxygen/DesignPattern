package com.shineoxygen.designpattern.factory.simple;

/**
 * 
 * @author 王辉阳
 * @date 2016年12月13日 下午10:16:09
 * @Description 悲剧电影
 */
public class TragedyMovie extends Movie {
	private String directorName;
	private String movieName;

	TragedyMovie(String directorName, String movieName) {
		this.directorName = directorName;
		this.movieName = movieName;
	}

	@Override
	public String getDirectorName() {
		return this.directorName;
	}

	@Override
	public String getMovieName() {
		return movieName;
	}

}
