package cpf.learn.chapter13.stringbuilder_;

import cpf.learn.myTool.ClassAbout;

/**
 * @author CPF 创建于： 2021/6/17 23:44
 * 比较 String StringBuffer StringBuilder的效率:
 * String慢上几百倍
 * 在循环没那么大的时候，StringBuilder最快，但随着循环变得越来越大，StringBuffer反而最快
 * 但是StringBuffer 与 StringBuilder始终在同一数量级，当循环次数设置为五百万，接近虚拟机极限的时候，
 * 两者的时间却越来越接近，总之哪个都可以，但是为了线程安全，只能使用StringBuffer
 */
public class Compare{
	public static void main(String[] args){
		int TIMES = 5000000;
		Buffer buffer = new Buffer(TIMES);
		Builder builder = new Builder(TIMES);
		StringAdd stringAdd = new StringAdd(TIMES);
		CacheType.timeSpend(builder);
		CacheType.timeSpend(buffer);
		CacheType.timeSpend(stringAdd);
	}//end main
}

abstract class CacheType{
	public int times;

	public CacheType(int times){
		this.times = times;
	}

	public abstract void job();

	public static long timeSpend(CacheType type){
		long beginTime = System.currentTimeMillis();
		type.job();
		long endTime = System.currentTimeMillis();
		String className = ClassAbout.getClassName(type);//调用工具类
		System.out.println(className +
				"花费时间：" + (endTime - beginTime));
		return endTime - beginTime;
	}
}//end class

class Buffer extends CacheType{
	public Buffer(int times){
		super(times);
	}

	@Override
	public void job(){
		StringBuffer stringBuffer = new StringBuffer("head");
		for(int i = 0; i < times; i++){
			stringBuffer.append(i);
		}
	}
}//end class

class Builder extends CacheType{
	public Builder(int times){
		super(times);
	}

	@Override
	public void job(){
		StringBuilder stringBuilder = new StringBuilder("head");
		for(int i = 0; i < times; i++){
			stringBuilder.append(i);
		}
	}
}

class StringAdd extends CacheType{
	public StringAdd(int times){
		super(times);
	}

	@Override
	public void job(){
		String string = "head";
		for(int i = 0; i < times; i++){
			string += i;
		}
	}
}
