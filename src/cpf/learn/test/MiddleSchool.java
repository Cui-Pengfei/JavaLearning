package cpf.learn.test;

import cpf.learn.oop.extend_.Student;

/**
 * 为了测试 :
 *       1> 不同包下，子类可直接继承的父类的属性和方法，
 *       2> super关键字访问属性、方法是否存在意义？(毕竟已经继承过来了)
 *          >>>super关键字访问属性、方法是没有意义的
 *
 *
 */
public class MiddleSchool extends Student{

	public static void main(String[] args){
		new MiddleSchool().call();

	}//end main

	public void call(){
		//不同包 子类 可直接访问到 父类的protected属性、方法
		//不同包 子类 无法直接访问 父类的default属性、方法
		System.out.println(this.subject);
		System.out.println(super.subject);
	}
}
