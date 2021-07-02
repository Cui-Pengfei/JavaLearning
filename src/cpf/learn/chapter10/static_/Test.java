package cpf.learn.chapter10.static_;

public class Test{
	public static void main(String[] args){
		Child jack = new Child("Jack");
		Child mary = new Child("Mary");
		Child lily = new Child("Lily");

		jack.join();
		lily.join();
		System.out.println("一共有" + Child.joinNum + "位孩子加入游戏。");
		mary.join();
		System.out.println("一共有" + Child.joinNum + "位孩子加入游戏。");
	}
}
