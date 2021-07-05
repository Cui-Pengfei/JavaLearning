package cpf.learn.chapter16.syncronized_;

/**
 * @author CPF 创建于： 2021/7/4 13:12
 * @version 1.0
 * 1. java语言中引入了对象互斥锁的概念，来保证共享数据操作的完整性
 *      （多个进程操作一个对象的时候，对象互斥锁可以保证一个时刻只有一个进程访问该对象数据）
 * 2. 每个对象都对应有一个互斥锁的标记，在地址空间上是一个位
 * 3. 关键字synchronized来与对象的互斥锁联系，当某个对象用synchronized修饰的时候，
 *      表明该对象在任一时刻，只能有一个线程访问
 * 4. 同步的局限性：程序的执行效率降低
 * 5. 同步方法（非静态的）的锁可以是this,也可以是其他对象，但要保证是同一个对象
 * 6. 同步方法（静态的）的锁，加在Class.class本类的类对象上
 *
 * 注意事项：
 * > 同步方法没有使用static修饰时，默认锁对象是this
 * > 同步方法是静态方法，默认对象锁是 当前类.class
 * > 当线程继承的是Thread的时候，要使用普通的对象锁，必须在构建线程的时候，往构造器内传一个共有对象
 *
 */
public class Synchronized_{
	public static void main(String[] args){

	}//end main
}
