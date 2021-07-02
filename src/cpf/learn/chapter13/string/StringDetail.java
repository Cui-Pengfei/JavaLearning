package cpf.learn.chapter13.string;

import java.lang.reflect.Field;

/**
 * @author CPF 创建于： 2021/6/16 1:21
 * String的细节说明：
 */
public class StringDetail{
	public static void main(String[] args)
			throws NoSuchFieldException, IllegalAccessException{
//1. 两种方式创建字符串
		String name = "cpf";//直接在字符串常量池中寻找，找不到就在池中创建
		String name1 = new String("cpf");
		//在堆中维护一个String对象，以及关键域value[]，这个value仍然会向常量池寻求是否有相同的字符数组

		//过渡知识： == 先执行左边，后执行右边，再执行比较
		System.out.println(a() == b());

//2. intern()方法的深入理解
		String a = "jack";                  //假设池中地址0X99
		String b = new String("jack");      //假设堆中地址0X11
		System.out.println(b == b.intern());//F
		/*
		此例非常经典：解读 b == b.intern()
		1. 先执行 b，此时的 b 指向的是堆中地址 0X99 ，此处就把0X99放在这儿了
		2. 再执行 b.intern()，发现池中有了"jack"，于是返回池中地址0X11，此处就把0X11放这儿了
		3. 最后比较 0X99 == 0X11 ，自然返回的是 false
		 */

//3. String的value[]会在池中找是否有相同的字符数组，怎么找？如何证明？
		System.out.println("=========3.反射获得value[]域证明其会向常量池找匹配值===========");
		String s1 = "你是大笨蛋！";
		String s2 = new String("你是大笨蛋！");
		//此时只要获得两个String的value[]，再比较一下首地址，就知道是不是同一个字符数组了！
		//问题是，value是private的，只能通过反射了
		Field valueStringField = String.class.getDeclaredField("value");
		valueStringField.setAccessible(true);//开通权限
		char[] value1 = (char[]) valueStringField.get(s1);
		char[] value2 = (char[]) valueStringField.get(s2);
		System.out.println(value1 == value2);//true
		System.out.println(System.identityHashCode(value1));//2133927002
		System.out.println(System.identityHashCode(value2));//2133927002
		//两者完全一致，说明是一个字符数组

//4. 判断创建的对象个数
		String string1 = "abc";
		string1 = "ert";//整个过程创建了两个对象，但是"abc由于没有人引用，马上会被GC回收"

		String string2 = "hello" + "world";
		/*
		创建了一个对象：
		hello 和 world 都是字面量，也就是编译器常量，编译器常量在编译阶段就会被简单处理，
		这里发现是拼接，在编译阶段就优化为一个字面量了，根本到不了运行阶段，
		再说，hello world没人引用，创建对象也是浪费，很快会被GC回收
		 */

		String c = "i love ";
		String d = "you";
		String p = c + d;//解读这句话的执行过程：
		/*
		1.创建一个StringBuilder对象，调用父类AbstractStringBuilder创建一个初始大小为16的字符数组value
		2.调用StringBuilder.append("i love "),追加进去第一个字面量
		3.追加第二个字面量 append("you"),到value[]内
		4.调用StringBuilder.toString(char[],0,count)把value[]内追加进去的字符变成字符串返回给p
		注意：由于toString方法中会new String，因此，p指向的是堆中的对象，这
		public String toString() {
        // Create a copy, don't share the array
        return new String(value, 0, count);
    }


		 */

	}

	public static int a(){
		System.out.println("调用a...");
		return 1;
	}

	public static int b(){
		System.out.println("调用b...");
		return 1;
	}
}
