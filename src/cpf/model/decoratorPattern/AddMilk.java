package cpf.model.decoratorPattern;

/**
 * @author CPF 创建于： 2021/7/12 19:02
 * @version 1.0
 */
public class AddMilk extends Decorator{

	public AddMilk(Coffee coffee){
		double price = coffee.getPrice() + 1;
		setPrice(price);

		String material = coffee.getMaterial() + "+milk";
		setMaterial(material);
	}
}
