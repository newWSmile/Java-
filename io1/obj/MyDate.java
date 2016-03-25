package cn.hncu.io1.obj;

import java.io.Serializable;

public class MyDate implements Serializable{
	private int year;
	private int month;
	private int day;
	
	public MyDate() {
		this(1970,1,1);
	}
	
	@Override
	public String toString() {
		return year + "." + month + "." + day;
	}

	public MyDate(int year, int month, int day) {
		
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
}
