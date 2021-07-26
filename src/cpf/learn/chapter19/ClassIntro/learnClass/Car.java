package cpf.learn.chapter19.ClassIntro.learnClass;

public class Car{
	public String name;
	public String color;
	public double price;

	static {
		System.out.println("Car初始化...");
	}

	@Override
	public String toString(){
		return "Car{" +
				"name='" + name + '\'' +
				", color='" + color + '\'' +
				", price=" + price +
				'}';
	}
	//constructor
	public Car(){
	}
	public Car(String name, String color, double price){
		this.name = name;
		this.color = color;
		this.price = price;
	}

	//get\set
	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getColor(){
		return color;
	}

	public void setColor(String color){
		this.color = color;
	}

	public double getPrice(){
		return price;
	}

	public void setPrice(double price){
		this.price = price;
	}
}

