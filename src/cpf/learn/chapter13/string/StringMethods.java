package cpf.learn.chapter13.string;

/**
 * @author CPF 创建于： 2021/6/16 13:26
 * String常用方法介绍：
 */
public class StringMethods{
	public static void main(String[] args){
		String s1 = " hello ";
		String s2 = " hello Henry ";
		String s3 = "HELLO";

//1. trim() 去掉字符串的前后空格 返回subString(int st,int len) : this
		System.out.println("==== 1.trim() ============================");
		System.out.println("修剪前：s1.len = " + s1.length() + " ， s2.len = " + s2.length());
		s1 = s1.trim();
		s2 = s2.trim();
		System.out.println("修剪后：s1.len = " + s1.length() + " ， s2.len = " + s2.length());

//2. 忽略大小写判断内容是否一样:
		// 核心是调用regionMatch(boolean ignoreCase,int toffset,String other,int ooffset,len)
		System.out.println("==== 2.equalsIgnoreCase(string) ==========");
		System.out.println(s1.equalsIgnoreCase(s3));

//3. string.indexOf()重载了四个普通方法，两个静态方法
		/*
		indexOf(int ch) 核心靠调用 indexOf(int ch, int fromIndex) 字符用Unicode码值ch代表
		indexOf(String str) 核心靠 indexOf(String str, int fromIndex)
		static int indexOf(char[] source, int sourceOffset, int sourceCount,
							String target, int fromIndex)
		static int lastIndexOf(char[] source, int sourceOffset, int sourceCount,
            String target, int fromIndex)
        后两个多用于jdk源码自己调用来实现某些功能，我们只需要掌握前四个即可：
        此时：
        String s1 = "hello";
		String s2 = "hello Henry";
		 */
		System.out.println("==== 3.indexOf(parameters) ===============");
		System.out.println(s1.indexOf('l'));//2
		System.out.println(s1.indexOf('l', 0));//两个是等价的

		System.out.println(s1.indexOf("lo"));//3 返回搜索到的目标字符串所在源串的起始index
		System.out.println(s1.indexOf("lo", 0));//两者等价
		System.out.println(s2.indexOf("Henry"));//6
		System.out.println(s2.indexOf("henry"));//找不到返回-1
//4. string.lastIndexOf()与indexOf()完全一致，不必赘述

/*5. string.charAt(int index):char返回位于index的字符，
     若index不在[0,string.length)范围内，会抛出StringIndexOutOfBoundsException(index)异常
     此时：
        String s1 = "hello";
		String s2 = "hello Henry";
     */
		System.out.println("==== 5.charAt(int) ==========================");
		System.out.println(s1.charAt(4));//o
		try{
			System.out.println(s2.charAt(-1));//抛出异常 继承自RuntimeException
		}catch(StringIndexOutOfBoundsException e){
			System.out.println(e);
		}

/*6. string.subString()获取string的子串，重载了两个方法，以及一个补充方法
		public String substring(int beginIndex)
		public String substring(int beginIndex, int endIndex)
		public CharSequence subSequence(int beginIndex, int endIndex)
		注意事项：下标超出范围一律异常、真子串会new String(value,begin,subLen)，源串本身就返回this
				 subLen = end - begin，由两个数字直接相减得到数量
		此时：
        String s1 = "hello";
		String s2 = "hello Henry";
       */
		System.out.println("==== 6.subString(parameters) ================");
		System.out.println(s1.substring(2));//llo
		System.out.println(s2.substring(5, 11));// Henry
		System.out.println(s2.subSequence(2, 9));//llo Hen

/*7. 获得字符串的某部分，传递给char[]
		public void getChars(int srcBegin, int srcEnd, char dst[], int dstBegin)
		*/
		System.out.println("==== 7.getChars() ================");
		char copy[] = new char[10];//这个是固定的
		s1.getChars(1, 4, copy, 2);
		System.out.println(copy);
		copy[0] = '@';
		copy[1] = '@';
		System.out.println(copy);
		System.out.println(copy.length);

/*8. 将字符串按照某个子串来分割成多个不同的字符串，形成一个字符串数组
		 public String[] split(String regex) {return split(regex, 0);}
		 public String[] split(String regex, int limit)
		 1> 当limit为0，也是单参数的情况，数组可以为任何长度，
		    分割模式将尽可能多地应用，尾部空字符会被丢弃,首部空字符会被保存
	     2> 当limit<0,数组可为任意长度，分割模式会尽可能多地应用，尾部空字符会被保存
	     3> 当limit>0，limit就是限制数组个数的，
	        如果limit过大，那就是limit = 0的结果
	        如果limit没有到达limit = 0时的数组长度，就会被数组长度限制，最后几步可能不会被分割

		*/
		System.out.println("==== 8.split() ================");
		String string = "boo:and:foo";//javadoc经典例子

		String strings0[] = string.split("o");// { "b", "", ":and:f" }
		String stringsN[] = string.split("o", -1);//{ "b", "", ":and:f", "", ""}
		String strings100[] = string.split("o", 100);//{ "b", "", ":and:f", "", ""}
		String strings2[] = string.split("o", 2);//{ "b", "o:and:foo"}
		String strings3[] = string.split("o", 3);//{ "b", "", ":and:foo"}
		String strings4[] = string.split("o", 4);//{ "b", "", ":and:f", "o"}
		String strings5[] = string.split("o", 5);//{ "b", "", ":and:f", "", ""}
		String strings6[] = string.split("o", 6);//{ "b", "", ":and:f", "", ""}
		for(String s : strings4){
			System.out.print(s + ",");
		}

/*9. String实现了Comparable接口，意味着其重写了compreTo(String)方法，
	 return 本字符串长度 - 要比较字符串长度【两个字符串长度不一致的情况下】
	        本字符串第一个不相等字符 - 要比较的字符串第一个不相等的字符 ， 是int值*/
		System.out.println("\n==== 9.compareTo() ================");
		System.out.println("abc".compareTo("acd"));//-1

		/*10. format()方法 实现像C语言那样的格式化输出*/
		String name = "cpf";
		char gender = 'm';
		double score = 99.99999;
		System.out.println("name = " + name + " gender = " + gender + " score = " + score);
		//如果另一个地方也想要这样的格式，那只能是把这个复制过去，再写一遍咯，增加了程序员负担
		String format = "name = %s, gender = %c, score = %.2f";
		//以上就制定了一个格式，甚至可以作为参数在各个对象间传输，若要调整格式，也只需要改变一个即可
		System.out.println(String.format(format, name, gender, score));
		System.out.printf(format, name, gender, score);//format与printf是一个机制
		System.out.println();

		/*11. concat(string)拼接字符串*/
		String name1 = "林黛玉";
		name = name1.concat("贾宝玉").concat("薛宝钗").concat("together");
		System.out.println(name);
		/*12. string.replace("xxx", "yyyy") 把string中所有的xxx替换成yyyy*/
		String many = "ababababab";
		many = many.replace('a', 'b');//字符替换
		System.out.println(many);//bbbbbbbbbbb
		many = many.replace("bb", "cc");
		System.out.println(many);//cccccccccc
		many = many.replaceAll("cc", "dd");//字符串替换
		System.out.println(many);//dddddddddd
		many = many.replaceFirst("dd", "ee");//只替换第一个匹配到的
		System.out.println(many);//eedddddddd


	}//end main
}
