package cpf.learn.chapter14.collection_.list_.arraylist_;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * @author CPF 创建于： 2021/6/21 20:04
 * 数组集合ArrayList：
 * 1. ArrayList由数组来实现数据的存储
 * 2. ArrayList基本等同于Vector，但是ArrayList是线程不安全的(类比StringBuilder StringBuffer)
 * 3. ArrayList的字段：
	 * 3.1 elementData[]:Object 存放数据元素的数组 transient表示该该属性在类序列化的时候不会被序列化
	 * 3.2 若使用的是无参构造器，则初试容量为10，以后若是不够了，逐渐扩容为1.5倍
	 * 3.3 若是使用ArrayList(int capacity)来构造集合，初始容量为capacity，若是不够，仍是1.5倍扩容
 *
 */
@SuppressWarnings({"all"})
public class ArrayListIntro{
	public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException{
/*1. ArrayList允许放空值进去，且允许放多个空值
		*/
		ArrayList arrayList = new ArrayList();
		arrayList.add(null);
		arrayList.add(null);
		System.out.println(arrayList);
/*2. 扩容机制的证明 通过反射
		下面是扩容函数：
		private void grow(int minCapacity) {
        // overflow-conscious code
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1); //不管三七二十一，先扩容1.5倍
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;                      //如果还不够就扩容到需要的那个值
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
            集合的最大容量 MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8，这是因为有些虚拟机的数组有头部
            如果比这个还打，就只能令newCapacity = Integer.MAX_VALUE，这是最大限度，超过了要报错
        elementData = Arrays.copyOf(elementData, newCapacity);
    }
		*/
		arrayList = new ArrayList();
		Field elementData = arrayList.getClass().getDeclaredField("elementData");
		elementData.setAccessible(true);
		Object thisElementData[] = (Object[]) elementData.get(arrayList);
		System.out.println(thisElementData.length);
		//第一次添加元素时...
		arrayList.add("head");
		thisElementData = (Object[]) elementData.get(arrayList);
		System.out.println("第一次添加一个元素时，容量变为：" + thisElementData.length);
		//添加使之超过10个元素
		Collection coll = new ArrayList();
		Collections.addAll(coll, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		arrayList.addAll(coll);
		System.out.println("添加10个元素后arrayList = " + arrayList);
		thisElementData = (Object[])elementData.get(arrayList);
		System.out.println("添加10个元素后扩容为："+thisElementData.length);
		//指定初始化集合大小的扩容方式也是1.5倍扩容，只是初始容量不同

		//问题：如果设置初始值为0呢？
		//0的1.5倍还是0，因此扩容后还是不满足，就把容量设置为刚刚好，也就是capacity = 1；
		//一开始我还纳闷儿，都扩容1.5倍了怎么还会不够呢，感情是防着基础值为0呢！
		ArrayList arrayList1 = new ArrayList(0);
		arrayList1.add("abc");


		//类变量空数组EMPTY_ELEMENTDATA的用处
		ArrayList arrayList2 = new ArrayList(0);
		arrayList2.add("cpf");//在计算calculateCapacity()时，显示出与默认构造器的不同，
		//这种方式并不会默认分配10个空间
		System.out.println(arrayList2);

	}
}
