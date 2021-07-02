package cpf.learn.debug;

/**
 * 断点调试，看一下类的初始化过程，包含基类、导出类。
 */
public class ClassInitProcess{
	public static void main(String[] args){
		/**
		 * 我们来捋一下这个初始化的过程：
		 *      1. Guitar无参构造器   构造器的作用就是构造对象
		 *      2.将分配到的 Guitar对象空间全置为0.对应效果就是属性都是 0 或者 null
		 *      3.调用父类 Instrument 无参构造器，因为子类构造器第一条语句一定是调用父类构造器，显性或隐性
		 *      4.往上继续调用Object构造器，由于 Object 没有显性构造器，debug 只定位到类名
		 *      5.Object 无属性不需要初始化，回退到 Instrument 无参构造器,
		 ****** 6.Instrument 有一个定义时就初始化的属性 name ，先执行该初始化语句（这个顺序非常重要），
		 *      7.再执行 Instrument 的构造器内语句，此处为 birth = "world";
		 *      8.Instrument 没有其他需要初始化的属性了，回退到 Guitar无参构造器，
		 *      9.Guitar 有一个定义时就初始化的属性 charm ,先执行该初始化语句，
		 *      10.再执行 Guitar无参构造器内其他语句，此处为 name = "guitar"; birth = "Spain";
		 *      11.初始化完毕，对象创建成功
		 *
		 * 思考上述过程，可以得到这样一个警醒：
		 *      >>>假如父类构造器内调用了一个方法，但此方法被子类重写，由于动态绑定机制，
		 *         父类构造器就会调用子类重写的这个方法，子类这个重写的方法恰好使用了子类特有的属性，
		 *         该属性不是基本类型，且在定义时就初始化，但是由于还没有轮到这个初始化语句执行，
		 *         因此，该属性值为 null ,这就可能会导致该重写方法使用此属性时，产生不可预料的错误，
		 *         且该错误在java中无法被编译器发现，且逻辑通畅，因此危害颇大。
		 *      >>>解决办法就是：
		 *          构造器尽量只调用final,static类的方法（private属性final），
		 *          或者父类构造器已经调用的方法，子类就不要重写了。
		 */
		Guitar guitar = new Guitar();
	}
}
//乐器类
class Instrument{
	public String name = "instrument";
	public String birth;

	//两个构造器
	public Instrument(){
		birth = "world";
		//showCharm();  //在此处调用重写的方法，出现了错误...
	}
	public Instrument(String name, String birth){
		this.name = name;
		this.birth = birth;
	}

	public void showCharm(){
		System.out.println("i don't have any charm...");
	}
}

//吉他类
class Guitar extends Instrument{
	public String feature;
	public String charm = "attract girls";

	//两个构造器
	public Guitar(){
		name = "guitar";
		birth = "Spain";
	}
	public Guitar(String name, String birth, String feature, String charm){
		super(name, birth);
		this.feature = feature;
		this.charm = charm;
	}

	public void showCharm(){
		System.out.println(charm.charAt(0));
	}
}

