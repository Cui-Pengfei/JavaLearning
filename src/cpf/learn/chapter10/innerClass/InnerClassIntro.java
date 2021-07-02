package cpf.learn.chapter10.innerClass;

/**
 * 内部类的简单入门：
 * 1> 内部类是类的五大成员之一（属性、构造器、方法、代码块、内部类）
 * 2> 内部类最大的特点，就是可以访问私有属性，可以体现类之间的包含关系
 * 3> 内部类是学习的难点，也是重点，必须掌握精通
 */
public class InnerClassIntro{
	public static void main(String[] args){
		Outer outer = new Outer();

	}//end main
}

class Outer{
	//私有属性
	private int a = 1;

	//构造器
	public Outer(){
	}
	public Outer(int a){
		this.a = a;
	}

	//get、set方法
	public int getA(){
		return a;
	}
	public void setA(int a){
		this.a = a;
	}

	//普通方法
	private void sayHello(){
		System.out.println("hello~");
	}

	//内部类
	class Inner{
		public void visit(){
			System.out.println(a);
			sayHello();
			setA(2);
			System.out.println(getA());
		}
	}
}