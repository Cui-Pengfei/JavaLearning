package cpf.learn.chapter11.enum_.exercise;

/**
 * @author CPF 创建于： 2021/6/10 22:21
 * 要求创建枚举类Week,输出：
 * 星期一
 * ...
 * 星期日
 */
public class ExerciseWeek{
	public static void main(String[] args){
		for(Week day : Week.values()){
			System.out.println(day);
		}
	}
}

enum Week{
	MONDAY("星期一"), TUESDAY("星期二"), WEDNESDAY("星期三"),
	THURSDAY("星期四"), FRIDAY("星期五"), SATURDAY("星期六"),
	SUNDAY("星期日");

	private String name;

	Week(String name){
		this.name = name;
	}

	@Override
	public String toString(){
		return  name;
	}
}
