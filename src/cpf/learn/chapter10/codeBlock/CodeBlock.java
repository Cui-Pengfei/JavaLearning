package cpf.learn.chapter10.codeBlock;

/**
 * 代码块的学习：
 *      1. 相当于另外一种形式的构造器（对构造器的补充机制），可以做初始化的操作
 *      2. 应用场景：如果多个构造器中都有重复的语句，可以抽取到初始化代码块中，可以提高代码的复用
 *      3. 代码块分为【静态代码块】【普通(非静态)代码块】
 *           > 静态代码块的执行，在类的初始化阶段
 *          > 普通代码块的执行，在类的实例化阶段
 *      4. 代码块的执行优先级：
 *          > 普通代码块的调用，早于构造器的调用
 *          > 当调用类的静态方法、非常数静态域时会导致类的初始化，此时会先执行类的初始化，后发生调用，
 *              而静态代码块的调用时类初始化的一部分，因此静态代码块先执行...
 *          > 而类的初始化会优先于对象的初始化，因此静态的东西总是比普通的东西更先执行
 */
public class CodeBlock{
	public static void main(String[] args){
		Movie movie = new Movie("IronMan");
		//System.out.println(Movie.type);
	}//end main
}//end class

class Movie{
	public static String type = "电影院放映...";
	private String name;
	private double price;
	private String director;

	{
		System.out.println("屏幕展开...");
		System.out.println("广告开始...");
		System.out.println("电影开始播放...");
	}

	static {
		System.out.println(type);
	}

	//三个constructor
	public Movie(String name){
		System.out.println("Movie(String name)被调用...");
		this.name = name;
	}

	public Movie(String name, double price){
		System.out.println("Movie(String name, double price)被调用...");
		this.name = name;
		this.price = price;
	}

	public Movie(String name, double price, String director){
		System.out.println("Movie(String name, double price, String director)被调用...");
		this.name = name;
		this.price = price;
		this.director = director;
	}

	//get\set
	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public double getPrice(){
		return price;
	}

	public void setPrice(double price){
		this.price = price;
	}

	public String getDirector(){
		return director;
	}

	public void setDirector(String director){
		this.director = director;
	}
}
