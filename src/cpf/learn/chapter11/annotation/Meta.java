package cpf.learn.chapter11.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * @author CPF 创建于： 2021/6/11 17:16
 * 元注解的了解
 */
/*
@Retention注解
只能用于修饰一个Annotation的定义，用于指该Annotation可以保留多长时间
@Retention包含一个RetentionPolicy类型的成员变量，使用@Retention时必须为该value成员变量指定值
 */
//@Retention(RetentionPolicy.SOURCE) //编译器使用完后，直接丢弃该注解
@Retention(RetentionPolicy.CLASS)   //编译器把注解记录在字节码中，运行时，JVM不会保留注解，是默认值
//@Retention(RetentionPolicy.RUNTIME)
// 编译器把注解记录入字节码中，运行时，JVM会保留注释，程序可以通过反射获得该注解


/*
@Target表示一个注解可以修饰的代码元素类型
 */
//该注解可应用于  包        类   属性      构造器     方法      局部变量            参数
@Target(value={PACKAGE, TYPE, FIELD, CONSTRUCTOR, METHOD, LOCAL_VARIABLE, PARAMETER})

@Documented //表示我自定义的Meta注解在使用过后，可以写入javadoc文档
public @interface Meta{
	/*注解的类型是@interface*/
}
