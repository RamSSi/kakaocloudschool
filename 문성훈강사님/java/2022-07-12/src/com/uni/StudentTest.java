package com.uni;

class Human {
	private String name;
	private int age;
	private int height;
	private int weight;
	
	Human() {
	}
	
	Human(String name, int age, int height, int weight) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}
	
	public String printInformation() {
		return this.name + " " + this.age + " " +this.height + " " + this.weight + " ";
	}
	

	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public void setName(String name) {
		this.name = name;
	}	

	public void setAge(int age) {
		this.age = age;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
}

class Student extends Human {
	private String number;
	private String major;
	
	public Student() {
		
	}
	
	public Student(String name, int age, int height, int weight, String number, String major) {
		super(name, age, height, weight);
		this.number = number;
		this.major = major;
	}
	
	public String getNumber() {
		return number;
	}
	
	public String getMajor() {
		return major;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	public void setMajor(String major) {
		this.major = major;
	}
	
	@Override
	public String printInformation() {
		return super.printInformation() + this.number + " " + this.major;
	}
}

public class StudentTest {

	public static void main(String[] args) {
		Student arrays[] = new Student[3];
		// Student 객체를 3개 생성하여 배열에 넣는다.
		// 배열에 있는 객체 정보를 모두 출력한다. (for문 이용)
		arrays[0] = new Student("홍길동", 15, 171, 81, "201101", "영문");
		arrays[1] = new Student("한사람", 13, 183, 72, "201102", "건축");
		arrays[2] = new Student("임걱정", 16, 175, 65, "201103", "무용");
		for (Student s : arrays) {
			System.out.println(s.printInformation());
		}
	}

}
