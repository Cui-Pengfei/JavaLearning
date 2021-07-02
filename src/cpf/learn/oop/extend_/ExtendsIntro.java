package cpf.learn.oop.extend_;

/**
 * 【继承的实质】：>在往方法区加载类信息的时候，根据先加载父类后加载子类的原则，逐级往上，直至顶级类。
 *               有继承关系的类之间建立起访问链接，
 *               >创建对象时，堆空间会沿着此链接，开辟出本类及所有父类的属性、方法，
 *               不同类的同名成员会开辟不同的空间
 * 1.继承概述
 *      继承可以解决代码复用的问题，当多个类存在相同的属性和方法时，
 *      我们可以从这些类中抽象出父类，在父类中定义这些相同的属性和方法，
 *      所有的子类就不需要重新定义这些属性和方法了，只需要extends来声明继承父类
 * 2.继承语法
 *      class 子类 extends 父类{
 *          2.1 子类会自动拥有父类定义的属性和方法，直接能访问到的只有 public 和 protected
 *          2.2 父类又叫超类、基类
 *          2.3 子类又叫派生类
 *      }
 * 3.继承细节
 *     3.1 子类继承了父类的所有属性和方法，但是【私有】【默认】属性和方法不能在子类中直接访问，
 *           要通过公共方法去访问。
 *     3.2 子类必须调用父类的构造器，完成父类的初始化：
 *           这个从快捷键中也可见端倪，快捷键建立构造器总是先让选择复用哪个父类构造器，而且必须选一个...
 *           如果可以复用父类的构造器，就用，如果没有任何一个父类构造器可合适地复用，
 *           就必须要用父类的无参构造器，如果父类没有无参构造器，就会报错。
 *           就算显示地没有用到super，那也一定是隐藏了一个super();
 *     3.2 总的来说就是：
 *          1> 子类默认构造器      调用      父类无参构造器
 *          2> 子类显性无参构造器   调用      父类无参构造器(或默认的无参构造器)
 *          3> 子类有参构造器      调用      父类对应参数构造器 + 子类特有的属性赋值
 *          4> 子类有参构造器      调用      父类无参构造器 + 子类特有属性赋值 + 继承父类属性赋值
 *          反正要调用一个父类的构造器，完成父类的初始化...
 *     3.4 如果希望指定去调用父类的某个构造器，则显示地指定一下 super(parameterList);
 *     3.5 super在使用的时候，必须放在构造器的第一行(这和this调用构造器的规则一样)
 *         super只能在构造器中使用。
 *     3.6 super(); this()都必须放在构造器第一行，因此两者不能共存，实际上，也不能存在两个super\this
 *     3.7 java中所有类都是Object类的子类，Object是所有类的超类\父类
 *     3.8  1>父类构造器的调用不限于直接父类！将一直往上追溯直到Object类(顶级父类)
 *               也就是说，以上所述的子类与父类的构造器调用关系，会一直往上追溯，
 *          2> Pupil类实例化时匹配Pupil类的构造器，Pupil的构造器会调用父类Student对应的构造器，
 *               完成直接父类的初始化，直接父类Student在初始化时又会向其直接父类Person寻求对应的构造器，
 *               如此一级一级，直到顶级父类Object...
 *     3.9 java中，子类最多只能继承一个父类（直接继承），即java是单继承机制，
 *         >>>思考：如何使A类继承B类和C类？
 *            ---->让A继承B，再让B继承C，这样A就具有B、C的所有属性和方法，就像A直接继承B、C一样
 *     3.10不能滥用继承，A继承B，必须满足，A is B的逻辑关系，
 *          例如：Cat is Animal --> Cat extends Animal
 *
 * 4.继承本质（极端重要）---->>>详情见 ExtendsTheory.java
 *
 *
 */
public class ExtendsIntro{
	public static void main(String[] args){

	/**
	 *  3.1 继承无参构造器
	 *  3.2 各种属性混合构造器的继承与复用情况
	 */
		Pupil pupil = new Pupil();
		/*通过debug可以清楚地看到，pupil拥有属性：
		pupil = {Pupil@490}
		 school = null
		 studentID = null
		 score = 0.0
		 name = null
		 gender = '\u0000' 0
		 age = 0
		 idCard = null
		 但是可访问的只有下面这些：*/
		System.out.println(pupil.age + "\t" +
							pupil.gender + "\t" +
							pupil.name + "\t" +
							pupil.school);

		System.out.println();

		//2.这个Pupil的构造器调用了父类的三个参数构造器
		Pupil pupilCF = new Pupil("萍乡中学", "3409181991", 120);
		pupilCF.showInfo();

		System.out.println();

		//4.这个构造器只有Pupil特有的属性，但是仍然会调用父类的无参构造器
		Pupil pupilLittle = new Pupil("我爱玩呀...");
		pupilLittle.showInfo();

		System.out.println();

		//5.特有属性与继承属性混合，且继承属性无法复用父类的构造器,此时仍然要调用父类的无参构造器
		Pupil pupilMix = new Pupil(99.5, "混合爱玩呀...");
		pupilMix.showInfo();


	}



}
