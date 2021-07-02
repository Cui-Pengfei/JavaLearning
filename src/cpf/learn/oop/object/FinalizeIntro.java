package cpf.learn.oop.object;

/**
 * 当垃圾回收器确定不存在对该对象的更多引用时，
 * 由对象的垃圾回收器调用此方法。子类重写 finalize 方法，
 * 以配置系统资源或执行其他清除。
 *
 *      我们平时几乎不会使用该方法，只为了应付面试...
 */
public class FinalizeIntro{
	public static void main(String[] args){
		Car car = new Car("宝马");

		car = null;//置空后对象就变成垃圾就会被JVM回收，会调用到finalize

		//垃圾回收机制的调用由JVM来决定，他有自己的GC算法，什么时候调用这个机制是不知道的
		//但是也可以用System.gc()主动触发垃圾回收机制
		//但是也不能保证100%响应，就像叫保洁阿姨来打扫卫生，保洁阿姨可能很忙没空搭理你...
		System.gc();//并不会造成阻塞，不是说一定要等到来回收才结束程序

		System.out.println("程序退出了...");
	}
}

class Car{
	public String name;

	public Car(String name){
		this.name = name;
	}


	@Override
	protected void finalize() throws Throwable{
		System.out.println("我们销毁了" + name + "...");
		super.finalize();
		System.out.println("垃圾已回收...");
	}
}
