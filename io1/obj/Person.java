package cn.hncu.io1.obj;

import java.io.Serializable;

public class Person implements Serializable{ //Ҫ����ǩ  �̶߳��������л�
	private String name;
	MyDate birth;
	public Person(String name, MyDate birth) {
		this.name = name;
		this.birth = birth;
	}
	
	@Override
	public String toString() {
		return "name=" + name + ", birth=" + birth ;
	}

	public Person() {
		super();
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
