package cpf.learn.chapter10.innerClass.exercise;

/**
 * 闹钟练习：内部类作为参数
 */
public class Exercise01{
	public static void main(String[] args){
		CellPhone cellPhone = new CellPhone();
		cellPhone.alarmClock(new Bell(){
			@Override
			public void ring(){
				System.out.println("懒猪起床了....");
			}
		});

		cellPhone.alarmClock(new Bell(){
			@Override
			public void ring(){
				System.out.println("小伙伴们上课了...");
			}
		});

	}//end main
}

interface Bell{
	void ring();
}

class CellPhone{
	public void alarmClock(Bell bell){
		bell.ring();
	}
}