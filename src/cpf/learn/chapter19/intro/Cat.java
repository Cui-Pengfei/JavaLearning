package cpf.learn.chapter19.intro;

import java.io.Serializable;

/**
 * @author CPF 创建于： 2021/7/22 14:59
 * @version 1.0
 */
public class Cat implements Serializable{
	private String name;
	private final long serialVersionUID = 1L;

	public Cat(){
	}

	public Cat(String name){
		this.name = name;
	}

	public void hi(){
		System.out.println(name + ": hi~");
	}

	public void cry(int times){
		System.out.println(name + ": 喵喵叫！" + times + "次");
	}
}
