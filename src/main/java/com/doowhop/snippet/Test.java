package com.doowhop.snippet;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Test {
	
	public static void main(String[] args) {
//		BigDecimal bg = new BigDecimal("9200.00").multiply(new BigDecimal("0.012345"));
//		System.out.println(bg);
		BigDecimal bg1 =  new BigDecimal("9200.00").multiply(new BigDecimal("0.012345")).setScale(2, BigDecimal.ROUND_HALF_UP);
		System.out.println(bg1);
		
		MathContext mc = new MathContext(2,RoundingMode.HALF_UP);
		BigDecimal bg2 = new BigDecimal("9200.00").multiply(new BigDecimal("0.012345"), mc);
		System.out.println(bg2);
		
		BigDecimal decimal = new BigDecimal("1.12545");
        System.out.println(decimal);       
        BigDecimal setScale1 = decimal.setScale(2,BigDecimal.ROUND_HALF_UP);
        System.out.println(setScale1);
	}

}
