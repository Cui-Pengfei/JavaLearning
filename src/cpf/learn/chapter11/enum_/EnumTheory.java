package cpf.learn.chapter11.enum_;

/**
 * @author CPF 创建于： 2021/6/8 19:46
 *枚举的功能原理：（注意事项）
 *1.使用关键字enum创建枚举类时，此枚举类默认extends Enum类，而且是final类
 *  通过javap反编译可以一目了然。
 *2.传统的public static final Season SPRING = new Season("春天", "温暖");被简化
 * 为 SPRING("春天", "温暖"),这里通过参数列表可以知道调用的具体是哪个构造器。
 *3.如果使用无参构造器，则实参列表和小括号都可以省略。
 *补充：枚举类创建实例对象的语法虽然特殊，但是底层仍然是调用构造器，因此构造器内的语句都会执行
 *4.如果使用enum关键字，就不能再继承其他类了，因为隐式继承了Enum，而一个类只能有一个父类，
 * 但是却可以实现多个接口,毕竟还是一个类。
 * 5.未完待续，为了赶进度，不得不暂时搁置...
 *
 */
public class EnumTheory{
	public static void main(String[] args){

	}
}
