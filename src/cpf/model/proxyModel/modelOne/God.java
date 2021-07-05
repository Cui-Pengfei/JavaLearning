package cpf.model.proxyModel.modelOne;

/**
 * @author CPF 创建于： 2021/7/3 9:07
 * @version 1.0
 */
public abstract class God implements Magical{
	//不实现Magical内的magic方法，全部留给子类去实现

	public void source(){//该方法模拟的是底层代码或奇缺的资源吗，独此一份
		magic();//魔法要有能量源
	}
}
