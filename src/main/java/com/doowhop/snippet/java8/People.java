package com.doowhop.snippet.java8;

import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class People {
	People(){};
	
	People(String name, Integer age){
		this.setName(name);
		this.setAge(age);
	}
	
	private String name;
	
	private Integer age;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return name + ":" + age;
	}
	
	public static int sortByName(People o1, People o2) {
		return o1.getName().compareTo(o2.getName());
	}
	
	public int sortByAge(People o1, People o2) {
		return o1.getAge().compareTo(o2.getAge());
	}

	public static List<People> updateMany(List<People> peopleList, 
			Predicate<People> predicate, Consumer<People> consumer) {
	    for (int i = 0; i < peopleList.size(); i++) {
	        if (predicate.test(peopleList.get(i))) {
	            consumer.accept(peopleList.get(i));
	        }
	    }
	    return peopleList;
	}

}
