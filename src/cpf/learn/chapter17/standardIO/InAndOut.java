package cpf.learn.chapter17.standardIO;

/**
 * @author CPF 创建于： 2021/7/13 11:17
 * @version 1.0
 */
public class InAndOut{
	public static void main(String[] args){
		/*
		in的编译类型是InputStream，运行类型是BufferedInputStream，
		System中语句 setIn0(new BufferedInputStream(fdIn));使得System通过修饰类BufferedInputStream来操作字节输入流
		>>>>>>操作的节点是键盘
		*/
		System.out.println(System.in.getClass());//class java.io.BufferedInputStream

		/*
		out的编译类型和运行类型都是PrintStream，表示打印到显示器，这表示此节点流的节点是显示器；
		>>>>>>操作的节点是显示器
		*/
		System.out.println(System.out.getClass());//class java.io.PrintStream
	}
}
