package cpf.learn.chapter10.exercise;

/**
 * @author CPF 创建于： 2021/6/11 17:49
 */
public class Exercise01{
	public static void main(String[] args){
		System.out.println(Frock.getNextNum());
		System.out.println(Frock.getNextNum());

		Frock frock1 = new Frock();
		Frock frock2 = new Frock();
		Frock frock3 = new Frock();
		System.out.println(frock1.getSerialNumber());
		System.out.println(frock2.getSerialNumber());
		System.out.println(frock3.getSerialNumber());
	}//end main
}

class Frock{
	private static int currentNum = 100000;
	private int serialNumber;

	//我认为获取接下来的一个序号，这个方法不应该导致序号发生改变，
	//因为它的目的仅仅是获得基于目前状况的下一个序号，并不是想改变序号值，
	//改变序号值的应该是构造器，每生产一件衣服，真实的序号才能加100
	public static int getNextNum(){
		return currentNum + 100;
	}

	public Frock(){
		currentNum = getNextNum();
		serialNumber = currentNum;
	}

	public int getSerialNumber(){
		return serialNumber;
	}
}
