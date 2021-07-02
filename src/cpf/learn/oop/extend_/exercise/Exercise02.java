package cpf.learn.oop.extend_.exercise;

public class Exercise02{

	public static void main(String[] args){
		CC cc = new CC();
		/*
		应该输出：
				我是AA类
				hahaha我是BB类的有参构造器
				我是CC类的有参构造器
				我是C类的无参构造器
		*/

	}//end main

}//end public class

class AA{//AA类

	public AA(){
		System.out.println("我是AA类");
	}
}

class BB extends AA{//BB类,继承AA类     //main方法中:CC cc =new CC;输出么内容

	public BB(){
		System.out.println("我是BB类的无参构造");
	}

	public BB(String name){
		System.out.println(name + "我是BB类的有参构造");
	}
}

class CC extends BB{

	public CC(){
		this("hello");
		System.out.println("我是C类的无参构造器");
	}

	public CC(String name){
		super("hahaha");
		System.out.println("我是CC类的有参构造器");
	}
}
