package cpf.learn.chapter17.exercise;

import java.io.*;

/**
 * @author CPF 创建于： 2021/7/14 17:59
 * @version 1.0
 */
public class ReadAndNumber{
	public static void main(String[] args) throws IOException{
		File file = new File("D:\\桌面\\快捷键.txt");
		File numberFile = new File("D:\\桌面\\快捷键编号.txt");


		BufferedReader br = null;
		BufferedWriter bw = null;

		try{
			br = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(file),"gbk"));
			bw = new BufferedWriter(new FileWriter(numberFile));
			String line = "";
			int lineNumber = 0;
			while((line = br.readLine()) != null){
				if(!line.equals("")){//有内容才编号
					lineNumber++;
					if(lineNumber < 10){
						line = lineNumber + ".  " + line;
					}else{
						line = lineNumber + ". " + line;
					}

				}

				System.out.println(line);
				bw.write(line);
				bw.newLine();
			}
		}catch(FileNotFoundException e){
			System.out.println("打开文件异常：" + e);
		}finally{
			if(br != null)
				br.close();
			if(bw != null)
				bw.close();
		}
	}
}
