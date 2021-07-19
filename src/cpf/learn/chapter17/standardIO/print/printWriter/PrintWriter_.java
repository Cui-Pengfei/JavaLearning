package cpf.learn.chapter17.standardIO.print.printWriter;

import java.io.*;

/**
 * @author CPF 创建于： 2021/7/13 17:20
 * @version 1.0
 */
public class PrintWriter_{
	public static void main(String[] args)
			throws IOException{
		String content = "希望我能够以GBK编码的形式写入文件";

		String path = "src/cpf/learn/chapter17/print/printWriter/GBK文件.txt";
		File file = new File(path);

		BufferedWriter bw = new BufferedWriter(new PrintWriter(file, "gbk"));
		bw.write(content);
		bw.close();


	}
}
