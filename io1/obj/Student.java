package cn.hncu.io1.obj;

import java.io.Serializable;

public class Student extends Person implements Serializable{
	private String speciality;
	
	public Student(String name, MyDate birth, String speciality) {
		super(name, birth);
		this.speciality = speciality;
	}
	
	public Student(String name, MyDate birth) {
		super(name, birth);
	}
	public Student() {
		
	}


	@Override
	public String toString() {
		return super.toString()+"speciality=" + speciality ;
	}

	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
}
