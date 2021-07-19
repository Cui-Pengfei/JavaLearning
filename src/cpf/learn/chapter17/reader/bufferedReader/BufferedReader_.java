package cpf.learn.chapter17.reader.bufferedReader;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @author CPF 创建于： 2021/7/12 19:37
 * @version 1.0
 */
public class BufferedReader_{

	@Test
	public void readFile() throws IOException{

		File file = new File("src/cpf/learn/chapter17/reader/bufferedReader/read.txt");
		BufferedReader bufferedReader = null;

		try{
			bufferedReader = new BufferedReader(new FileReader(file));
			String line;

			while((line = bufferedReader.readLine()) != null){
				System.out.println(line);
			}

		}catch(FileNotFoundException e){
			System.out.println("打开文件异常：" + e);
		}finally{
			if(bufferedReader != null){
				bufferedReader.close();
			}
		}

	}

}
