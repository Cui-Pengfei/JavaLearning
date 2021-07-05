package cpf.model.proxyModel;

/**
 * @author CPF 创建于： 2021/7/3 9:28
 * @version 1.0
 */
public class God implements Magical{

	private Magical target = null;//God要在自己的血脉中加一个定向

	public God(){
	}

	public God(Magical target){//接收一个凡人
		this.target = target;
	}

	/**
	 * 规定魔法必须经由God的source方法才可以施展.
	 * 此处的source模拟的是有限的资源，不可复制与再生.
	 */
	public void source(){
		magic();
	}

	public void magic(){
		//由于稀缺资源source中会调用到本方法，本方法必须与凡人的魔法联系
		if(target != null){
			target.magic();
		}
	}
}
