package cpf.learn.chapter17.transformation;

import org.junit.jupiter.api.Test;
import sun.nio.cs.ext.GBK;

import java.io.*;

/**
 * @author CPF 创建于： 2021/7/13 11:48
 * @version 1.0
 */
public class FileReaderDiff{

	/**
	 *如果仅仅使用FileReader，那么默认使用的就是UTF-8来处理读进来的字节流.
	 * 因此，必须使用FileReader的父类InputStreamReader来指定编码类型.
	 * @throws IOException
	 */
	@Test
	public void readByDefault() throws IOException{
		String path = "src/cpf/learn/chapter17/transformation/我是UTF-8编码.txt";
		File gbkFile = new File(path);

		FileReader fileReader = null;

		try{
			char[] buffer = new char[10];
			int readLen;
			fileReader = new FileReader(gbkFile);
			while((readLen = fileReader.read(buffer)) != -1){
				System.out.println(new String(buffer, 0, readLen));
			}

		}catch(FileNotFoundException e){
			System.out.println("打开文件异常" + e);
		}finally{
			if(fileReader != null){
				fileReader.close();
			}
		}
	}

	/**
	 * 使用GBK编码模式来组织读取到的字节流，自然能够正确读取GBK的文件
	 * @throws IOException
	 */
		@Test
		public void readByTransform() throws IOException{
			String path = "E:/IDEA_2020_2_4/IdeaProjects/hsp/src/" +
					"cpf/learn/chapter17/transformation/我是GBK编码.txt";
			File gbkFile = new File(path);

			InputStreamReader isr = null;

			try{
				char[] buffer = new char[10];
				int readLen;
				isr = new InputStreamReader(new FileInputStream(gbkFile),new GBK());
				while((readLen = isr.read(buffer)) != -1){
					System.out.println(new String(buffer, 0, readLen));
				}

			}catch(FileNotFoundException e){
				System.out.println("打开文件异常" + e);
			}finally{
				if(isr != null){
					isr.close();
				}
			}

	}
}
