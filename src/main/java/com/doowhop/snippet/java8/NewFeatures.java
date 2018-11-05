package com.doowhop.snippet.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.Test;

public class NewFeatures {
	
	private static List<People> peopleList = new ArrayList<>();
	
	static{
		peopleList.add(new People("a",17));
	    peopleList.add(new People("b",16));
	    peopleList.add(new People("c",19));
	    peopleList.add(new People("d",15));
	}
	
	/**
	 *Lambda 表达式，也可称为闭包。Lambda 允许把函数作为一个方法的参数（函数作为参数传递进方法中）。
	 *Lambda表达式可以替代以前广泛使用的内部匿名类，各种回调，
	 *比如:事件响应器、传入Thread类的Runnable等。
	 *
	 *语法:(parameters) -> expression / (parameters) ->{ statements; }
	*/
	@Test
	public void testLambda() {
		System.out.println("排序前:"+ peopleList);	
		//第一种, 传统匿名Compartor接口排序
		Collections.sort(peopleList, new Comparator<People>() {
			@Override
			public int compare(People o1, People o2) {
				return o1.getAge().compareTo(o2.getAge());
			}			
		});
		System.out.println("匿名接口方法——排序后："+peopleList);
		
		//第二种, 使用Lambda表达式代替匿名接口方法
		//1.声明式, 不使用大括号, 只可以写单条语句
		Collections.sort(peopleList, (People a, People b)->
			a.getAge().compareTo(b.getAge()));
		System.out.println("Lambda表达式1、排序："+peopleList);
		//2.不声明式，使用大括号，可以写多条语句
		Collections.sort(peopleList, (a, b)->{
			System.out.println("-------------------");
			return a.getAge().compareTo(b.getAge());
		});
		System.out.println("Lambda表达式2、排序："+peopleList);
		
		//第三种，使用Lambda表达式调用类的静态方法
		Collections.sort(peopleList, (a,b)->People.sortByName(a,b));
		System.out.println("Lambda表达式调用静态方法："+peopleList);
		
		//第四种，使用Lambda表达式调用类的实例方法
	    Collections.sort(peopleList, (a,b)->new People().sortByAge(a,b));
	    System.out.println("Lambda表达式调用实例方法:"+peopleList);
	}
	
	
	/**
		  方法引用的种类
		 1. 类静态方法引用
			Class::staticMethodName
		 2.某个对象的方法引用
			instance::instanceMethodName
		 3.特定类的任意对象的方法引用：
			Class::method
		 4.构造方法引用：
			Class::new
	*/
	@Test
	public void testMethodReference() {
		//第一种，引用类的静态方法
		Collections.sort(peopleList, People::sortByName);
		System.out.println("引用类的静态方法：" + peopleList);
		
		//第二种，引用类的实例方法
		Collections.sort(peopleList, new People()::sortByAge);
		System.out.println("引用类的实例方法：" + peopleList);
		
		//第三种，特定类的方法调用()
		Integer[] a = new Integer[]{3, 1, 2, 4, 6, 5};
		Arrays.sort(a, Integer::compare);
		System.out.println("特定类的方法引用：" + Arrays.toString(a));
		
		//第四种，引用类的构造器
		/*Car car = Car.create(Car::new);
		System.out.println("引用类的构造器:" + car);*/
	}
	
	
	//Supplier接口是在1.8中新出现的函数接口，用于支持函数式编程。它用于返回一个任意泛型的实例对象，与工厂的功能类似
	/*public static Car create(Supplier<Car> supplier){
	    return supplier.get();
	}*/
	
	/**java.util.function.Predicate, Comparator, Supplier, Consumer
	 * 其他的还有一些函数接口，如Runnable，InvocationHandler等，在这里就不阐述了。有兴趣的大家可以自行查询资料。
	 * Stream、Function、Optional也是函数接口，将在下面进行详细介绍。
	 */
	@Test
	public void testFuncInte() {
		
		Predicate<Integer> predicate = x -> x > 3;
		predicate.test(10);//true
		predicate.negate().test(10);//false
		predicate.or(x -> x < 1).and(x -> x > -1).negate().test(-1);//true
	
		
		Integer[] a = new Integer[]{3, 1, 2, 4, 6, 5};
		Comparator<Integer> comparator = Integer::compare;
		Arrays.sort(a, comparator);
		System.out.println("升序：" + Arrays.toString(a));
		Arrays.sort(a,comparator.reversed());
		System.out.println("降序："+Arrays.toString(a));
	
		//批量修改，将age<18的对象的age改为18
		People.updateMany(peopleList,
		        p -> p.getAge() < 18,
		        p -> p.setAge(18));
		System.out.println("修改后的结果：" + peopleList);
	}
	
	
	/**
	 *  Java8提供的java.util.function包的核心函数接口有4个。

		函数型T ->R，完成参数类型T向结果类型R的转换和数据处理。核心函数接口Function
		判断型T ->boolean，核心函数接口Predicate
		消费型T ->void，核心函数接口Consumer
		供给型void->T，核心函数接口Supplier
		Function接口是为Java8提供了函数式编程的基础，apply方法与Consumer的accept方法功能类似，但是提供了返回及类型转换的可能，功能更加强大；再通过andThen与compose方法可以使Function组成Function功能链，进行多级数据处理及转换。
		
		主要方法
		R apply(T t) – 将Function对象应用到输入的参数上，然后返回计算结果。
		
		default Function<T,V> andThen(Function<? super R,? extends V> after) 返回一个先执行当前函数对象apply方法再执行after函数对象apply方法的函数对象。
		
		default Function<T,V> compose(Function<? super V,? extends T> before)返回一个先执行before函数对象apply方法再执行当前函数对象apply方法的函数对象。
		
		static Function<T,T> identity() 返回一个执行了apply()方法之后只会返回输入参数的函数对象。
	 */
	@Test
	public void testFunction() {
		
	}
	
	/**
	 * Java8中提供了Stream API,即流式处理。
	 * 可以通过将List、Set、Array等对象转换成流进行操作。
	 * Stream内的流操作分为两种：中间操作和最终操作，
	 * 中间操作会返回一个全新的Stream对象，意味着你的操作不会影响最初的流；
	 * 最终操作会将流进行转换或者操作，返回非Stream的对象。
	 * Stream可以替代传统的循环操作，
	 * 从线程上区别，Stream分为串行（Stream）和并行（parallelStream）
	 */
	@Test
	public void testStream() {
		
	}
	
	
	public static void main(String[] args) {
		System.out.println(peopleList.size());
	}
}
