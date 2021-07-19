package cpf.learn.chapter17.outputStream.objectOutputStream;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author CPF 创建于： 2021/7/13 10:18
 * @version 1.0
 * 对象输出流，目的是把数据值、数据类型都保存起来，这就叫序列化，以期待将来的反序列化.
 */
public class ObjectOutputStream_{

	@Test
	public void synchronized_() throws IOException{
		String path = "src/cpf/learn/chapter17/outputStream/" +
				"objectOutputStream/content.txt";
		File file = new File(path);

		ObjectOutputStream oos = null;

		try{
			oos = new ObjectOutputStream(new FileOutputStream(file));

			oos.writeInt(100);
			oos.writeUTF("崔鹏飞");
			oos.writeChar('男');
			//包含一个transient值0.8，一个static值"黄色"
			oos.writeObject(new Dog("大黄", 3, 0.8, "黄色"));

		}catch(IOException e){
			e.printStackTrace();
		}finally{
			if(oos != null){
				oos.close();
			}
		}

	}

}
