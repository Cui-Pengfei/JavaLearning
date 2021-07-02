package cpf.learn.chapter14.collection_.list_;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author CPF 创建于： 2021/6/22 19:39
 * 比较一下数组集合、链表集合添加移除数据的效率:链表要快得多！
 */
public class CompareArrayLinked{
	public static void main(String[] args){
		int workload = 100000;
		ArrayJob arrayJob = new ArrayJob(workload);
		LinkedJob linkedJob = new LinkedJob(workload);
		System.out.println("数组集合所花时间：" + calculate(arrayJob));
		System.out.println("链表集合所花时间：" + calculate(linkedJob));

	}

	public static long calculate(Computable job){
		long beginTime = System.currentTimeMillis();
		job.job();
		long endTime = System.currentTimeMillis();
		return endTime - beginTime;
	}
}

interface Computable{
	void job();
}
class JobLoad{
	protected int loop;

	public JobLoad(int loop){
		this.loop = loop;
	}
}
class ArrayJob extends JobLoad implements Computable{
	public ArrayJob(int loop){
		super(loop);
	}
	@Override
	public void job(){
		ArrayList arrayList = new ArrayList();
		for(int i = 0; i < loop; i++){
			arrayList.add(i);
		}
		while(arrayList.size() != 0){
			arrayList.remove(0);
		}
	}
}

class LinkedJob extends JobLoad implements Computable{
	public LinkedJob(int loop){
		super(loop);
	}

	@Override
	public void job(){
		LinkedList linkedList = new LinkedList();
		for(int i = 0; i < loop; i++){
			linkedList.add(i);
		}
		while(linkedList.size() != 0){
			linkedList.remove();
		}
	}
}
