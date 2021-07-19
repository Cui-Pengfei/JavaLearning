package cpf.model.decoratorPattern;

/**
 * @author CPF 创建于： 2021/7/12 18:55
 * @version 1.0
 */
public class AddSugar extends Decorator{

	public AddSugar(Coffee coffee){
		double price = coffee.getPrice() + 2;
		setPrice(price);

		String material = coffee.getMaterial() + "+sugar";
		setMaterial(material);
	}
}
