package cpf.learn.chapter10.exercise;
/**
 * @author CPF 创建于： 2021/6/11 21:29
 */
public class Exercise06{
	public static void main(String[] args){
		Person tang = new Person("唐僧", new Horse());
		tang.normal();
		tang.passRiver();
		tang.passFireMountain();
	}//end main
}

interface Vehicles{//交通工具接口
	void work();
}

class Horse implements Vehicles{//马
	@Override
	public void work(){
		System.out.println("通常骑马前进...");
	}
}

class Boat implements Vehicles{//船
	@Override
	public void work(){
		System.out.println("遇见河流要坐船...");
	}
}

class Plane implements Vehicles{
	@Override
	public void work(){
		System.out.println("过火焰山要坐飞机...");
	}
}

class Factory{//工厂类
	private static Horse horse;//单例模式：懒汉式

	public static Horse getHorse(){
		if(horse == null){//只有第一次才会创建一个对象
			horse = new Horse();
		}
		return horse;
	}

	public static Boat getBoat(){
		return new Boat();
	}

	public static Plane getPlane(){
		return new Plane();
	}
}

class Person{//人类
	private String name;
	private Vehicles vehicles;

	public Person(String name, Vehicles vehicles){
		this.name = name;
		this.vehicles = vehicles;
	}

	public void passRiver(){
		if(!(vehicles instanceof Boat)){//这句话两层含义：为空、不是船
			vehicles = Factory.getBoat();
		}
		vehicles.work();
	}

	public void passFireMountain(){
		if(!(vehicles instanceof Plane)){
			vehicles = Factory.getPlane();
		}
		vehicles.work();
	}

	public void normal(){
		if(!(vehicles instanceof Horse)){//这句话两层含义：为空、不是马
			vehicles = Factory.getHorse();
		}
		vehicles.work();
	}

	//get\set
	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public Vehicles getVehicles(){
		return vehicles;
	}

	public void setVehicles(Vehicles vehicles){
		this.vehicles = vehicles;
	}
}
