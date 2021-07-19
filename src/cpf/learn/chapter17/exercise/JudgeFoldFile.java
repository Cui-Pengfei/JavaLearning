package cpf.learn.chapter17.exercise;

import com.sun.xml.internal.fastinfoset.util.CharArray;
import cpf.learn.chapter17.reader.fileReader.FileReader_;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author CPF 创建于： 2021/7/14 17:32
 * @version 1.0
 * 判断mytemp文件夹是否存在，如果不存在就创建之；
 * 如果存在就判断文件夹下是否有hello.txt文件，如果有，检查其中内容是否包括是hello,world!
 * 如果不是就写入覆盖之，如果没有文件就创建之，并写入hello,world!
 */
public class JudgeFoldFile{
	public static void main(String[] args) throws IOException{
		File fold = new File("e:\\mytemp");
		File file = new File(fold, "hello.txt");

		if(fold.exists()){
			System.out.println("e盘下已存在文件夹mytemp");
		}else{
			fold.mkdirs();
			System.out.println("e盘下不存在文件夹mytemp，现在已创建");
		}

		boolean isNew = false;
		if(file.exists()){
			System.out.println("hello.txt文件已存在");
		}else{
			file.createNewFile();
			System.out.println("hello.txt文件不存在，现已创建之");
			isNew = true;
		}

		FileWriter fileWriter = new FileWriter(file);
		if(isNew){
			fileWriter.write("hello,world!");
			System.out.println("已在新创建文件中写入内容！");
		}else{//不是新建内容，就要检测其中内容
			FileReader fileReader = new FileReader(file);
			char[] buffer = new char[20];
			int readLen;
			String content = "";
			while((readLen = fileReader.read(buffer)) != -1){
				content += new String(buffer, 0, readLen);
			}
			fileReader.close();
			if(content.contains("hello,world!")){
				System.out.println("文件中已包含要写入的内容，故不写入！");
			}else{
				fileWriter.write("hello,world!");
				System.out.println("文件中没有指定内容，现已覆盖写入！");
			}
		}
		fileWriter.close();
		System.out.println("所有操作完毕！");
	}
}
