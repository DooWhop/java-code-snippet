package com.doowhop.snippet.a;

public class Test1 {
	/*1、初始化父类的静态变量，静态代码块，初始化的顺序按照出现顺序。 
	2、初始化子类的静态变量，静态代码块。 
	3、初始化父类的成员变量。 
	4、执行父类的构造函数。 
	5、初始化子类的成员变量。 
	6、构造代码块创建对象时执行。 
	7、执行子类的构造函数。 */
	
	    public static void main(String args[]){
	        staticFunction();
	    }
	    static Test1 st = new Test1();
	    static{
	        System.out.println("1");
	    }
	    Test1(){
	        System.out.println("3");
	        System.out.println("a="+a+" b="+b);
	    }
	    public static void staticFunction(){
	        System.out.println("4");
	    }
	    {
	        System.out.println("2");
	    }
	    int a=100;
	    static int b=112;
	    

}
