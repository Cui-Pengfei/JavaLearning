package cpf.learn.chapter19.interface_;

/**
 * @author CPF 创建于： 2021/7/29 16:48
 * @version 1.0
 */
public interface Usb{
	int id = 1;
	String name = "cpf";
	char gender = '男';


	void insertTo();

	default void sayHello(){
		System.out.println("hello!");
	}

	static void hi(){
		System.out.println("hi");
	}
}
