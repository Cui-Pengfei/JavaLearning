package cpf.learn.chapter15;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author CPF 创建于： 2021/6/30 4:46
 */
public class Homework01{
	public static void main(String[] args){
		User jack = new User(1, "jack", 12);
		User mary = new User(2, "mary", 18);
		User tom = new User(3, "tom", 17);
		User smith = new User(4, "smith", 22);

		DAO<User> dao = new DAO<>();
		dao.save("001", jack);
		dao.save("002", mary);
		dao.save("003", tom);
		dao.save("004", smith);

		System.out.println(dao.coll());
	}//end main
}

class DAO<T>{
	private Map<String,T> map = new HashMap<>();

	public void save(String id ,T entity){
		map.put(id,entity);
	}

	public T get(String id){
		return map.get(id);
	}

	public void update(String id, T entity){
		map.replace(id, entity);
	}

	public Collection<T> coll(){
		return map.values();
	}

	public void delete(String id){
		map.remove(id);
	}
}//end DAO

class User{
	private int id;
	private String name;
	private int age;

	public User(int id, String name, int age){
		this.id = id;
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString(){
		return "\nUser{" +
				"id=" + id +
				", name='" + name + '\'' +
				", age=" + age +
				'}';
	}
}
