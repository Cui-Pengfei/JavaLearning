package cpf.learn.chapter17.writer;

import cpf.learn.chapter17.reader.fileReader.FileReader_;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author CPF 创建于： 2021/7/11 20:45
 * @version 1.0
 * <p>
 * 写入文件注意事项：
 * 1.必须close或者flush才可以把内容写入文件
 * 2.写入的核心就在这个close\flush方法中，其中核心的核心是如何将char[]按照编码规则转化为byte，
 *      毕竟最后还是调用的OutputStream的write(byte[] b)方法
 */
public class FileWriter_{

	/**
	 * 把读取到的不同语言文字再写入一个文件.
	 */
	@Test
	public void writeLanguage() throws IOException{
		FileReader_ fileReader_ = new FileReader_();
		String content = "";
		try{
			content = fileReader_.readLanguage();
		}catch(IOException e){
			System.out.println("读取内容失败" + e);
		}

		String path = "src/cpf/learn/chapter17/writer/receive.txt";
		FileWriter fileWriter = null;

		char[] turn = new char[content.length()];

		try{
			fileWriter = new FileWriter(path);
			fileWriter.write(content);//三种写入方式
			fileWriter.write(content.toCharArray());
			content.getChars(0, content.length(), turn, 0);
			fileWriter.write(turn, 0, 4);
		}catch(IOException e){
			System.out.println("写入文件失败！\n" + e);
		}finally{
			if(fileWriter == null){
				System.out.println("打开写入文件失败！");
			}else{
				fileWriter.close();
				//fileWriter.flush();
			}

		}


	}

}
