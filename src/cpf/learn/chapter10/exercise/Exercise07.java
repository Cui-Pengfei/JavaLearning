package cpf.learn.chapter10.exercise;

/**
 * @author CPF 创建于： 2021/6/12 1:04
 */
public class Exercise07{
	public static void main(String[] args){
		Car car1 = new Car(-12);
		car1.airCondition();

		Car car2 = new Car(24);
		car2.airCondition();

		Car car3 = new Car(41);
		car3.airCondition();

	}//end main
}

class Car{
	private double temperature;

	private class Air{
		public void flow(){
			if(temperature > 40){
				System.out.println("吹冷风~~~");
			}else if(temperature < 0){
				System.out.println("吹暖气~~~");
			}else{
				System.out.println("空调关闭中...");
			}
		}
	}//end Air

	public void airCondition(){
		new Air().flow();
	}

	public Car(double temperature){
		this.temperature = temperature;
	}
}
