package com.bhagava.common.utils;

public class Test {

	private String name="zhangsan";
	private int age = 18;
	
	public Test() {
		
	}

	public Test(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Test [name=" + name + ", age=" + age + "]";
	}
}
