package cpf.learn.chapter15;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CPF 创建于： 2021/6/30 3:25
 * 泛型的继承和通配符：
 * 0. 泛型没有继承性...
 * 1. <?> 支持任意类型的泛型
 * 2. <? extends A> 支持A类以及A类的子类，规定了泛型的上限
 * 3. <? super A>   支持A类以及A类的父类，不限于直接父类，规定了泛型的下限
 */
public class GenericExtend{
	public static void main(String[] args){
		//List<Object> list = new ArrayList<String>();//这是错的

		List<? extends Object> list = new ArrayList<>();
		/*
		你可能认为上述代码表明 list将可以持有任意类型的Object,
		但实际上，它的意思是“list将持有某种没有指定的继承自Object的类型”；
		泛型需要指定的是明确的类型，此处意味着，该泛型没有确定某一类型，将无法存入任意类型的元素；
		因此这是毫无意义的，如果你不知道List该持有什么样的类型，那你要这样的泛型有什么用呢？
			只能在编译阶段，用于约束接收泛型参数的范围，使类型匹配异常在编译阶段暴露出来，
			当然传过去的泛型也只能遍历不能添加了，因为不知道添加什么类型的元素
		 */
		ArrayList<Integer> integers = new ArrayList<>();
		integers.add(1);
		integers.add(2);
		integers.add(3);
		integers.add(4);
		list = integers;
		for(Object i : list){
			System.out.println(i);
		}

	}//end main
}
