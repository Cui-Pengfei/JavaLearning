package cpf.model.proxyModel;

/**
 * @author CPF 创建于： 2021/7/3 9:31
 * @version 1.0
 */
public class Son extends Father implements Magical{

	public void magic(){
		System.out.println("我以凡人之躯，比肩神明！");
	}

	public void source(){//必须通过God的source方法才可以使用魔法
		God god = new God(this);
		god.source();
		/*
		可是这样发出的魔法就不是自己的魔法了，因此必须把自己的信息在构建god时就传给God;
		传过去一个参数，可以调用自己的magic方法，那只能把本对象传进去了；
		可是凡人无穷无尽，难道要在God里面构建无数个构造器吗？
		因此需要让凡人都实现一个Magical接口，God只用构建一个接收Magical接口的构造器即可；
		 */
	}

}
