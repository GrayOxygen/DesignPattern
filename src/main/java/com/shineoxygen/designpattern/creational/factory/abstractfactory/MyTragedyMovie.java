package com.shineoxygen.designpattern.creational.factory.abstractfactory;

/**
 * 
 * @author 王辉阳
 * @date 2016年12月13日 下午10:47:13
 * @Description 子产品：悲剧电影
 */
public class MyTragedyMovie extends AbstractMovie {
	private String directorName;
	private String movieName;

	MyTragedyMovie(String directorName, String movieName) {
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
		return "MyTragedyMovie [directorName=" + directorName + ", movieName=" + movieName + ", getDirectorName()=" + getDirectorName() + ", getMovieName()=" + getMovieName()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
