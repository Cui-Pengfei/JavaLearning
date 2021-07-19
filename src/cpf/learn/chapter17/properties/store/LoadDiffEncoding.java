package cpf.learn.chapter17.properties.store;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * @author CPF 创建于： 2021/7/14 9:24
 * @version 1.0
 */
public class LoadDiffEncoding{
	public static void main(String[] args) throws IOException{
		Properties properties = new Properties();

		File file = new File("src/cpf/learn/chapter17/" +
				"properties/store/save.properties");
		properties.load(new InputStreamReader(new FileInputStream(file),"gbk"));

		properties.list(System.out);
		System.out.close();

	}

}
