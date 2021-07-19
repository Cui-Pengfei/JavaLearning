package cpf.learn.chapter17.reader.fileReader;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author CPF 创建于： 2021/7/11 20:22
 * @version 1.0
 *
 */
public class FileReader_{
	public static void main(String[] args) throws IOException{
		new FileReader_().readLanguage();
	}


	/**
	 * 读取不同语言，都可以成功，我们知道不同语言存储的字节数不一样，依靠StreamDecoder解码器，
	 * reader可以成功解析出字符内容，具体底层实现，还没有深究.
	 * @throws IOException
	 */
	@Test
	public String  readLanguage() throws IOException{
		String path = "src/cpf/learn/chapter17/reader/fileReader/source.txt";
		File file = new File(path);
		FileReader fileReader = null;

		char[] buffer = new char[10];
		int readLen;
		String result = "";

		try{
			fileReader = new FileReader(file);
			while((readLen = fileReader.read(buffer)) != -1){
				System.out.println("读取字符个数：" + readLen);
				System.out.println(new String(buffer, 0, readLen));
				result += new String(buffer, 0, readLen);
			}
		}catch(FileNotFoundException e){
			System.out.println("读取文件异常：" + e);
		}finally{
			if(fileReader == null){
				System.out.println("没有打开相应文件");
			}else{
				fileReader.close();
			}
		}

		System.out.println("总共读取到的数据如下：");
		System.out.println(result);
		return result;
	}
}


























