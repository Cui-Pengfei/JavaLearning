package cpf.learn.chapter17.transformation;

import org.junit.jupiter.api.Test;
import sun.nio.cs.ext.GBK;

import java.io.*;

/**
 * @author CPF 创建于： 2021/7/13 12:47
 * @version 1.0
 */
public class OutputStreamWriter_{

	@Test
	public void writeIntoGbkFile() throws IOException{
		String path = "E:/IDEA_2020_2_4/IdeaProjects/hsp/src/" +
				"cpf/learn/chapter17/transformation/我是GBK编码.txt";
		File gbkFile = new File(path);

		String content = "\n这是写入GBK文件的内容";

		OutputStreamWriter osw = new OutputStreamWriter
				(new FileOutputStream(gbkFile, true), new GBK());
		osw.write(content);
		osw.close();


	}

	@Test
	public void writeIntoGbkFileByBuffer() throws IOException{
		String path = "src/cpf/learn/chapter17/transformation/我是GBK编码.txt";
		File gbkFile = new File(path);

		String content = "\n这是通过BufferedWriter写入GBK文件的内容";

		BufferedWriter bw = new BufferedWriter(
								new OutputStreamWriter(
									new FileOutputStream(gbkFile, true)
								)
							);
		bw.write(content);
		bw.close();


	}

}
