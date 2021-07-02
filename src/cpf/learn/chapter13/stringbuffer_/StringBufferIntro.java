package cpf.learn.chapter13.stringbuffer_;

/**
 * @author CPF 创建于： 2021/6/17 2:23
 * StringBuffer的入门：
 * 1.三个自己的域：
	 * 1.1 toStringCache[]  这里面存放了value内有字符的那一部分，
     *     这个字符数组的长度就是StringBuffer的length
	 * 1.2 serialVersionUID 由于String实现了Serialiable可序列化接口，就要有一个可序列化ID
	 * 1.3 serialPersistentFields[] StringBuffer的可序列化字段
 * 2.三个继承自父类AbstractStringBuilder的域
	 * 2.1 value[] 这是StringBuffer存放缓存的字符数组，继承自父类，在父类中是默认访问权限，但两个类都在lang包里,
	 *     因此在StringBuffer内可以直接访问value[]
	 * 2.2 count 这是value[]内已有的字符个数，也是默认访问权限
	 * 2.3 MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8 用于制约缓存区的最大值，部分虚拟机在数组中保留了一些头字，因此-8
	 *     若缓存区大小超出MAX_ARRAY_SIZE，会报 OutOfMemoryError: Requested array size exceeds VM limit
 * 3. 凡是涉及到线程安全的函数，均用关键字synchronized修饰：
	 * 节选自StringBuffer源码的注释
	 * String buffers are safe for use by multiple threads. The methods
	 * are synchronized where necessary so that all the operations on any
	 * particular instance behave as if they occur in some serial order
	 * that is consistent with the order of the method calls made by each of
	 * the individual threads involved.
 */
@SuppressWarnings({"all"})
public class StringBufferIntro{
	public static void main(String[] args){
/*1. String 转化为 StringBuffer */
		String string = "you";

		StringBuffer stringBuffer1 = new StringBuffer(string);
		System.out.println(stringBuffer1.capacity());//缓存区value[]的真正长度 16 + 3 = 19
		System.out.println(stringBuffer1.length());//缓存区内字符长度 count = 3

		StringBuffer stringBuffer2 = new StringBuffer();
		stringBuffer2 = stringBuffer2.append(string);//其实第一种也是调用append，不同的是，第一种方式会先扩容，再append
		System.out.println(stringBuffer2.capacity());//默认count = 16
		System.out.println(stringBuffer2.length());//3

/*2. StringBuffer 转化为 String*/
		StringBuffer stringBuffer = new StringBuffer("who");//count = 3, capacity = 19

		String string1 = new String(stringBuffer);//会只取字符部分，空容量不会放入字符串
		String string2 = stringBuffer.toString();//自然是取得toStringCache[]内的，也就是count个字符


	}//end main
}
