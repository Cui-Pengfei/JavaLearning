package cpf.learn.chapter17.inputStream.objectInputStream;

import cpf.learn.chapter17.outputStream.objectOutputStream.Dog;
import cpf.learn.chapter17.outputStream.objectOutputStream.ObjectOutputStream_;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @author CPF 创建于： 2021/7/13 10:32
 * @version 1.0
 */
public class ObjectInputStream_{

	@Test
	public void deSynchronized_() throws IOException{

		String path = "src/cpf/learn/chapter17/outputStream/" +
				"objectOutputStream/content.txt";
		/*存入文件的后缀不会影响存储以及读取，只是规范是.bat，还是遵循规范比较好*/
		File file = new File(path);

		ObjectInputStream ois = null;

		try{
			ois = new ObjectInputStream(new FileInputStream(file));

			System.out.println(ois.readInt());
			System.out.println(ois.readUTF());
			System.out.println(ois.readChar());
			Object dog = ois.readObject();
			System.out.println(dog);




		}catch(IOException | ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			if(ois != null){
				ois.close();
			}
		}


	}
}
