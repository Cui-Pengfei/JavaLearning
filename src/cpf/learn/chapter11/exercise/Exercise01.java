package cpf.learn.chapter11.exercise;

/**
 * @author CPF 创建于： 2021/6/12 1:17
 */
public class Exercise01{

	public static void main(String[] args){
		for(Color color : Color.values()){
			switch(color){
				case RED:
					System.out.println("匹配到红色");
					Color.valueOf("RED").show();
					break;
				case BLUE:
					System.out.println("匹配到蓝色");
					Color.valueOf("BLUE").show();
					break;
				case BLACK:
					System.out.println("匹配到黑色");
					Color.valueOf("BLACK").show();
					break;
				case YELLOW:
					System.out.println("匹配到黄色");
					Color.valueOf("YELLOW").show();
					break;
				case GREEN:
					System.out.println("匹配到绿色");
					Color.valueOf("GREEN").show();
					break;
				default:
					System.out.println("匹配出错，什么也没匹配到...");
			}
		}

	}//end main
}

@SuppressWarnings({"unused"})
enum Color implements ShowAble{
	RED(255,0,0),
	BLUE(0,0,255),
	BLACK(0,0,0),
	YELLOW(255,255,0),
	GREEN(0,255,0);

	private final int redValue;
	private final int greenValue;
	private final int blueValue;

	Color(int redValue, int greenValue, int blueValue){
		this.redValue = redValue;
		this.greenValue = greenValue;
		this.blueValue = blueValue;
	}

	@Override
	public void show(){
		System.out.println(this.toString());
	}

	@Override
	public String toString(){
		return  this.name() +
				"{" +
				"redValue=" + redValue +
				", greenValue=" + greenValue +
				", blueValue=" + blueValue +
				'}';
	}
}
@SuppressWarnings({"unused"})
interface ShowAble{
	void show();
}
