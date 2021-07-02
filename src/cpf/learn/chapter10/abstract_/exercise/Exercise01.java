package cpf.learn.chapter10.abstract_.exercise;

import cpf.learn.oop.poly.Master;

/**
 * 员工：包括经理、普通工人
 */
public class Exercise01{
	public static void main(String[] args){
		Manager manager = new Manager("Jack", "123456", 20000, 10000);
		Worker worker = new Worker("Bob", "234567", 10000);
		manager.work();
		worker.work();

	}//end main
}//end class

abstract class Employee{
	private String name;
	private String id;
	private double salary;

	public abstract void work();

	//constructor
	public Employee(){
	}
	public Employee(String name, String id, double salary){
		this.name = name;
		this.id = id;
		this.salary = salary;
	}

	//get\set
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getId(){
		return id;
	}
	public void setId(String id){
		this.id = id;
	}
	public double getSalary(){
		return salary;
	}
	public void setSalary(double salary){
		this.salary = salary;
	}
}

class Worker extends Employee{
	@Override
 	public void work(){
		System.out.println("普通员工" + getName() + "正在工作中....");
	}
	//constructor
	public Worker(){
	}
	public Worker(String name, String id, double salary){
		super(name, id, salary);
	}
}

class Manager extends Employee{
	private double bonus;

	@Override
	public void work(){
		System.out.println("经理" + getName() + "正在工作中...");
	}

	//constructor
	public Manager(){
	}
	public Manager(String name, String id, double salary, double bonus){
		super(name, id, salary);
		this.bonus = bonus;
	}

	//get\set
	public double getBonus(){
		return bonus;
	}
	public void setBonus(double bonus){
		this.bonus = bonus;
	}
}
