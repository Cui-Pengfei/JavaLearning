package cpf.model.decoratorPattern;

/**
 * @author CPF 创建于： 2021/7/12 18:48
 * @version 1.0
 */
public abstract class Coffee{
	private double price;
	private String material;

	public double cost(){
		return price;
	}

	public String material(){
		return material;
	}

	public double getPrice(){
		return price;
	}

	public void setPrice(double price){
		this.price = price;
	}

	public String getMaterial(){
		return material;
	}

	public void setMaterial(String material){
		this.material = material;
	}

	@Override
	public String toString(){
		return "Coffee{" +
				"price=" + price +
				", material='" + material + '\'' +
				'}';
	}
}
