package cpf.learn.oop.modifier.content;

//在同类中，显然都可以访问到
public class Public {
	//四个不同访问限制的属性
	public String s1 = "public.public";
	protected String s2 = "public.protected";
	String s3 = "public.default";
	private String s4 = "public.private";


	public void m1() {
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		System.out.println();
	}

	protected void m2() {
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		System.out.println();
	}

	void m3() {
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		System.out.println();
	}

	private void m4() {
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		System.out.println();
	}

	public static void main(String[] args) {
		Public p = new Public();
		//四个属性都能访问到
		System.out.println("四个属性：");
		System.out.println(p.s1);
		System.out.println(p.s2);
		System.out.println(p.s3);
		System.out.println(p.s4);
		System.out.println();

		//四个方法也都能访问到
		System.out.println("四个方法：");
		p.m1();
		p.m2();
		p.m3();
		p.m4();
	}

}


