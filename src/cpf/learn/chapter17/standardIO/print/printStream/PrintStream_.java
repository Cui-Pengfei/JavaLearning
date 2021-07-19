package cpf.learn.chapter17.standardIO.print.printStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

/**
 * @author CPF 创建于： 2021/7/13 13:31
 * @version 1.0
 */
public class PrintStream_{
	public static void main(String[] args)
			throws FileNotFoundException, UnsupportedEncodingException{

		/*
		由于System类有一个静态初始化器，调用一个native方法，
		JVM借助该方法调用 initializeSystemClass()方法输出化System类，
		使得in默认指向节点键盘，out默认指向节点屏幕.
		 */
		PrintStream out = System.out;
		out.println("你是谁？");

		File file = new File("src/cpf/learn/chapter17/print/printStream/GBK文件.txt");

		/*通过setOut()方法可以改变打印节点，
		虽然setOut()方法只接受PrintStream类型的，但是PrintStream却存在大量构造器，
		可以接受的参数包括两大类：
			一类是输出的目的地，可以是：文件、字节输出流、文件路径
			一类是输出的编码格式,可以是：String表示的编码（"gbk"……）、CharSet子类("GBK"……)，没有编码默认就是 utf-8
		*/
		System.setOut(new PrintStream(file,"gbk"));

		System.out.println("我是GBK编码内容！！！");

		System.out.close();


	}
}
