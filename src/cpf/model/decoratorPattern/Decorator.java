package cpf.model.decoratorPattern;

/**
 * @author CPF 创建于： 2021/7/12 18:56
 * @version 1.0
 */
public abstract class Decorator extends Coffee{

	protected  Coffee coffee;

	public Decorator(){
	}

	public Decorator(Coffee coffee){
		this.coffee = coffee;
	}
}
