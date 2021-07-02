package cpf.learn.chapter11.enum_.methods;

/**
 * @author CPF 创建于： 2021/6/8 23:29
 */
public class Values{
	public static void main(String[] args){
		for(Animal animal : Animal.values()){
			System.out.println(animal + ", ordinal: " + animal.ordinal());
		}

	}//end main
}

enum Animal{
	DOG, CAT, PIG, TIGER;
}
