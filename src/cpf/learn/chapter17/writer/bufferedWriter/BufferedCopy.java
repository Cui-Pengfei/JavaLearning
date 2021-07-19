package cpf.learn.chapter17.writer.bufferedWriter;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @author CPF 创建于： 2021/7/12 19:47
 * @version 1.0
 */
public class BufferedCopy{

	@Test
	public void copyFile() throws IOException{
		File file = new File("E:/IDEA_2020_2_4/IdeaProjects/hsp/src/cpf/learn/" +
				"chapter17/bufferedReader/read.txt");
		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;
		File copy = new File("E:/IDEA_2020_2_4/IdeaProjects/hsp/src/cpf/learn/" +
				"chapter17/bufferedWriter/copy.txt");

		try{
			bufferedReader = new BufferedReader(new FileReader(file));
			bufferedWriter = new BufferedWriter(new FileWriter(copy));
			String line;

			while((line = bufferedReader.readLine()) != null){
				bufferedWriter.write(line);
				bufferedWriter.newLine();
			}

		}catch(FileNotFoundException e){
			System.out.println("打开文件异常：" + e);
		}finally{
			if(bufferedReader != null){
				bufferedReader.close();
			}
			if(bufferedWriter != null){
				bufferedWriter.close();
			}
		}
	}
}
