package com.doowhop.snippet.java151;

import java.util.Random;

public class practice {
	
	public static final int RAND_CONST = new Random().nextInt();
	
	public static void main(String[] args) {
		/*System.out.println(RAND_CONST);
		System.out.println(RAND_CONST+1);*/
		
		int fee = 200;
		saveDefault:save(fee);
		
	}
	
	static void saveDefault() {
		System.out.println("------------");
	}
	
	static void save(int fee) {
		System.out.println(".............");
	}
}
