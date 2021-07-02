package cpf.learn.chapter13.string;

import java.io.Serializable;

/**
 * @author CPF 创建于： 2021/6/15 19:37
 * String的轮廓介绍：
 * 1. String继承自Object,实现了Serializable、Comparable、CharSequence接口
 * 2. 实现Serializable，说明String可串行化，意思是可以在网络上传输
 * 3. 实现Comparable,说明String对象可以比较
 * 4. 字符串常量是【双引号包起来的字符串】，指向字符串常量的引用是变量
 * 5. 字符串的字符使用Unicode编码，一个字符占两个字节
 * 6. String有非常多构造器，它实现了构造器的重载
 *    常用的有String() String(String) String(char[]) String(char[],int,int)
 *           String(byte[]) String(byte[],int,int)
 * 7. String是final类，不能被其他类继承
 * 8. String有一个field是 private final char value[];用于存放字符串的内容
 * 9. 注意上述的value[]是一个final变量，是不可修改的；
 *    要理解【不可修改】是需要功力的，value是一个cahr[]类型的，也就是一个数组引用，
 *    即value的栈类型是一个地址变量，它被final修饰，就是说value只能指向那一片地址！
 *    但是那一片数组地址的每个字符都是可以改变的
 *    String name = "jack";理解 栈变量name 与 堆中String对象"jack"的域value，就算通透了
 *
 */
public class StringIntro{
	public static void main(String[] args){
		//理解 9. 中内容
		final char value[] = {'j','a','c','k'};
		//value = new char[]{'m','a','r','y'};//不能指向新的地址
		value[0] = 'm';//修改那个不变地址内的每个字符都是可以的

	}
}
