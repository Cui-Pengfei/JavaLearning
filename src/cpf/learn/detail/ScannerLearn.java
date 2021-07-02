package cpf.learn.detail;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * @author CPF 创建于： 2021/6/13 20:50
 * Scanner学习：
 * 1.Scanner的构造器可以接收任何类型的输入对象，包括File对象、InputString、String
 * 2.所有的输入、分词、翻译的操作都隐藏在不同类型的next方法中
 * 3.所有的基本类型（除了char）都有对应的next方法
 * 4.普通的next()方法返回可读输入流的下一个String
 * 5.所有的next只有找到一个完整的分词之后才会返回
 * 6.分词的默认定界符是【空格】，也可以设置自定义的定界符
 * 7.自定义定界符：scanner.useDelimiter("\\s*,\\s*"); 表示定界符自定义为【,】，注意中英文
 * 8.分词的意思是，一个特定类型的、可识别的 数据
 * 8.各类型的hasNext()函数都只会寻找定界符后一位是否还是对应类型，不会跳着检测输出
 * 9.未完待续...
 */
public class ScannerLearn{
	public static void main(String[] args) throws IOException{
		/*7*/delimiter();
		///*8*/departElement();
	}

	public static void delimiter() throws IOException{//Scanner的定界符
		InputStream in = System.in;
		Scanner scanner1 = new Scanner(in);
		scanner1.useDelimiter("\\s*,\\s*");
		while(scanner1.hasNext()){
			System.out.println(scanner1.next());
		}
		in.close();
		//整个Scanner过程中必须得到InputStream类型的整个System.in的支持，不可以提前关闭
	}

	public static void departElement(){
		Scanner scanner = new Scanner("123 456 abc 1.2 3.3 dog4 1 gdc 89 ");
		while(scanner.hasNext()){
			if(scanner.hasNextInt()) System.out.println(scanner.nextInt());
			if(scanner.hasNext()) System.out.println(scanner.next());
			if(scanner.hasNextFloat()) System.out.println(scanner.nextFloat());
			if(scanner.hasNextDouble()) System.out.println(scanner.nextDouble());
		}
	}

}
