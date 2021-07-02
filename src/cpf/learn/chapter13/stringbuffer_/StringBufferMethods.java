package cpf.learn.chapter13.stringbuffer_;

/**
 * @author CPF 创建于： 2021/6/17 18:03
 * StringBuffer一些常用方法的学习：
 *
 */
public class StringBufferMethods{
	public static void main(String[] args){
/*1. 缓存区容量 capacity() */
		System.out.println("================ 1.capacity() ================");
		StringBuffer stringBuffer1 = new StringBuffer();//默认缓存容量16
		System.out.println(stringBuffer1.capacity());
		StringBuffer stringBuffer2 = new StringBuffer(100);//新建的是几个就给几个
		System.out.println(stringBuffer2.capacity());
		StringBuffer stringBuffer3 = new StringBuffer("you");//用字符串，那就是 16 + string.length()
		System.out.println(stringBuffer3.capacity());

		StringBuffer stringBuffer4 = new StringBuffer();
		stringBuffer4 = stringBuffer4.append("you");//通过append添加进去的字符串，不会扩大缓存区容量
		System.out.println(stringBuffer4.capacity());

/*2. 缓存区内拥有字符的长度，也是toStringCache[]的长度 length() */
		System.out.println("================ 2.length() ================");
		StringBuffer stringBuffer = new StringBuffer(10);
		System.out.println(stringBuffer.length());//不管capacity有多大，没有内容，长度就是0
		stringBuffer.append("长度是4");
		System.out.println(stringBuffer.length());

/*3. 增  append()
		父类AbstractStringBuilder重载了14个append(parameters)
		StringBuffer 重写了这14个append(),且每一个都用关键字synchronized修饰，是线程安全的，但是效率会降低
		基本数据类型 char, int, long, float, double, boolean 共6个 (byte short会重载到int参数)
		字符数组序列 char[], char[] int int, charSequence, charSequence int int 共4个
		类及特殊类   Object, String, StringBuffer, AbstractStringBuilder 共4个  合计14个
		append(string)若string = null,那么填入value[]的也是null四个字符
		*/
		System.out.println("================ 3.append() ================");
		StringBuffer stringBuffer5 = new StringBuffer();
		byte b = 6;
		short s = 8;
		stringBuffer5.append(b);
		stringBuffer5.append(s);
		System.out.println(stringBuffer5);
		stringBuffer5.append("111111111111111111111111111111111");//在剩余14个空位内加入15个字符，该怎么扩容？
		System.out.println(stringBuffer5.capacity());//35 如果容量不够，就【现容量 * 2 + 2】,如果还是不够，就扩容到刚刚好

		String strings[] = {"jack","mary"};
		stringBuffer5.append(strings);//如果增加字符串数组，只会把该数组当做一般的object来对待，最终添加的是数组的toString值
		System.out.println(stringBuffer5);
		System.out.println(strings.getClass().getName());


/*4. 删 delete() 有两个相关方法
		delete(int start, int end) 会把value[]内把end之后的所有字符复制到start开始的地方，value[]容量不变，
		deleteCharAt(int point) 一样的 其实就是 delete(int point, int point+1)
		*/
		System.out.println("================ 4.delete() ================");
		System.out.println(stringBuffer5.capacity());
		stringBuffer5.delete(0,stringBuffer5.length());//删除内容，value[]容量不变
		System.out.println(stringBuffer5.capacity());
		System.out.println(stringBuffer5.length());

/*5. 改 replace(int start, int end, string);
        用string来替代value双int之间的内容，内容长度为 end - start
        特点：
        5.1 start < 0 会报异常 ; end > count却只会令end = count不会报错
        5.2 在修改之前，会先保证value[]的容量够大，不够大就按照扩容的两种策略来，够大就不变
        5.3 修改时，会先让没有改变的那些字符先站好位置，再把要修改的str插进预留好的位置
        */
		System.out.println("================ 5.replace() ================");
		StringBuffer stringBuffer6 = new StringBuffer("你知道很多事情");
		stringBuffer6.replace(1, 3,"不知道");
		System.out.println(stringBuffer6);

/*6. 查 indexOf()重载了两个方法：
		indexOf(string)找到就返回第一个匹配的字符串的首地址，找不到返回-1
		indexOf(string,i)从第i个开始找匹配的字符串 ；说到底调用的还是string的indexOf()静态方法
		String.indexOf(char[] source, int sourceOffset, int sourceCount,
                       char[] target, int targetOffset, int targetCount,
                       int fromIndex)
		*/
		System.out.println("================ 6.indexOf() ================");
		StringBuffer stringBuffer7 = new StringBuffer("我叫你一声你敢答应吗？");
		System.out.println(stringBuffer7.indexOf("你"));//返回第一个“你”的index = 2
		System.out.println(stringBuffer7.indexOf("你", 3));//从第三个开始查，就是第二个“你”的index = 5

/*7. 插 insert() 重载了12个方法
		7.1 和append()非常像，底层代码也非常像，都是调用System.arraycopy()函数
		    arraycopy(Object src, int srcPos, Object dest, int destPos, int length);
		    再调用string.getChars()方法，把要插入的元素插入到预留位置
		7.2 比append()少两个参数列表 (StringBuffer) (AbstractStringBuilder),仔细想想，有(Object)其实就足够
		7.3 如果string = null, 那么insert(i, string)就会在index = i的位置上插入字符串"null"
		此时:stringBuffer7 = "我叫你一声你敢答应吗？"
		*/
		stringBuffer7.insert(0,"爷爷");
		System.out.println(stringBuffer7);
		stringBuffer7.insert(stringBuffer7.indexOf("你",5),"孙子");
		System.out.println(stringBuffer7);

	}//end main
}
