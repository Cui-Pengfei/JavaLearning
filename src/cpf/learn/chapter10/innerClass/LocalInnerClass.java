package cpf.learn.chapter10.innerClass;

/**
 * 局部内部类：
 * 【定义】
 *      局部内部类定义在外部类的局部位置（方法内、代码块中），拥有类名
 * 【特点】
 *      1. 可以直接访问外部类的所有成员，包括私有的
 *      2. 不能添加访问修饰符，因为他的地位就是一个局部变量，局部变量无法使用修饰符。
 *          但是可以使用final修饰，因为局部变量也可以使用final修饰，
 *          被final修饰的局部类，无法再被继承
 *      3. 作用域：局部内部类的作用域，仅仅在定义它的方法体、代码块中，与局部变量类似
 *      4. 局部内部类---访问--->外部类的成员：直接访问
 *      5. 外部类--- 访问 ---> 局部内部类成员：创建对象再访问，必须在作用域内，
 *          也就是通过方法来访问。
 *      6. 外部类---不能直接访问--->局部内部类（因为局部内部类的地位类似于局部变量）
 *      7. 局部内部类 与 外部类 的成员重名时，默认遵循就近原则，
 *          如果想访问外部类这个同名成员，可使用【外部类名.this.成员名】去访问
 *          （由此可见，this是类隐藏的private static的属性）
 *
 *
 * 【理解】
 *      1.局部内部类只有在其作用域内，才能活的像一个类，超出作用域，啥也不是，访问不了
 *          在其作用域内，一切的类的功能都具备，就是只能用final来修饰。
 *
 *
 */
public class LocalInnerClass{
	public static void main(String[] args){
		Outer01 outer01 = new Outer01();
		outer01.getVisit();
	}
}

class Outer01{
	private int x = 6;
	private String same = "我么都一样";

	private void sayHello(){
		System.out.println("hello~");
	}

	public void getVisit(){
		//局部内部类
		class Inner01{
			private String same = "一样吗？";
			public void visit(){
				System.out.println("x = " + x);
				sayHello();
				System.out.println(same);
				System.out.println(this.same);
				System.out.println(Outer01.this.same);
			}
		}

		Inner01 inner01 = new Inner01();
		inner01.visit();
		System.out.println(inner01.same);//可以在局部内部类外直接访问其私有属性
	}

}

























