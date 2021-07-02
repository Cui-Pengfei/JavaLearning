package cpf.learn.chapter14.map_.hashMap;

import java.util.HashMap;
import java.util.Objects;

/**
 * @author CPF 创建于： 2021/6/26 11:04
 */
@SuppressWarnings({"all"})
public class HashMapMethod{
	public static void main(String[] args){
		//看一下HashMap填入1000个对象是什么样的
		HashMap hashMap = new HashMap();

		int loop = 1000;
		for(int i = 0; i < loop; i++){
			hashMap.put(new Fish(i), i);
		}
		System.out.println(hashMap);

	}//end main
}
class Fish{
	private int id;

	public Fish(int id){
		this.id = id;
	}

	@Override
	public String toString(){
		return "Fish-" + id;
	}

	@Override
	public int hashCode(){
		return 100;
	}
}
