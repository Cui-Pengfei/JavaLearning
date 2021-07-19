package cpf.learn.chapter17.writer.bufferedWriter;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @author CPF 创建于： 2021/7/12 19:54
 * @version 1.0
 */
public class CopyJPG{
	public static void main(String[] args) throws IOException{
		File picture = new File("F:/Pictures/girl.jpg");
		File copy = new File("E:/girlCopy.jpg");

		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;

		try{
			char[] buffer = new char[1024];
			bufferedReader = new BufferedReader(new FileReader(picture));
			bufferedWriter = new BufferedWriter(new FileWriter(copy));

			while(bufferedReader.read(buffer) != -1){
				bufferedWriter.write(buffer);
			}

		}catch(FileNotFoundException e){
			System.out.println("图片文件打开异常：" + e);
		}finally{
			if(bufferedReader != null){
				bufferedReader.close();
			}
			if(bufferedWriter != null){
				bufferedWriter.close();
			}
		}
	}//end main

	/**
	 * 操作图片视频等非字符文件时，最好用字节流来读取和写入.
	 * @throws IOException 抛出IO异常.
	 */
	@Test
	public void rightCopy() throws IOException{
		File picture = new File("F:/Pictures/girl.jpg");
		File copy = new File("E:/girlCopy.jpg");

		BufferedInputStream bin = null;
		BufferedOutputStream bout = null;

		try{
			byte[] buffer = new byte[1024];
			bin = new BufferedInputStream(new FileInputStream(picture));
			bout = new BufferedOutputStream(new FileOutputStream(copy));

			while(bin.read(buffer) != -1){
				bout.write(buffer);
			}

		}catch(FileNotFoundException e){
			System.out.println("图片文件打开异常：" + e);
		}finally{
			if(bin != null){
				bin.close();
			}
			if(bout != null){
				bout.close();
			}
		}
	}
}
