package cpf.learn.chapter11.enum_.exercise;

/**
 * @author CPF 创建于： 2021/6/8 20:17
 * 我的问题：
 **** 1.为什么枚举可以返回这个常量值的名字？这是非常特殊的功能！
 *
 * 枚举类默认继承Enum，这个重写的toString方法，是返回枚举常量的名字
 *
 */
public class Exercise01{
	public static void main(String[] args){
		Gender boy = Gender.BOY;
		System.out.println(boy);
		System.out.println(boy.name());
		System.out.println(Gender.GIRL );
	}//end main
}

enum Gender{
	BOY,GIRL;
}
