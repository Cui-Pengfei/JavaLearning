package cpf.learn.chapter13.wrapper.number;

/**
 * @author CPF 创建于： 2021/6/14 18:30
 * 1.直接继承自Number,间接继承自Object
 * 2.实现了Comparable、Serializable接口
 */
public class ByteLearn{
	public static void main(String[] args){
		System.out.println(Byte.BYTES);//1
		System.out.println(Byte.SIZE);//8
		System.out.println(Byte.MAX_VALUE);//127
		System.out.println(Byte.MIN_VALUE);//-128
		System.out.println(Byte.TYPE == byte.class);//true
		System.out.println(Byte.class);//Class java.lang.Byte
	}
}
