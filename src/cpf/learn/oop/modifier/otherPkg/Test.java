package cpf.learn.oop.modifier.otherPkg;

//import cpf.learn.oop.modifier.content.Default;
import cpf.learn.oop.modifier.content.Public;

//访问控制符在跨包情况下的使用
public class Test {
	public static void main(String[] args) {
		//1.public的类 跨包只能访问到public的类(非子类)
		Public p1 = new Public();

		//属性访问情况
		System.out.println(p1.s1); //跨包 只能访问到public的属性
		System.out.println();
		//System.out.println(p1.s2);    //protected不可访问
		//System.out.println(p1.s3);    //default不可访问
		//System.out.println(p1.s4);    //private不可访问

		//方法访问情况
		p1.m1(); //跨包 只能访问到public的方法
		//p1.m2();
		//p1.m3();
		//p1.m4();

		// 2.default类 private类 protected类跨包都不可以访问（这里不讨论子类）
		//Default p2 = new Default();


	}//end main
}//end class
