package cpf.learn.oop.homework.hwk02;

/**
 * 人类
 */
public class Person{
	private String name;
	private int age;
	private String job;

	public static void main(String[] args){

		Person[] pArray = {
				new Person("jack", 23, "实习生"),
				new Person("mary", 20, "员工"),
				new Person("Tom", 33, "主管")
		};
		Person temp;//临时交换量
		boolean isOrdered = true;//冒泡排序优化
		for(int i = 0; i < pArray.length - 1; i++){
			for(int j = 0; j < pArray.length - 1 - i; j++){
				if(pArray[j].getAge() < pArray[j + 1].getAge()){//大的排在后面
					temp = pArray[j];
					pArray[j] = pArray[j + 1];
					pArray[j + 1] = temp;
					isOrdered = false;
				}
			}
			if(isOrdered){
				break;//如果某一次没有交换任何数据，说明数列已经是有序的了
			}
		}

		for(Person person : pArray){
			System.out.println(person.toString());
		}

	}//main方法测试

	@Override
	public String toString(){
		return "Person{" +
				"name='" + name + '\'' +
				", age=" + age +
				", job='" + job + '\'' +
				'}';
	}

	//constructor
	public Person(){
	}

	public Person(String name, int age, String job){
		this.name = name;
		this.age = age;
		this.job = job;
	}

	//get\set
	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public int getAge(){
		return age;
	}

	public void setAge(int age){
		this.age = age;
	}

	public String getJob(){
		return job;
	}

	public void setJob(String job){
		this.job = job;
	}
}
