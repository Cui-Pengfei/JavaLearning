package cpf.learn.chapter11.annotation;

/*
 * @author CPF 创建于： 2021/6/11 15:48也被称为元数据，
 * 注解的介绍：
 * 1.注解（Annotation）也被称为元数据（Metadata）,
 * 用来修饰包、类、方法、属性、构造器、局部变量等信息
 * 2.和注释一样，注解不影响代码逻辑，但是注解可以被编译或运行，
 * 相当于嵌入代码中能被编译器识别的补充信息
 * 3.在java se中，注解的使用目的比较简单，标记过时的功能、忽略警告等
 *   在java ee中，注解占据了更重要的角色，例如用来配置应用程序的任何切面、
 *   代替java ee旧版所遗留的冗余代码河XML配置等
 * 4.使用Annotatiopn要在其前面加 @ 符号，并把该Annotation当成修饰符来使用，
 *   用于修饰它所支持的程序元素
 * 5.三个基本的Annotation
 * @Override : 限定某个方法是重写父类的方法
 * @Deprecated : 用于表示某个程序元素（类、方法）已过时
 * @SuppressWarnings : 抑制编译器警告
 */
public class AnnotationIntro{
	public static void main(String[] args){

	}
}

class Father{

	public void fly(){
	}

	/*
	1. @Deprecated表示某个元素已经过时，会在引用到该元素时出现横线划掉，但是过时了仍然可以使用，
	只是提醒程序员可能有风险或者更好的选择。
	2.@Target(value=构造器，属性，局部变量，方法，包，参数，类
				{CONSTRUCTOR, FIELD, LOCAL_VARIABLE, METHOD, PACKAGE, PARAMETER, TYPE})
	3.通常用于版本升级过度使用
	 */
	@Deprecated
	public void noUse(){
	}

}
/*
1.当我们不希望看到警告时，用@SuppressWarnings来解决
2.在大括号中可以填入你希望抑制的警告
3.抑制的范围与所写的位置有关，整个类、整个方法、一句代码
4.@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
 */
@SuppressWarnings({"unused", ""})//没有使用过的警告unused
class Son extends Father{

	/*
	1.这里加上重写注解有语法校验的作用，编译器会去检查你是否真的重写了超类的某个方法，
	如果没有重写，就会编译出错，这是一种校验的功效。
	2.添加的注解也能充当注释的功效，使代码可读性更高
	3.@Override注解只能用于方法，查看其源码会发现 @Target(ElementType.METHOD)
		这个规定了应用场景，像@Target这样的修饰注解的注解，叫作院【元注解】
	 */
	@Override
	public void fly(){
		super.fly();
	}


}













