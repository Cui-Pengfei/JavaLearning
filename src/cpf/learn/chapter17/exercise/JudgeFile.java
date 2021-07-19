package cpf.learn.chapter17.exercise;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author CPF 创建于： 2021/7/14 12:10
 * @version 1.0
 * 判断e盘下是否有文件hello.txt，如果没有就创建该文件，并写入hello,world!
 */
public class JudgeFile{
	public static void main(String[] args) throws IOException{
		File file = new File("e:/hello.txt");

		if(file.exists()){
			System.out.println("e盘下已有该文件");
		}else{
			file.createNewFile();
			System.out.println("e盘下没有该文件，已经创建成功！");
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write("hello,world!");
			fileWriter.close();
			System.out.println("成功写入内容！");
		}
	}
}
