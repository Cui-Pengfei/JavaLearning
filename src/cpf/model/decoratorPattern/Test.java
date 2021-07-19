package cpf.model.decoratorPattern;

/**
 * @author CPF 创建于： 2021/7/12 19:03
 * @version 1.0
 */
public class Test{
	public static void main(String[] args){
		Coffee coffee = new OriginalCoffee();
		System.out.println(coffee);

		coffee = new AddSugar(coffee);
		System.out.println(coffee);

		coffee = new AddMilk(coffee);
		System.out.println(coffee);

	}
}
