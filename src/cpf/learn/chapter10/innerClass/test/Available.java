package cpf.learn.chapter10.innerClass.test;

/**
 * 四种内部类的私有属性，有三种可以被外部类直接访问到
 */
public class Available{
	public static void main(String[] args){
		Outer outer = new Outer();
		outer.local();
	}//end main
}//end calss

class Outer{

	static class Inner01{//1.静态内部类
		private int a = 1;
	}

	class Inner02{//2.成员内部类
		private int b = 2;
	}

	//局部方法
	public void local(){
		class Inner03{//3.局部内部类
			private int c = 3;
		}

		Dog dog = new Dog(){//4.匿名内部类
			private int d= 4;
		};

		Inner01 inner01 = new Inner01();
		System.out.println(inner01.a);//1.直接访问了静态内部类私有属性

		Inner02 inner02 = new Inner02();
		System.out.println(inner02.b);//2.直接访问成员内部类私有属性

		Inner03 inner03 = new Inner03();
		System.out.println(inner03.c);//3.在局部，直接访问局部内部类私有属性

		//System.out.println(dog.d);//4.匿名内部类无法访问到私有属性
		/*
		原因非常简单，因为你匿名内部类其实是一个很正常的类，是一种类组合进入外部类，
		只是这种组合只用一次，没必要起名字，因此与正常语法无异，
		当然无法在类体外部访问到私有属性
		 */
	}
}//end Outer
class Dog{}
