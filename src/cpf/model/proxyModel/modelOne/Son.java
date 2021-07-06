package cpf.model.proxyModel.modelOne;

/**
 * @author CPF 创建于： 2021/7/3 9:13
 * @version 1.0
 */
public class Son extends Father implements Magical{
	@Override
	public void magic(){
		System.out.println("以凡人之躯，比肩神明！");
	}//要学习魔法就得实现接口

	/**
	 * 由于能量源只在God那里，就要求新建一个God对象，调用其source方法；
	 * 但是God此时是一个抽象类，无法实例化，
	 * 则就要求，God的能量源方法必须是静态的.
	 * 那么Magical的方法也必须是静态的，动态绑定就完全失效了，一切都乱套了！
	 */
	@Override
	public void source(){

	}


}
