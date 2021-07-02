package cpf.learn.oop.extend_.exercise;

public class Exercise01{
	public static void main(String[] args){
		B b = new B();
		/*
		结果应该是：  a
					b name
					b
		*/

	}//end main
}//end class

class A{
	//两个构造器
	A(){
		System.out.println("a");
	}

	A(String name){
		System.out.println("a name");
	}
}//end class

class B extends A{

	//两个构造器
	B(){
		//根据调用构造器必须是第一条语句可以断定，此处没有调用父类的super();
		this("B无参构造器调用自己的有参构造器...");
		System.out.println("b");
	}


	B(String name){
		//这里默认的调用父类的无参构造器super()
		System.out.println("b name");
	}
}
